package net.suncaper.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
