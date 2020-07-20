package com.ashimaFabMonitor.controller;

import com.ashimaFabMonitor.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    RestService restService;

    @GetMapping("/")
    public Object get(){
        return restService.getPostsPlainJSON().get(0);
    }

}
