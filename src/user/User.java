/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import utils.Query;

/**
 *
 * @author Taleb
 */
public class User {
    private final String user;
    private final Query query;

    public User(String user, Query query) {
        this.user = user;
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", query=" + query + '}';
    }
    
    
}
