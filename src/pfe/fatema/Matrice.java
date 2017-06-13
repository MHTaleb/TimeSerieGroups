/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfe.fatema;

import java.util.ArrayList;

/**
 *
 * @author Taleb
 */
public class Matrice {

    public static float DistanceQosr(ArrayList<ArrayList<Float>> distance1) {
        float dist =0;
        for (ArrayList<Float> line : distance1) {
            for (Float value : line) {
                dist+=value;
            }
        }
        dist = (float) Math.sqrt(dist);
        return dist;
    }
    
}
