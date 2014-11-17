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
