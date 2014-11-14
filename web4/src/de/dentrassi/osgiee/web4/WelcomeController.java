package de.dentrassi.osgiee.web4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{
    @RequestMapping ( value = "/", method = RequestMethod.GET )
    public ModelAndView index ()
    {
        final ModelAndView mv = new ModelAndView ( "index" );

        mv.addObject ( "timestamp", System.currentTimeMillis () );

        return mv;
    }
}
