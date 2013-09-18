package org.eclipsercp.integration.model;

import java.util.List;

public class Message implements ITree {
	private Long id;
	private String name;
	private boolean isInMsg;
	
	public Message(){
	}
	public Message(String name){
		this.name = name;
	}

	public void setIsInMsg(boolean isInMsg){
		this.isInMsg = isInMsg;
	}
	public boolean getIsInMsg(){
		return isInMsg;
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
	public void setChildren(List Children) {
		// TODO Auto-generated method stub
	}
	@Override
	public List getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
