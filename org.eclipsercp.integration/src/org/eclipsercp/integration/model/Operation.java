package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class Operation implements ITree {
	private Long id;
	private String name;
	private  List children = new ArrayList();
	public Operation(){
	}	
	public Operation(String name){
		this.name = name;
	}
	
	public void setId(){
		this.id = id;
	}	
	public Long getId(Long id){
		return id;
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
	public void setChildren(List Children) {
		// TODO Auto-generated method stub
        this.children = children;
	}
	@Override
	public List getChildren() {
		// TODO Auto-generated method stub
		return children;
	}

}