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
import java.io.*;


//librerias que se importan
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;


public class ServerRRMI extends UnicastRemoteObject implements RMIDAO {
    
    /**
     * Declaración de variables
     */
    String nombreUsuario; 
    String celularUsuario;
    String direcciónUsuario;
    String [][] carroCompras;
    String [] cupones;
    String usuariVerdad;
    String contraVerdad;
    int compras;
    String Sugerencia;
    String mensaje;
 
    /**
     * Constructor
     * @throws RemoteException 
     */
    
    public ServerRRMI() throws RemoteException{
        super();
        usuariVerdad="Maria";
        contraVerdad="123";
        nombreUsuario="Karla Rodriguez";
        celularUsuario="322-390-7472";
        direcciónUsuario="Cra 20 #123 Casa2";
        compras=0;
        Sugerencia="";
        mensaje="No se aplica el cupon, invalido";
        /**
         * Array carrito de compras
         */
        carroCompras = new String[][]{
            {"01","Camiseta conjunto primavera","57000","0","0","",""},
            {"02","Short conjunto primavera","79000","0","0","",""},
            {"03","Hoodie conjunto primavera","120000","0","0","",""},
            {"04","Zapatos conjunto primavera","315000","0","0","",""},
            {"05","Abrigo a cuadros","200000","0","0","",""},
            {"06","Camisa sencilla","58000","0","0","",""},
            {"07","Pantalon holgado","96000","0","0","",""},
            {"8","Zapatos deportivos","193000","0","0","",""},
            {"9","Bolso elegante mujer","389000","0","0","",""},
            {"10","Bolso brillante muejr","256000","0","0","",""},
            {"11","Bolso casual hombre","142000","0","0","",""},
            {"12","Bolso formal hombre","315000","0","0","",""},
            
        };
        /**
         * Array cupones
         */
         cupones = new String[]{"DESCUENTO10", "BIENVENIDO20", "OFERTA25", "REGALO50"};
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
     * @param id
     * @param num
     * @return
     * @throws RemoteException 
     */
    
    @Override
    public String Compras(int id, int num, String talla, String color)throws RemoteException{
       
            int nuevaCompra=Integer.parseInt(carroCompras[num][3])+1;
            int vrCompra=Integer.parseInt(carroCompras[num][2])*nuevaCompra;
            carroCompras[num][3]=String.valueOf(nuevaCompra);
            carroCompras[num][4]=String.valueOf(vrCompra);
            carroCompras[num][5]=carroCompras[num][5]+""+talla;
            carroCompras[num][6]=carroCompras[num][6]+""+color;
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
        int descuento=1;
        int descuentoTotal=0;
        String MuestraCarro = "";
        for (int i = 0; i < carroCompras.length; i++) {
            if(mensaje.equals("Se ha aplicado un descuento del 15%")){
               descuento=15;
               descuentoTotal=Integer.parseInt(carroCompras[i][4])/descuento;
               int total=Integer.parseInt(carroCompras[i][4])-descuentoTotal;
               carroCompras[i][4]=String.valueOf(total) ;
            }
            if( Integer.parseInt(carroCompras[i][3])>0 ){
                MuestraCarro =  "\n"+MuestraCarro + "Producto => "  + carroCompras[i][1] + " Cant: " + carroCompras[i][3] + " Valor: " + carroCompras[i][4] +  " Talla: " + carroCompras[i][5] +" Color: " + carroCompras[i][6] +" \n";
            }
            //System.out.print(MuestraCarro);
            //ServerRRMI server= new ServerRRMI();
            //server.ArchivoBinarioCarrito();
            
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

 

    @Override
    public boolean VerificarUsuarios(String usuario, String contraseña) throws RemoteException {
        boolean estado=false;
        if((usuario.equals(usuariVerdad))&&(contraseña.equals(contraVerdad)))
            estado=true;
        return estado;
    }
    
     @Override 
    public void cambiarNombreUsuario (String nomUs ) throws RemoteException{
        nombreUsuario=nomUs;
 
    }
    @Override 
    public void cambiarUsuario (String usuariNuev) throws RemoteException{
        usuariVerdad=usuariNuev;

    }

    @Override 
    public void cambiarDirección (String direccionNuev) throws RemoteException{
      direcciónUsuario=  direccionNuev;

    } 
    @Override 
    public void cambiarContraseña (String contraPrueb,String contraNueva) throws RemoteException{
      if (contraPrueb.equals(contraVerdad)){
      contraVerdad=  contraNueva;
      }
    }
    @Override 
    public String devolverNombreUsuario ( ) throws RemoteException{
        return nombreUsuario;
    }
    @Override 
    public String devolverUsuario ( ) throws RemoteException{
      return usuariVerdad;
    }
    @Override 
    public String devolverDirección ( ) throws RemoteException{
      return direcciónUsuario;
    }
    
   
  
      
    
     @Override 
    public int historialCompras (int comp) throws RemoteException{
       compras=compras+comp;
      return compras;
    } 
    
    
    @Override 
    public String comprobarCupon (String cup) throws RemoteException{
       
        boolean respuesta=false;
        for(int i=0;i<cupones.length;i++){
          if(cup.equals(cupones[i])){
          respuesta=true;
          if(respuesta=true){
          mensaje="Se ha aplicado un descuento del 15%";
            }
           }
        } 
     return mensaje;
    }
     @Override
    public int añadirCompra (int compra) throws RemoteException{
       compras=compras+compra;   
     return compras;
    }

    @Override
    public int verCompra ( ) throws RemoteException{
        return compras;
    }
    /**
     * Metodos escribir archivo binario
     * @param carrito
     * @throws RemoteException 
     */
    @Override
    public void ArchivoBinarioCarrito( String usuario, String nombre, String direccion ) throws RemoteException{
    
        String rutaArchivo = "carrito.bin"; // ruta y nombre del archivo binario
        try {
            ServerRRMI server= new ServerRRMI(); 
           
            FileOutputStream archivo = new FileOutputStream(rutaArchivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(archivo);
            objectOut.writeObject(new CarritoBin(usuario, nombre, direccion));
            System.out.print("Se registró exitosamente");
            objectOut.close();
           
            //ServerRRMI server= new ServerRRMI();
            //server.LeerBinarioCarrito(carro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
   /**
    * metodo que lee el archivo binario creando 2 objetos nuevos
    * implementa un wile ifinito para leer la informacion con el metodo readObject
    */
    @Override
    public void LeerBinarioCarrito() throws RemoteException, ClassNotFoundException{
        CarritoBin carro1;
        String rutaArchivo = "carrito.bin"; 
        try {
            FileInputStream archivo = new FileInputStream(rutaArchivo);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            while(true){
               carro1=(CarritoBin)lectura.readObject();
               carro1.mostrarDatos();
            }  
        } catch (EOFException exception) {
            return;
        } catch (IOException error) {
            error.printStackTrace(System.out);
        } 
       
    }

  
    

}
