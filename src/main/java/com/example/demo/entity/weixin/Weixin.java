package com.example.demo.entity.weixin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weixin {
    private String openid;
    private String session_key;
    private String code;
    private String encryptedData;
    private  String iv;

}
