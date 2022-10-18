package com.example.controller;

import com.example.model.People;
import com.example.service.TestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private TestApi testapi;

    @Autowired
    public TestController(TestApi testapi) {
        this.testapi = testapi;
    }

    @GetMapping("/test")
    public ResponseEntity<List<People>> getPeoples(){
        List<People> peoples = testapi.getPeoples();
        return ResponseEntity.ok(peoples);
    }
}
