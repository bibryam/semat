package com.ofbizian.semat.webapp.footer;

import org.apache.isis.viewer.wicket.ui.ComponentFactoryAbstract;
import org.apache.isis.viewer.wicket.ui.ComponentType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * {@link org.apache.isis.viewer.wicket.ui.ComponentFactory} to create container for the page footer.
 */
public class CustomFooterPanelFactory extends ComponentFactoryAbstract {

    private static final long serialVersionUID = 1L;

    public CustomFooterPanelFactory() {
        super(ComponentType.FOOTER, CustomFooterPanel.class);
    }

    @Override
    public ApplicationAdvice appliesTo(final IModel<?> model) {
        return ApplicationAdvice.APPLIES;
    }

    @Override
    public Component createComponent(final String id, final IModel<?> model) {
        return new CustomFooterPanel(id);
    }

}
