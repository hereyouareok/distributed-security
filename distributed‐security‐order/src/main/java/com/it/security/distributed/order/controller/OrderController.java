package com.it.security.distributed.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/22 14:22
 **/
@RestController
public class OrderController {

    @GetMapping("r1")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String r1(){
        return "访问资源1";
    }
}
