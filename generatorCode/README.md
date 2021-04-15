## generatorCode

自动生成代码工具

默认使用 lombok, 如若想使用原生的 get/set/toString，
请自行修改模板

```
<#list clazzInfo.fieldList as field>
    public ${field.fieldType} get${field.fieldNameUpperFirstLetter}() {
        return ${field.fieldName};
    }

    public void set${field.fieldNameUpperFirstLetter}(${field.fieldType} ${field.fieldName}) {
        this.${field.fieldName} = ${field.fieldName};
    }
</#list>

    @Override
    public String toString() {
        return "${clazzInfo.className}{" +
<#list clazzInfo.fieldList as field>
                "${field.fieldName}='" + ${field.fieldName} + '\'' +
</#list>
                '}';
    }
```

