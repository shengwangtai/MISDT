package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class Service implements ITree<Interface> {
	private Long id;
	private String name;
	private  List<Interface> children = new ArrayList<Interface>();
	
    public Service(){    	
    }
    
    public Service(String name){
    	this.name = name;
    }
    
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
    this.name = name;
	}

	@Override
	public void setChildren(List<Interface> children) {
		// TODO Auto-generated method stub
    this.children = children;
	}

	@Override
	public List<Interface> getChildren() {
		// TODO Auto-generated method stub
		return children;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}

}
