package de.frena.helloworld.configuration;

import static org.camunda.bpm.engine.authorization.Authorization.ANY;
import static org.camunda.bpm.engine.authorization.Authorization.AUTH_TYPE_GRANT;
import static org.camunda.bpm.engine.authorization.Permissions.ALL;

import org.camunda.bpm.engine.AuthorizationService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.authorization.Groups;
import org.camunda.bpm.engine.authorization.Resource;
import org.camunda.bpm.engine.authorization.Resources;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.persistence.entity.AuthorizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGenerator {

	@Autowired
	private IdentityService identityService;
	@Autowired
	private AuthorizationService authorizationService;
	

	public void createUsers() {

		User demo = identityService.newUser("demo");
		demo.setFirstName("demo");
		demo.setLastName("demo");
		demo.setPassword("demo");
		identityService.saveUser(demo);

		if (identityService.createGroupQuery().groupId(Groups.CAMUNDA_ADMIN).count() == 0) {
			Group camundaAdminGroup = identityService.newGroup(Groups.CAMUNDA_ADMIN);
			camundaAdminGroup.setName("camunda BPM Administrators");
			camundaAdminGroup.setType(Groups.GROUP_TYPE_SYSTEM);
			identityService.saveGroup(camundaAdminGroup);
		}
		identityService.createMembership(demo.getId(), Groups.CAMUNDA_ADMIN);
		
		// create ADMIN authorizations on all built-in resources
	      for (Resource resource : Resources.values()) {
	        if(authorizationService.createAuthorizationQuery().groupIdIn(Groups.CAMUNDA_ADMIN).resourceType(resource).resourceId(ANY).count() == 0) {
	          AuthorizationEntity userAdminAuth = new AuthorizationEntity(AUTH_TYPE_GRANT);
	          userAdminAuth.setGroupId(Groups.CAMUNDA_ADMIN);
	          userAdminAuth.setResource(resource);
	          userAdminAuth.setResourceId(ANY);
	          userAdminAuth.addPermission(ALL);
	          authorizationService.saveAuthorization(userAdminAuth);
	        }
	      }

	}

}
