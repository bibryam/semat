package com.ofbizian.semat.app.services.tenancyevaluator;

import com.ofbizian.semat.dom.domain.AbstractPersistable;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.isisaddons.module.security.dom.tenancy.ApplicationTenancy;
import org.isisaddons.module.security.dom.tenancy.ApplicationTenancyEvaluator;
import org.isisaddons.module.security.dom.user.ApplicationUser;

@DomainService(nature = NatureOfService.DOMAIN)
public class SematApplicationTenancyEvaluator implements ApplicationTenancyEvaluator {

    @Override
    public boolean handles(Class<?> cls) {
        return AbstractPersistable.class.isAssignableFrom(cls);
    }

    @Override
    public String hides(Object domainObject, ApplicationUser applicationUser) {
        if (!(domainObject instanceof AbstractPersistable)) {
            return null;
        }

        final AbstractPersistable persistable = (AbstractPersistable) domainObject;
        final ApplicationTenancy applicationUserTenancy = applicationUser.getTenancy();
        final ApplicationTenancy persistableApplicationTenancy = persistable.getApplicationTenancy();

        if (applicationUserTenancy == null || persistableApplicationTenancy == null) {
            return "missing tenancy";
        }

        return applicationUserTenancy.equals(persistableApplicationTenancy) ? null: "different tenancies";
    }

    @Override
    public String disables(Object domainObject, ApplicationUser applicationUser) {
        return null;
    }
}
