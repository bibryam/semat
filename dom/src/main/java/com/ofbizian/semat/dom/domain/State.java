package com.ofbizian.semat.dom.domain;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(
                name = "findByAlphaType", language = "JDOQL",
                value = "SELECT "
                        + "FROM com.ofbizian.semat.dom.domain.State "
                        + "WHERE alphaType == :alphaType")
})
@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema = "simple"
)
@DomainObject
public class State extends AbstractPersistable {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Title
    private String name;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private String description;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private AlphaType alphaType;

    private SortedSet<Item> items = new TreeSet<>();

    public SortedSet<Item> getItems() {
        return items;
    }

    @CollectionLayout(defaultView = "table")
    @javax.jdo.annotations.Persistent(mappedBy = "state", defaultFetchGroup = "true")
    public void setItems(SortedSet<Item> items) {
        this.items = items;
    }

    public void addToItems(Item item) {
        getItems().add(item);
    }

    @Action
    public State createItem(
            @ParameterLayout(named="Description")
            String description) {
        stateRepository.createStateItem(description, this);
        return this;
    }

    public AlphaType getAlphaType() {
        return alphaType;
    }

    public void setAlphaType(AlphaType alphaType) {
        this.alphaType = alphaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(AbstractPersistable other) {
        return ObjectContracts.compare(this, other, "alphaType", "name", "description", "id");
    }

    @javax.inject.Inject
    StateRepository stateRepository;

}
