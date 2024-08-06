package cic.examen.examen_parcial.EJ1;

public class Armario extends Mueble {


    private int puertas;

    public Armario(int puertas) {
        super();
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public boolean tienePuertas() {
       if (puertas>0){
        return true;
       }
       return false;
    }

    
   

    


}
