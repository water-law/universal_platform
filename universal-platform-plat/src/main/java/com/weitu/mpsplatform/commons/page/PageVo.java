package com.weitu.mpsplatform.commons.page;

import com.weitu.mpsplatform.commons.constants.SaasBusinessConstants;

import java.io.Serializable;

/**
 * 分页Vo
 *
 * @author fsh
 */
public class PageVo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2001090003559170569L;

    public static int MAX_PAGE_SIZE = 3000;
    /**
     * 页码
     */
    private int pageBegin;

    /**
     * 记录数
     */
    private int pageSize;


    /**
     * 设置页码
     *
     * @param pageNos
     * @param pageSizes
     * @return
     */
    public static PageVo getPageVo(Integer pageNos, Integer pageSizes) {
        PageVo pageVo = new PageVo();
        //页码
        int pageNum = 0;
        //记录数
        int pageSize = 0;
        if (pageNos == null || "0".equals(pageNos.toString())) {
            pageNos = SaasBusinessConstants.SaasPage.PAGE_NUM_INT;
        }
        pageNum = pageNos;
        if (pageSizes == null || "0".equals(pageSizes.toString())) {
            pageSizes = SaasBusinessConstants.SaasPage.PAGE_SIZE_INT;
        }
        pageSize = pageSizes;
        if (pageSize > MAX_PAGE_SIZE) {
            throw new PageExeception("当前分页请求记录数超过允许的最大值:" + MAX_PAGE_SIZE);
        }

        int pageBegin = (pageNum - 1) * pageSize;
        pageVo.setPageBegin(pageBegin);
        pageVo.setPageSize(pageSize);
        return pageVo;
    }

    public int getPageBegin() {
        return pageBegin;
    }

    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}