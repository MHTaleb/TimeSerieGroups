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
public class TimeSerieGroup {
    // liste chainé des Requetes
    private final ArrayList<Query> querys;

    public TimeSerieGroup() {
        querys  = new ArrayList<>();
    }

    public TimeSerieGroup(ArrayList<Query> querys) {
        this.querys = querys;
    }
    public void ajouter(Query q){
        querys.add(q);
    }
    public Query lire(int index){
        return querys.get(index);
    }

    public ArrayList<Query> lireToutesLesRequetes() {
        return querys;
    }
    

    @Override
    public String toString() {
        return "TimeSerieGroup{" + "querys=" + querys + '}';
    }
    public int size(){
        return querys.size();
    }
    
    public Query lireEnUneSeulRequete(){
        Query allQuery = new Query();// cella est notre requete global
        for (Query query : querys) {// pour chaque requette dans la liste chainer
            allQuery.ajouter(query); //  on ajoute cette requete dans notre requete global
        }
        return allQuery; // on retourne la requete global en resultat
    }
}
