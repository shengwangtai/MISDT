package org.eclipsercp.integration.model;

import java.util.ArrayList;
import java.util.List;

public class TreeFactory {
	@SuppressWarnings("unchecked")
    public static List<Service> createTree(){
    //����service
    Service service1 = new Service("LabOrderService");
    //����interface
    Interface inf1 = new Interface("PlacerOrderManagement");
    Interface inf2 = new Interface("OrderResultManagement");
    //����operation
    Operation op1= new Operation("NewLabOrder");
    Operation op2 = new Operation("LabOrderResult");
    
    //����message��operation
    ArrayList<Message> msgList = new ArrayList<Message>();
    
    Message inMsg1 = new Message();
    inMsg1.setName("NewLabOrderRequest");
    inMsg1.setIsInMsg(true);
    msgList.add(inMsg1);    
    Message outMsg1 = new Message();
    outMsg1.setName("NewLabOrderResponse");
    outMsg1.setIsInMsg(false);    
    msgList.add(outMsg1);
    op1.setChildren(msgList);
    
    msgList =new ArrayList<Message>();
    Message inMsg2 = new Message();
    inMsg2.setName("SendLabOrderResult");
    inMsg2.setIsInMsg(true);
    msgList.add(inMsg2);    
    Message outMsg2 = new Message();
    outMsg2.setName("LabOrderResultACK");
    outMsg2.setIsInMsg(false);    
    msgList.add(outMsg2);
    op2.setChildren(msgList);
    
    //����interface��operation
    ArrayList<Operation> opList = new ArrayList<Operation>();
    opList.add(op1);
    inf1.setChildren(opList);
    opList = new ArrayList<Operation>();
    opList.add(op2);
    inf2.setChildren(opList);
    
    //����service��interface
    ArrayList<Interface> infList = new ArrayList<Interface>();
    infList.add(inf1);
    infList.add(inf2);
    service1.setChildren(infList);
    
    //service�б�
    ArrayList<Service> serviceList = new ArrayList<Service>();
    serviceList.add(service1);
    return serviceList;      
    }

}
