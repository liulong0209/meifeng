package net.beautifycrack.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
public class HomeController {

	/**
	 * Ìø×ªµ½Ê×Ò³
	 * @return
	 */
	@RequestMapping(value = "/home.do")
    public ModelAndView newsIndex()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home");

        return mv;
    }
}
