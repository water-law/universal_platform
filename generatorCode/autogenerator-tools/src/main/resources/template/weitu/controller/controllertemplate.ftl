<#-- controller文件初始化 -->
<#-- 引入定义的变量 -->
<#include "../../variabledefinition.ftl">

package ${packageInfoVo.controllerPackageName};

import ${packageInfoVo.busiServicePackageName}.I${clazzInfo.className}BusiService;
import ${packageInfoVo.commosPackageName}.exception.JudicialException;
import ${packageInfoVo.commosPackageName}.utils.MessageResponse;
import ${packageInfoVo.commosPackageName}.page.PageResult;
import ${packageInfoVo.commosPackageName}.page.PageVo;
import ${packageInfoVo.pojoVoPackageName}.${clazzInfo.className}Vo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *  ${clazzInfo.tableRemark}controller
 * @author ${author}
 */
@Controller
@ResponseBody
@RequestMapping("/${clazzInfo.classNameFirstLowerCase}")
@Api(value = "${clazzInfo.tableRemark}", description = "${clazzInfo.tableRemark}相关接口 ")
public class ${clazzInfo.className}Controller {


    private static final Logger log = LoggerFactory.getLogger(${clazzInfo.className}Controller.class);

    @Autowired
    private I${clazzInfo.className}BusiService ${clazzInfo.classNameFirstLowerCase}BusiService;


    @PostMapping("/add")
    @ApiOperation(value = "新增${clazzInfo.tableRemark}")
    public MessageResponse add(@RequestBody ${clazzInfo.className}Vo record) {
        try {
            boolean flag = ${clazzInfo.classNameFirstLowerCase}BusiService.insert(record);
            return flag ?  MessageResponse.getSuccessMessage("新增成功") : MessageResponse.getFailMessage("新增失败");
        } catch (Exception e) {
            log.error(Thread.currentThread().getName() + " 新增异常");
            throw e;
        }
    }


    @PostMapping("/edit")
    @ApiOperation(value = "修改${clazzInfo.tableRemark}")
    public MessageResponse edit(@RequestBody ${clazzInfo.className}Vo record) {
        try {
            boolean flag =  ${clazzInfo.classNameFirstLowerCase}BusiService.update(record);
            return flag ?  MessageResponse.getSuccessMessage("修改成功") : MessageResponse.getFailMessage("修改失败");
        } catch (Exception e) {
            log.error(Thread.currentThread().getName() + " 修改异常");
            throw e;
        }
    }


    @PostMapping("/del")
    @ApiOperation(value = "删除${clazzInfo.tableRemark}")
    public MessageResponse del(@ApiParam(name = "${primaryKeyName}", value = "${primaryKeyName}") @RequestParam(required = false) String ${primaryKeyName}) {
        try {
            boolean flag = ${clazzInfo.classNameFirstLowerCase}BusiService.deleteByPrimaryKey(${primaryKeyName});
            return flag ?  MessageResponse.getSuccessMessage("删除成功") : MessageResponse.getFailMessage("删除失败");
        } catch (Exception e) {
            log.error(Thread.currentThread().getName() + " 删除异常");
            throw e;
        }
    }


    @PostMapping("/get/list")
    @ApiOperation(value = "${clazzInfo.tableRemark}列表查询")
    public MessageResponse getList(@RequestBody ${clazzInfo.className}Vo record) {
        try {
            PageVo pageVo = PageVo.getPageVo(record.getPageBegin(), record.getPageSize());
            PageResult<${clazzInfo.className}Vo> result =  ${clazzInfo.classNameFirstLowerCase}BusiService.selectByPage(record, pageVo.getPageBegin(), pageVo.getPageSize());
            return MessageResponse.getSuccessMessage(result);
        } catch (Exception e) {
            log.error(Thread.currentThread().getName() + " 列表查询异常");
            throw e;
        }
    }

}
