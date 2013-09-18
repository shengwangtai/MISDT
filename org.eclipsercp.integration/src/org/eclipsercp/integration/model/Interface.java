package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class Interface implements ITree<Operation> {
	private Long id;
	private String name;
	private  List<Operation> children = new ArrayList<Operation>();
	public Interface(){
	}	
	public Interface(String name){
		this.name = name;
	}
	
	public void setId(Long id){
		this.id = id;
	}	
	public Long getId(){
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
	public void setChildren(List<Operation> children) {
		// TODO Auto-generated method stub
        this.children = children;
	}
	@Override
	public List<Operation> getChildren() {
		// TODO Auto-generated method stub
		return children;
	}

}
