package com.bastex.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("vets")
public class VetController {
    @RequestMapping({"", "/"})
    public ModelAndView vetsIndex() {
        return new ModelAndView("vets/vetsindex");
    }
}
