package org.eclipsercp.integration.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipsercp.integration.adapter.properties.ServicePropertySource;
import org.eclipsercp.integration.model.Service;

public class ServicePropertiesSourceAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		// TODO Auto-generated method stub
		if (adapterType == IPropertySource.class)
			return new ServicePropertySource((Service)adaptableObject);
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[]{IPropertySource.class};
	}

}
