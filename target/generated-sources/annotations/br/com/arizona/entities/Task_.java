package br.com.arizona.entities;

import br.com.arizona.entities.JobType;
import br.com.arizona.entities.User;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Long> id;
    public static volatile ListAttribute<Task, User> users;
    public static volatile SingularAttribute<Task, Boolean> status;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile ListAttribute<Task, JobType> jobsType;
    public static volatile SingularAttribute<Task, Calendar> createDate;

}