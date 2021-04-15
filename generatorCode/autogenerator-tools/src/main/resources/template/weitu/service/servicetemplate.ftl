<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.servicePackageName};

import ${packageInfoVo.pojoVoPackageName}.${clazzInfo.className}Vo;

import java.util.List;

/**
 * @Description ${clazzInfo.tableRemark}Service接口
 * @Author: ${author}
 **/
public interface I${clazzInfo.className}Service {


    /**
     * @return
     * @Description 根据主键删除
     * @Author: ${author}
     * @Param
     **/
    int deleteByPrimaryKey(String ${primaryKeyName});

    /**
     * @return
     * @Description 插入
     * @Author: ${author}
     * @Param
     **/
    String insert(${clazzInfo.className}Vo record);

    /**
     * @return
     * @Description 插入
     * @Author: ${author}
     * @Param
     **/
    String insertSelective(${clazzInfo.className}Vo record);

    /**
     * @return
     * @Description 根据主键查询
     * @Author: ${author}
     * @Param
     **/
    ${clazzInfo.className}Vo selectByPrimaryKey(String ${primaryKeyName});

    /**
     * @return
     * @Description 更新
     * @Author: ${author}
     * @Param
     **/
    int updateByPrimaryKeySelective(${clazzInfo.className}Vo record);

    /**
     * @return
     * @Description 更新
     * @Author: ${author}
     * @Param
     **/
    int updateByPrimaryKey(${clazzInfo.className}Vo record);

    /**
     * @return
     * @Description 查询分页信息
     * @Author: ${author}
     * @Param
     **/
    List<${clazzInfo.className}Vo> selectByPage(${clazzInfo.className}Vo record, int pageBegin, int pageSize);

    /**
    * @return
    * @Description 查询总数
    * @Author: ${author}
    * @Param
    **/
    int selectCount(${clazzInfo.className}Vo record);

}
