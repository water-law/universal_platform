<#-- dao文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.mapperJavaPackageName};

import ${packageInfoVo.pojoBoPackageName}.${clazzInfo.className};
/**
 * ${clazzInfo.tableRemark}Mapper
 */
public interface ${clazzInfo.className}Mapper {
    /**
     *
     * 根据主键删除单条数据
     *
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * 保存所有字段数据
     *
     */
    int insert(${clazzInfo.className} record);

    /**
     *
     * 保存数据，只保存不为null的字段
     *
     */
    int insertSelective(${clazzInfo.className} record);

    /**
     *
     * 根据主键查询数据
     *
     */
    ${clazzInfo.className} selectByPrimaryKey(String id);

    /**
     *
     * 根据条件修改数据
     *
     */
    int updateByPrimaryKeySelective(${clazzInfo.className} record);

    /**
     *
     * 根据主键修改数据
     *
     */
    int updateByPrimaryKey(${clazzInfo.className} record);
}