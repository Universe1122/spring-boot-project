package com.example.springbootproject.controller;

import com.example.springbootproject.domain.MemberForm;
import com.example.springbootproject.service.MemberService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> processLogin(@RequestBody MemberForm memberForm ){
        Map<String, String> result = new HashMap<>();

        if(memberService.login(memberForm)){
            result.put("result", "success");
        }
        else{
            result.put("result", "error");
            result.put("message", "회원 정보를 찾을 수 없습니다.");
        }

        // ResponseEntity 사용 방법
        // https://hyeonic.tistory.com/197
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}