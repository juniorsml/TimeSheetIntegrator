/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.services;

import br.com.arizona.database.queries.JobTypeQueries;
import br.com.arizona.database.queries.TaskQueries;
import static br.com.arizona.database.queries.TenantQueries.GET_TENANT_BY_NAME;
import br.com.arizona.database.queries.UserQueries;
import br.com.arizona.entities.JobType;
import br.com.arizona.entities.Project;
import br.com.arizona.entities.ProjectInfos;
import br.com.arizona.entities.Task;
import br.com.arizona.entities.TaskAssigner;
import br.com.arizona.entities.Tenant;
import br.com.arizona.entities.User;
import br.com.arizona.jsons.CreateProject;
import br.com.arizona.rest.clients.RestRequests;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author valter.gomes
 */
@Stateless
public class ProjectService {

    @PersistenceContext
    EntityManager em;

    @Inject
    RestRequests restClient;

    public Project createRemoteProject(ProjectInfos infos, Tenant tenant) {
        System.out.println(tenant);
        StringBuilder sb = new StringBuilder();
        sb.append("/v1.1/companies/").append(tenant.getResourceContext().getTimedoctorCompanyId()).append("/users/").
                append(tenant.getResourceContext().getTimedoctorUserId().toString()).append("/projects");

        CreateProject createProject = new CreateProject();
        createProject.setFormat("json");
        createProject.setProject(new CreateProject.InnerProject(infos.getTitle()));
        Project project = restClient.buildRequest(tenant.getResourceContext().getApiEndpoint(), sb.toString())
                .queryParam("access_token", tenant.getResourceContext().getAccessToken())
                .request().post(Entity.entity(createProject, MediaType.APPLICATION_JSON), Project.class);
        //System.out.println("createRemoteProject :" + project);
        return project;
    }

    public Project createProject(ProjectInfos infos, boolean assignTasks) {
        Tenant tenant = (Tenant) em.createNamedQuery(GET_TENANT_BY_NAME).setParameter("tname", infos.getTenant()).getSingleResult();
        JobType jt = (JobType) em.createNamedQuery(JobTypeQueries.GET_JOBTYPE_BY_NAME_AND_TENANT).setParameter("jtlabel", infos.getJobType()).setParameter("tId", tenant.getId()).getSingleResult();
        Project project = createRemoteProject(infos, tenant);
        project.setJobId(infos.getJobId());
        project.setTenant(tenant);
        project.setJobType(jt);
        em.persist(project);
        if (assignTasks) {
            assignProjectTasks(project);
        }

        return project;
    }

    private TaskAssigner assignProjectTaskTo(TaskAssigner assigner) {

        return assigner;
    }

    public Project assignProjectTasks(Project project) {

        List<Task> tasks = em.createNamedQuery(TaskQueries.GET_TASKS_BY_JOBTYPE).setParameter("jbId", project.getJobType().getId()).getResultList();
        List<User> users = em.createNamedQuery(UserQueries.GET_USERS_BY_JOBTYPE).setParameter("jbId", project.getJobType().getId()).getResultList();

        System.out.println("tasks size : " + tasks.size());
        System.out.println("users size : " + users.size());
        return null;
    }

}
