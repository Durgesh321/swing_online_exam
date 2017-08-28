/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

/**
 *
 * @author durgesh
 */

public class Options {
    
    private int oId;
    private String o;

    public Options() {
    }

    public Options(int oId, String o) {
        this.oId = oId;
        this.o = o;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

   
}
