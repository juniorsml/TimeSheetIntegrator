/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.mb;

import br.com.arizona.entities.ResourceContext;
import br.com.arizona.services.APIService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author valter.gomes
 */
@Named("timedoctor")
@Path("token/timedoctor")
@SessionScoped
public class TimeDoctorMB implements Serializable {

    @Inject
    APIService api;

    Long tenant;

    public String getAuthURI(Long tenant) {
        setTenant(tenant);
        return api.buildURIAuthentication(tenant);
    }

    @Path(value = "/redirect")
    @GET
    @Produces("application/json")
    public ResourceContext redirect(@QueryParam("code") String code) {
        System.out.println("CODE : " + code);
        return api.authenticateCodeAndRetriveInformation(code , getTenant());
    }

    public APIService getApi() {
        return api;
    }

    public void setApi(APIService api) {
        this.api = api;
    }

    public Long getTenant() {
        return tenant;
    }

    public void setTenant(Long tenant) {
        this.tenant = tenant;
    }

}
