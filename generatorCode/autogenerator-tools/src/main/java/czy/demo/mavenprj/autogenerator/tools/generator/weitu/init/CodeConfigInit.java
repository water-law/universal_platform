package czy.demo.mavenprj.autogenerator.tools.generator.weitu.init;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base.BaseConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz.ClazzFieldInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz.ClazzInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.CodeConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.form.FormFieldInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.form.FormInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.grid.GridFieldInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.grid.GridInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.querycondition.QueryConditionInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.querycondition.QueryFieldInfoVo;
import czy.demo.mavenprj.autogenerator.tools.util.SString;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * 
 * @author zhiyic
 * @version $Id: ClassGenerator.java, v 0.1 zhiyic Exp $
 */
public class CodeConfigInit {
    
    private CodeConfigInit() {
        
    }
    
    /**
     *  数据库列字段key
     */
    private static final String COLUMN_NAME = "COLUMN_NAME";
    
    /**
     *  数据库列字段类型key
     */
    private static final String TYPE_NAME = "TYPE_NAME";
    
    /**
     *  数据库列字段注释key
     */
    private static final String REMARKS = "REMARKS";
    /**
     *  当前连接
     */
    private static Connection currConection = null;
    /**
     *  数据库元数据
     */
    private static DatabaseMetaData currDatabaseMetaData = null;
    
    public static synchronized void init(String url, String user, String password) {
        initConnection(url, user, password);
        initDatabaseMetaData();
    }
    
