package com.ofbizian.semat.dom.domain;

import javax.jdo.annotations.IdentityType;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema = "simple"
)
@DomainObjectLayout(bookmarking= BookmarkPolicy.AS_CHILD)
public class Checklist extends AbstractPersistable {

    @javax.jdo.annotations.Column(allowsNull = "false")
    private Item item;

    @PropertyLayout(hidden = Where.PARENTED_TABLES)
    @javax.jdo.annotations.Column(allowsNull = "false")
    private AlphaState alphaState;

    @javax.jdo.annotations.Column(allowsNull = "false")
    private boolean achieved;

    @MemberOrder(sequence = "2")
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
    public Checklist achieve() {
        setAchieved(true);
        return this;
    }

    public String disableAchieve() {
        return isAchieved() ? "Already achieved" : null;
    }

    @Action(invokeOn = InvokeOn.OBJECT_AND_COLLECTION)
    public Checklist unachieve() {
        setAchieved(false);
        return this;
    }

    public String disableUnachieve() {
        return isAchieved() ? null : "Already unachieved";
    }

    @Action
    public Project goToProject() {
        return getAlphaState().getAlpha().getProject();
    }

    @Action
    public AlphaState goToAlpha() {
        return getAlphaState();
    }

    @javax.jdo.annotations.Column(allowsNull = "false")
    private int sequence;

    @PropertyLayout(named="Checklist Item")
    public String getItemName() {
        return item.getDescription();
    }

    @Programmatic
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Programmatic
    public AlphaState getAlphaState() {
        return alphaState;
    }

    public void setAlphaState(AlphaState alphaState) {
        this.alphaState = alphaState;
    }

    @Programmatic
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @PropertyLayout(hidden = Where.ALL_TABLES)
    public String getStateName() {
        return alphaState.getStateName();
    }
    @Override
    public int compareTo(AbstractPersistable other) {
        return ObjectContracts.compare(this, other, "alphaState", "item", "sequence", "id");

//        return new CompareToBuilder()
//                .append(getSequence(), ((Checklist) other).getSequence() )
//                .append(getClass().getName(), other.getClass().getName())
//                .toComparison();
    }

    public String title() {
        return "Checklist Item: " + item.getDescription();
    }


}
