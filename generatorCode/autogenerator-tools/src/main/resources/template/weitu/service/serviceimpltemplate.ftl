<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.servicePackageName}.impl;

import ${packageInfoVo.commosPackageName}.utils.KeyMarker;
import ${packageInfoVo.commosPackageName}.utils.SString;
import ${packageInfoVo.daoJavaPackageName}.${clazzInfo.className}Dao;
import ${packageInfoVo.mapperJavaPackageName}.${clazzInfo.className}Mapper;
import ${packageInfoVo.pojoBoPackageName}.${clazzInfo.className};
import ${packageInfoVo.pojoVoPackageName}.${clazzInfo.className}Vo;
import ${packageInfoVo.servicePackageName}.I${clazzInfo.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static ${packageInfoVo.commosPackageName}.utils.BeanConvertTools.*;

@Service
@Transactional
public class ${clazzInfo.className}Service implements I${clazzInfo.className}Service {

    @Resource
    private ${clazzInfo.className}Mapper ${clazzInfo.classNameFirstLowerCase}Mapper;
    @Resource
    private ${clazzInfo.className}Dao ${clazzInfo.classNameFirstLowerCase}Dao;

    @Override
    public int deleteByPrimaryKey(String ${primaryKeyName}) {
        return ${clazzInfo.classNameFirstLowerCase}Mapper.deleteByPrimaryKey(${primaryKeyName});
    }

    @Override
    public String insert(${clazzInfo.className}Vo record) {
        int result = -1;
        if (SString.isBlank(SString.getTrimString(record.get${primaryKeyNameFirstUpper}()))) {
            record.set${primaryKeyNameFirstUpper}(KeyMarker.getKey());
        }
        if (SString.isBlank(SString.getTrimString(record.getGmtCreated()))) {
            record.setGmtCreated(new Date());
        }
        if (SString.isBlank(SString.getTrimString(record.getGmtModified()))) {
            record.setGmtModified(new Date());
        }
        result = ${clazzInfo.classNameFirstLowerCase}Mapper.insert(copyPropertiesToClazz(record, ${clazzInfo.className}.class));
        return result > 0 ? record.get${primaryKeyNameFirstUpper}() : "";
    }

    @Override
    public String insertSelective(${clazzInfo.className}Vo record) {
        int result = -1;
        if (SString.isBlank(SString.getTrimString(record.get${primaryKeyNameFirstUpper}()))) {
            record.set${primaryKeyNameFirstUpper}(KeyMarker.getKey());
        }
        if (SString.isBlank(SString.getTrimString(record.getGmtCreated()))) {
            record.setGmtCreated(new Date());
        }
        if (SString.isBlank(SString.getTrimString(record.getGmtModified()))) {
            record.setGmtModified(new Date());
        }
        result = ${clazzInfo.classNameFirstLowerCase}Mapper.insertSelective(copyPropertiesToClazz(record, ${clazzInfo.className}.class));
        return result > 0 ? record.get${primaryKeyNameFirstUpper}() : "";
    }

    @Override
    public ${clazzInfo.className}Vo selectByPrimaryKey(String ${primaryKeyName}) {
        return copyPropertiesToClazz(${clazzInfo.classNameFirstLowerCase}Mapper.selectByPrimaryKey(${primaryKeyName}), ${clazzInfo.className}Vo.class);
    }

    @Override
    public int updateByPrimaryKeySelective(${clazzInfo.className}Vo record) {
        if (SString.isBlank(SString.getTrimString(record.getGmtModified()))) {
            record.setGmtModified(new Date());
        }
        return ${clazzInfo.classNameFirstLowerCase}Mapper.updateByPrimaryKeySelective(copyPropertiesToClazz(record, ${clazzInfo.className}.class));
    }

    @Override
    public int updateByPrimaryKey(${clazzInfo.className}Vo record) {
        if (SString.isBlank(SString.getTrimString(record.getGmtModified()))) {
            record.setGmtModified(new Date());
        }
        return ${clazzInfo.classNameFirstLowerCase}Mapper.updateByPrimaryKey(copyPropertiesToClazz(record, ${clazzInfo.className}.class));
    }

    @Override
    public List<${clazzInfo.className}Vo> selectByPage(${clazzInfo.className}Vo record, int pageBegin, int pageSize) {
        return copyList(${clazzInfo.classNameFirstLowerCase}Dao.selectByPage(copyPropertiesToClazz(record, ${clazzInfo.className}.class), pageBegin, pageSize), ${clazzInfo.className}Vo.class);
    }

    @Override
    public int selectCount(${clazzInfo.className}Vo record) {
        return ${clazzInfo.classNameFirstLowerCase}Dao.selectCount(copyPropertiesToClazz(record, ${clazzInfo.className}.class));
    }

}