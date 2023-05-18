/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.controlador;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.practiva03.dao.CompositorDAO;
import ups.edu.ec.practiva03.idao.ICompositorDAO;
import ups.edu.ec.practiva03.modelo.Cantante;
import ups.edu.ec.practiva03.modelo.Compositor;
import ups.edu.ec.practiva03.vista.VistaCantante;
import ups.edu.ec.practiva03.vista.VistaCompositor;
import ups.edu.ec.practiva03.idao.ICantanteDAO;
import ups.edu.ec.practiva03.modelo.Cancion;
import ups.edu.ec.practiva03.vista.VistaCancion;

/**
 *
 * @author estem
 */
public class ControladorCompositor {

    private VistaCantante vistaCantante;
    private VistaCompositor vistaCompositor;
    private VistaCancion vistaCancion;

    private Cantante cantante;
    private Compositor compositor;

    private ICantanteDAO cantanteDAO;
    private ICompositorDAO compositorDAO;

    public ControladorCompositor(VistaCantante vistaCantante, VistaCompositor vistaCompositor, VistaCancion vistaCancion, ICantanteDAO cantanteDAO, ICompositorDAO compositorDAO) {
        this.vistaCantante = vistaCantante;
        this.vistaCompositor = vistaCompositor;
        this.vistaCancion = vistaCancion;

        this.cantanteDAO = cantanteDAO;
        this.compositorDAO = compositorDAO;
    }

    public void registrar() {
        compositor = vistaCompositor.inresarCompositor();
        compositor.calularSalario();
        compositorDAO.create(compositor);
    }

    public void verCompositor() {
        int id = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(id);
        vistaCompositor.verCompositor(compositor);
    }

    public void actualizarCompositor() {
        compositor = vistaCompositor.actualizaCompositor();
        compositorDAO.update(compositor);
    }

    public void eliminar() {
        compositor = vistaCompositor.eliminarCompositor();
        compositorDAO.delete(compositor);
    }

    public void verCompositores() {
        List<Compositor> compositores = new ArrayList();
        compositores = compositorDAO.findAll();
        vistaCompositor.verCompositores(compositores);
    }

    public void agreagarCliente() {
        int id = vistaCantante.buscarCantante();
        int condigo = vistaCompositor.buscarCompositor();
        cantante = cantanteDAO.read(id);
        compositor = compositorDAO.read(condigo);
        compositor.agregarCliente(cantante);
        compositorDAO.update(compositor);
    }

    //metodos de la cancion
    public void ingresarCancion() {
        Cancion cancion = vistaCancion.ingresarCancion();
        int codigo = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(codigo);
        compositor.agregarCancion(cancion);
        compositorDAO.update(compositor);
    }

    public void verCancion() {
        int codigoCancion = vistaCancion.buscarCancion();
        int codigo = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(codigo);
        Cancion c = compositor.buscarCancion(codigoCancion);
        vistaCancion.verCancion(c);
    }

    public void actualizarCancion() {
        int codigo = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(codigo);
        Cancion c = vistaCancion.actualizarCancion();
        compositor.actualizarCancion(c);
        compositorDAO.update(compositor);
    }

    public void eliminarCancion() {
        Cancion disco = vistaCancion.eliminarDisco();
        int codigo = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(codigo);
        compositor.eliminarCacion(disco);
        compositorDAO.update(compositor);
    }

    public void verCanciones() {
        List<Cancion> listaCancion;
        int codigo = vistaCompositor.buscarCompositor();
        compositor = compositorDAO.read(codigo);
        listaCancion = compositor.listarCancionesTop100Billaboar();
        vistaCancion.verCanciones(listaCancion);
    }

    //busqueda del compositor por nombre de cancion
    public void buscarCompositorPorTituloDeCancion() {
        String titulo = vistaCompositor.buscarPorTituloDeCancion();
        compositor = compositorDAO.buscarPorTituloDeCancion(titulo);
        vistaCompositor.verCompositor(compositor);
    }
}
