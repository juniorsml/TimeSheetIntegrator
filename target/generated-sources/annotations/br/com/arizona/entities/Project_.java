package br.com.arizona.entities;

import br.com.arizona.entities.JobType;
import br.com.arizona.entities.Task;
import br.com.arizona.entities.Tenant;
import br.com.arizona.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Long> id;
    public static volatile SingularAttribute<Project, JobType> jobType;
    public static volatile ListAttribute<Project, User> users;
    public static volatile SingularAttribute<Project, Long> jobId;
    public static volatile SingularAttribute<Project, Boolean> archived;
    public static volatile SingularAttribute<Project, Tenant> tenant;
    public static volatile SingularAttribute<Project, String> projectSource;
    public static volatile ListAttribute<Project, Task> tasks;
    public static volatile SingularAttribute<Project, String> projectName;
    public static volatile SingularAttribute<Project, Long> timedoctorProjectId;

}