package de.dentrassi.osgiee.jpa1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity ( name = "BOOKS" )
public class Book
{
    @Id
    private long id;

    private String name;

    public long getId ()
    {
        return this.id;
    }

    public void setId ( final long id )
    {
        this.id = id;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setName ( final String name )
    {
        this.name = name;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( this.id ^ this.id >>> 32 );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( ! ( obj instanceof Book ) )
        {
            return false;
        }
        final Book other = (Book)obj;
        if ( this.id != other.id )
        {
            return false;
        }
        return true;
    }

}
