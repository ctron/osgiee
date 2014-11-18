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
package de.dentrassi.osgiee.service2;

import java.util.List;

import de.dentrassi.osgiee.jpa1.Book;

public interface BookService
{
    public void persist ( Book book );

    public void delete ( long bookId );

    public List<Book> listAll ();

    public Book get ( long bookId );
}
