/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesemmaven;

import ifpb.dac.service.*;

/**
 *
 * @author Sergio Diniz
 */
public class Conexoes {
    
    public static ServiceLocator service = new ServiceLocator();
    
    public static DAOIT DAO(){
        return service.lookup("java:global/AppWeb/DAO", DAOIT.class);  
    }
    
    public static CidadeServiceIT cidadeService(){
        return service.lookup("java:global/AppWeb/CidadeService", CidadeServiceIT.class);
    }
    
}