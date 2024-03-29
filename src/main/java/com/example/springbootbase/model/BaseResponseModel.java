package com.example.springbootbase.model;

/**
 * 基本レスポンスモデル
 */
public class BaseResponseModel {
    private Boolean result = true;
    private String errorCode = "";
    private String errorMessage = "";

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
