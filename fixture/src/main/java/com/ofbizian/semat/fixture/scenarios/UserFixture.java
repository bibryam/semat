package com.ofbizian.semat.fixture.scenarios;

import com.google.common.collect.Lists;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.layout.LayoutServiceMenu;
import org.apache.isis.core.metamodel.services.jdosupport.Persistable_datanucleusIdLong;
import org.isisaddons.module.security.dom.permission.ApplicationPermissionMode;
import org.isisaddons.module.security.dom.permission.ApplicationPermissionRule;
import org.isisaddons.module.security.dom.user.AccountType;
import org.isisaddons.module.security.seed.scripts.AbstractRoleAndPermissionsFixtureScript;
import org.isisaddons.module.security.seed.scripts.AbstractTenancyFixtureScript;
import org.isisaddons.module.security.seed.scripts.AbstractUserAndRolesFixtureScript;

public class UserFixture extends FixtureScript {

    public UserFixture() {
        withDiscoverability(Discoverability.NON_DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        ec.executeChild(this, new SematRoleAndPermissionsFixtureScript("semat-admin", "Semat Application Admin Role"));

        ec.executeChild(this, new AbstractTenancyFixtureScript(){
            @Override
            protected void execute(ExecutionContext executionContext) {
                create("Demo Tenancy", "/demo", null, executionContext);
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("metadata-menu-user", "User access to metadata menu"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, LayoutServiceMenu.class.getPackage().getName());
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("persistable-mixins-user", "User access to persistable metadata"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, Persistable_datanucleusIdLong.class.getPackage().getName());
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("todoapp-sessionlogger-admin", "Admin access to session logger module"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, "org.isisaddons.module.sessionlogger");
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("todoapp-auditing-admin", "Admin access to audit module"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, "org.isisaddons.module.audit");
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("todoapp-settings-admin", "Admin access to settings module"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, "org.isisaddons.module.settings");
            }
        });

        ec.executeChild(this, new AbstractRoleAndPermissionsFixtureScript("todoapp-command-admin", "Admin access to command module"){
            @Override
            protected void execute(ExecutionContext executionContext) {
                newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, "org.isisaddons.module.command");
            }
        });

        ec.executeChild(this, new AbstractUserAndRolesFixtureScript("user", "user", null, "/demo", AccountType.LOCAL, Lists.newArrayList("semat-admin","isis-module-security-regular-user", "persistable-mixins-user")){});

        ec.executeChild(this, new AbstractUserAndRolesFixtureScript("admin", "admin", null, "/", AccountType.LOCAL, Lists.newArrayList("semat-admin","isis-module-security-admin", "todoapp-auditing-admin", "metadata-menu-user", "persistable-mixins-user", "todoapp-sessionlogger-admin", "todoapp-settings-admin", "todoapp-command-admin")){});
    }

    private static class SematRoleAndPermissionsFixtureScript extends AbstractRoleAndPermissionsFixtureScript {
        public SematRoleAndPermissionsFixtureScript(String roleName, String roleDescriptionIfAny) {
            super(roleName, roleDescriptionIfAny);
        }

        @Override
        protected void execute(ExecutionContext ec) {
            newPackagePermissions(ApplicationPermissionRule.ALLOW, ApplicationPermissionMode.CHANGING, "com.ofbizian.semat");
        }
    }
}
