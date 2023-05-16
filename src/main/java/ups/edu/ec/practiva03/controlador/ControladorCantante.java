/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.controlador;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.practiva03.dao.CantanteDAO;
import ups.edu.ec.practiva03.modelo.Cantante;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.idao.ICantanteDAO;

/**
 *
 * @author estem
 */
public class ControladorCantante {
    //objeto modelo
    private Cantante cantante;
    //objeto vist
    private VistaCantante vistaCantante;
    //obejto dinamico cantante
    private ICantanteDAO cantanteDAO;
    
    //contructores
    public ControladorCantante() {
    }

    public ControladorCantante(ICantanteDAO cantanteDAO, VistaCantante vistaCantante) {
        this.cantanteDAO = cantanteDAO;
        this.vistaCantante = vistaCantante;
    }
    
    //metodos de la clase utilzacion de los objetos
    public void registrar(){
        cantante = vistaCantante.ingresarCantante();
        cantanteDAO.create(cantante);
    }
    
    public void verCantante(){
        int id = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(id);
    }
    
    public void actualizarCantante(){
        cantante = vistaCantante.actualizarCantante();
        cantanteDAO.update(cantante);
    }
    
    public void eliminar(){
        cantante = vistaCantante.eliminarCantante();
        cantanteDAO.delete(cantante);
    }
    
    public void verCantantes(){
        List<Cantante> cantantes = new ArrayList();
        cantantes = cantanteDAO.findAll();
        vistaCantante.verCantantes(cantantes);
    }
    
    //metodo para buscar cantante por nombre del disco
    public void buscarCantantePorDisco(){
        cantanteDAO.buscarPorNombreDeDisco(vistaCantante.buscarPorNombreDeDisco());
        
    }
}
