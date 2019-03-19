package com.designer.th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ThApplication {
    @GetMapping("GG")
    public Map getString(){
        Map map = new HashMap();
        map.put("key","123");
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThApplication.class, args);
    }
}
