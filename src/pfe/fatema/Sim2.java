/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfe.fatema;

import java.util.ArrayList;
import utils.Query;

/**
 *
 * @author Taleb
 */
public class Sim2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Query> SeedTSG = new ArrayList<>();
        SeedTSG.add(new  Query(150));
        SeedTSG.add(new  Query(150));
        SeedTSG.add(new  Query(150));
        SeedTSG.add(new  Query(150));
        SeedTSG.add(new  Query(150));
        for (Query query : SeedTSG) {
            for (int i = 0; i < query.size(); i++) {
                query.lire(i).generateBruits();
                System.out.println("seed ("+i+") = "+query.lire(i));
            }
        }
    }
   
}
