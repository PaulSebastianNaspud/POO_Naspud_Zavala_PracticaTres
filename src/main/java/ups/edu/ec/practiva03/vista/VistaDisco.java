/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.vista;

import java.util.List;
import java.util.Scanner;
import ups.edu.ec.practiva03.modelo.Disco;

/**
 *
 * @author ESTUDIANTE
 */
public class VistaDisco {
    Scanner entrada = new Scanner(System.in);
    public Disco ingresarDisco(){
       entrada.nextLine();//posible salto de nextInt
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del disco: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingresar el año del disco: ");
        int anioLanzamiento = entrada.nextInt();
        entrada.nextLine();//posible salto de nextInt
        System.out.println("Ingresar el nombre del disco: ");
        String nombre = entrada.nextLine();
        return new Disco(codigo, nombre, anioLanzamiento); 
    }
    public Disco actualizarDisco(){
        entrada.nextLine();//posible salto de nextInt
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del disco a actualizar: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingresar el año del disco: ");
        int anioLanzamiento = entrada.nextInt();
        entrada.nextLine();//posible salto de nextInt
        System.out.println("Ingresar el nombre del disco: ");
        String nombre = entrada.nextLine();
        return new Disco(codigo, nombre, anioLanzamiento);
    }
    
    public Disco eliminarDisco(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del disco a eliminar: ");
        int codigo = entrada.nextInt();
        return new Disco(codigo);
    }
    
    public int buscarDisco(){
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del disco a buscar");
        int codigo = entrada.nextInt();
        return codigo;
    }
    
    public void verDisco(Disco disco){
        System.out.println("Datos del disco: " + disco);
    }
    public void verDiscografia(List<Disco> listaDisco){
        System.out.println("***********LISTA DISCO***********");
        for(Disco disco: listaDisco){
            System.out.println(disco);
        }
    }
}
