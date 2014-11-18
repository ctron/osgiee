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
