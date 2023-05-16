/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ups.edu.ec.practiva03.modelo.Cantante;
import ups.edu.ec.practiva03.modelo.Disco;
import ups.edu.ec.practiva03.idao.ICantanteDAO;

public class CantanteDAO implements ICantanteDAO{
    static int cont = 0;
    private List<Cantante> listaCantante;

    public CantanteDAO() {
        this.listaCantante = new ArrayList();
    }

    public List<Cantante> getListaCantante() {
        return listaCantante;
    }

    public void setListaCantante(List<Cantante> listaCantante) {
        this.listaCantante = listaCantante;
    }
    
    //metodo para Disco
    public Cantante buscarPorNombreDeDisco(String valor) {  
        for (Cantante cantante : listaCantante) { //for each de la lista de las personas
                for (Disco disco : cantante.listarDiscografia()) { 
                    //comparar Strings hasta que se cumpla la condicion atraves del get
                    if (disco.getNombre().equals(valor)) { 
                        return cantante; //return de persona
                    }break;
            }
        }return null; // si no exite, return null
    } 
    
    //sobrescritura
    @Override
    public void create(Cantante obj) {
         if (cont < MAX_OBJECTCS) {
            listaCantante.add(obj);
            cont++;
        } else {
            System.out.println("Has llegado al limite");
        }
    }

    @Override
    public Cantante read(int codigo) {
        for(Cantante cantante:listaCantante){
            if(cantante.getCodigo() == codigo){
                return cantante;
            }
        }return null;
    }

    @Override
    public void update(Cantante obj) {
        for (int i = 0; i < listaCantante.size(); i++) {
            Cantante cantantito = listaCantante.get(i);
            if (cantantito.getCodigo()== obj.getCodigo()) {
                listaCantante.set(i, (Cantante) obj);
                break;
            }
        }
    }

    @Override
    public void delete(Cantante obj) {
        Iterator<Cantante> it = listaCantante.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            if (c.getCodigo() == obj.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Cantante> findAll() {
        return listaCantante ;
    }
    
}
