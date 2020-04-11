//package com.kastking.personProduct.controller;
//
//import com.kastking.personProduct.core.TestHttp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kastking/test/api")
//public class TestsController {
//
//    @Autowired
//    private TestHttp testHttp;
//
//    @GetMapping("test1")
//    public String test1(@RequestParam("str") String str,@RequestParam("name") String name) {
//        return testHttp.test(str,name);
//    }
//}
