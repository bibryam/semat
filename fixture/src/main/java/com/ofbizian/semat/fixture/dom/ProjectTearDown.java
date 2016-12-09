package com.ofbizian.semat.fixture.dom;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class ProjectTearDown extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"simple\".\"Checklist\"");
        isisJdoSupport.executeUpdate("delete from \"simple\".\"AlphaState\"");
        isisJdoSupport.executeUpdate("delete from \"simple\".\"Alpha\"");
        isisJdoSupport.executeUpdate("delete from \"simple\".\"Project\"");
    }

    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;
}
