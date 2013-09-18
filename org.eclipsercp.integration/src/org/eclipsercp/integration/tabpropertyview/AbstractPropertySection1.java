package org.eclipsercp.integration.tabpropertyview;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipsercp.integration.model.Interface;
import org.eclipsercp.integration.view.InterfaceTreeView;

public class AbstractPropertySection1 extends AbstractPropertySection {
    private Text nameText;
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// TODO Auto-generated method stub
		super.createControls(parent, aTabbedPropertySheetPage);
	    Composite composite = getWidgetFactory().createFlatFormComposite(parent);
	    composite.setLayout(new GridLayout(2,false));
	    CLabel nameLabel = getWidgetFactory().createCLabel(composite, "Name");
	    nameText = getWidgetFactory().createText(composite, "");
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		super.setInput(part, selection);
        Assert.isTrue(selection instanceof IStructuredSelection);
        Object input = ((IStructuredSelection) selection).getFirstElement();
        Assert.isTrue(input instanceof Interface);
        this.nameText = (Text)input;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		super.refresh();
	}

	public AbstractPropertySection1() {
		// TODO Auto-generated constructor stub
	}

	
}
