/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author Taleb
 */
public class TimeVariance {

    private final ArrayList<Float> times;
    
    final int LAST_ELEMENT;
    
    final float tm1;
    final float tn1;
    final float tnl;
    final float tml;
    
    public TimeVariance(Query query1, Query query2,int i,int j) {
        this.times = new ArrayList<>();
        LAST_ELEMENT = query1.size() - 1;
        tm1 = query1.lire(0).getT();
        tn1 = query2.lire(0).getT();
        tnl = query2.lire(LAST_ELEMENT).getT();
        tml = query1.lire(LAST_ELEMENT).getT();
        times.add(tm1 - tn1);
        times.add(tml - tnl);
        
        times.add(getT3MN(i,j));
        
        times.add(getT4MN(i,j));
        
    }

    public ArrayList<Float> getTimes() {
        return times;
    }
    
    private Float getT3MN(int i, int j) throws IllegalArgumentException{
        if (i==j) {
            return (float)0;
        }
        if (tm1>=tn1) {
            return tm1-tnl;
        }
        if (tml<tn1) {
            return -(tn1-tml);
        }
        if (Math.abs(tm1-tn1)<EPSILON) {
            return tm1-tnl;
        }
        // partie reparation
        System.out.println("\n i="+i+" j="+j);
        System.out.println("\ntm1 ="+tm1);
        System.out.println("\ntn1 ="+tn1);
        System.out.println("\ntml ="+tml);
        System.out.println("\ntnl ="+tnl);
        // je genere une exception ( erreur )
        throw new IllegalTimeVarianceArgumentException("erreur dans T3MN",i,j);
    }
    private static final double EPSILON = 0.004; // degrer d erreur 1--> 149  (random (0..1))

    private Float getT4MN( int i, int j) {
        if (i==j) {
            return (float)0;
        }
        if (tm1>=tn1) {
            return tml-tn1;
        }
        if (tml<tn1) {
            return -(tml-tm1);
        }
        
        if (Math.abs(tm1-tn1)<EPSILON) {
            return tml-tn1;
        }
        throw new IllegalTimeVarianceArgumentException("erreur dans T4MN",i,j);
        
    }

    public float lire(int index){
        return times.get(index);
    }

    @Override
    public String toString() {
        return "TimeVariance{" + "times=" + times + "}";
    }

    
}