    public static synchronized void initConnection(String url, String user, String password) {
        if (currConection == null) {
            if (currConection == null) {
                try {
                    Properties connectionProps = new Properties();
                    connectionProps.put("remarks", "true");//设置可以获取remarks信息
                    connectionProps.put("useInformationSchema", "true");//设置可以获取tables remarks信息
                    connectionProps.put("user", user);
                    connectionProps.put("password", password);
                    currConection = DriverManager.getConnection(url,connectionProps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
               
            }
        }
    }
    
    private static synchronized void closeConnection() {
        if (currConection != null) {
            try {
                currConection.close();
                currConection = null;
            } catch (Exception e) {
                e.printStackTrace();
                currConection = null;
            }
        }
    }
    
    public static synchronized void initDatabaseMetaData() {
        if (currDatabaseMetaData == null) {
            if (currDatabaseMetaData == null) {
                try {
                    currDatabaseMetaData = currConection.getMetaData();
                } catch (Exception e) {
                   e.printStackTrace();
                }
               
            }
        }
    }
    
    private static synchronized void clearDatabaseMetaData() {
        if (currDatabaseMetaData != null) {
            if (currDatabaseMetaData != null) {
                currDatabaseMetaData = null;
            }
        }
    }
    
    private static synchronized void close() {
        closeConnection();
        clearDatabaseMetaData();
    }

    public static synchronized CodeConfigInfoVo generateCodeConfig (String tableName, String aliasName, String author) throws Exception {
        return generateCodeConfig(tableName, aliasName, null, author, false);
    }
    
    public static synchronized CodeConfigInfoVo generateCodeConfig (String tableName, String aliasName, String moduleName, String author) throws Exception {
        return generateCodeConfig(tableName, aliasName, moduleName, author, false);
    }
    
    /**
     * @author zhiyic
     * @param tableName     数据库表名称
     * @param aliasName     表别名
     * @param moduleName    所属业务模块名（多级之间，用“.”隔开，如：busiconfig.standcode）
     * @param author        创建者姓名
     * @param isDuplicateName 是否开启重名判断，如果开启，则spring的相关注解会加上value值
     * @return
     * @throws Exception
     */
    public static synchronized CodeConfigInfoVo generateCodeConfig (String tableName,String aliasName, String moduleName, String author, boolean isDuplicateName) throws Exception {
        CodeConfigInfoVo codeConfigInfo = new CodeConfigInfoVo();
        
        BaseConfigInfoVo baseConfigInfoVo = new BaseConfigInfoVo();
        baseConfigInfoVo.setAuthorName( SString.isNotBlank(SString.getTrimString(author)) ? SString.getTrimString(author) : "autoGenarator");
        baseConfigInfoVo.setIsDuplicateName(isDuplicateName);
        baseConfigInfoVo.setDuplicateNamePrefix(isDuplicateName ? GeneratorConstants.CommonConstants.COMMON_DUPLICATE_NAME_PREFIX_CODE : null);
        ClazzInfoVo clazzInfo = new ClazzInfoVo();
        List<ClazzFieldInfoVo> fieldList = new ArrayList<>();
        
        QueryConditionInfoVo queryConditionInfo = new QueryConditionInfoVo();
        List<QueryFieldInfoVo> queryFieldInfoList = new ArrayList<>();
        
        GridInfoVo gridInfo = new GridInfoVo();
        List<GridFieldInfoVo> gridFieldInfoList = new ArrayList<>();
        
        FormInfoVo formInfo = new FormInfoVo();
        List<FormFieldInfoVo> formFieldInfoList = new ArrayList<>();

        //设置表注释
        ResultSet r = currDatabaseMetaData.getTables(null, null, tableName, null);
        try {
            while (r.next()) {
                String tableRemark = SString.getTrimString(r.getString("REMARKS"));
                if (SString.isNotBlank(tableRemark)) {
                    if (tableRemark.endsWith("表")) {
                        tableRemark = tableRemark.substring(0 , tableRemark.length() - 1);
                    }
                }
                clazzInfo.setTableRemark(tableRemark);
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        //查询主键

        String primaryKeyColumnName = null;
        String primaryKey = null;
        ResultSet primaryKeys = currDatabaseMetaData.getPrimaryKeys(null, null, tableName);
        if (primaryKeys != null) {
            while (primaryKeys.next()) {
                primaryKeyColumnName = primaryKeys.getString(COLUMN_NAME);
                primaryKey = SString.getFieldName(primaryKeyColumnName);
            }
        }
        if (primaryKeyColumnName == null) {
            throw new Exception("该表未设置主键");
        }

        ResultSet rs = null;
        try {
            rs = currDatabaseMetaData.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
              //列名
              String columnName = rs.getString(COLUMN_NAME);
              //类型
              String typeName = rs.getString(TYPE_NAME);
              //注释
              String remarks = rs.getString(REMARKS);
              //设置主键数据
              if (primaryKeyColumnName.equals(columnName)) {
                    clazzInfo.setPrimaryKeyName(primaryKey);
                    clazzInfo.setPrimaryKeyColumnName(columnName);
                    clazzInfo.setPrimaryKeyColumnType(SString.columnTypeFilter(typeName));
                    clazzInfo.setPrimaryKeyNameFirstUpper(SString.getFirstToUpper(primaryKey));
              }

              //设置类属性
              ClazzFieldInfoVo field = new ClazzFieldInfoVo();
              field.setFieldColumnName(columnName);
              field.setFieldColumnType(SString.columnTypeFilter(typeName));
              field.setFieldName(SString.getFieldName(columnName));
              field.setFieldType(SString.columnTypeToFieldType(typeName));
              field.setFieldRemarks(remarks);
              field.setFieldNameUpperFirstLetter(SString.getFirstToUpper(field.getFieldName()));
              fieldList.add(field);
              
              //主键不放入这几个vo对象内，单独获取
              if ( !primaryKey.equalsIgnoreCase(field.getFieldName()) ) {
                  //查询条件字段
                  QueryFieldInfoVo queryField = new QueryFieldInfoVo();
                  queryField.setFieldName(field.getFieldName());
                  queryField.setFieldLabel(field.getFieldRemarks());
                  queryField.setFieldInputType("text");
                  queryFieldInfoList.add(queryField);
                  //grid字段
                  GridFieldInfoVo gridFieldInfo = new GridFieldInfoVo();
                  gridFieldInfo.setFieldName(field.getFieldName());
                  gridFieldInfo.setFieldLabel(field.getFieldRemarks());
                  gridFieldInfo.setFieldDataType("text");
                  gridFieldInfoList.add(gridFieldInfo);
                  //form字段
                  FormFieldInfoVo formFieldInfo = new FormFieldInfoVo();
                  formFieldInfo.setFieldName(field.getFieldName());
                  formFieldInfo.setFieldLabel(field.getFieldRemarks());
                  formFieldInfo.setFieldInputType("text");
                  formFieldInfo.setIsRequired(true);
                  formFieldInfoList.add(formFieldInfo);
              }
            }
            //closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        String className = SString.isNotBlank(SString.getTrimString(aliasName)) ? 
                SString.getFirstToLowerCase(SString.getTrimString(aliasName)) : SString.getFirstToLowerCase(SString.getFieldName(tableName)); 
        
        clazzInfo.setClassNameFirstLowerCase(className);
        clazzInfo.setClassName(SString.getFirstToUpper(className));
        clazzInfo.setTableName(tableName);
        clazzInfo.setModuleName(moduleName);
        clazzInfo.setFieldList(fieldList);
        
        queryConditionInfo.setQueryFieldList(queryFieldInfoList);
        gridInfo.setGridFieldList(gridFieldInfoList);
        formInfo.setFormFieldList(formFieldInfoList);
        
        codeConfigInfo.setClazzInfo(clazzInfo);
        codeConfigInfo.setQueryConditionInfo(queryConditionInfo);
        codeConfigInfo.setGridInfo(gridInfo);
        codeConfigInfo.setFormInfo(formInfo);
        codeConfigInfo.setBaseConfigInfoVo(baseConfigInfoVo);
        
        codeConfigInfo.setIsOpeQuery(true);
        codeConfigInfo.setIsOpeAdd(true);
        codeConfigInfo.setIsOpeUpdate(true);
        codeConfigInfo.setIsOpeDelete(true);
        codeConfigInfo.setIsOpeDetail(true);
        //每次生成完毕后，关闭资源
        close();
        return codeConfigInfo;
    }
    
}
