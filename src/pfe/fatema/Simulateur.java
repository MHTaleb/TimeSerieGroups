/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pfe.fatema;

import java.util.ArrayList;
import providers.ClientTSGFactory;
import utils.QOSRelation;
import utils.Query;
import utils.TimeSerieGroup;

/**
 *
 * @author pc
 */
public class Simulateur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int TAILLE = 3;
        
        
        TimeSerieGroup tsg = GenerateTSG(TAILLE);
        
        TimeSerieGroup seedtsg2 = new TimeSerieGroup();
        seedtsg2.ajouter(new Query(TAILLE));
        seedtsg2.ajouter(new Query(TAILLE));
        seedtsg2.ajouter(new Query(TAILLE));// 3 seed
       
        //------------------------- transformer tsg en un vecteur  
        Query tsg2GrandeRequete = seedtsg2.lireEnUneSeulRequete();
        System.out.println(tsg2GrandeRequete);
        Query tsg1GrandeRequete = tsg.lireEnUneSeulRequete();
        System.out.println(tsg1GrandeRequete);
        //-------------------------------------   distance entre tsg  QA 
        float QADistance = tsg2GrandeRequete.calculerDistanceQA(tsg1GrandeRequete);
        System.out.println("Distance est egale a : "+QADistance);
        //------------------------------------  calculer QosR de TSG1 et TSG2
       QOSRelation qosr = new QOSRelation(tsg);
        System.out.println(qosr);
       QOSRelation qosr1 = new QOSRelation(seedtsg2);
        System.out.println(qosr1);
        // ------------------------------- Distance entre Qosr 1 et 2 // QR
        ArrayList<ArrayList<Float>> distance1 = qosr.distance(qosr1);
       // System.out.println("Matrice des distance de chaque individu : \n  ");
        for (ArrayList<Float> arrayList : distance1) {
            System.out.println("    "+arrayList);
        }
        //---------------------------------------------------------------------
        float QRDistance = Matrice.DistanceQosr(distance1);
        System.out.println("\nla distance final entre Qosr 1 et 2 : "+QRDistance);
        
        //------------------  dist tsci,tscj ---------------------------------- racine (QR*QA)
        float finalDistance = (float) Math.sqrt(QRDistance*QADistance);
        System.out.println("finalresult = "+finalDistance);
        
        
        //--------------------   sim 2 -------------------------------------
        System.out.println("----------------------------------------------------------------\n\n"
                + "----------------------------------------------------------------\n\n"
                + "----------------------------------------------------------------\n\n ");
        
        ClientTSGFactory clientTSGFactory = new ClientTSGFactory();
        TimeSerieGroup tsgClient1 = clientTSGFactory.generate(TAILLE);
        System.out.println(tsgClient1);
        
        Query requeteGlobalClient = tsgClient1.lireEnUneSeulRequete();
        float globalTsg2 = requeteGlobalClient.calculerDistanceQA(tsg2GrandeRequete);
        
       
        float globalTsg1 = requeteGlobalClient.calculerDistanceQA(tsg1GrandeRequete);
        
    }

    private static TimeSerieGroup GenerateTSG(final int TAILLE) {
        TimeSerieGroup tsg = new TimeSerieGroup();
        tsg.ajouter(new Query(TAILLE));
        tsg.ajouter(new Query(TAILLE));
        tsg.ajouter(new Query(TAILLE));
        return tsg;
    }
    
}
