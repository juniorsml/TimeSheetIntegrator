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
public class JobTypeQueries {

    @PersistenceContext
    EntityManager em;

    public static final String GET_JOBTYPE_BY_NAME_AND_TENANT = "GET_JOBTYPE_BY_NAME_AND_TENANT";

    @PostConstruct
    public void postConstruct() {
        System.out.println("@@@JobTypeQueries is iniitlized... *****************************************");
        createQueries();
    }

    public void createQueries() {
        Query query;
        query = em.createQuery("SELECT jt FROM  JobType jt where jt.label = :jtlabel and jt.tenant.id = :tId ");
        em.getEntityManagerFactory().addNamedQuery(GET_JOBTYPE_BY_NAME_AND_TENANT, query);
    }

}
