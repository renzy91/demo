package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientSessionHandler extends IoHandlerAdapter {

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		session.write("Test");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("ClientMessageReceived:"+message);
	}
	
}
