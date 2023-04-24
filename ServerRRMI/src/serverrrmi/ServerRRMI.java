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
import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.management.remote.rmi.RMIServer;
import javax.swing.JOptionPane;


public class ServerRRMI extends UnicastRemoteObject implements RMIDAO {
    String [][] seccionH;
    String [][] carroCompras;
    public ServerRRMI() throws RemoteException{
        super();
        seccionH = new String[][]{
            {"01","Camiseta conjunto primavera","57.000",""},
            {"02","Short conjunto primavera","79.000",""},
            {"03","Hoodie conjunto primavera","120.000",""},
            {"04","Zapatos conjunto primavera","315.000",""}
        };
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
    public String Compras(int id, int num)throws RemoteException{
        carroCompras = new String[][]{
            {"a","b"}
        };
        
        return String.valueOf(seccionH[num][1]);
    }
    @Override
    public String VerCarrito()throws RemoteException{
        
        return "";
    }
    @Override
    public String VaciarCarrito ( ) throws RemoteException{
        return "";
    }
    
}
