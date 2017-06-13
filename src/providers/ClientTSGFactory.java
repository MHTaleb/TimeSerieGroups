/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import java.util.ArrayList;
import java.util.Hashtable;
import saas.QSi;
import utils.Query;
import utils.TimeSerie;
import utils.TimeSerieGroup;

/**
 *
 * @author Taleb
 */
public class ClientTSGFactory {

    private int index = 0;
    Hashtable<Integer, ArrayList<QSi>> database = new Hashtable<>();

    public ClientTSGFactory() {
    }

    public TimeSerieGroup generate(int longeur) {
        for (int j = 0; j < 3; j++) {// nombre de ligne S1, S2 , S3
         ArrayList<QSi> client = new ArrayList<QSi>();
            for (int i = 0; i < longeur; i++) { //QSi 1-->150
                QSi qSi = new QSi();
                System.out.println("SQ("+i+")="+qSi);
                client.add(qSi);
            }
            database.put(index++, client);
        }
// instantiation des S1.2.3 du tsg
        ArrayList<Query> querys = new ArrayList<>();
// Calcul du debit du tsg      
        ArrayList<TimeSerie> debitSeries = new ArrayList<>();
        
        for (int i = 0; i < longeur; i++) {
            final float debitS1i = database.get(0).get(i).getDebit();
            final float debitS2i = database.get(1).get(i).getDebit();
            final float debitS3i = database.get(2).get(i).getDebit();
            final String name = "debit S(1)("+i+")="+debitS1i;
            final String name1 = "debit S(2)("+i+")="+debitS2i;
            final String name2 = "debit S(3)("+i+")="+debitS3i;
            System.out.println(name+"  "+name1+"  "+name2);
            float debitMinI = Math.min(Math.min(debitS1i, debitS2i), debitS3i);
            
            debitSeries.add(new TimeSerie(debitMinI, i));
        }
        
        querys.add(new Query(debitSeries));

// Calcul de la reputation du tsg      
        ArrayList<TimeSerie> reputationSeries = new ArrayList<>();
        
        for (int i = 0; i < longeur; i++) {
            final float reputS1i = database.get(0).get(i).getReputation();
            final float reputS2i = database.get(1).get(i).getReputation();
            final float reputS3i = database.get(2).get(i).getReputation();
            float ri = reputS1i*reputS2i*reputS3i;
            reputationSeries.add(new TimeSerie(ri, i));
        }
        
        querys.add(new Query(reputationSeries));
// Calcul du cout du tsg      
        ArrayList<TimeSerie> coutSeries = new ArrayList<>();
        
        for (int i = 0; i < longeur; i++) {
            final float coutS1i = database.get(0).get(i).getCout();
            final float coutS2i = database.get(1).get(i).getCout();
            final float coutS3i = database.get(2).get(i).getCout();
            float ci = coutS1i+coutS2i+coutS3i;
            coutSeries.add(new TimeSerie(ci, i));
        }
        
        querys.add(new Query(coutSeries));
        
       // generation du tsg a apartir des calcul precedant 
        TimeSerieGroup tsg = new TimeSerieGroup(querys);
        return tsg;
    }

}
