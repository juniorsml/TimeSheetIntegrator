/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.database.queries;

import static br.com.arizona.database.queries.TenantQueries.GET_TENANT_BY_NAME;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author valter.gomes
 */
@Singleton
@Startup
public class ResourceContextQueries {

    @PersistenceContext
    EntityManager em;

    public static String GET_RESOURCECONTEXT_BY_TENANT_ID = "GET_RESOURCECONTEXT_BY_TENANT_ID";

    @PostConstruct
    public void postConstruct() {
        System.out.println("@@@ResourceContextQueries is iniitlized... *****************************************");
        createQueries();
    }

    private void createQueries() {

        Query query = em.createQuery("SELECT rc FROM ResourceContext rc WHERE rc.tenant.id = :tenantId");
        em.getEntityManagerFactory().addNamedQuery(GET_RESOURCECONTEXT_BY_TENANT_ID, query);

    }

}
