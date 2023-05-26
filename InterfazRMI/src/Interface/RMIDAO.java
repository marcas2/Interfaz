/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Clase que implementa el DAO
 * @author maria
 */
public interface RMIDAO extends Remote {
    
    /**
     * Declaración metodo compras
     * @param id
     * @param num
     * @return
     * @throws RemoteException 
     */
    
    public String Compras(int id, int num, String talla, String color)throws RemoteException;
    
    /**
     * Declaración metodo VerCarrito
     * @return
     * @throws RemoteException 
     */
    
    public String VerCarrito()throws RemoteException;
    
    /**
     * Declaración metodo VaciarCarrito
     * @return
     * @throws RemoteException 
     */
    
    public String VaciarCarrito () throws RemoteException;
    
    /**
     * Declaración metodo VerificarUsuarios
     * @param usuario
     * @param contraseña
     * @return
     * @throws RemoteException 
     */
    public boolean VerificarUsuarios (String usuario, String contraseña) throws RemoteException;
   /**
    * devolver nombre
    * @return
    * @throws RemoteException 
    */
    public String devolverNombreUsuario ( ) throws RemoteException;
    public String devolverUsuario ( ) throws RemoteException;   
    public String devolverDirección ( ) throws RemoteException;
    
    /**
     * cambiarNombre
     * @param nomUs
     * @return
     * @throws RemoteException 
     */
 
    public String cambiarNombreUsuario (String nomUs ) throws RemoteException;
    
    /**
     * cambiarUsuario
     * @param usuariVerdad
     * @return
     * @throws RemoteException 
     */
    
    public String cambiarUsuario (String usuariVerdad) throws RemoteException;
    
    /**
     * 
     * @param direccionNuev
     * @return
     * @throws RemoteException 
     */
    
    public String cambiarDirección (String direccionNuev) throws RemoteException;
    public String cambiarContraseña (String contraPrueb,String contraNueva) throws RemoteException;
   
    public int historialCompras (int comp) throws RemoteException;
    public String comprobarCupon (String cup) throws RemoteException;
    public int añadirCompra (int compra) throws RemoteException;
    public int verCompra () throws RemoteException;

    

}
