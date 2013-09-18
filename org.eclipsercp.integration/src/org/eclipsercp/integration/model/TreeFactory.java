package org.eclipsercp.integration.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TreeFactory {
	@SuppressWarnings("unchecked")
    public static List createTree(){
    //生成service
    Service service1 = new Service("service1");
    //生成interface
    Interface inf1 = new Interface("interface1");
//    Interface inf2 = new Interface("interface2");
    //生成operation
    Operation op1= new Operation("operation1");
    Operation op2 = new Operation("operation2");
    
    //关联message与operation
    ArrayList msgList = new ArrayList();
    msgList.add(new Message("rq1"));
    msgList.add(new Message("rsp1"));
    op1.setChildren(msgList);
    
    msgList =new ArrayList();
    msgList.add(new Message("rq2"));
    msgList.add(new Message("rsp2"));
    op2.setChildren(msgList);
    
    //关联interface与operation
    ArrayList opList = new ArrayList();
    opList.add(op1);
    opList.add(op2);
    inf1.setChildren(opList);
    
    //关联service与interface
    ArrayList infList = new ArrayList();
    infList.add(inf1);
    service1.setChildren(infList);
    
    //service列表
    ArrayList serviceList = new ArrayList();
    serviceList.add(service1);
    return serviceList;      
    }

}
