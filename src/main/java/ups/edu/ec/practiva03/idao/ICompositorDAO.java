/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ups.edu.ec.practiva03.idao;

import java.util.List;
import ups.edu.ec.practiva03.modelo.Compositor;

/**
 *
 * @author estem
 */
public interface ICompositorDAO {
    //Creacion de una constante para el maximo elementos de la lista
    public final int MAX_OBJECTCS = 10;
    
    //metodos CRUDE
    //metodo abastrac create que recibe un parametro del tipo Compositor 
    public abstract void create(Compositor obj);//C
    //metodo abastrac read que recibe un parametro del tipo int y devuelve una Compositor 
    public abstract Compositor read(int codigo);//R
    //metodo abstract update que recibe un parametro del tipo Compositor 
    public abstract void update(Compositor obj);//U
    //metodo abastract deleta que recibe un parametro del tipo Compositor 
    public abstract void delete(Compositor obj);//D
    
    //metodo de return de la lista de personas final
    public List<Compositor> findAll();
    
    //metodo para buscar cancion por el titulo
    public abstract Compositor buscarPorTituloDeCancion(String valor);
}
