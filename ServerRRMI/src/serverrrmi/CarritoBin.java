/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrrmi;

import Interface.RMIDAO;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class CarritoBin implements Serializable{

    String usuario;
    String nombre; 
    String direccion; 

    public CarritoBin(String usuario, String nombre, String direccion) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void mostrarDatos(){
       System.out.println("");
       System.out.println("Nombre     :"+ nombre);
       System.out.println("Usuario    :"+ usuario);
       System.out.println("Direccion  :"+ direccion);
    }



}
