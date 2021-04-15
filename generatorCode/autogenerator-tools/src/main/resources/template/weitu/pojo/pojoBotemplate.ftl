<#-- 生成pojo对象 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.pojoBoPackageName};

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ${clazzInfo.tableRemark}
 */
@Data
public class ${clazzInfo.className} implements Serializable {
    private static final long serialVersionUID = 1L;
<#list clazzInfo.fieldList as field>
    /**
     *
     * ${field.fieldRemarks}
     */
    private ${field.fieldType} ${field.fieldName};
</#list>
}