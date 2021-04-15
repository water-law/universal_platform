<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.busiServicePackageName};

import ${packageInfoVo.commosPackageName}.page.PageResult;
import ${packageInfoVo.pojoVoPackageName}.${clazzInfo.className}Vo;

/**
 * @Description ${clazzInfo.tableRemark}BusiService接口
 * @Author: ${author}
 **/
public interface I${clazzInfo.className}BusiService {


    /**
     * @return
     * @Description 根据主键删除
     * @Author: ${author}
     * @Param
     **/
    boolean deleteByPrimaryKey(String ${primaryKeyName});

    /**
     * @return
     * @Description 插入
     * @Author: ${author}
     * @Param
     **/
    boolean insert(${clazzInfo.className}Vo record);


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
    boolean update(${clazzInfo.className}Vo record);

    /**
     * @return
     * @Description 查询分页信息
     * @Author: linjintao
     * @Param
     **/
    PageResult<${clazzInfo.className}Vo> selectByPage(${clazzInfo.className}Vo record, int pageBegin, int pageSize);

    /**
    * @return
    * @Description 查询总数
    * @Author: ${author}
    * @Param
    **/
    int selectCount(${clazzInfo.className}Vo record);

}
