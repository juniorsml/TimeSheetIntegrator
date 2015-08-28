/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.rest.resources;

import br.com.arizona.entities.Project;
import br.com.arizona.entities.ProjectInfos;
import br.com.arizona.services.APIService;
import br.com.arizona.services.ProjectService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author valter.gomes
 */
@Path("timedoctor")
@RequestScoped
public class TimeDoctorResource {

    @Inject
    APIService api;

    @Inject
    ProjectService projectService;

    @Path(value = "/auth/url")
    @GET
    public String getAuthUrl(@QueryParam("tenant") Long idTenant) {
        return api.buildURIAuthentication(idTenant);
    }

    @POST
    @Path("/project")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String createProject(ProjectInfos projectInfos) {
        Project project = projectService.createProject(projectInfos, true);
        System.out.println("createProject : " + project);
        return project.toString();
    }

}
