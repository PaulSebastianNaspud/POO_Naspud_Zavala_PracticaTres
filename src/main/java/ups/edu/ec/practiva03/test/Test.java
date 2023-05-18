/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ups.edu.ec.practiva03.test;

import java.util.Scanner;
import ups.edu.ec.practiva03.controlador.ControladorCantante;
import ups.edu.ec.practiva03.controlador.ControladorCompositor;
import ups.edu.ec.practiva03.dao.CantanteDAO;
import ups.edu.ec.practiva03.dao.CompositorDAO;
import ups.edu.ec.practiva03.vista.VistaCancion;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.vista.VistaCompositor;
import ups.edu.ec.practiva03.vista.VistaDisco;

/**
 *
 * @author estem
 */
public class Test {

    public static void main(String[] args) {
        //vista 
        VistaCompositor vistaCompositor = new VistaCompositor();
        VistaCantante vistaCantante = new VistaCantante();
        VistaCancion vistaCancion = new VistaCancion();
        VistaDisco vistaDisco = new VistaDisco();
        //dao
        CompositorDAO compositorDAO = new CompositorDAO();
        CantanteDAO cantanteDAO = new CantanteDAO();
        //controlador
        ControladorCompositor controladorCompositor = new ControladorCompositor(vistaCantante, vistaCompositor, vistaCancion, cantanteDAO, compositorDAO);
        ControladorCantante controladorCantante = new ControladorCantante(cantanteDAO, vistaCantante,vistaDisco);
        
        //scanner para navegar por el menu
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0;
        do{
            System.out.println("\n Menu \n1. Acceder al menu del Cantante \n2. Acceder al menu del Compositor \n3. Acceder al menu del Disco \n4. Acceder al menu de la Cancion \n5. Salir ");
            opcion = entrada.nextInt();
            switch(opcion) {
                case 1:
                    do{
                        System.out.println("\nMenu del Cantante \n1. Registrar Cantante \n2. Ver Cantante \n3. Actualizar Cantante "
                                + "\n4. Eliminar Cantante \n5. Ver lista Cantantes \n6. Volver al menu Principal");
                        opcion = entrada.nextInt();
                        switch(opcion){
                            case 1:
                                controladorCantante.registrar();
                                break;
                            case 2:
                                controladorCantante.verCantante();
                                break;
                            case 3:
                                controladorCantante.actualizarCantante();
                                break;
                            case 4:
                                controladorCantante.eliminar();
                                break;
                            case 5:
                                controladorCantante.verCantantes();
                                break;
                        }
                    }while(opcion !=6);
                    break;
                case 2:
                    do{
                        System.out.println("\nMenu del Compositor \n1 Registrar Compositor \n2. Ver Compositor \n3. Actualizar Compositor "
                            + "\n4. Eliminar Compositor \n5. Ver lista Compositores \n.6 Volver al menu Principal");
                    opcion = entrada.nextInt();
                        switch(opcion){
                            case 1:
                                controladorCompositor.registrar();
                                break;
                            case 2:
                                controladorCompositor.verCompositor();
                                break;
                            case 3:
                                controladorCompositor.actualizarCompositor();
                                break;
                            case 4:
                                controladorCompositor.eliminar();
                                break;
                            case 5:
                                controladorCompositor.verCompositores();
                                break;
                        }
                    }while(opcion !=6);
                    break;
                case 3:
                    do{
                        System.out.println("\n Menu del disco del Cantante \n1. Agregar un disco a un cantante \n2. Ver disco \n3. Actualizar disco "
                            + "\n4. Eliminar disco \n5. Ver discografia de un cantante \n6. Buscar un cantante por el nombre del disco \n7. Volver al menu Principal");
                    opcion = entrada.nextInt();
                        switch(opcion){
                                case 1:
                                controladorCantante.ingresarDisco();
                                break;
                            case 2:
                                controladorCantante.verDisco();
                                break;
                            case 3:
                                controladorCantante.actualizarDisco();
                                break;
                            case 4:
                                controladorCantante.eliminarDisco();
                                break;
                            case 5:
                                controladorCantante.verDiscos();
                                break;
                            case 6:
                                controladorCantante.buscarCantantePorDisco();
                                break;
                        }
                    }while(opcion !=7);
                    break;
                case 4:
                    do{
                        System.out.println("\n Menu de la cancion de un Compositor \n1. Agregar cancion a un compositor \n2. Ver cancion \n3. Actualizar cancion "
                            + "\n4. Eliminar cancion \n5. Ver cancionesTop100Billaboar de un compositor \n6. Buscar un compositor por e titulo de una cancion \n7. Volver al menu Principal");
                        opcion = entrada.nextInt();
                        switch(opcion){
                                case 1:
                                controladorCompositor.ingresarCancion();
                                break;
                            case 2:
                                controladorCompositor.verCancion();
                                break;
                            case 3:
                                controladorCompositor.actualizarCancion();
                                break;
                            case 4:
                                controladorCompositor.eliminarCancion();
                                break;
                            case 5:
                                controladorCompositor.verCanciones();
                                break;
                            case 6:
                                controladorCompositor.buscarCompositorPorTituloDeCancion();
                                break;
                        }
                    }while(opcion !=7);
                    break;
                case 5:
                    System.out.println("Salio del programa :)");
                    break;
            }
        }while(opcion !=5);
    }
}
