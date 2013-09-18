package org.eclipsercp.integration.model;

import java.util.List;

public class Message implements ITree {
	private Long id;
	private String name;
	
	public Message(){
	}
	public Message(String name){
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
	}
	@Override
	public List getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
