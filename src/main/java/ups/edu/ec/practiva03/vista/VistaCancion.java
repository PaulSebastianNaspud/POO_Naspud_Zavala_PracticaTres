/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.vista;

import java.util.List;
import java.util.Scanner;
import ups.edu.ec.practiva03.modelo.Cancion;

/**
 *
 * @author ESTUDIANTE
 */
public class VistaCancion {
    Scanner entrada = new Scanner(System.in);
    
    public Cancion ingresarCancion(){
       entrada.nextLine();//posible salto de nextInt
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo de la cancion: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingresar la duracion de la cancion: ");
        double tiempoEnM = Double.parseDouble(entrada.nextLine());
        entrada.nextLine();//posible salto de nextInt
        System.out.println("Ingresar el titulo de la cancion: ");
        String titulo = entrada.nextLine();
        System.out.println("Ingresar el letra de la cancion: ");
        String letra = entrada.nextLine();
        return new Cancion(codigo, titulo, letra, tiempoEnM); 
    }
    
    public Cancion actualizarCancion(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo de la cancion a actualizar: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingresar la duracion de la cancion: ");
        double tiempoEnM = Double.parseDouble(entrada.nextLine());
        entrada.nextLine();//posible salto de nextInt
        System.out.println("Ingresar el titulo de la cancion: ");
        String tirulo = entrada.nextLine();
        System.out.println("Ingresar el letra de la cancion: ");
        String letra = entrada.nextLine();
        return new Cancion(codigo, tirulo, letra, tiempoEnM); 
    }
    
    public Cancion eliminarDisco(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo de la cancion a eliminar: ");
        int codigo = entrada.nextInt();
        return new Cancion(codigo);
    }
    public int buscarCancion(){
        System.out.println("Ingresa el codigo de la cancion a buscar");
        int codigo = entrada.nextInt();
        return codigo;
    }
    
    public void verCancion(Cancion cancion){
        System.out.println("Datos de la cancion: " + cancion);
    }
    public void verCanciones (List<Cancion> listaCancion){
        System.out.println("***********LISTA CANCION***********");
        for(Cancion c: listaCancion){
            System.out.println(c);
        }
    }
}
