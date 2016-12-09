package com.ofbizian.semat.app.services.export;

import javax.inject.Inject;

import com.ofbizian.semat.dom.domain.Project;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.xmlsnapshot.XmlSnapshotService;
import org.apache.isis.applib.value.Clob;

@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ExportAsXmlContributions extends AbstractFactoryAndRepository {

    @Action(semantics = SemanticsOf.SAFE)
    public Clob exportAsXml(Project project, String fileName) {
        if (!fileName.endsWith(".xml")) {
            fileName += ".xml";
        }

        XmlSnapshotService.Builder builder = xmlSnapshotService.builderFor(project);
        builder.includePath("opportunityStatus");
        XmlSnapshotService.Snapshot snapshot = builder.build();
        return new Clob(fileName, "application/xml", snapshot.getXmlDocumentAsString());
    }

    public String default1ExportAsXml(Project project) {
        return "project.xml";
    }

    @Inject
    private XmlSnapshotService xmlSnapshotService;
}
