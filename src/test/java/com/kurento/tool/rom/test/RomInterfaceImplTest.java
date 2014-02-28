package com.kurento.tool.rom.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kurento.kmf.jsonrpcconnector.client.JsonRpcClientLocal;
import com.kurento.tool.rom.client.RemoteObjectFactory;
import com.kurento.tool.rom.client.RemoteObjectTypedFactory;
import com.kurento.tool.rom.server.RomException;
import com.kurento.tool.rom.test.model.SampleRemoteClass;
import com.kurento.tool.rom.transport.jsonrpcconnector.RomServerJsonRpcHandler;
import com.kurento.tool.rom.transport.jsonrpcconnector.RomClientJsonRpcClient;

import static org.junit.Assert.*;

public class RomInterfaceImplTest {

	protected static RemoteObjectTypedFactory factory;

	@BeforeClass
	public static void initFactory() {
		factory = new RemoteObjectTypedFactory(new RemoteObjectFactory(new RomClientJsonRpcClient(
				new JsonRpcClientLocal(new RomServerJsonRpcHandler(
						"com.kurento.tool.rom.test.model","Impl")))));
	}
	
	private SampleRemoteClass obj;
	
	@Before
	public void initObject() {
		obj = factory.create(SampleRemoteClass.class);
	}

	@Test
	public void voidReturnMethodTest() throws RomException {		
		obj.methodReturnVoid();
	}
	
	@Test
	public void stringReturnMethodTest() throws RomException {
		assertEquals(obj.methodReturnsString(),"XXXX");
	}
	
	@Test
	public void intReturnMethodTest() throws RomException {
		assertEquals(obj.methodReturnsInt(),0);
	}
	
	@Test
	public void booleanReturnMethodTest() throws RomException {
		assertEquals(obj.methodReturnsBoolean(),false);
	}
	
	@Test
	public void floatReturnMethodTest() throws RomException {
		assertEquals(obj.methodReturnsFloat(),0.5f,0.01);
	}	
	
	@Test
	public void stringParamMethodTest() throws RomException {
		assertEquals(obj.methodParamString("XXXX"),"XXXX");
	}
	
	@Test
	public void intParamMethodTest() throws RomException {
		assertEquals(obj.methodParamInt(55),55);
	}
	
	@Test
	public void booleanParamMethodTest() throws RomException {
		assertEquals(obj.methodParamBoolean(true),true);
	}
	
	@Test
	public void floatParamMethodTest() throws RomException {
		assertEquals(obj.methodParamFloat(0.5f),0.5f,0.01);
	}	
	
}