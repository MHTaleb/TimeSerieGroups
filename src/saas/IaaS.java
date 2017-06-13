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

// suplementaire
public class IaaS {
    private final int cpu;
    private final int network;
    private final int cost;


    public IaaS() {

        this.cost = (int) (Math.random()*200+1);
        this.network = (int) (Math.random()*20+1);
        this.cpu = (int) (Math.random()*7+1);
    }

    public int getCost() {
        return cost;
    }

    public int getCpu() {
        return cpu;
    }

    public int getNetwork() {
        return network;
    }


    @Override
    public String toString() {
        return "IaaS{" + "cpu=" + cpu + ", network=" + network + ", cost=" + cost + " '}'";
    }
    
}
