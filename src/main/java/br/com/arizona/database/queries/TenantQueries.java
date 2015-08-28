/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.database.queries;

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
public class TenantQueries {

    @PersistenceContext
    EntityManager em;

    public static final String GET_TENANT_BY_NAME = "GET_TENANT_BY_NAME";

    @PostConstruct
    public void postConstruct() {
        System.out.println("@@@TenantQueries is iniitlized... *****************************************");
        createQueries();
    }

    public void createQueries() {
        Query query = em.createQuery("SELECT t FROM  Tenant t where t.name = :tname ");
        em.getEntityManagerFactory().addNamedQuery(GET_TENANT_BY_NAME, query);
    }

}
