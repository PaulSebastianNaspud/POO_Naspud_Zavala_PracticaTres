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
            System.out.println("\n Menu \n1. Opciones Cantante \n2. Opciones del compositor /");
            opcion = entrada.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("\nMenu del Cantante \n1 Registrar Cantante \n2. Ver Cantante \n3. Actualizar Cantante \n4. Eliminar Cantante \n5. Ver lista Cantantes \n6. Volver al menu Principal");
                    opcion = entrada.nextInt();
                    do{
                        switch(opcion){
                            case 1:
                                controladorCantante.registrar();
                                break;
                            case 2:
                                controladorCantante.verCantante();
                            case 3:
                                controladorCantante.actualizarCantante();
                            case 4:
                                controladorCantante.eliminar();
                            case 5:
                                controladorCantante.verCantantes();
                            case 6:
                                System.out.println("Volvio");
                        }
                        
                    }while(opcion !=6);
                case 2:
                    System.out.println("\nMenu del Compositor \n1 Registrar Compositor \n2. Ver Compositor \n3. Actualizar Compositor \n4. Eliminar Compositor \n5. Ver lista Compositores \n.6 Volver al menu Principal");
                    opcion = entrada.nextInt();
                    do{
                        switch(opcion){
                            case 1:
                                controladorCompositor.registrar();
                                break;
                            case 2:
                                controladorCompositor.verCompositor();
                            case 3:
                                controladorCompositor.actualizarCompositor();
                            case 4:
                                controladorCompositor.eliminar();
                            case 5:
                                controladorCompositor.verCompositores();
                            case 6:
                                System.out.println("Volvio");
                        }
                        
                    }while(opcion !=6);
            }
           
        }while(opcion !=10);
    }
}
