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
public class QOSRelation {
    
    private final int  size;

    private ArrayList<ArrayList<QRelation>> qRelation;
    
    public QOSRelation(TimeSerieGroup tsg) {
        qRelation = new ArrayList<>(); //  Allocation de memoir
        size = tsg.size(); // 3 (debit reput cout)
        for (int i = 0; i < size; i++) {
            qRelation.add(new ArrayList<QRelation>());
        }
        // fin allocation de memoire
        for (int i = 0; i < size; i++) { // 3 (dedbit reput cout)
            ArrayList<QRelation> line = qRelation.get(i); // i0 : debit
            for (int j = 0; j < size; j++) {
                Query queryI = null;
                Query queryJ;
                try {
                    queryI = tsg.lire(i);
                    queryJ = tsg.lire(j);
                    final QRelation qRelation1 = new QRelation(i, j, queryI, queryJ); // si erreur ici
                    line.add(qRelation1);
                } catch (IllegalTimeVarianceArgumentException e) { // alor reparation
                    queryI.lire(0).setT((float) Math.random());
                    queryI.lire(queryI.size()-1).setT((float) Math.random());
                    j--;
                    System.out.println("correction done");
                }
            }
        }
    }
    
    public QRelation lire(int i, int j){
        return qRelation.get(i).get(j);
    }
    
        public ArrayList<ArrayList<Float>> distance(QOSRelation qosr1){
        try {
            ArrayList<ArrayList<Float>> result = new ArrayList<>();
            for (int i = 0; i < qosr1.qRelation.size(); i++) {
                ArrayList<Float> currentProcessedLine = new ArrayList<>();
                ArrayList<QRelation> qosrLineI = qosr1.qRelation.get(i);
                ArrayList<QRelation> thisLineI = this.qRelation.get(i);
                for (int j = 0; j < qosrLineI.size(); j++) {
                float somme = 0;
                    QRelation qosrIJ = qosrLineI.get(j);
                    QRelation thisIJ = thisLineI.get(j);
                    Float[] qosrValues = qosrIJ.getArray();
                    Float[] thisValues = thisIJ.getArray();
                    for (int k = 0; k < qosrValues.length; k++) {
                        somme += Math.pow(qosrValues[k]-thisValues[k], 2); // ici c ets la somme de tout les element
                    }
                    //somme = (float) Math.sqrt(somme); // ici je calcule la racine de leurs somme
                    currentProcessedLine.add(somme);
                }
                result.add(currentProcessedLine);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        String show="";
        for (ArrayList<QRelation> arrayList : qRelation) {
            show+=arrayList.toString()+"\n";
        }
        return show;
    }
    
}
