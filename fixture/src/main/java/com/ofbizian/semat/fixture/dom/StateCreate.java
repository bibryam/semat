package com.ofbizian.semat.fixture.dom;

import com.ofbizian.semat.dom.domain.AlphaType;
import com.ofbizian.semat.dom.domain.ProjectRepository;
import com.ofbizian.semat.dom.domain.State;
import com.ofbizian.semat.dom.domain.StateRepository;
import com.ofbizian.semat.fixture.scenarios.AbstractFixtureScript;

public class StateCreate extends AbstractFixtureScript {
    private String name;
    private String description;
    private State state;
    private AlphaType alphaType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlphaType getAlphaType() {
        return alphaType;
    }

    public void setAlphaType(AlphaType alphaType) {
        this.alphaType = alphaType;
    }

    @Override
    protected void doExecute(final ExecutionContext ec) {
        String name = checkParam("name", ec, String.class);
        String description = checkParam("description", ec, String.class);
        AlphaType alphaType = checkParam("alphaType", ec, AlphaType.class);
        this.state = wrap(repository).createState(name, description, alphaType);
        ec.addResult(this, state);
    }

    @javax.inject.Inject
    private StateRepository repository;

}
