package tw.paintingparty.config;

import javax.servlet.http.HttpSession;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ServletAwareConfig extends ServerEndpointConfig.Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
		//在ServletRequestListener之requestInitialized()方法中需先建立HttpSession物件
		//否則下列最後一行敘述可能會產生NullPointerException		
		HttpSession httpSession = (HttpSession) request.getHttpSession();	
		config.getUserProperties().put("httpSession", httpSession);		
	}
}
