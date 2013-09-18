package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class Operation implements ITree<Message> {
	private Long id;
	private String name;
	private  List<Message> children = new ArrayList<Message>();
	public Operation(){
	}	
	public Operation(String name){
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
	public void setChildren(List<Message> children) {
		// TODO Auto-generated method stub
        this.children = children;
	}
	@Override
	public List<Message> getChildren() {
		// TODO Auto-generated method stub
		return children;
	}

}