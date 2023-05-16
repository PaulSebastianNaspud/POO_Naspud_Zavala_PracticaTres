/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ups.edu.ec.practiva03.idao.ICompositorDAO;
import ups.edu.ec.practiva03.modelo.Cancion;
import ups.edu.ec.practiva03.modelo.Compositor;
import ups.edu.ec.practiva03.modelo.Persona;

/**
 *
 * @author estem
 */
public class CompositorDAO implements ICompositorDAO{
    //contador estatico para el maximo de elementos de la clase
    static int cont;
    
    // atributo lista compositor
    List <Compositor> listaCompositor;
    
    //constructor
    public CompositorDAO() {
        this.listaCompositor = new ArrayList();
    }
    
    //metodo para buscar un compositor poe un titulo de la cancion
    public Compositor buscarPorTituloDeCancion(String valor) {
        for (Compositor compositor : listaCompositor) {  //for each de la lsita personas
            for (Cancion cancion : compositor.listarCancionesTop100Billaboar()) {
                //comparar Strings hasta que se cumpla la condicion atraves del get
                if (cancion.getTitulo().equals(valor)) {
                    return compositor; //retunr de persona
                }break;
            }
        }return null; // si no existe, return null
    }
    
    //metodos sobreescritos ICompositor
    @Override
    public void create(Compositor obj) {
        if (cont < MAX_OBJECTCS) {
            listaCompositor.add(obj);
            cont++;
        } else {
            System.out.println("Has llegado al limite");
        }
    }

    @Override
    public Compositor read(int codigo) {
        for(Compositor compositor:listaCompositor){
            if(compositor.getCodigo() == codigo){
                return compositor;
            }
        }return null;
    }

    @Override
    public void update(Compositor obj) {
        for (int i = 0; i < listaCompositor.size(); i++) {
            Compositor compositorsito = listaCompositor.get(i);
            if (compositorsito.getCodigo()== obj.getCodigo()) {
                listaCompositor.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void delete(Compositor obj) {
        Iterator<Compositor> it = listaCompositor.iterator();
        while (it.hasNext()) {
            Compositor c = it.next();
            if (c.getCodigo() == obj.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Compositor> findAll() {
        return listaCompositor;
    }
}
