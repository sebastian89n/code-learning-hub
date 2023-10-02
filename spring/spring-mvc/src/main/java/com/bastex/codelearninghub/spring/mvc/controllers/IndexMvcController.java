package com.bastex.codelearninghub.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Just maps index page on "" and "/" and points to page that redirects by default to books.
 * Another approach would be to use a filter with the redirect.
 */
@Controller
public class IndexMvcController {
    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
