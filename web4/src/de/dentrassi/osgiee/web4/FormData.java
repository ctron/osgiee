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
