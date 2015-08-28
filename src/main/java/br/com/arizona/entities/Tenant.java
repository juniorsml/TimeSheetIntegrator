/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_tenants")
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @OneToOne
    ResourceContext resourceContext;

    @OneToMany(mappedBy = "tenant")
    List<JobType> jobsType;

    public List<JobType> getJobsType() {
        return jobsType;
    }

    public void setJobsType(List<JobType> jobsType) {
        this.jobsType = jobsType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResourceContext getResourceContext() {
        return resourceContext;
    }

    public void setResourceContext(ResourceContext resourceContext) {
        this.resourceContext = resourceContext;
    }

    public List<JobType> getJobType() {
        return jobsType;
    }

    public void setJobType(List<JobType> jobType) {
        this.jobsType = jobType;
    }

    @Override
    public String toString() {
        return "Tenant{" + "id=" + id + ", name=" + name + ", resourceContext=" + resourceContext + ", jobsType=" + jobsType + '}';
    }

    
}
