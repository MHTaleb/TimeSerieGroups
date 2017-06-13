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
public class QoSVariance {
    private final ArrayList<Float> SampledQoSValues;
  

    public QoSVariance(Query query1, Query query2) {
        SampledQoSValues = new ArrayList<>();
        for (int i = 0; i < query1.size(); i++) {
            SampledQoSValues.add(Math.abs(query1.lire(i).getX()-query2.lire(i).getX()));
        }
    }

    public ArrayList<Float> getSampledQoSValues() {
        return SampledQoSValues;
    }
    
    public float lire(int index){
        return SampledQoSValues.get(index);
    }

    @Override
    public String toString() {
        return "QoSVariance{" + "SampledQoSValues=" + SampledQoSValues + '}';
    }
    
    
    
}
