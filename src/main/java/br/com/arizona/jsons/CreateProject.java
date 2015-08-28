
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.jsons;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valter.gomes
 */
@XmlRootElement
public class CreateProject {

    @XmlElement(name = "_format")
    String format;
    @XmlElement(name = "project")
    InnerProject project;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public InnerProject getProject() {
        return project;
    }

    public void setProject(InnerProject project) {
        this.project = project;
    }

    @XmlRootElement(name = "project")
    public static class InnerProject {

        public InnerProject() {
        }

        public InnerProject(String project_name) {
            this.project_name = project_name;
        }

        @XmlElement(name = "project_name")
        String project_name;

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

    }

}
