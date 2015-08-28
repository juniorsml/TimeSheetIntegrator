package br.com.arizona.entities;

import br.com.arizona.entities.Task;
import br.com.arizona.entities.Tenant;
import br.com.arizona.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(TaskAssigner.class)
public class TaskAssigner_ { 

    public static volatile SingularAttribute<TaskAssigner, Long> id;
    public static volatile SingularAttribute<TaskAssigner, Tenant> tenant;
    public static volatile SingularAttribute<TaskAssigner, Boolean> status;
    public static volatile SingularAttribute<TaskAssigner, Integer> counter;
    public static volatile SingularAttribute<TaskAssigner, Long> id_project;
    public static volatile SingularAttribute<TaskAssigner, Task> timedoctorTask;
    public static volatile SingularAttribute<TaskAssigner, User> timedoctorUser;

}