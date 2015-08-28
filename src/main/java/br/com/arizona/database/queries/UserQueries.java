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
public class UserQueries {

    @PersistenceContext
    EntityManager em;

    public static final String GET_USERS_BY_JOBTYPE = "GET_TASKS_BY_JOBTYPE";

    @PostConstruct
    public void postConstruct() {
        System.out.println("@@@UserQueries is iniitlized... *****************************************");
        createQueries();
    }

    public void createQueries() {
        Query query;
        query = em.createQuery("SELECT us FROM  User us where us.jobsType jb where jb.id :jbId ");
        em.getEntityManagerFactory().addNamedQuery(GET_USERS_BY_JOBTYPE, query);
    }

}
