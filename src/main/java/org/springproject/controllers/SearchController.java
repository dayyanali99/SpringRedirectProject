package org.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SearchController
{

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("querybox") String query)
    {
        if (query.isEmpty())
            return "redirect:/";
        return "redirect:https://www.google.com/search?q="+query;
    }
}
