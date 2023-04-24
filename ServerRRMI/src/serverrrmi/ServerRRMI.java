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
    String [][] carroCompras;
    public ServerRRMI() throws RemoteException{
        super();
        carroCompras = new String[][]{
            {"01","Camiseta conjunto primavera","57000","0","0","Talla", "Color"},
            {"02","Short conjunto primavera","79000","0","0","Talla", "Color"},
            {"03","Hoodie conjunto primavera","120000","0","0","Talla", "Color"},
            {"04","Zapatos conjunto primavera","315000","0","0","Talla", "Color"},
            {"05","Abrigo a cuadros","200000","0","0","Talla", "Color"},
            {"06","Camisa sencilla","58000","0","0","Talla", "Color"},
            {"07","Pantalon holgado","96000","0","0","Talla", "Color"},
            {"8","Zapatos deportivos","193000","0","0","Talla", "Color"},
            {"9","Bolso elegante mujer","389000","0","0","Talla", "Color"},
            {"10","Bolso brillante muejr","256000","0","0","Talla", "Color"},
            {"11","Bolso casual hombre","142000","0","0","Talla", "Color"},
            {"12","Bolso formal hombre","315000","0","0","Talla", "Color"},
            
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
        int nuevaCompra=Integer.parseInt(carroCompras[num][3])+1;
        int vrCompra=Integer.parseInt(carroCompras[num][2])*nuevaCompra;
        carroCompras[num][3]=String.valueOf(nuevaCompra);
        carroCompras[num][4]=String.valueOf(vrCompra);
       // return "Se ha añadido este producto a tu compra => " + carroCompras[num][1];
       return "Se ha añadido "+carroCompras[num][3] +" "+ carroCompras[num][1];
    }
    @Override
    public String VerCarrito()throws RemoteException{
        String MuestraCarro = "";
        for (int i = 0; i < carroCompras.length; i++) {
            if( Integer.parseInt(carroCompras[i][3])>0 ){
                MuestraCarro = MuestraCarro + "Producto => "  + carroCompras[i][1] + " Cant=>" + carroCompras[i][3] + " Valor=> " + carroCompras[i][4] + " \n";
            }
        }
        return MuestraCarro;
    }
    @Override
    public String VaciarCarrito ( ) throws RemoteException{
        for (int i = 0; i < carroCompras.length; i++) {
            carroCompras[i][3]="0";
            carroCompras[i][4]="0";
        }
       return "El carrito está vacío";
       
    }
    
}
