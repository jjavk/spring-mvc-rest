package com.github.rest.controller;

import com.github.rest.annotation.IgnoreSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiabin on 2018/5/13.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/html")
    @IgnoreSecurity
    public String index() {
        return "index";
    }
}
