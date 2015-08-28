package br.com.arizona.entities;

import br.com.arizona.entities.JobType;
import br.com.arizona.entities.ResourceContext;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(Tenant.class)
public class Tenant_ { 

    public static volatile SingularAttribute<Tenant, Long> id;
    public static volatile SingularAttribute<Tenant, String> name;
    public static volatile ListAttribute<Tenant, JobType> jobsType;
    public static volatile SingularAttribute<Tenant, ResourceContext> resourceContext;

}