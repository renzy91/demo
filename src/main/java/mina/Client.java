package mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Client {
	public static void main(String[] args) throws Throwable {
	    NioSocketConnector connector = new NioSocketConnector();
	    connector.setConnectTimeoutMillis(1000);

	    connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

	    connector.getFilterChain().addLast("logger", new LoggingFilter());
	    connector.setHandler(new ClientSessionHandler());
	    IoSession session;
	        try {
	            ConnectFuture future = connector.connect(new InetSocketAddress("localhost", 9123));
	            future.awaitUninterruptibly();
	            session = future.getSession();
	            session.getCloseFuture().awaitUninterruptibly();
	        } catch (RuntimeIoException e) {
	            System.err.println("Failed to connect.");
	            e.printStackTrace();
	            Thread.sleep(5000);
	        }
	    // wait until the summation is done
	    connector.dispose();
	}
}
