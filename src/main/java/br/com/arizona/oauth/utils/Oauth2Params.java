/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.oauth.utils;

/**
 *
 * @author valter.gomes
 */
public enum Oauth2Params {
    
    CLIENT_ID("client_id"), CLIENT_SECRET("client_secret"),
    GRANT_TYPE("grant_type"), REDIRECT_URI("redirect_uri"), CODE("code");

    private Oauth2Params(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
