<#-- detail.jsp文件生成 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">
package ${packageInfoVo.busiServicePackageName}.impl;

import ${packageInfoVo.busiServicePackageName}.I${clazzInfo.className}BusiService;
import ${packageInfoVo.commosPackageName}.page.PageResult;
import ${packageInfoVo.pojoVoPackageName}.${clazzInfo.className}Vo;
import ${packageInfoVo.servicePackageName}.I${clazzInfo.className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ${clazzInfo.className}BusiService implements I${clazzInfo.className}BusiService {

    @Autowired
    private I${clazzInfo.className}Service ${clazzInfo.classNameFirstLowerCase}Service;

    @Override
    public boolean deleteByPrimaryKey(String ${primaryKeyName}) {
        int result = ${clazzInfo.classNameFirstLowerCase}Service.deleteByPrimaryKey(${primaryKeyName});
        return result > 0 ? true : false;
    }

    @Override
    public boolean insert(${clazzInfo.className}Vo record) {
        String result = ${clazzInfo.classNameFirstLowerCase}Service.insertSelective(record);
        return result != null ? true : false;
    }

    @Override
    public ${clazzInfo.className}Vo selectByPrimaryKey(String ${primaryKeyName}) {
        return ${clazzInfo.classNameFirstLowerCase}Service.selectByPrimaryKey(${primaryKeyName});
    }

    @Override
    public boolean update(${clazzInfo.className}Vo record) {
        int result = ${clazzInfo.classNameFirstLowerCase}Service.updateByPrimaryKeySelective(record);
        return result > 0 ? true : false;
    }

    @Override
    public PageResult<${clazzInfo.className}Vo> selectByPage(${clazzInfo.className}Vo record, int pageBegin, int pageSize) {
    PageResult<${clazzInfo.className}Vo> page = new PageResult<>();
        List<${clazzInfo.className}Vo> list = ${clazzInfo.classNameFirstLowerCase}Service.selectByPage(record, pageBegin, pageSize);
		page.setValueList(list);
		page.setPageCount(${clazzInfo.classNameFirstLowerCase}Service.selectCount(record));
		page.setSuccess(true);
		return page;
	}

	@Override
	public int selectCount(${clazzInfo.className}Vo record) {
		return ${clazzInfo.classNameFirstLowerCase}Service.selectCount(record);
	}

}

