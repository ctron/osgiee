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

 import javax.validation.constraints.NotNull;

 import org.hibernate.validator.constraints.NotEmpty;

 public class FormData
 {
     @NotEmpty
     @NotNull
     private String name;

     public void setName ( final String name )
     {
         this.name = name;
     }

     public String getName ()
     {
         return this.name;
     }
 }
