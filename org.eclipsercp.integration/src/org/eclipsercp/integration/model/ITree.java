/**
 * 
 */
package org.eclipsercp.integration.model;

import java.util.List;


/**
 * @author LSS
 * set/get���úͻ�ȡ����ʵ������ԺͰ�ȫ�ԣ��������������ԵĶ�д����
 */
public interface ITree<T> {

	//������õ����ڵ������
	public String getName();
	public void setName(String name);
	
	//������õ��ӽڵ㼯��
	public void setChildren(List<T> Children);
	public List<T> getChildren();
}
