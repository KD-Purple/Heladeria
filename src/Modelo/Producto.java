/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ronni
 */
public class Producto implements Comparable<Producto> {

    private int id;
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(int id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        String dato = " ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + 
                "\nID: " + id
                + "\nNombre: " + nombre   
                + "\nPrecio: " + precio + " pesos";  
                return dato;
                }

    @Override
    public int compareTo(Producto t) {
       if(id == t.getID()){
          return 0;
       } else {
           if(id > t.getID()){
               return 1;
           } else {
               return -1;
           }
       }
        
    }
    
    
}

