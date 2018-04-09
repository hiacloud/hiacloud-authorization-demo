/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hiacloud.demo.rest;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 
  * @ClassName: AbstractResponse
  * @Description: Ajax请求相应抽象类。
  * @author zhuqinghua@emcc.net.cn
  * @date 2015年7月2日 下午12:14:44
  *
 */
@ApiModel("响应")
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    
	public static final String responseStatu_searchSuccess  = "查询成功!";
	public static final String responseStatu_addSuccess     = "添加成功!";
	public static final String responseStatu_createSuccess  = "创建成功!";
	public static final String responseStatu_updateSuccess  = "修改成功!";
	public static final String responseStatu_deleteSuccess  = "删除成功!";

	public static final String responseStatu_searchFail     = "没有找到数据!";
	public static final String responseStatu_addFail        = "添加失败,请稍后再试!";
	public static final String responseStatu_createFail     = "创建失败,请稍后再试!";
	public static final String responseStatu_updateFail     = "修改失败,请稍后再试!";
	public static final String responseStatu_deleteFail     = "删除失败,请稍后再试!";
	
	
    /** 响应是否成功. */
	@ApiModelProperty("响应是否成功")
    private boolean success = false;
    /** 响应的操作信息. */
	@ApiModelProperty("响应的操作信息")
    private String msg;
    /** 错误信息. */
	@ApiModelProperty("错误信息")
    private String error;
    /** 错误代码    */
	@ApiModelProperty("错误码")
    private String errno;
    /** 返回的对象   */
	@ApiModelProperty("返回对象")
    private Object obj;

    public BaseResponse() {}

    public BaseResponse(boolean success, String error) {
        super();
        this.success = success;
        this.error = error;
    }

    /**
     * getter method
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * setter method
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * getter method
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * setter method
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * setter method
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * getter method
     */
    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }
	
    /**
     * 客户端响应数据
     * 
     * @param isSuccess
     * @param msg
     * @param data
     * @return
     */
	public static BaseResponse getResponse(Boolean isSuccess, String msg, Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.success = isSuccess;
		baseResponse.msg = msg;
		baseResponse.obj = data;
		return baseResponse;
	}
}
