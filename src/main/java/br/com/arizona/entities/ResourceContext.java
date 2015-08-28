/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valter.gomes
 */
@Entity
@Table(name = "tsi_resources")
@XmlRootElement
public class ResourceContext implements Serializable {

    @PostConstruct
    public void onCreate() {
        System.out.println("ResourceContext");
    }

    public ResourceContext() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(mappedBy = "resourceContext")
    private Tenant tenant;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "redirect_uri")
    private String redirectURI;
    @Column(name = "api_label")
    private String apiLabel;
    @Column(name = "authorization_endpoint")
    private String authorizationEndpoint;
    @Column(name = "token_endpoint")
    private String tokenEndpoint;
    @Column(name = "api_endpoint")
    private String apiEndpoint;
    @Column(name = "renew_token_endpoint")
    private String renewTokenEndpoint;
    @Column(name = "code")
    private String code;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "expires_in")
    private Long expiresDate;
    @Column(name = "token_type")
    private String tokenType;
    @Column(name = "scope")
    private String scope;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "status")
    private boolean status;
    @Column(name = "timeoctor_company_name")
    String timeDoctorCompanyName;
    @Column(name = "timedoctor_company_id")
    Long timedoctorCompanyId;
    @Column(name = "timedoctor_user_full_name")
    String timedoctorUserFullName;
    @Column(name = " timedoctor_user_email")
    String timedoctorUserEmail;
    @Column(name = "timedoctor_user_id")
    Long timedoctorUserId;

    public String getTimedoctorUserFullName() {
        return timedoctorUserFullName;
    }

    public void setTimedoctorUserFullName(String timedoctorUserFullName) {
        this.timedoctorUserFullName = timedoctorUserFullName;
    }

    public String getTimedoctorUserEmail() {
        return timedoctorUserEmail;
    }

    public void setTimedoctorUserEmail(String timedoctorUserEmail) {
        this.timedoctorUserEmail = timedoctorUserEmail;
    }

    public Long getTimedoctorUserId() {
        return timedoctorUserId;
    }

    public void setTimedoctorUserId(Long timedoctorUserId) {
        this.timedoctorUserId = timedoctorUserId;
    }
    
    public String getTimeDoctorCompanyName() {
        return timeDoctorCompanyName;
    }

    public void setTimeDoctorCompanyName(String timeDoctorCompanyName) {
        this.timeDoctorCompanyName = timeDoctorCompanyName;
    }

    public Long getTimedoctorCompanyId() {
        return timedoctorCompanyId;
    }

    public void setTimedoctorCompanyId(Long timedoctorCompanyId) {
        this.timedoctorCompanyId = timedoctorCompanyId;
    }
    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getApiLabel() {
        return apiLabel;
    }

    public void setApiLabel(String apiLabel) {
        this.apiLabel = apiLabel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRenewTokenEndpoint() {
        return renewTokenEndpoint;
    }

    public void setRenewTokenEndpoint(String renewTokenEndpoint) {
        this.renewTokenEndpoint = renewTokenEndpoint;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorizationEndpoint() {
        return authorizationEndpoint;
    }

    public void setAuthorizationEndpoint(String authorizationEndpoint) {
        this.authorizationEndpoint = authorizationEndpoint;
    }

    public String getTokenEndpoint() {
        return tokenEndpoint;
    }

    public void setTokenEndpoint(String tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "ResourceContext {" + "id=" + id + ", authorizationEndpoint=" + authorizationEndpoint + ", tokenEndpoint=" + tokenEndpoint + ", apiEndpoint=" + apiEndpoint + ", code=" + code + ", accessToken=" + accessToken + ", expiresDate=" + expiresDate + ", tokenType=" + tokenType + ", scope=" + scope + ", refreshToken=" + refreshToken + '}';
    }

    // Json Returned from tokenendpoint - To bind Json into a jova object is required set's methods 
    // with same name field of the Json
    // 
    //{
    //"access_token":"MzZhY2NiMGVkODgzYjlkYTQwMTkzZjc2ZTk5Mzc4ODUxNTdmYjYwZTE4M2EwZDZhNDE5NDA2MTIxZWY0MjIxZQ"
    //,"expires_in":432000,
    //"token_type":"bearer",
    //"scope":null,
    //"refresh_token":"NzY2NzU2NWY1MWJjYjI2ZGVkYmNmOWE1ZjU0YjI1MmQ0OGJkOTM4MDhmZmM4ZTc5MzIzMjJlZDg3OGE5NjdjOA"
    // }     
    public String getAccess_token() {
        System.out.println("GET AT");
        return accessToken;
    }

    public void setAccess_token(String accessToken) {
        System.out.println("Chamou");
        this.accessToken = accessToken;
    }

    public void setExpires_in(Long expiresDate) {
        System.out.println("setExpires_in");
        this.expiresDate = expiresDate;
    }

    public Long getExpires_in() {
        System.out.println("getExpires_in");
        return expiresDate;
    }

    public void setToken_type(String tokenType) {
        System.out.println("setToken_type");
        this.tokenType = tokenType;
    }

    public String getToken_type() {
        System.out.println("setToken_type");
        return tokenType;
    }

    public void setRefresh_token(String refreshToken) {
        System.out.println("setRefresh_token");
        this.refreshToken = refreshToken;
    }

    public String getRefresh_token() {
        System.out.println("setRefresh_token");
        return refreshToken;
    }

}
