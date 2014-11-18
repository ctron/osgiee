package de.dentrassi.osgiee.service2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import de.dentrassi.osgiee.jpa1.Book;
import de.dentrassi.osgiee.service2.BookService;

public class BookServiceImpl extends AbstractJpaServiceImpl implements BookService
{
    @Override
    public Book get ( final long bookId )
    {
        return doWithManager ( new ManagerFunction<Book> () {

            @Override
            public Book process ( final EntityManager entityManager )
            {
                final Book result = entityManager.find ( Book.class, bookId );
                entityManager.detach ( result );
                return result;
            }
        } );
    }

    @Override
    public void persist ( final Book book )
    {
        doWithManager ( new ManagerFunction<Void> () {

            @Override
            public Void process ( final EntityManager entityManager )
            {
                entityManager.persist ( book );
                entityManager.detach ( book );
                return null;
            }
        } );
    }

    @Override
    public void delete ( final long bookId )
    {
        doWithManager ( new ManagerFunction<Void> () {

            @Override
            public Void process ( final EntityManager entityManager )
            {
                entityManager.remove ( entityManager.getReference ( Book.class, bookId ) );
                return null;
            }
        } );
    }

    @Override
    public List<Book> listAll ()
    {
        return doWithManager ( new ManagerFunction<List<Book>> () {

            @Override
            public List<Book> process ( final EntityManager entityManager )
            {
                final CriteriaQuery<Book> cq = entityManager.getCriteriaBuilder ().createQuery ( Book.class );
                cq.from ( Book.class );

                final TypedQuery<Book> q = entityManager.createQuery ( cq );

                final List<Book> result = q.getResultList ();
                for ( final Book book : result )
                {
                    entityManager.detach ( book );
                }

                return result;
            }
        } );
    }
}
