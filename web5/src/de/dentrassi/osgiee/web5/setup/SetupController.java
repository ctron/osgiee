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
package de.dentrassi.osgiee.web5.setup;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.dentrassi.osgiee.web5.Configurator;
import de.dentrassi.osgiee.web5.internal.Activator;

@Controller
public class SetupController
{
    @RequestMapping ( value = "/setup", method = RequestMethod.GET )
    public ModelAndView main ()
    {
        final Map<String, Object> model = new HashMap<> ();

        try ( Configurator cfg = Configurator.create () )
        {
            model.put ( "command", cfg.getDatabaseSettings () );
        }

        model.put ( "jdbcDrivers", Activator.getJdbcDrivers () );

        return new ModelAndView ( "setup/index", model );
    }

    @RequestMapping ( value = "/setup", method = RequestMethod.POST )
    public ModelAndView setup ( @Valid
            @ModelAttribute ( "command" )
    final SetupData data, final BindingResult result )
    {
        final Map<String, Object> model = new HashMap<> ();
        model.put ( "command", data );

        model.put ( "jdbcDrivers", Activator.getJdbcDrivers () );

        if ( !result.hasErrors () )
        {
            // store

            try ( Configurator cfg = Configurator.create () )
            {
                cfg.setDatabaseSettings ( data );
            }

            if ( Activator.waitForBookService ( 5000 ) != null )
            {
                return new ModelAndView ( "redirect:/" );
            }
        }

        return new ModelAndView ( "setup/index", model );
    }
}
