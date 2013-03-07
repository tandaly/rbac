package com.frame.application.admin.modules.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * FreeMarker示例控制器
 * @author Tandaly
 * @date 2013-3-7 上午9:29:57
 */
@Controller
@RequestMapping("/freeMarker")
public class FreeMarkerController {
    
    @RequestMapping("/hello")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        map.addAttribute("name", " World!");
        return "hello";
    }
    
    @RequestMapping("/hi")
    public String sayHi(ModelMap map) {
        System.out.println("say hi ……");
        map.put("name", "jojo");
        return "hi";
    }
    
    @RequestMapping("/jsp")
    public String jspRequest(ModelMap map) {
        System.out.println("jspRequest ……");
        map.put("name", "jsp");
        return "system/login";
    }
}