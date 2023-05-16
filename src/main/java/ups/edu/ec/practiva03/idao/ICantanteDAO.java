/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ups.edu.ec.practiva03.idao;

import java.util.List;
import ups.edu.ec.practiva03.modelo.Cantante;

/**
 *
 * @author estem
 */
public interface ICantanteDAO {
    //Creacion de una constante, la cual no se ha usado por que se han guardado los objetos en ArrayList
    public final int MAX_OBJECTCS = 10;
    
    //metodo abastrac create que recibe un parametro del tipo Persona 
    public abstract void create(Cantante obj);//C
    //metodo abastrac read que recibe un parametro del tipo Persona y devuelve una persona 
    public abstract Cantante read(int codigo);//R
    //metodo abstract update que recibe un parametro del tipo Persona 
    public abstract void update(Cantante obj);//U
    //metodo abastract deleta que recibe un parametro del tipo Persona 
    public abstract void delete(Cantante obj);//D
    //metodo de return de la lista de personas final
    public List<Cantante> findAll();
}
