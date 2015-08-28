/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_taskAssignment")
public class TaskAssigner implements Serializable {

    public TaskAssigner() {
    }

    public TaskAssigner(User timedoctorUser, Task timedoctorTask, Tenant tenant) {
        this.timedoctorUser = timedoctorUser;
        this.timedoctorTask = timedoctorTask;
        this.tenant = tenant;
    }

    public TaskAssigner(User timedoctorUser, Task timedoctorTask) {
        this.timedoctorUser = timedoctorUser;
        this.timedoctorTask = timedoctorTask;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    User timedoctorUser;
    @OneToOne
    Task timedoctorTask;
    @OneToOne
    Tenant tenant;
    Long id_project;
    int counter;
    boolean status;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTimedoctorUser() {
        return timedoctorUser;
    }

    public void setTimedoctorUser(User timedoctorUser) {
        this.timedoctorUser = timedoctorUser;
    }

    public Task getTimedoctorTask() {
        return timedoctorTask;
    }

    public void setTimedoctorTask(Task timedoctorTask) {
        this.timedoctorTask = timedoctorTask;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
