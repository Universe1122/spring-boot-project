package com.example.springbootproject.controller;

import com.example.springbootproject.domain.MemberForm;
import com.example.springbootproject.service.MemberService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController{
    @Autowired
    MemberService memberService;

    @GetMapping("/auth/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/auth/login")
    @ResponseBody
    public String processLogin(@RequestBody MemberForm memberForm ){
        JsonObject json = new JsonObject();

        json.addProperty("userid", memberForm.getUserid());
        json.addProperty("userpw", memberForm.getUserpw());

        return json.toString();
    }
}