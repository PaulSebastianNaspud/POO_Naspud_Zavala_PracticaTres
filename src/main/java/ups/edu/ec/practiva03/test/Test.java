/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ups.edu.ec.practiva03.test;

import java.util.Scanner;
import ups.edu.ec.practiva03.controlador.ControladorCantante;
import ups.edu.ec.practiva03.controlador.ControladorCompositor;
import ups.edu.ec.practiva03.dao.CantanteDAO;
import ups.edu.ec.practiva03.dao.CompositorDAO;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.vista.VistaCompositor;

/**
 *
 * @author estem
 */
public class Test {

    public static void main(String[] args) {
        //vista 
        VistaCompositor vistaCompositor = new VistaCompositor();
        VistaCantante vistaCantante = new VistaCantante();
        //dao
        CompositorDAO compositorDAO = new CompositorDAO();
        CantanteDAO cantanteDAO = new CantanteDAO();
        //controlador
        ControladorCompositor controladorCompositor = new ControladorCompositor(vistaCantante, vistaCompositor, cantanteDAO, compositorDAO);
        ControladorCantante controladorCantante = new ControladorCantante(cantanteDAO, vistaCantante);
        
        //scanner para navegar por el menu
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0;
        do{
            System.out.println("\n Menu \n1. Ingreso de Cantante \n2. Ingreson de Compositor \n3. Agregar Clientes \n4. Imprimir"
                    + " \n5. Busqueda de cantante por el nombre del disco \n6. Busqueda de compositor por nombre de cancion \n7. Salir");
            opcion = entrada.nextInt();
            switch(opcion) {
                case 1:
                    controladorCantante.registrar();
                    break;
                case 2:
                    controladorCompositor.reigistrar();
                    break;
                    
                case 3:
                    controladorCompositor.agreagarCliente();
                    break;
                case 4:
                    controladorCantante.verCantantes();
                    controladorCompositor.verCompositores();
                    break;
                case 5:
                    controladorCantante.buscarCantantePorDisco();
                    break;
                case 6:
                    controladorCompositor.buscarCompositorPorTituloDeCancion();
                    break;
                case 7:
                    System.out.println("Salio del programa :)");
                    break;
            }
           
        }while(opcion !=7);
    }
}
