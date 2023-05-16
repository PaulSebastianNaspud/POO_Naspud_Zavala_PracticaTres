/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.controlador;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.practiva03.idao.ICompositorDAO;
import ups.edu.ec.practiva03.modelo.Cantante;
import ups.edu.ec.practiva03.modelo.Compositor;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.vista.VistaCompositor;
import ups.edu.ec.practiva03.idao.ICantanteDAO;

/**
 *
 * @author estem
 */
public class ControladorCompositor {
    
    private VistaCantante vistaCantante;
    private VistaCompositor vistaCompositor;
    
    private Cantante cantante;
    private Compositor compositor;
    
    private ICantanteDAO cantanteDAO;
    private ICompositorDAO compositorDAO;

    public ControladorCompositor(VistaCantante vistaCantante, VistaCompositor vistaCompositor, ICantanteDAO cantanteDAO, ICompositorDAO compositorDAO) {
        this.vistaCantante = vistaCantante;
        this.vistaCompositor = vistaCompositor;
        
        this.cantanteDAO = cantanteDAO;
        this.compositorDAO = compositorDAO;
    }
    
    
    public void reigistrar(){
        compositor = vistaCompositor.inresarCompositor();
        compositorDAO.create(compositor);
    }
    
    public void verCompositor(){
        int id = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(id);
        vistaCompositor.verCompositor(compositor);
    }
    
    public void actualizar(){
        compositor = vistaCompositor.actualizaCompositor();
        compositorDAO.update(compositor);
    }
    
    public void eliminar(){
        compositor = vistaCompositor.eliminarCompositor();
        compositorDAO.delete(compositor);
    }
    
    public void verCompositores(){
        List<Compositor> compositores = new ArrayList();
        compositores = compositorDAO.findAll();
        vistaCompositor.verCompositores(compositores);
    }
    
    public void agreagarCantante(){
        int id = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(id);
        int condigo = vistaCompositor.buscarCompositor();
        if(compositor != null && cantante != null){
            compositor.agregarCantante(cantante);
            compositorDAO.update(compositor);
        }
    }
}
