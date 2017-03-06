package com.ofbizian.semat.app.services.registration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

import com.ofbizian.semat.fixture.scenarios.SematFixture;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.sudo.SudoService;
import org.apache.isis.applib.services.userreg.UserDetails;
import org.apache.isis.applib.value.Password;
import org.isisaddons.module.security.dom.role.ApplicationRole;
import org.isisaddons.module.security.dom.role.ApplicationRoleRepository;
import org.isisaddons.module.security.dom.tenancy.ApplicationTenancy;
import org.isisaddons.module.security.dom.tenancy.ApplicationTenancyRepository;
import org.isisaddons.module.security.dom.user.ApplicationUser;
import org.isisaddons.module.security.dom.user.ApplicationUserRepository;
import org.isisaddons.module.security.userreg.SecurityModuleAppUserRegistrationServiceAbstract;

@DomainService
public class AppUserRegistrationService extends SecurityModuleAppUserRegistrationServiceAbstract {

    protected ApplicationRole getInitialRole() {
        return findRole("semat-admin");
    }

    protected Set<ApplicationRole> getAdditionalInitialRoles() {
        final HashSet<ApplicationRole> applicationRoles = new HashSet<>();
        applicationRoles.add(findRole("isis-module-security-regular-user"));
        applicationRoles.add(findRole("persistable-mixins-user"));
        return applicationRoles;
    }
    private ApplicationRole findRole(final String roleName) {
        return applicationRoleRepository.findByNameCached(roleName);
    }

    @Override
    public void registerUser(
            final UserDetails userDetails) {

        final Password password = new Password(userDetails.getPassword());
        final ApplicationRole initialRole = getInitialRole();
        final Boolean enabled = true;
        final String username = userDetails.getUsername();
        final String emailAddress = userDetails.getEmailAddress();
        final ApplicationUser applicationUser = applicationUserRepository.newLocalUser(username, password, password, initialRole, enabled, emailAddress);

        final Set<ApplicationRole> additionalRoles = getAdditionalInitialRoles();
        if(additionalRoles != null) {
            for (final ApplicationRole additionalRole : additionalRoles) {
                applicationUser.addRole(additionalRole);
            }
        }

        // set up new user custom
        final ApplicationTenancy applicationTenancy = applicationTenancyRepository.newTenancy(username, "/" + username, null);
        applicationUser.setAtPath(applicationTenancy.getPath());

        fixtureScripts.runFixtureScript(new SematFixture(username, Arrays.asList(SudoService.ACCESS_ALL_ROLE)), null);
    }

    @Inject
    private ApplicationRoleRepository applicationRoleRepository;

    @Inject
    private ApplicationUserRepository applicationUserRepository;

    @Inject
    private ApplicationTenancyRepository applicationTenancyRepository;

    @Inject
    private FixtureScripts fixtureScripts;

    @Inject
    private RepositoryService repositoryService;


}