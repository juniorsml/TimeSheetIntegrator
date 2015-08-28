/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;
    @Column(name = "description")
    String description;
    @Column(name = "status")
    boolean status;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    Calendar createDate;
    @ManyToMany(mappedBy = "tasks")
    List<JobType> jobsType;
    @ManyToMany
    List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<JobType> getJobsType() {
        return jobsType;
    }

    public void setJobsType(List<JobType> jobsType) {
        this.jobsType = jobsType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public List<JobType> getJobType() {
        return jobsType;
    }

    public void setJobType(List<JobType> jobsType) {
        this.jobsType = jobsType;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description=" + description + ", status=" + status + ", createDate=" + createDate + ", jobType=" + jobsType + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }

}
