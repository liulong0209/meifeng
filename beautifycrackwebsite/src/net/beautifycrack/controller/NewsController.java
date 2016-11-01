package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
public class NewsController
{
    @RequestMapping(value = "/newsmanager")
    public ModelAndView newsIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/news/newsList");

        return mv;
    }
}
