/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_projects")
public class Project implements Serializable {

    public Project() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "timedoctor_project_id")
    Long timedoctorProjectId;
    @Column(name = "visto_job_id")
    Long jobId;
    @Column(name = "project_name")
    String projectName;
    @Column(name = "project_source")
    String projectSource;
    @Column(name = "archived")
    boolean archived;
    @ManyToOne
    Tenant tenant;
    @ManyToMany
    List<Task> tasks;
    @ManyToMany
    List<User> users;
    @ManyToOne
    JobType jobType;

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimedoctorProjectId() {
        return timedoctorProjectId;
    }

    public void setTimedoctorProjectId(Long timedoctorProjectId) {
        this.timedoctorProjectId = timedoctorProjectId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Json Returned from tokenendpoint - To bind Json into a jova object is required set's methods 
    // with same name field of the Json
    // 
    //    {
    //    "project_id": 233078,
    //    "project_source": "TSI",
    //    "project_name": "Campanha 1",
    //    "archived": false,
    //    "url": "https://webapi.timedoctor.com/v1.1/companies/318669/users/400102/projects/233078"
    //}
    public String getProject_source() {
        return projectSource;
    }

    public void setProject_source(String projectSource) {
        this.projectSource = projectSource;
    }

    public Long getProject_id() {
        return timedoctorProjectId;
    }

    public void setProject_id(Long projectId) {
        this.timedoctorProjectId = projectId;
    }

    public String getProject_name() {
        return projectName;
    }

    public void setProject_name(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", projectId=" + timedoctorProjectId + ", jobId=" + jobId + ", projectName=" + projectName + ", projectSource=" + projectSource + ", archived=" + archived + ", tenant=" + tenant + ", tasks=" + tasks + ", users=" + users + '}';
    }

}
