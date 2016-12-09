package com.ofbizian.semat.dom.domain;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema = "simple"
)
@DomainObject
public class Item extends AbstractPersistable {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @PropertyLayout(multiLine=5)
    private String description;
    private State state;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Programmatic
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Action
    public State goToState() {
        return getState();
    }

    @Override
    public int compareTo(AbstractPersistable other) {
        return ObjectContracts.compare(this, other, "description", "id");
    }
}
