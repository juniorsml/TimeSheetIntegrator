package br.com.arizona.entities;

import br.com.arizona.entities.JobType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, JobType> jobsType;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, Long> idTimeDoctor;

}