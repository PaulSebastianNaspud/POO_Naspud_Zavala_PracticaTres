/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.vista;

import java.util.List;
import java.util.Scanner;
import ups.edu.ec.practiva03.modelo.Cantante;

/**
 *
 * @author estem
 */
public class VistaCantante {
    
    //llamar al metodo scanner para ingresar datos por teclado
    Scanner entrada = new Scanner(System.in);
    
    //metodo para ingresar los datos del cantante junto a una discografia
    public Cantante ingresarCantante(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del cantante: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar el nombre del cantante: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresar el apelldo del cantante: ");
        String apellido = entrada.nextLine();
        System.out.println("Ingresar la edad del cantante: ");
        int edad = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar la nacionalidad del cantante: ");
        String nacionalidad = entrada.nextLine();
        System.out.println("Ingresar el salario del cantante: ");
        double salario = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingresar el nombre artistico del cantante: ");
        String nombreArtistico = entrada.nextLine();
        System.out.println("Ingresar el genero musical del cantante: ");
        String generoMusical = entrada.nextLine();
        System.out.println("Ingresar el numero de sensillos: ");
        int nSensillos = Integer.parseInt(entrada.nextLine());
        System.out.println("Ingresar el numero de conciertos del cantante: ");
        int nConciertos = Integer.parseInt(entrada.nextLine());
        System.out.println("Ingresar el numero de giras del cantante: ");
        int nGiras = entrada.nextInt();
        //instaciar un objeto persona atraves del polimorfismo
        Cantante cantante = new Cantante(nombreArtistico, generoMusical, nSensillos, nConciertos, nGiras, codigo, nombre, apellido, edad, salario, nacionalidad);
        System.out.println("Ingrese el numero de discos del cantante: ");
        int cantidad = entrada.nextInt();//numero de discos del cantante
        for (int i = 0; i < cantidad; i++) { //for para ingreasr los datos por teclado del disco
            System.out.println("Ingresar el codigo del disco: ");
            int codigo2 = entrada.nextInt();
            System.out.println("Ingresar el año de lanzamiento:");
            int anioDeLanzamiento = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingresar el nombre del disco: ");
            String nomreCancion = entrada.nextLine();
            //utilizar el metdodo agregarDisco para aañadir discos a la lista del objeto
            cantante.agregarDisco(codigo2, nomreCancion, anioDeLanzamiento);
        }
        cantante.calularSalario();//llamar al metodo calcularSalario para calcular el salrio final y utiliazcion de los metodos sobrescritos abstract
        return cantante;
    }
    
    //metodo para actualizar datos del cantante por teclado
    public Cantante actualizarCantante(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del cantante a actualizar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar el nombre del cantante: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresar el apelldo del cantante: ");
        String apellido = entrada.nextLine();
        System.out.println("Ingresar la edad del cantante: ");
        int edad = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar la nacionalidad del cantante: ");
        String nacionalidad = entrada.nextLine();
        System.out.println("Ingresar el salario del cantante: ");
        double salario = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingresar el nombre artistico del cantante: ");
        String nombreArtistico = entrada.nextLine();
        System.out.println("Ingresar el genero musical del cantante: ");
        String generoMusical = entrada.nextLine();
        System.out.println("Ingresar el numero de sensillos: ");
        int nSensillos = Integer.parseInt(entrada.nextLine());
        System.out.println("Ingresar el numero de conciertos del cantante: ");
        System.out.println("Ingresar el numero de giras del cantante: ");
        int nGiras = entrada.nextInt();
        int nConciertos = Integer.parseInt(entrada.nextLine());
        return new Cantante(nombreArtistico, generoMusical, nSensillos, nConciertos, nGiras, codigo, nombre, apellido, edad, salario, nacionalidad);
    }
    
    //metodo para elimiar cantante atraves del id, utiliza un constructor solo con el parametro codigo no le elimina
    public Cantante eliminarCantante(){
        entrada.nextLine();
        System.out.println("Ingresa el codigo del cantante a eliminar");
        int codigo = entrada.nextInt();
        return new Cantante(codigo);
    }
    
    //buscar cantante, ingresa dato del codigo del cantante
    public int buscarCantante() {
        System.out.println("Ingresa el codigo del cantante a buscar");
        int id = entrada.nextInt();
        return id;
    }
    
    //recibe un cantante e imprime los datos
    public void verCantante(Cantante cantante) {
        System.out.println("Datos del cantante: " + cantante);
    }
    
    //ver la lista de cantantes
    public void verCantantes(List<Cantante> cantantes) {
        for (Cantante c : cantantes) {
            System.out.println("Datos cantante: " + c);
        }
    }
    
    //buscar cantante por disco, String nombre
    public String buscarPorNombreDeDisco(){
        System.out.println("Ingresar el nombre del disco del cantante: ");
        String nombre = entrada.nextLine();
        return nombre;
    }
}
