package com.ssm.exception;

import com.ssm.entity.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
public class CommonException extends Exception  {

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
