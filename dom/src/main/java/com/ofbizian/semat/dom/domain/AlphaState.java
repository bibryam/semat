package com.ofbizian.semat.dom.domain;

import java.util.SortedSet;
import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema = "simple"
)
@DomainObjectLayout(bookmarking= BookmarkPolicy.AS_CHILD)
public class AlphaState extends AbstractPersistable {

    @javax.jdo.annotations.Column(allowsNull = "false")
    private Alpha alpha;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private State state;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private boolean achieved;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private int sequence;

    private SortedSet<Checklist> checklists;

    @CollectionLayout(defaultView = "table")
    @javax.jdo.annotations.Persistent(mappedBy = "alphaState", defaultFetchGroup = "true")
    public SortedSet<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(SortedSet<Checklist> checklists) {
        this.checklists = checklists;
    }

    @PropertyLayout(hidden = Where.EVERYWHERE)
    public Alpha getAlpha() {
        return alpha;
    }

    public void setAlpha(Alpha alpha) {
        this.alpha = alpha;
    }

    @PropertyLayout(hidden = Where.EVERYWHERE)
    public State getState() {
        return state;
    }

    @PropertyLayout(hidden = Where.ALL_TABLES)
    public String getAlphaName() {
        return alpha.getName();
    }

    @MemberOrder(sequence = "1")
    public String getStateName() {
        return state.getName();
    }

    @MemberOrder(sequence = "3")
    @PropertyLayout(hidden = Where.ALL_TABLES)
    public String getStateDescription() {
        return state.getDescription();
    }

    @Programmatic
    public void setState(State state) {
        this.state = state;
    }

    @MemberOrder(sequence = "4")
    @Property(
            editing = Editing.DISABLED,
            editingDisabledReason = "Use actions to change"
    )
    public boolean isAchieved() {
        return achieved;
    }

    @Programmatic
    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    @Action(invokeOn = InvokeOn.OBJECT_AND_COLLECTION)
    public AlphaState achieve() {
        setAchieved(true);
        return this;
    }

    public String disableAchieve() {
        return isAchieved() ? "Already achieved" : null;
    }

    @Action(invokeOn = InvokeOn.OBJECT_AND_COLLECTION)
    public AlphaState unachieve() {
        setAchieved(false);
        return this;
    }

    public String disableUnachieve() {
        return isAchieved() ? null : "Already unachieved";
    }

    @Programmatic
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Action
    public Project goToProject() {
        return getAlpha().getProject();
    }

    @MemberOrder(sequence = "3")
    public String getChecklistSummary() {
        final SortedSet<Checklist> checklists = getChecklists();
        if (checklists == null) {
            return "(0/0)";
        }

        int total = checklists.size();
        int achieved = 0;
        for (Checklist checklist : checklists) {
            if (checklist.isAchieved()) {
                achieved++;
            }
        }
        return "(" + achieved + "/" + total + ")";
    }

    public String title() {
        return getAlpha().getName() + ": " + state.getName();
    }

    @Override
    public int compareTo(AbstractPersistable other) {
        return ObjectContracts.compare(this, other, "alpha", "state", "sequence", "id");
    }
}
