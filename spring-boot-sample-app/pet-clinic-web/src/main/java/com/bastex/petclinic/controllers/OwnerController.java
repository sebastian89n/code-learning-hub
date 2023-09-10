package com.bastex.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @RequestMapping({"", "/"})
    public ModelAndView ownersIndex() {
        return new ModelAndView("owners/ownersindex");
    }
}
