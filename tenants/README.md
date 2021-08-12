#Tenants in shared process definitions

This prototype starts instances for a tenant "stefan".
The process definitions are shared, not deployed for a specifict tenant.

To set the tenant, we make use of a process variable "tenantId". Using a [CustomTenantProvider](./src/main/java/de/frena/CustomTenantProvider.java) this variable will be used as tenant. It is removed in the process right after start to demostrate, that it isnt needed afterwards.

Created with [Camunda Platform Initializr](https://start.camunda.com/)
Start the application and check [h2-console](http://localhost:8080/h2-console/), no user or pw needed.
In ACT_HI_PROCINST, TENANT_ID_ will be "stefan".

#####sources
[Topic in Camunda Forum](https://forum.camunda.org/t/can-two-tenants-share-same-processdefinition-without-tenant-identifier-where-process-instance-is-tenant-specific-with-tenant-identifier/7764/2)
* [instantiate-a-shared-definition](https://docs.camunda.org/manual/7.15/user-guide/process-engine/multi-tenancy/#instantiate-a-shared-definition)

* [adding-additional-configurations](https://docs.camunda.org/manual/7.15/user-guide/spring-boot-integration/configuration/#adding-additional-configurations)


