/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pc
 */
public class Query {

    private final ArrayList<TimeSerie> series;

    public Query(int size) {
        series = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            series.add(new TimeSerie(i));
        }
    }
    public Query(int size,Random r){
         series = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            float gaussianRandomValue = (float) r.nextGaussian();
            while (gaussianRandomValue < 0 || gaussianRandomValue > 1) {                
                gaussianRandomValue = (float) r.nextGaussian();
            }
            series.add(new TimeSerie(gaussianRandomValue,i));
        }
    }

    
    public Query(ArrayList<TimeSerie> series) {
        this.series = series;
    }

    public int size(){
        return series.size();
    }
    
    public Query() {
        this.series = new ArrayList<>();
    }

    public void ajouter(TimeSerie serie) {
        if (serie != null) {
            series.add(serie);
        }
    }

    public void ajouter(Query q) {
        if (q != null) {
            for (TimeSerie sery : q.series) {
                series.add(sery);
            }
        }
    }

    public TimeSerie lire(int index) {
        return series.get(index);
    }
    public float calculerDistanceQA(Query q){
        int lastIndex;
        if(q.series.size()>=this.series.size()){
            lastIndex = q.series.size(); 
        }else{
            lastIndex = this.series.size();
        }
        float somme = 0;
        for (int index = 0; index < lastIndex; index++) {
            somme += Math.pow(q.series.get(index).getX()-this.series.get(index).getX(),2);
        }
        float dist = (float) Math.sqrt(somme);
        
        return dist;
    }

    @Override
    public String toString() {
        return "Query{" + "series=" + series + '}';
    }

}
