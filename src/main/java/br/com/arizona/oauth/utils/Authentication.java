/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.oauth.utils;

import br.com.arizona.entities.ResourceContext;
import br.com.arizona.entities.Tenant;
import br.com.arizona.rest.clients.RestRequests;
import static java.lang.System.out;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valter.gomes
 */
public class Authentication {

    @Inject
    RestRequests restClient;

    @PostConstruct
    public void onCreate() {
        System.out.println("Construtor OauthService");
    }

    public ResourceContext requestTokenByCode(@NotNull ResourceContext rc, String currentCode) {
        rc = restClient.buildRequest(rc.getApiEndpoint(), rc.getTokenEndpoint()).queryParam(Oauth2Params.CLIENT_ID.getLabel(), rc.getClientId()).
                queryParam(Oauth2Params.CLIENT_SECRET.getLabel(), rc.getClientSecret()).
                queryParam(Oauth2Params.GRANT_TYPE.getLabel(), "authorization_code").
                queryParam(Oauth2Params.REDIRECT_URI.getLabel(), rc.getRedirectURI()).
                queryParam(Oauth2Params.CODE.getLabel(), currentCode)
                .request().get(ResourceContext.class);

        out.println("Received response: " + rc.toString());
        return rc;
    }

}
