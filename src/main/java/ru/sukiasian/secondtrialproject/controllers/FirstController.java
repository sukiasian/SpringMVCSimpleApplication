package ru.sukiasian.secondtrialproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first/")
public class FirstController {
    @GetMapping("hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name) {
        System.out.println(name);

        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodbyePage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");

        model.addAttribute("message", name);

        System.out.println(name);

        return "first/goodbye";
    }
}
