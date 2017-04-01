package com.score.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cheng on 16/12/13.
 */
@Controller
@RequestMapping("")
public class HomeController {


    @RequestMapping("")
    public String login(){
        return "login";
    }


}
