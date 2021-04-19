package com.weitu.mpsplatform.commons.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询返回对象
 * 
 * @author fsh
 */
public class PageResult<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = 3857074436122722281L;

    /** 是否处理成功 */
    private boolean           isSuccess        = false;

    /** 非业务错误码，仅在<code>isSuccess==false</code>时才有效 */
    private String            errorCode;

    /**返回信息*/
    protected String          message;

    /** 当前页的结果集对象 */
    private List<T>           valueList  = new ArrayList<T>();

    /**
     * 页码
     */
    private int               page;

    /**
     * 记录数
     */
    private int               pageCount;
    
    /**
     * 下一页  起始值
     */
    private long  pageBegin;
    
    
    /**
     *  上一页  起始值
     */
    private long prePageBegin;
    
    /**
     * 扩展对象
     */
    private Object extraObj;

    /**
     * 扩展对象2
     * @return
     */
    private Object extraObj2;

    public Object getExtraObj2() {
        return extraObj2;
    }

    public void setExtraObj2(Object extraObj2) {
        this.extraObj2 = extraObj2;
    }

    public long getPrePageBegin() {
        return prePageBegin;
    }

    public void setPrePageBegin(long prePageBegin) {
        this.prePageBegin = prePageBegin;
    }

    /**
     * Getter method for property <tt>isSuccess</tt>.
     * 
     * @return property value of isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * Setter method for property <tt>isSuccess</tt>.
     * 
     * @param isSuccess value to be assigned to property isSuccess
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     * 
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     * 
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>message</tt>.
     * 
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     * 
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for property <tt>valueList</tt>.
     * 
     * @return property value of valueList
     */
    public List<T> getValueList() {
        return valueList;
    }

    /**
     * Setter method for property <tt>valueList</tt>.
     * 
     * @param valueList value to be assigned to property valueList
     */
    public void setValueList(List<T> valueList) {
        this.valueList = valueList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

	public long getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(long pageBegin) {
		this.pageBegin = pageBegin;
	}

	public Object getExtraObj() {
		return extraObj;
	}

	public void setExtraObj(Object extraObj) {
		this.extraObj = extraObj;
	}
}