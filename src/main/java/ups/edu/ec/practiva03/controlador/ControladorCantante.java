/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.controlador;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.practiva03.modelo.Cantante;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.idao.ICantanteDAO;
import ups.edu.ec.practiva03.modelo.Disco;
import ups.edu.ec.practiva03.vista.VistaDisco;

/**
 *
 * @author estem
 */
public class ControladorCantante {
    //objeto modelo
    private Cantante cantante;
    //objeto vist
    private VistaCantante vistaCantante;
    private VistaDisco vistaDisco;
    //obejto dinamico cantante
    private ICantanteDAO cantanteDAO;
    
    //constructores
    public ControladorCantante() {
    }

    public ControladorCantante(ICantanteDAO cantanteDAO, VistaCantante vistaCantante, VistaDisco vistaDisco) {
        this.cantanteDAO = cantanteDAO;
        this.vistaCantante = vistaCantante;
        this.vistaDisco = vistaDisco;
    }
    
    //metodos de la clase utilzacion de los objetos
    public void registrar(){
        cantante = vistaCantante.ingresarCantante();
        cantante.calularSalario();
        cantanteDAO.create(cantante);
    }
    
    public void verCantante(){
        int id = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(id);
        vistaCantante.verCantante(cantante);
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
        List<Cantante> cantantes;
        cantantes = cantanteDAO.findAll();
        vistaCantante.verCantantes(cantantes);
    }
    
    //metodos de la composcion
    public void ingresarDisco(){
        Disco disco = vistaDisco.ingresarDisco();
        int codigo = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(codigo);
        cantante.agregarDisco(disco);
        cantanteDAO.update(cantante);
    }
    
    public void verDisco(){
        int codigoDisco = vistaDisco.buscarDisco();
        int codigo = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(codigo);
        Disco disco = cantante.buscarDisco(codigoDisco);
        vistaDisco.verDisco(disco);
    }
    
    public void actualizarDisco(){
        int codigo = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(codigo);
        Disco disco = vistaDisco.actualizarDisco();
        cantante.actualizarDisco(disco);
        cantanteDAO.update(cantante);
    }
    
    public void eliminarDisco(){
        Disco disco = vistaDisco.eliminarDisco();
        int codigo = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(codigo);
        cantante.eliminarDisco(disco);
        cantanteDAO.update(cantante);
    }
    
    public void verDiscos(){
        List <Disco> discografia;
        int codigo = vistaCantante.buscarCantante();
        cantante = cantanteDAO.read(codigo);
        discografia =cantante.listarDiscografia();
        vistaDisco.verDiscografia(discografia);
    }
    
    //metodo para buscar cantante por nombre del disco
    public void buscarCantantePorDisco(){
        String nombre = vistaCantante.buscarPorNombreDeDisco();
        cantante = cantanteDAO.buscarPorNombreDeDisco(nombre);
        vistaCantante.verCantante(cantante);
    }
}
