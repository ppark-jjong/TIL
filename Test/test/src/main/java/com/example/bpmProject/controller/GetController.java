package com.example.bpmProject.controller;

import com.example.bpmProject.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")//공통되는 URL을 위한 RequestMapping
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Park";
    }

    @GetMapping(value = "/variable/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }


    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=park&email=hi@gmail.com&organization=hiBYe
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + ", and , " + email + ", and , " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=value&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> param
    ) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=park&email=hi@gmail.com&organization=hiBYe
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();

    }

}
