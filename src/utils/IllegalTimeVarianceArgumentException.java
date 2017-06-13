/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author 
 */
class IllegalTimeVarianceArgumentException extends IllegalArgumentException {

    private final int i;
    private final int j;
    
    public IllegalTimeVarianceArgumentException(String erreur_dans_T3MN, int i, int j) {
        super(erreur_dans_T3MN);
        this.i=i;
        this.j=j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
    
}
