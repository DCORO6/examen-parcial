package cic.examen.examen_parcial.EJ3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String num;
    private boolean enLlamada;
    private boolean encendido;
    public Telefono() {
    }
    
    public Telefono(String num, boolean enLlamada, boolean encendido) {
        this.num = num;
        this.enLlamada = enLlamada;
        this.encendido = encendido;
    }

    
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public boolean isEnLlamada() {
        return enLlamada;
    }
    public void setEnLlamada(boolean enLlamada) {
        this.enLlamada = enLlamada;
    }
    public boolean isEncendido() {
        return encendido;
    }
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    
    public void marcar(String num) {
        if (encendido) {
            this.num = num;
        }
    }

    public void llamar() {
        if (encendido && !num.isEmpty()) {
            this.enLlamada = true;
        }
    }

    public void colgar() {
        this.enLlamada = false;
    }

    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
        this.enLlamada = false; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
