package br.com.arizona.entities;

import br.com.arizona.entities.Task;
import br.com.arizona.entities.Tenant;
import br.com.arizona.entities.User;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(JobType.class)
public class JobType_ { 

    public static volatile SingularAttribute<JobType, Long> id;
    public static volatile ListAttribute<JobType, User> users;
    public static volatile SingularAttribute<JobType, Tenant> tenant;
    public static volatile SingularAttribute<JobType, Boolean> status;
    public static volatile SingularAttribute<JobType, String> description;
    public static volatile SingularAttribute<JobType, String> label;
    public static volatile ListAttribute<JobType, Task> tasks;
    public static volatile SingularAttribute<JobType, Calendar> createDate;

}