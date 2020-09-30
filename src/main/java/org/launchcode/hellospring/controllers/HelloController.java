package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("hello")
public class HelloController {
    // Handles request at path hello

    @PostMapping("sayHello")
    @ResponseBody
    public String hello(@RequestParam String name,@RequestParam String language){
        return createMessage(name, language);
    }


    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring";
    }

    //lives at /hello?name=LaunchCode
    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){

        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // lives at /hello/Launch
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name,Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
    return "hello";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
    public static String createMessage(String name,String language) {
        String result = "";
        if (language.equals("english")) {
            result = "Hello, " + name;
        } else if (language.equals("spanish")) {
            result = "HOLA, " + name;
        } else if (language.equals("french")) {
            result = "BONJOUR, " + name;
        } else if (language.equals("italian")) {
            result = "CIAO, " + name;
        } else if (language.equals("swahili")) {
            result = "JAMBO, " + name;
        }
        return result;
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names",names);
        return "hello-list";
    }
}
