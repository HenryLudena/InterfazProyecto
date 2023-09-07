package DataAccess.Entities;

public class Mascota {
    private int MASID;
    private String MAS_NOMBRE;                  
    private String MAS_OBSERVACION;               
    private String MAS_SINTOMA_ALERGIAS;          
    private String MAS_ESTADO;

    

    //Constructor de la tabla con sus respectivos parámetros para getters y setters
    public Mascota (int MASID, String MAS_NOMBRE, String MAS_OBSERVACION, String MAS_SINTOMA_ALERGIAS, String MAS_ESTADO){
        this.MASID = MASID;
        this.MAS_NOMBRE=MAS_NOMBRE;
        this.MAS_OBSERVACION=MAS_OBSERVACION;
        this.MAS_SINTOMA_ALERGIAS=MAS_SINTOMA_ALERGIAS;
        this.MAS_ESTADO=MAS_ESTADO;
    }

    //Getters y Setters
    public int getMASID() {
        return MASID;
    }

    public void setMASID(int MASID) {
        this.MASID = MASID;
    }

    public String getMAS_NOMBRE() {
        return MAS_NOMBRE;
    }

    public void setMAS_NOMBRE(String MAS_NOMBRE) {
        this.MAS_NOMBRE = MAS_NOMBRE;
    }

    public String getMAS_OBSERVACION() {
        return MAS_OBSERVACION;
    }

    public void setMAS_OBSERVACION(String MAS_OBSERVACION) {
        this.MAS_OBSERVACION = MAS_OBSERVACION;
    }

    public String getMAS_SINTOMA_ALERGIAS() {
        return MAS_SINTOMA_ALERGIAS;
    }

    public void setMAS_SINTOMA_ALERGIAS(String MAS_SINTOMA_ALERGIAS) {
        this.MAS_SINTOMA_ALERGIAS = MAS_SINTOMA_ALERGIAS;
    }

    public String getMAS_ESTADO() {
        return MAS_ESTADO;
    }

    public void setMAS_ESTADO(String MAS_ESTADO) {
        this.MAS_ESTADO = MAS_ESTADO;
    }

    
}
