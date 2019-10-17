package com.example.demo.controller.weixin;

import com.example.demo.entity.Candidate;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("weixin")
public class WeixinSign {
    @Autowired
    private CandidateService candidateService;
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> doSign(@RequestBody Candidate candidate){
        Map map=candidateService.toSign(candidate);
        return map;
    }
}
