package cic.examen.examen_parcial.EJ1;

public class Mueble implements ConPuerta{

    private String material;
    private String nombre;



    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean tienePuertas() {
        return false;
    }


  

}
