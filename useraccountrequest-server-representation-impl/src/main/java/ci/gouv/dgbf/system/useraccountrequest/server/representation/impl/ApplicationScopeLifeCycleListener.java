package ci.gouv.dgbf.system.useraccountrequest.server.representation.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.instance.InstanceBuilderImpl;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(FunctionRunnableMap.class).set(InstanceBuilderImpl.class, InstanceBuilderFunctionRunnableImpl.class,2);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}
