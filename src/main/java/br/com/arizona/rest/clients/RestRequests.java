/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arizona.rest.clients;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author valter.gomes
 */
public class RestRequests {

  //  private final Client client;
    // private WebResource webResource ;
    @PostConstruct
    public void onCreate() {
        System.out.println("Construtor RestRequests");
    }

    public RestRequests() {
        //  this.client = Client.create();
    }

//    public WebResource  buildRequest(String uriDomain, String path, MultivaluedMap params) {
//       //return this.webResource  = client.resource(uriDomain).path(path).queryParams(params);
//    }
    public WebTarget buildRequest(String uriDomain, String path) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(uriDomain + path);
        System.out.println(target.getUri());
        return target;
    }

}
