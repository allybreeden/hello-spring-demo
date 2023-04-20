package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")   //everything will be /hello
public class HelloController {

    //handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @GetMapping("hello")
    public String helloWithQueryParam( @RequestParam String name) {
       return "Hello, " + name + "!";
    }

   //Handles requests of /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam( @PathVariable String name) {
        return "Hi, " + name + "?";
    }

    //Display form

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action= 'hello' method = 'post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
