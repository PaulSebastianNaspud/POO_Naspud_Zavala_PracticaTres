/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.vista;

import java.util.List;
import java.util.Scanner;
import ups.edu.ec.practiva03.modelo.Compositor;

/**
 *
 * @author estem
 */
public class VistaCompositor {
    //Scanner para ingrasaer datos por teclado
    Scanner entrada = new Scanner(System.in);
    
    //ingresar los datos del cantante y una lista de canciones
    public Compositor inresarCompositor(){
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del compositor: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingresar el nombre del compositor: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresar el apelldo del compositor: ");
        String apellido = entrada.nextLine();//salto nextInt
        System.out.println("Ingresar la edad del compositor: ");
        int edad = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar la nacionalidad del compositor: ");
        String nacionalidad = entrada.nextLine();
        System.out.println("Ingresar el salario del compositor: ");
        double salario = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingresat el numero de composiciones del compositor; ");
        int nDeComposiciones = entrada.nextInt();
        Compositor compositor = new Compositor(nDeComposiciones, codigo, nombre, apellido, edad, salario, nacionalidad);
        System.out.println("Ingesar las cantidades de canciones del compositor: ");
        int cantidad = entrada.nextInt();
        entrada.nextLine();//salto nextInt
        for (int i = 0; i < cantidad; i++) {  //for para ingresar datos por teclado para llenar la lista de canciones
            System.out.println("Ingresar el codigo de la cancion: ");
            int codigo2 = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingresar el titulo de la cancion: ");
            String titulo = entrada.nextLine();
            System.out.println("Ingresar la la letra de la canciom: ");
            String letra = entrada.nextLine();
            System.out.println("Ingresar el tiempo de duracion de la cancion: ");
            double tiempoEnMinutos = Double.parseDouble(entrada.nextLine());
            //llamar el metodo agregarCancion de la clase Persona
            compositor.agregarCancion(codigo2, titulo, letra, tiempoEnMinutos);
        }
        compositor.calularSalario(); // llamar al metodo calcularSalario
        return compositor;
    }

    //actualizar datos del compositor atraves del codigo   
    public Compositor actualizaCompositor(){
        entrada.nextLine();//posible salto de nextInt
        //Ingresar datos por teclado con el Scanner
        System.out.println("Ingresar el codigo del compositor a actualizar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();//posible salto de nextInt
        System.out.println("Ingresar el nombre del compositor: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresar el apelldo del compositor: ");
        String apellido = entrada.nextLine();//salto nextInt
        System.out.println("Ingresar la edad del compositor: ");
        int edad = entrada.nextInt();
        entrada.nextLine();//salto de nextInt
        System.out.println("Ingresar la nacionalidad del compositor: ");
        String nacionalidad = entrada.nextLine();
        System.out.println("Ingresar el salario del compositor: ");
        double salario = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingresat el numero de composiciones del compositor; ");
        int nDeComposiciones = entrada.nextInt();
        return new Compositor(nDeComposiciones, codigo, nombre, apellido, edad, salario, nacionalidad);
    }
    
    //metodo para elimiar compositor atraves del id, utiliza un constructor deun  solo con el parametro codigo, no le elimina
    public Compositor eliminarCompositor(){
        entrada.nextLine();
        System.out.println("Ingresa el id del compositor a eliminar");
        int codigo = entrada.nextInt();
        return new Compositor(codigo);
    }
    
    //buscar compositor, ingresar dato del codigo del compositor
    public int buscarCompositor() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del compositor a buscar");
        int codigo = entrada.nextInt();
        return codigo;
    }
    
    //recibe un compositor e imprime los datos
    public void verCompositor(Compositor compositor) {
        System.out.println("Datos del compositor: " + compositor);
    }
    
    //ver la lista de compositor
    public void verCompositores(List<Compositor> compositores) {
        System.out.println("***********LISTA COMPOSITORES***********");
        for (Compositor c : compositores) {
            System.out.println(c);
        }
    }
    //buscar compositor por nombre de cancion
    public String buscarPorTituloDeCancion(){
        System.out.println("Ingresar el nombre de la cancion del compositor");
        String nombre = entrada.nextLine();
        return nombre;
    }
    
}
