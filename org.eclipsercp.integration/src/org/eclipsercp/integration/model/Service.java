package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class Service implements ITree {
	private Long id;
	private String name;
	private  List children = new ArrayList();
	
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
	public void setChildren(List children) {
		// TODO Auto-generated method stub
    this.children = children;
	}

	@Override
	public List getChildren() {
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
