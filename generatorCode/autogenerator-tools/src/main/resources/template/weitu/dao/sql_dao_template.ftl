<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageInfoVo.daoJavaPackageName}.${clazzInfo.className}Dao">
    <resultMap id="BaseResultMap" type="${packageInfoVo.pojoBoPackageName}.${clazzInfo.className}">
<#list clazzFieldList>
    <#items as field>
		<#if primaryKeyName == field.fieldName>
        <id column="${field.fieldColumnName}" jdbcType="${field.fieldColumnType}" property="${field.fieldName}"/>
		<#else>
        <result column="${field.fieldColumnName}" jdbcType="${field.fieldColumnType}" property="${field.fieldName}"/>
		</#if>
	</#items>
</#list>
    </resultMap>
    <sql id="Base_Column_List">
<#if clazzFieldList??>
    <#list clazzFieldList>
		<#items as field>
			${field.fieldColumnName}<#sep>,
		</#items>
	</#list>
</#if>

    </sql>
    <sql id="Base_Query_Condition">
        <trim prefix="WHERE" prefixOverrides="AND|OR">
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            <#if "deleteFlag" == field.fieldName>
                AND ${field.fieldColumnName} = 0
            <#else>
                <#if "String" == field.fieldType>
             <if test="record.${field.fieldName} != null and record.${field.fieldName} != ''">
                 AND ${field.fieldColumnName} =  ${r'#{'}record.${field.fieldName},jdbcType=${field.fieldColumnType}}
             </if>
                <#else>
             <if test="record.${field.fieldName} != null">
                 AND ${field.fieldColumnName} =  ${r'#{'}record.${field.fieldName},jdbcType=${field.fieldColumnType}}
             </if>
                </#if>
            </#if>
        </#items>
    </#list>
</#if>
        </trim>
    </sql>
    <select id="selectByPage" resultMap="BaseResultMap">
        SELECT
        <include refid="Base_Column_List"></include>
        FROM ${tableName}
        <include refid="Base_Query_Condition"></include>
        <if test="pageBegin > -1 and pageSize > 0 ">
            LIMIT  ${r'#{'}pageBegin} ,  ${r'#{'}pageSize}
        </if>
    </select>
    <select id="selectCount" resultType="java.lang.Integer">
        SELECT
        count(*)
        FROM ${tableName}
        <include refid="Base_Query_Condition"></include>
    </select>
</mapper>
