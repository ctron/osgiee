package de.dentrassi.osgiee.web4;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ( "/form" )
public class FormController
{
    @RequestMapping ( method = RequestMethod.GET )
    public ModelAndView show ()
    {
        final Map<String, Object> model = new HashMap<> ();
        model.put ( "command", new FormData () );
        return new ModelAndView ( "form", model );
    }

    @RequestMapping ( method = RequestMethod.POST )
    public ModelAndView process ( @Valid
    @ModelAttribute ( "command" )
    final FormData data, final BindingResult result )
    {
        if ( result.hasErrors () )
        {
            final Map<String, Object> model = new HashMap<> ();
            model.put ( "command", data );

            return new ModelAndView ( "form" );
        }
        else
        {
            return new ModelAndView ( "success" );
        }
    }
}
