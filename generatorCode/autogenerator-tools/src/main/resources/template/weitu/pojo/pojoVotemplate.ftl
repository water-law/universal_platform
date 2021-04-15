<#-- 生成pojo对象 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.pojoVoPackageName};

import ${packageInfoVo.commosPackageName}.page.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import lombok.Data;

/**
 * ${clazzInfo.tableRemark}
 */
@ApiModel(value = "${clazzInfo.tableRemark}")
@Data
public class ${clazzInfo.className}Vo extends PageVo {
    private static final long serialVersionUID = 1L;
<#list clazzInfo.fieldList as field>
    /**
     *
     * ${field.fieldRemarks}
     */
    @ApiModelProperty(value = "${field.fieldRemarks}")
    private ${field.fieldType} ${field.fieldName};
</#list>
}