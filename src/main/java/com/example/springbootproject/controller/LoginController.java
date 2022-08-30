package com.example.springbootproject.controller;

import com.example.springbootproject.domain.MemberForm;
import com.example.springbootproject.service.MemberService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController{

    private final MemberService memberService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String processLogin(@RequestBody MemberForm memberForm ){
        JsonObject json = new JsonObject();

        if(memberService.login(memberForm)){
            json.addProperty("result", "success");
        }
        else{
            json.addProperty("result", "error");
            json.addProperty("message" , "회원 정보를 찾을 수 없습니다.");
        }

        return json.toString();

    }
}