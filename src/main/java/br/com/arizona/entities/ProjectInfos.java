/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valter.gomes
 */
public class ProjectInfos implements Serializable {

    Long jobId;
    String title;
    String tenant;
    String jobType;

    public Long getJobId() {
        return jobId;
    }

    public ProjectInfos() {
    }

    public ProjectInfos(Long jobId, String title, String tenant, String job_type) {
        this.jobId = jobId;
        this.title = title;
        this.tenant = tenant;
        this.jobType = job_type;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
    
    @XmlTransient
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    
    //Fields to serealize key from Json that is not in name form pattern
    public String getJob_type() {

        return jobType;
    }

    public void setJob_type(String jobType) {
        this.jobType = jobType;
    }

    @Override
    public String toString() {
        return "ProjectInfos{" + "jobId=" + jobId + ", title=" + title + ", tenant=" + tenant + ", jobType=" + jobType + '}';
    }

}
