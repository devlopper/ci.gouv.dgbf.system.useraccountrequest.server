package ci.gouv.dgbf.system.useraccountrequest.server.business.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.network.protocol.ProtocolDefaults;
import org.cyk.utility.network.protocol.ProtocolSimpleMailTransfer;
import org.cyk.utility.security.Credentials;
import org.cyk.utility.system.node.SystemNodeServer;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(ProtocolDefaults.class).get(ProtocolSimpleMailTransfer.class)
		.setHost("smtp.gmail.com").setPort(587).setIsAuthenticationRequired(Boolean.TRUE).setIsSecuredConnectionRequired(Boolean.TRUE)
		.setAuthenticationCredentials(__inject__(Credentials.class).setIdentifier("dgbfdtideveloppers").setSecret("dgbf2016dti"));
		
		__inject__(SystemNodeServer.class).setName("Demande de compte utilisateur");
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}
