/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saas;

/**
 *
 * @author Taleb
 */
public class QSi {
    private final float debit;
    private final float reputation;
    private final float cout;
   
    public QSi() {
        
        this.debit = (float) (Math.random());
        this.cout = (float) (Math.random());
        this.reputation = (float) Math.random();
    }

    public float getCout() {
        return cout;
    }

    public float getDebit() {
        return debit;
    }

            
    
    public float getReputation() {
        return reputation;
    }

    
    @Override
    public String toString() {
        return "SaaS{" + "requeteParSecond=" + debit + ", reputation=" + reputation + ", cout=" + cout + '}';
    }
    
    
    
    
    
}
