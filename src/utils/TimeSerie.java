/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class TimeSerie {
    
    private final float x;
    private  float t; //  1
    private ArrayList<TimeSerie> bruits; // 199

    public TimeSerie(float t) {
        this.x = (float) Math.random();
        this.t = t;
    }
    
    public void generateBruits() throws Exception{
        bruits = new ArrayList<>();
        for (int i = 1; i < 200; i++) {
            bruits.add(new TimeSerie(i));
        }
    }

    public TimeSerie(float x, float t) {
        this.x = x;
        this.t = t;
    }

    public void setT(float t) {
        this.t = t;
    }
 
    public float getT() {
        return t;
    }

    public float getX() {
        return x;
    }

    @Override
    public String toString() {
        String message = "";
        message+="TimeSerie{" + "x=" + x + ", t=" + t ;
        if (bruits!= null) {
            message+="\n (";
             for (TimeSerie bruit : bruits) {
                 if (bruit.t/5==0) {
                     message+="\n";
                     System.out.println("");
                 }
                 message+=bruit;
            }
             message+=").";
        }
        return message;
    }

   
    
}
