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
    
    public String Compras( int num, String talla, String color)throws RemoteException;
    
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
   
}
