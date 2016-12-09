package com.ofbizian.semat.dom.domain;

import java.util.SortedSet;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema = "simple"
)
@DomainObject
public class Alpha extends AbstractPersistable {

    private SortedSet<AlphaState> alphaStates;
    private Concern concern;
    private AlphaType alphaType;
    private String name;
    private Project project;

    public Alpha(AlphaType alphaType, String name, Concern concern) {
        this.alphaType = alphaType;
        this.name = name;
        this.concern = concern;
    }

    public Concern getConcern() {
        return concern;
    }

    @Programmatic
    public AlphaType getAlphaType() {
        return alphaType;
    }

    public String getName() {
        return name;
    }

    @CollectionLayout(defaultView = "table")
    @javax.jdo.annotations.Persistent(mappedBy = "alpha", defaultFetchGroup = "true")
    public SortedSet<AlphaState> getAlphaStates() {
        return alphaStates;
    }

    public void setAlphaStates(SortedSet<AlphaState> alphaStates) {
        this.alphaStates = alphaStates;
    }

    @Programmatic
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String iconName() {
        return name;
    }

    @Override
    public int compareTo(AbstractPersistable other) {
        return ObjectContracts.compare(this, other, "concern", "alphaType", "name", "id");
    }
}
