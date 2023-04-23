/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverrrmi;

/**
 *
 * @author maria
 */
import Interface.RMIDAO; //libreria propia

//librerias que se importan
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.management.remote.rmi.RMIServer;


public class ServerRRMI extends UnicastRemoteObject implements RMIDAO {

    public ServerRRMI() throws RemoteException{
            super();
        }
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServerRRMI());
            System.out.println("Servidor esta activo");
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String Compras()throws RemoteException{
        return "";
    }
    @Override
    public String VerCarrito(int [] cantidad,String [][] info, int x)throws RemoteException{
        return "";
    }
    @Override
    public String VaciarCarrito ( String [][] info,int [] cantidad, int x) throws RemoteException{
        return "";
    }
    
}
