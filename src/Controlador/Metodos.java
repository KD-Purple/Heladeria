/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author ronni
 */
public class Metodos {

    public LinkedList<Producto> lista = new LinkedList<>();     

    public void Agregar(int id, String nombre, int precio) {
        Producto p = new Producto(id, nombre, precio);
        lista.add(p);
    }

    public boolean buscar(String num) {
        int n = Integer.parseInt(num);
        for (Producto p : lista) {
            if (p.getID() == n) {
                return true;
            }
        }
        return false;
    }

//    public String MostrarporID(String num) {
//
//        String informacion = "";
//        int n = Integer.parseInt(num);
//        for (Producto p : lista) {
//            if (p.getID() == n) {
//                informacion = p.toString();
//            }
//        }
//        return informacion;
//    }

    public String bajas(String matricula) {

        boolean bandera = false;
        int matri = Integer.parseInt(matricula);
        for (int x = 0; x < lista.size(); x++) {
            Producto p = lista.get(x);
            if (p.getID() == matri) {
                bandera = true;
                lista.remove(x);
            }
        }
        if (bandera == false) {
            JOptionPane.showMessageDialog(null, "No existe el ID");
        }
        return null;
    }

//    public String MostrarID(String num) {
//        String informacion = "";
//        int n = Integer.parseInt(num);
//        for (Producto p : lista) {
//            int pp = p.getID();
//            if (pp == n) {
//
//            }
//        }
//
//        return informacion;
//    }
    
    public boolean buscar2(String num){
        int n = Integer.parseInt(num);
        insercionDirecta();
         Producto p = busquedaBinariaID(n, 0, lista.size() - 1);
         if(p!=null){
             return true;
         }
         return false;
    }
    
    public Producto busquedaBinariaID(int id, int menor, int mayor) {
        if (menor > mayor) {
            return null;
        }
        int centro = (int) Math.floor((menor + mayor) / 2);
        Producto p = lista.get(centro);
        if (id == p.getID()) {
            return p;
        } else if (id < p.getID()) {
            mayor = (centro - 1);
            return busquedaBinariaID(id, menor, mayor);
        } else {
            menor = (centro + 1);
            return busquedaBinariaID(id, menor, mayor);
        }
    }
    
    public Producto busquedaBinariaNom(String nombre, int menor, int mayor) {
        if (menor > mayor) {
            return null;
        }
        int centro = (int) Math.floor((menor + mayor) / 2);
        Producto p = lista.get(centro);
        if (nombre.equalsIgnoreCase(p.getNombre())) {
            return p;
        } else if ((nombre.compareTo(p.getNombre()) < 0)) {
            mayor = (centro - 1);
            return busquedaBinariaNom(nombre, menor, mayor);
        } else {
            menor = (centro + 1);
            return busquedaBinariaNom(nombre, menor, mayor);
        }
    }
    
    
    public void insercionDirecta() {
        for(int i=1;i<lista.size();i++) {
            Producto aux = lista.get(i);
            int j=i-1;
            while(j>=0 && aux.getID()<lista.get(j).getID()) {
                lista.set(j+1,lista.get(j));
                j--;
        }
        lista.set(j+1, aux);        
        }
    }

    public int busquedaBin(LinkedList<Producto> lista, int clave) {
        int bajo = 0;
        int alto = lista.size() - 1;
        Producto valorCentral;
        while (bajo <= alto) {
            int central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista.get(central); // valor del índice central
            if (clave == valorCentral.getID()) {
                return central; // encontrado, devuelve posición
            } else if (clave < valorCentral.getID()) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
        }
        return -1; //elemento no encontrado
    }

    public int busquedaBin(LinkedList<Producto> lista, int clave, int bajo, int alto) {
        Producto valorCentral;
        if (bajo <= alto) {
            int central = (bajo + alto) / 2; // índice de elemento central
            valorCentral = lista.get(central); // valor del índice central
            if (clave == valorCentral.getID()) {
                return central; // encontrado, devuelve posición
            } else if (clave < valorCentral.getID()) {
                alto = central - 1; // ir a sublista inferior
            } else {
                bajo = central + 1; // ir a sublista superior
            }
            return busquedaBin(lista, clave, bajo, alto);
        }
        return -1; //elemento no encontrado
    }

}
