<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.daoJavaPackageName};

import ${packageInfoVo.pojoBoPackageName}.${clazzInfo.className};
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${clazzInfo.tableRemark}Dao
 */
public interface ${clazzInfo.className}Dao {

    /**
     * 查询记录列表
     *
     * @param record
     * @return
     */
    List<${clazzInfo.className}> selectByPage(@Param("record") ${clazzInfo.className} record,
    @Param("pageBegin") int pageBegin,
    @Param("pageSize") int pageSize);

    /**
    * 查询记录总数
    *
    * @param record
    * @return
    */
    int selectCount(@Param("record") ${clazzInfo.className} record);

}