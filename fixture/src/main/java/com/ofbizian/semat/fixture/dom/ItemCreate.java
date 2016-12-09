package com.ofbizian.semat.fixture.dom;

import com.ofbizian.semat.dom.domain.Checklist;
import com.ofbizian.semat.dom.domain.Item;
import com.ofbizian.semat.dom.domain.ProjectRepository;
import com.ofbizian.semat.dom.domain.State;
import com.ofbizian.semat.dom.domain.StateRepository;
import com.ofbizian.semat.fixture.scenarios.AbstractFixtureScript;

public class ItemCreate extends AbstractFixtureScript {
    private String description;
    private boolean achieved;
    private int sequence;
    private State state;
    private Item item;
    private Checklist checklist;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    protected void doExecute(final ExecutionContext ec) {
        String description = checkParam("description", ec, String.class);
        State state = checkParam("state", ec, State.class);
        this.item = wrap(repository).createStateItem(description, state);

        ec.addResult(this, item);
    }

    @javax.inject.Inject
    private StateRepository repository;

}
