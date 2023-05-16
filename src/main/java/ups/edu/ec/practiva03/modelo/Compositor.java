/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.practiva03.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author estem
 */
public class Compositor extends Persona {

    //atributos de la clase 
    private int numeroDeComposiciones;
    
    //atributos de relaciones con las otras clases
    private List<Cancion> cancionesTop100Billaboar;
    private List<Cantante> clientes;
    
    //contructores nescesarios
    public Compositor() {
        this.clientes = new ArrayList();
        this.cancionesTop100Billaboar = new ArrayList();
    }

    public Compositor(int codigo) {
        super(codigo);
        this.clientes = new ArrayList();
        this.cancionesTop100Billaboar = new ArrayList();
    }

    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        super(codigo, nombre, apellido, edad, salario, nacionalidad);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.clientes = new ArrayList();
        this.cancionesTop100Billaboar = new ArrayList();
    }
    
    //get and set del atributo
    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }
    
    //top100Billaboar
    public void agregarCancion(int codigo,String titulo,String letra,double tiempoEnMinutos){
        Cancion cancion = new Cancion(codigo, titulo, letra, codigo);
        cancionesTop100Billaboar.add(cancion);   
    }

    public void actualizarCancion(Cancion cancion) {
        if (cancionesTop100Billaboar.contains(cancion)) {
            int index = cancionesTop100Billaboar.indexOf(cancion);
            cancionesTop100Billaboar.set(index, cancion);
        }
    }

    public void eliminarCacion(Cancion cancion) {
        if (cancionesTop100Billaboar.contains(cancion)) {
            int index = cancionesTop100Billaboar.indexOf(cancion);
            cancionesTop100Billaboar.remove(index);
        }
    }

    public List<Cancion> listarCancionesTop100Billaboar() {
        return cancionesTop100Billaboar;
    }

    public Cancion buscarCancionesTop100Billaboar(int codigo) {
        for(Cancion cancion: cancionesTop100Billaboar){
            if(cancion.getCodigo() == codigo){
                return cancion;
            } 
        }
        return null;
    }
    
    //clientes
    public void agregarCliente(Cantante cliente){
        clientes.add(cliente);
    }

    public void actualizarCliente(Cantante cliente) {
        if (clientes.contains(cliente)) {
            int index = clientes.indexOf(cliente);
            clientes.set(index, cliente);
        }
    }

    public void eliminarCliente(Cantante cliente) {
        if (clientes.contains(cliente)) {
            int index = clientes.indexOf(cliente);
            clientes.remove(index);
        }
    }

    public List<Cantante> listarClente() {
        return clientes;
    }

    public Cantante buscarCliente(int codigo) {
        for(Cantante cantante : clientes){
            if(cantante.getCodigo()== codigo){
                return cantante;
            }
        }
        return null;
    }
    
    //metodo abstract de la herencia
    @Override
    public double calularSalario() {
        if (numeroDeComposiciones > 5) {
            return (super.getSalario() + 300);
        } else if (cancionesTop100Billaboar.size() >= 1 || cancionesTop100Billaboar.size() <= 3) {
            return (super.getSalario()*1.1);
        } else if (cancionesTop100Billaboar.size() >=4 || cancionesTop100Billaboar.size()<=6){
            return (super.getSalario()*1.2);
        } else if (cancionesTop100Billaboar.size() > 6){
            return (super.getSalario());
        }
        return super.getSalario();
    }
    
    //metodos de la clase
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + super.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compositor other = (Compositor) obj;
        return super.hashCode() == other.getCodigo();
    }
    
    @Override
    public String toString() {
        return "Compositor{" + super.toString() + "numeroDeComposiciones=" + numeroDeComposiciones + '}'+ "\n cancionesTop100Billaboar=" + cancionesTop100Billaboar + "\n clientes=" + clientes ;
    }

}