package com.sure.zerotoone.exception;


import com.sure.zerotoone.common.ErrorCode;

public class BusinessException extends RuntimeException{
    private final int code;

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(int code,String message) {
        super(message);
        this.code = code;
    }



    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();

    }
    public BusinessException(ErrorCode errorCode,String message){
        super(message);
        this.code = errorCode.getCode();
    }



    public int getCode() {
        return code;
    }
}
