/*******************************************************************************
 * Copyright (c) 2014 Jens Reimann.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.osgiee.web5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.dentrassi.osgiee.service2.BookService;
import de.dentrassi.osgiee.web5.internal.Activator;

@Controller
public class WelcomeController
{
    @RequestMapping ( "/" )
    public ModelAndView main ()
    {
        final BookService bs = Activator.getBookService ();
        if ( bs == null )
        {
            return new ModelAndView ( "redirect:/setup" );
        }
        else
        {
            final Map<String, Object> model = new HashMap<> ();
            model.put ( "books", bs.listAll () );
            return new ModelAndView ( "index", model );
        }
    }
}
