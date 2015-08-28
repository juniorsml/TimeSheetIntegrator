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
public class TaskQueries {

    @PersistenceContext
    EntityManager em;

    public static final String GET_TASKS_BY_JOBTYPE = "GET_TASKS_BY_JOBTYPE";

    @PostConstruct
    public void postConstruct() {
        System.out.println("@@@TaskQueries is iniitlized... *****************************************");
        createQueries();
    }

    public void createQueries() {
        Query query;
        query = em.createQuery("SELECT tk FROM  Task tk join tk.jobsType jb where jb.id = :jbId ");
        em.getEntityManagerFactory().addNamedQuery(GET_TASKS_BY_JOBTYPE, query);
    }

}
