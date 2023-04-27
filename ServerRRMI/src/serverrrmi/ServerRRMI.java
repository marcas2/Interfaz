/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverrrmi;

/**
 *
 * @author maria
 * @class ServerRMMI
 * Clase servidor
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
    
    /**
     * Declaración de variables
     */
    
    String [][] carroCompras;
    String usuariVerdad;
    String contraVerdad;
    
    /**
     * Constructor
     * @throws RemoteException 
     */
    
    public ServerRRMI() throws RemoteException{
        super();
         usuariVerdad="elfuerte";
         contraVerdad="123";
        /**
         * Array carrito de compras
         */
        carroCompras = new String[][]{
            {"01","Camiseta conjunto primavera","57000","0","0","", ""},
            {"02","Short conjunto primavera","79000","0","0","", ""},
            {"03","Hoodie conjunto primavera","120000","0","0","", ""},
            {"04","Zapatos conjunto primavera","315000","0","0","", ""},
            {"05","Abrigo a cuadros","200000","0","0","", ""},
            {"06","Camisa sencilla","58000","0","0","", ""},
            {"07","Pantalon holgado","96000","0","0","", ""},
            {"8","Zapatos deportivos","193000","0","0","", ""},
            {"9","Bolso elegante mujer","389000","0","0","", ""},
            {"10","Bolso brillante muejr","256000","0","0","", ""},
            {"11","Bolso casual hombre","142000","0","0","", ""},
            {"12","Bolso formal hombre","315000","0","0","", ""},
            
        };
    }
    
    /**
     * Main
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
    /**
     * Metodo compras 
     * @param num
     * @return
     * @throws RemoteException 
     */
    
    @Override
    public String Compras(int num, String talla, String color)throws RemoteException{
        int nuevaCompra=Integer.parseInt(carroCompras[num][3])+1;
        int vrCompra=Integer.parseInt(carroCompras[num][2])*nuevaCompra;
        carroCompras[num][3]=String.valueOf(nuevaCompra);
        carroCompras[num][4]=String.valueOf(vrCompra);
        carroCompras[num][5]=carroCompras[num][5]+talla+",";
        carroCompras[num][6]=carroCompras[num][6]+color+",";
       // return "Se ha añadido este producto a tu compra => " + carroCompras[num][1];
       return "Se ha añadido "+carroCompras[num][3] +" "+ carroCompras[num][1];
    }
    
    /**
     * Metodo para ver carrito
     * @return
     * @throws RemoteException 
     */
    
    @Override
    public String VerCarrito()throws RemoteException{
        String MuestraCarro = "";
        for (int i = 0; i < carroCompras.length; i++) {
            if( Integer.parseInt(carroCompras[i][3])>0 ){
                MuestraCarro = MuestraCarro + "Producto => "  + carroCompras[i][1] + " Cant=>" + carroCompras[i][3] + " Valor=> " + carroCompras[i][4]+ " Talla=> "+carroCompras[i][5] +" Color=> "+carroCompras[i][6] + " \n";
            }
        }
        return MuestraCarro;
    }
    
    /**
     * Metodo vaciar carrito
     * @return
     * @throws RemoteException 
     */
    
    @Override
    public String VaciarCarrito ( ) throws RemoteException{
        for (int i = 0; i < carroCompras.length; i++) {
            carroCompras[i][3]="0";
            carroCompras[i][4]="0";
        }
       return "El carrito está vacío";  
    }
    
    /**
     * Metodo verificar usuario
     * @param usuario
     * @param contraseña
     * @return estado
     * @throws RemoteException 
     */
    
    @Override 
     public boolean VerificarUsuarios (String usuario, String contraseña) throws RemoteException{
         boolean estado=false;
            if((usuario.equals(usuariVerdad))&&(contraseña.equals(contraVerdad)))
                estado=true;
        return estado;
     }

    
}
