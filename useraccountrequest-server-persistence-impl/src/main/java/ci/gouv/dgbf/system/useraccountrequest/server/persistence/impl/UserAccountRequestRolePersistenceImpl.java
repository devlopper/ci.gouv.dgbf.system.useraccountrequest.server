package ci.gouv.dgbf.system.useraccountrequest.server.persistence.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.computation.ComparisonOperator;
import org.cyk.utility.server.persistence.jpa.AbstractPersistenceEntityImpl;
import org.cyk.utility.server.persistence.query.PersistenceQuery;
import org.cyk.utility.server.persistence.query.PersistenceQueryRepository;
import org.cyk.utility.sql.builder.QueryStringBuilderSelect;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestRolePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestRole;

@Singleton
public class UserAccountRequestRolePersistenceImpl extends AbstractPersistenceEntityImpl<UserAccountRequestRole> implements UserAccountRequestRolePersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readByUserAccountRequest;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByUserAccountRequest, __instanciateQuerySelect__()
				.getWherePredicateBuilderAsEqual().addOperandBuilderByAttribute(UserAccountRequestRole.FIELD_USER_ACCOUNT_REQUEST,ComparisonOperator.EQ)
				.getParentAsWhereClause().getParentAs(QueryStringBuilderSelect.class));
	}
	
	@Override
	protected Object[] __getQueryParameters__(String queryIdentifier, Object... objects) {
		PersistenceQuery persistenceQuery = __inject__(PersistenceQueryRepository.class).getBySystemIdentifier(queryIdentifier);
		
		if(persistenceQuery.isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByUserAccountRequest,queryIdentifier))
			return new Object[]{UserAccountRequestRole.FIELD_USER_ACCOUNT_REQUEST,objects[0]};
		
		return super.__getQueryParameters__(queryIdentifier, objects);
	}
	
	@Override
	public Collection<UserAccountRequestRole> readByUserAccountRequest(UserAccountRequest userAccountRequest) {
		return __readMany__(____getQueryParameters____(userAccountRequest));
	}

}
