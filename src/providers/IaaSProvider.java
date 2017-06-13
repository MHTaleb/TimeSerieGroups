/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import java.util.ArrayList;
import saas.IaaS;

/**
 *
 * @author Taleb
 */
// suplementaire
public class IaaSProvider {
    private final ArrayList<IaaS> registredIaaS;

    public IaaSProvider() {
        registredIaaS = new ArrayList<>();
    }
    
    public boolean registerInfrastructureService(IaaS iaaS){
        if(registredIaaS.contains(iaaS))return true;
        boolean add = registredIaaS.add(iaaS);     
        return add;
    }
    public void remove(int index){
        if (index==-1) {
            return;
        }
        registredIaaS.remove(index);
    }
    
    public int find(IaaS  iaas){
        return registredIaaS.indexOf(iaas);
    }
    public ArrayList<IaaS> getAll(){
        return registredIaaS;
    }

    @Override
    public String toString() {
        return "IaaSProvider{" + "registredIaaS=" + registredIaaS + '}';
    }
    
}
