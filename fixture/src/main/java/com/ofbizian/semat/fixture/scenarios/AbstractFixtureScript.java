package com.ofbizian.semat.fixture.scenarios;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.sudo.SudoService;

public abstract class AbstractFixtureScript extends FixtureScript {

    protected String userName = "user";
    protected List<String> roles = null;

    @Override
    protected final void execute(final ExecutionContext ec) {

        sudoService.sudo(userName, roles, new Runnable() {
            @Override
            public void run() {
                doExecute(ec);
            }
        });
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRoles(final List<String> roles) {
        this.roles = roles;
    }

    protected abstract void doExecute(final ExecutionContext ec);

    @Inject
    SudoService sudoService;

}
