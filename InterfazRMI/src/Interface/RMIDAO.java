/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author maria
 */
public interface RMIDAO extends Remote {
    public String Compras(int id, int num)throws RemoteException;
    public String VerCarrito()throws RemoteException;
    public String VaciarCarrito () throws RemoteException;
}
