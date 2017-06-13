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
public class QRelation { // ligne
    private final TimeVariance timeVariance;
    private final QoSVariance QosVariance;

    public QRelation(int i, int j,Query query1,Query query2) {
        timeVariance = new TimeVariance(query1, query2, i, j); // taille  4
        QosVariance=new QoSVariance(query1, query2 );// taille egale a taille de la sim 150
    }

    public Float[] getArray(){
        ArrayList<Float> floats = new ArrayList<>();
        floats.addAll(QosVariance.getSampledQoSValues());
        floats.addAll(timeVariance.getTimes());
        Float[] ts = new Float[floats.size()];
        return floats.toArray(ts);
    }
    
    @Override
    public String toString() {
        return "\nQRelation{" + "QosVariance=" + QosVariance + ", timeVariance=" + timeVariance + '}';
    }
    
}
