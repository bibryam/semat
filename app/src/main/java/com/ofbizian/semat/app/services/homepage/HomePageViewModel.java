package com.ofbizian.semat.app.services.homepage;

import java.util.List;

import com.ofbizian.semat.dom.domain.Project;
import com.ofbizian.semat.dom.domain.ProjectRepository;
import org.apache.isis.applib.annotation.ViewModel;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

@ViewModel
public class HomePageViewModel {

    public TranslatableString title() {
        return TranslatableString.tr("Home Page");
    }

    @org.apache.isis.applib.annotation.HomePage
    public List<Project> getProjects() {
        return wrapperFactory.wrap(repository).listAll();
    }

    @javax.inject.Inject
    ProjectRepository repository;

    @javax.inject.Inject
    WrapperFactory wrapperFactory;
}
