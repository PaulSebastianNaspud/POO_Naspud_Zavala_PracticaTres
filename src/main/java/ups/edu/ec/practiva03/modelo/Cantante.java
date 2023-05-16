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
public class Cantante extends Persona {
    //atributos private de la clase y encapsulamiento

    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSensillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    //atributo private de relacion con la clase Disco y encapsulamiento
    private List<Disco> discografia;

    public Cantante() {
        this.discografia = new ArrayList();
    }

    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSensillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        super(codigo, nombre, apellido, edad, salario, nacionalidad);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSensillos = numeroDeSensillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList();
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSensillos() {
        return numeroDeSensillos;
    }

    public void setNumeroDeSensillos(int numeroDeSensillos) {
        this.numeroDeSensillos = numeroDeSensillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }

    //disco
    
    public void agregarDisco(int codigo, String nombre, int anioDeLanzamiento) {
        Disco disco = new Disco(codigo, nombre, anioDeLanzamiento);
        discografia.add(disco);
    }

    public void actualizarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.set(index, disco);
        }
    }

    public void eliminarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.remove(index);
        }
    }

    public List<Disco> listarDiscografia() {
        return discografia;
    }

    public Disco buscarDisco(int codigo) {
        for(Disco disco : discografia) {
            if (disco.getCodigo() == codigo){
                return disco;
            }break;
        }
        return null;
    }

    @Override
    public double calularSalario() {
        if (numeroDeSensillos > 10 && numeroDeGiras > 3) {
        } else if (numeroDeSensillos > 1 || numeroDeSensillos <= 10) {
            return (super.getSalario() + 1000);
        } else if (numeroDeGiras > 0 || numeroDeGiras < 4) {
            return (super.getSalario() + super.getSalario() * 0.05);
        } else if (discografia.size() >= 5) {
            return (super.getSalario() + super.getSalario() * 0.03);
        }
        return super.getSalario();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + super.hashCode();
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
        final Cantante other = (Cantante) obj;
        if (this.numeroDeSensillos != other.numeroDeSensillos) {
            return false;
        }
        if (this.numeroDeConciertos != other.numeroDeConciertos) {
            return false;
        }
        if (this.numeroDeGiras != other.numeroDeGiras) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        if (!Objects.equals(this.generoMusical, other.generoMusical)) {
            return false;
        }
        return Objects.equals(this.discografia, other.discografia);
    }

    
    @Override
    public String toString() {
        return "Cantante{" + super.toString() + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSensillos=" + numeroDeSensillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + '}' + "\n discografia=" + discografia;
    }

}