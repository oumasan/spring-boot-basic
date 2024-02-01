package com.example.springbootbase.model;

/**
 * 基本レスポンスモデル
 */
public class BaseResponseModel {
    private Boolean result = true;
    private String errorCode = "";

    public BaseResponseModel() {
    }

    public BaseResponseModel(Boolean result, String errorCode) {
        this.result = result;
        this.errorCode = errorCode;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
