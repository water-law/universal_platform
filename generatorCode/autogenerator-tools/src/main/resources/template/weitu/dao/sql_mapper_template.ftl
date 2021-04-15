<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageInfoVo.mapperJavaPackageName}.${clazzInfo.className}Mapper">
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
    <select id="selectByPrimaryKey" parameterType="java.lang.String" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        where ${primaryKeyColumnName} = ${r'#{'}${primaryKeyName},jdbcType=${primaryKeyColumnType}}
    </select>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.String">
        delete from ${tableName}
        where ${primaryKeyColumnName} = ${r'#{'}${primaryKeyName},jdbcType=${primaryKeyColumnType}}
    </delete>
    <insert id="insert" parameterType="${packageInfoVo.pojoBoPackageName}.${clazzInfo.className}">
        insert into ${tableName} (
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            ${field.fieldColumnName}<#sep>,
        </#items>
    </#list>
</#if>

        )
        values (
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            ${r'#{'}${field.fieldName},jdbcType=${field.fieldColumnType}}<#sep>,
        </#items>
    </#list>
</#if>

        )
    </insert>
    <insert id="insertSelective" parameterType="${packageInfoVo.pojoBoPackageName}.${clazzInfo.className}">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            <if test="${field.fieldName} != null">
                ${field.fieldColumnName},
            </if>
        </#items>
    </#list>
</#if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            <if test="${field.fieldName} != null">
                ${r'#{'}${field.fieldName}, jdbcType=${field.fieldColumnType}},
            </if>
        </#items>
    </#list>
</#if>
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="${packageInfoVo.pojoBoPackageName}.${clazzInfo.className}">
        update ${tableName}
        <set>
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            <if test="${field.fieldName} != null">
                ${field.fieldColumnName} =  ${r'#{'}${field.fieldName}, jdbcType=${field.fieldColumnType}},
            </if>
        </#items>
    </#list>
</#if>

        </set>
        where  ${primaryKeyColumnName} = ${r'#{'}${primaryKeyName},jdbcType=${primaryKeyColumnType}}
    </update>
    <update id="updateByPrimaryKey" parameterType="${packageInfoVo.pojoBoPackageName}.${clazzInfo.className}">
        update ${tableName}
        set
<#if clazzFieldList??>
    <#list clazzFieldList>
        <#items as field>
            ${field.fieldColumnName} = ${r'#{'}${field.fieldName},jdbcType=${field.fieldColumnType}}<#sep>,
        </#items>
    </#list>
</#if>

        where  ${primaryKeyColumnName} = ${r'#{'}${primaryKeyName},jdbcType=${primaryKeyColumnType}}
    </update>

</mapper>