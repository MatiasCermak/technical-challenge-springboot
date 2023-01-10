package com.example.technicalchallengebackend.response;

import com.example.technicalchallengebackend.enums.ResponseCodes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response <T> {
    private String code;
    private String message;
    private T data;

    public  Response(ResponseCodes responseCodes, T data){
        this.code = responseCodes.getCode();
        this.message = responseCodes.getMessage();
        this.data = data;
    }

    public void setCode(ResponseCodes responseCodes){
        this.code = responseCodes.getCode();
    }

    public void setMessage(ResponseCodes responseCodes) {
        this.message = responseCodes.getMessage();
    }
}
