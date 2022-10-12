package ru.sukiasian.secondtrialproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sukiasian.secondtrialproject.dao.PersonDAO;


@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonDAO personDAO;

    @Autowired
    public PeopleController(@Autowired PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        // получим всех людей из dao и передадим в представление
        model.addAttribute("people", personDAO.index());

        return "people/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));

        return "people/show";
    }


    @GetMapping("form")
    public String showForm() {
        return "people/add-person-form";
    }

    @PostMapping
    public void addPeople(@RequestBody String request) {
        System.out.println(request);
    }
}
