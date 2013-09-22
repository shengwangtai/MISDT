package org.eclipsercp.integration.adapter.properties;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipsercp.integration.model.Service;

public class ServicePropertySource implements IPropertySource {
     private final Service service;
     
     public ServicePropertySource(Service service){
    	 this.service = service;
     }
	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// TODO Auto-generated method stub
		return new IPropertyDescriptor[]{
				new TextPropertyDescriptor("name", "Name"),
				new TextPropertyDescriptor("id", "Id")
		};
	}

	@Override
	public Object getPropertyValue(Object id) {
		// TODO Auto-generated method stub
        if ("name".equals(id)) return service.getName();
        else if ("id".equals(id)) return service.getId();	
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub
		if ("name".equals(id)) service.setName((String)value);
		else if ("id".equals(id)) service.setId((Long)value);
	}

}
