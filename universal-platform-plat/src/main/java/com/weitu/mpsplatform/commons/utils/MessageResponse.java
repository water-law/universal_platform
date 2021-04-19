package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.constants.SaasPlatConstants;
import com.weitu.mpsplatform.commons.exception.SExceptionTools;

import java.io.Serializable;


/**
 * 消息对象
 *
 * @author fsh
 */
public class MessageResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4181751422540267420L;

    /**
     * 消息类型
     */
    private String messageType = "";

    /**
     * 消息体，消息内容要显示：成功或失败信息。
     */
    private String messageContent = "";

    /**
     * 业务返回的数据对象
     */
    private Object valueObj;

    /**
     * 重定向URL
     */
    private String redirectUrl = "";
    /**
     * 消息状态码
     */
    private Integer statusCode;


    public MessageResponse() {
        super();
    }

    public MessageResponse(String messageType, String messageContent, Object valueObj,
                           String redirectUrl) {
        super();
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.valueObj = valueObj;
        this.redirectUrl = redirectUrl;
    }

    public MessageResponse(MessageType messageType, String messageContent, Object valueObj) {
        super();
        this.messageType = String.valueOf(messageType);
        this.messageContent = messageContent;
        this.valueObj = valueObj;
    }

    public MessageResponse(MessageType messageType) {
        super();
        this.messageType = String.valueOf(messageType);
    }

    public MessageResponse(MessageType messageType, Object valueObj) {
        super();
        this.messageType = String.valueOf(messageType);
        this.valueObj = valueObj;
    }

    public MessageResponse(MessageType messageType, String messageContent) {
        super();
        this.messageType = String.valueOf(messageType);
        this.messageContent = messageContent;
    }

    public MessageResponse(String messageType, Object valueObj) {
        super();
        this.messageType = messageType;
        this.valueObj = valueObj;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = String.valueOf(messageType);
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Object getValueObj() {
        return valueObj;
    }

    public void setValueObj(Object valueObj) {
        this.valueObj = valueObj;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 消息类型
     *
     * @author 范森华
     */
    public enum MessageType {
        SUCCESS,    //成功
        FAIL,       //失败
        WARN,       //警告
        APPROVE,    //需要选择下一步审批人
        PROCESS     //后台有异步任务在执行
    }

    /**
     * 消息状态码
     */
    public static class StatusCode {
        public static final int STATUS_CODE_SUCCESS = 200;
        public static final int STATUS_CODE_BUSI_ERROR = 204;
    }

    /**
     * Method description : 返回成功消息
     * <p>
     * Author：fsh
     *
     * @param messageContent
     * @return
     */
    public static MessageResponse getSuccessMessage(String messageContent) {
        return getSuccessMessage(messageContent, null);
    }

    /**
     * Method description : 返回成功消息
     * <p>
     * Author：fsh
     *
     * @param obj
     * @return
     */
    public static MessageResponse getSuccessMessage(Object obj) {
        return getSuccessMessage(null, obj);
    }

    /**
     *  返回成功消息
     * @param messageContent
     * @param obj
     * @return
     */
    public static MessageResponse getSuccessMessage(String messageContent, Object obj) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setStatusCode(StatusCode.STATUS_CODE_SUCCESS);
        messageResponse.setMessageContent(messageContent);
        messageResponse.setMessageType(MessageType.SUCCESS);
        messageResponse.setValueObj(obj);
        return messageResponse;
    }

    /**
     * Method description : 返回失败消息
     * <p>
     * Author：fsh
     *
     * @param messageContent
     * @return
     */
    public static MessageResponse getFailMessage(String messageContent) {
        return getFailMessage(StatusCode.STATUS_CODE_BUSI_ERROR, messageContent);
    }

    /**
     *  返回失败
     * @param messageContent
     * @param obj
     * @return
     */
    public static MessageResponse getFailMessage(String messageContent, Object obj) {
        return getFailMessage(StatusCode.STATUS_CODE_BUSI_ERROR, messageContent, obj);
    }

    public static MessageResponse getFailMessage(int statusCode, String messageContent) {
        return getFailMessage(statusCode, messageContent, null);
    }

    public static MessageResponse getFailMessage(int statusCode, String messageContent, Object obj) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessageType(MessageType.FAIL);
        messageResponse.setStatusCode(statusCode);
        messageResponse.setMessageContent(messageContent);
        messageResponse.setValueObj(obj);
        return messageResponse;
    }

    /**
     * Method description : 返回警告消息
     * <p>
     * Author：fsh
     *
     * @param messageContent
     * @return
     */
    public static MessageResponse getWarnMessage(String messageContent) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessageType(MessageType.WARN);
        messageResponse.setMessageContent(messageContent);
        return messageResponse;
    }

    /**
     * Method description : 返回执行类型的异常信息（若非该类型异常，则返回系统繁忙）
     * <p>
     * Author：fsh
     *
     * @param e
     * @param exceptionType
     * @return
     */
    public static MessageResponse getExceptionMessage(Exception e, Class exceptionType) {
        Throwable throwable = SExceptionTools.getException(e, exceptionType);
        if (throwable != null) {
            return MessageResponse.getFailMessage(throwable.getMessage());
        } else {
            return MessageResponse
                    .getFailMessage(SaasPlatConstants.MessageConstants.SYSTEM_ERROR_MESSAGE);
        }
    }

}