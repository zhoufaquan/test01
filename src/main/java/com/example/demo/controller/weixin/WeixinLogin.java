package com.example.demo.controller.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.weixin.Weixin;
import com.example.demo.util.AesCbcUtil;
import com.example.demo.util.HttpClientUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("weixin")
public class WeixinLogin {
    private String session_key;

 @RequestMapping(value = "/Login",method = RequestMethod.POST)
 @ResponseBody
 public Map<String,String> doLogin(@RequestBody  Weixin weixin) {
     String appid="wx78e814f63c08c5a0";
     String secret="73c5d9328bd4d28bb2dc839ae5e9d3d8";
     String type="authorization_code";
     Map<String,String> parm=new HashMap<>();
     parm.put("appid",appid);
     parm.put("secret",secret);
     parm.put("js_code",weixin.getCode());
     parm.put("grant_type",type);
     String url="https://api.weixin.qq.com/sns/jscode2session";
     String res=HttpClientUtil.doGet(url,parm);
     Weixin wx=JSON.parseObject(res,Weixin.class);
     session_key=wx.getSession_key();
     Map map = new HashMap();
     map.put("openid",wx.getOpenid());
     return map;
 }
 @RequestMapping(value = "/decodePhone",method = RequestMethod.POST)
 @ResponseBody
 public Map<String,String> decodePhone(@RequestBody  Weixin weixin) {
     /*企业级微信才能获取用户的电话*/
     System.out.println(session_key);
     Map map = new HashMap();
     return map;
 }
}
