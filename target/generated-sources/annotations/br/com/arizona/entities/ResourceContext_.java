package br.com.arizona.entities;

import br.com.arizona.entities.Tenant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-28T14:44:02")
@StaticMetamodel(ResourceContext.class)
public class ResourceContext_ { 

    public static volatile SingularAttribute<ResourceContext, String> renewTokenEndpoint;
    public static volatile SingularAttribute<ResourceContext, Long> timedoctorCompanyId;
    public static volatile SingularAttribute<ResourceContext, String> scope;
    public static volatile SingularAttribute<ResourceContext, String> timeDoctorCompanyName;
    public static volatile SingularAttribute<ResourceContext, Long> expiresDate;
    public static volatile SingularAttribute<ResourceContext, String> accessToken;
    public static volatile SingularAttribute<ResourceContext, Boolean> status;
    public static volatile SingularAttribute<ResourceContext, String> code;
    public static volatile SingularAttribute<ResourceContext, String> refreshToken;
    public static volatile SingularAttribute<ResourceContext, String> clientSecret;
    public static volatile SingularAttribute<ResourceContext, String> clientId;
    public static volatile SingularAttribute<ResourceContext, Long> id;
    public static volatile SingularAttribute<ResourceContext, Long> timedoctorUserId;
    public static volatile SingularAttribute<ResourceContext, String> tokenType;
    public static volatile SingularAttribute<ResourceContext, Tenant> tenant;
    public static volatile SingularAttribute<ResourceContext, String> timedoctorUserFullName;
    public static volatile SingularAttribute<ResourceContext, String> redirectURI;
    public static volatile SingularAttribute<ResourceContext, String> apiEndpoint;
    public static volatile SingularAttribute<ResourceContext, String> apiLabel;
    public static volatile SingularAttribute<ResourceContext, String> timedoctorUserEmail;
    public static volatile SingularAttribute<ResourceContext, String> tokenEndpoint;
    public static volatile SingularAttribute<ResourceContext, String> authorizationEndpoint;

}