package de.frena;

import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProvider;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderCaseInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderHistoricDecisionInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderProcessInstanceContext;

/**
 * As in:
 * https://forum.camunda.org/t/can-two-tenants-share-same-processdefinition-without-tenant-identifier-where-process-instance-is-tenant-specific-with-tenant-identifier/7764/6
 * 
 */

public class CustomTenantProvider implements TenantIdProvider {

    @Override
    public String provideTenantIdForProcessInstance(TenantIdProviderProcessInstanceContext ctx) {
        return (String) ctx.getVariables().get("dataset");
    }

    @Override
    public String provideTenantIdForCaseInstance(TenantIdProviderCaseInstanceContext ctx) {
        return (String) ctx.getVariables().get("dataset");
    }

    @Override
    public String provideTenantIdForHistoricDecisionInstance(TenantIdProviderHistoricDecisionInstanceContext ctx) {
        return (String) ctx.getExecution().getVariable("dataset");
    }
}
