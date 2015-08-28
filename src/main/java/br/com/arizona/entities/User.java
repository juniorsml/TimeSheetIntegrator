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
import javax.persistence.Table;

/**
 *
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_timedoctor_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;
    @Column(name = "full_name")
    String fullName;
    @Column(name = "email")
    String email;
    @Column(name = "id_timedoctor")
    Long idTimeDoctor;
    @ManyToMany
    List<JobType> jobsType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdTimeDoctor() {
        return idTimeDoctor;
    }

    public void setIdTimeDoctor(Long idTimeDoctor) {
        this.idTimeDoctor = idTimeDoctor;
    }

    public List<JobType> getJobsType() {
        return jobsType;
    }

    public void setJobsType(List<JobType> jobsType) {
        this.jobsType = jobsType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
