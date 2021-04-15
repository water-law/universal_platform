<#-- 默认值定义 -->
<#-- 定义变量 -->
<#assign clazzInfo = codeConfigInfo.clazzInfo />
<#assign primaryKeyName = clazzInfo.primaryKeyName />
<#assign primaryKeyColumnName = clazzInfo.primaryKeyColumnName />
<#assign primaryKeyColumnType = clazzInfo.primaryKeyColumnType/>
<#assign primaryKeyNameFirstUpper = clazzInfo.primaryKeyNameFirstUpper />
<#assign tableName = clazzInfo.tableName />
<#assign isOpeQuery = codeConfigInfo.isOpeQuery!false />
<#assign isOpeAdd = codeConfigInfo.isOpeAdd!false />
<#assign isOpeUpdate = codeConfigInfo.isOpeUpdate!false />
<#assign isOpeDelete = codeConfigInfo.isOpeDelete!false />
<#assign isOpeDetail = codeConfigInfo.isOpeDetail!false />
<#assign queryFieldList = codeConfigInfo.queryConditionInfo.queryFieldList />
<#assign gridFieldList = codeConfigInfo.gridInfo.gridFieldList />
<#assign formFieldList = codeConfigInfo.formInfo.formFieldList />
<#assign clazzFieldList = codeConfigInfo.clazzInfo.fieldList />
<#assign author = codeConfigInfo.baseConfigInfoVo.authorName!'auto' />
<#assign pojoSuffix = codeConfigInfo.baseConfigInfoVo.pojoSuffix!'Vo' />
<#assign isDuplicateName = codeConfigInfo.baseConfigInfoVo.isDuplicateName!false />
<#assign duplicateNamePrefix = codeConfigInfo.baseConfigInfoVo.duplicateNamePrefix!'' />
<#assign packageInfoVo = codeConfigInfo.packageInfoVo />
<#if isDuplicateName>
<#assign classNameAlias = (duplicateNamePrefix + clazzInfo.classNameFirstLowerCase + pojoSuffix) />
<#else>
<#assign classNameAlias = (clazzInfo.classNameFirstLowerCase + pojoSuffix) />
</#if>
