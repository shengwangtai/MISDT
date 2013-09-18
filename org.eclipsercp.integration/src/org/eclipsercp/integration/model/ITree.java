/**
 * 
 */
package org.eclipsercp.integration.model;

import java.util.List;


/**
 * @author LSS
 * set/get设置和获取属性实现灵活性和安全性，按需求设置属性的读写特性
 */
public interface ITree {

	//设置与得到树节点的名称
	public String getName();
	public void setName(String name);
	
	//设置与得到子节点集合
	public void setChildren(List Children);
	public List getChildren();
}
