/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.services;

import static br.com.arizona.database.queries.ResourceContextQueries.GET_RESOURCECONTEXT_BY_TENANT_ID;
import br.com.arizona.entities.ResourceContext;
import br.com.arizona.entities.Tenant;
import br.com.arizona.oauth.utils.Authentication;
import br.com.arizona.rest.clients.RestRequests;
import java.io.StringReader;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author valter.gomes
 */
@Stateless

public class APIService {

    @Inject
    Authentication auth;

    @Inject
    RestRequests restClient;

    @PersistenceContext
    EntityManager em;

    public String buildURIAuthentication(Long tenantId) {
        //    "https://webapi.timedoctor.com/oauth/v2/auth?
//      client_id=115_2crmi6i864g0048kg84s4ogwcccok4o0k0gco4wgckw0ow48o0&
//      response_type=code&redirect_uri=http://localhost:8080/tsi/api/timedoctor/redirect" ;
        ResourceContext rc = (ResourceContext) em.createNamedQuery(GET_RESOURCECONTEXT_BY_TENANT_ID).setParameter("tenantId", tenantId).getSingleResult();
        StringBuilder sb = new StringBuilder();
        sb.append(rc.getApiEndpoint()).append(rc.getAuthorizationEndpoint()).append("?")
                .append(" client_id=").append(rc.getClientId()).append("& response_type=code")
                .append("&redirect_uri=").append(rc.getRedirectURI());
        System.out.println(sb);
        return sb.toString();
    }

    @Transactional(Transactional.TxType.MANDATORY)
    public ResourceContext authenticateCodeAndRetriveInformation(String code, Long tenantId) {
        Tenant tenant = em.find(Tenant.class, tenantId);
        ResourceContext rc = auth.requestTokenByCode(tenant.getResourceContext(), code);
        ResourceContext resourceTenant = (ResourceContext) em.createNamedQuery(GET_RESOURCECONTEXT_BY_TENANT_ID).setParameter("tenantId", tenantId).getSingleResult();
        String companyInfos = restClient.buildRequest(resourceTenant.getApiEndpoint(), "/v1.1/companies").queryParam("access_token", rc.getAccessToken()).request().get(String.class);
        JsonObject json = Json.createReader(new StringReader(companyInfos)).readObject();
        System.out.println(" company informations : " + companyInfos);
        resourceTenant.setAccessToken(rc.getAccessToken());
        resourceTenant.setRefreshToken(rc.getRefreshToken());
        resourceTenant.setExpiresDate(rc.getExpiresDate());
        resourceTenant.setTokenType(rc.getTokenType());
        resourceTenant.setScope(rc.getScope());
        resourceTenant.setCode(code);
        resourceTenant.setStatus(true);
        resourceTenant.setTimedoctorCompanyId(json.getJsonArray("accounts").getJsonObject(0).getJsonNumber("company_id").longValue());
        resourceTenant.setTimeDoctorCompanyName(json.getJsonArray("accounts").getJsonObject(0).getString("company_name"));
        resourceTenant.setTimedoctorUserId(json.getJsonArray("accounts").getJsonObject(0).getJsonNumber("user_id").longValue());
        resourceTenant.setTimedoctorUserFullName(json.getJsonObject("user").getString("full_name"));
        resourceTenant.setTimedoctorUserEmail(json.getJsonObject("user").getString("email"));
        tenant.setResourceContext(resourceTenant);

        System.out.println(tenant.getResourceContext().getCode());
        return rc;
    }
}
