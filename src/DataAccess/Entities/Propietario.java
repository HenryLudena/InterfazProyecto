package DataAccess.Entities;

public class Propietario {
    private int PROID;
    private String PROPNOMBRES;
    private String PROAPELLIDOS;
    private String PRODIRECCION;
    private String PROCORRERO;
    private String PROTELEFONO;
    private String PROESTADO;
    

    //Constructor de la tabla con sus respectivos parámetros para getters y setters
    public Propietario (int PROID, String PROPNOMBRES, String PROAPELLIDOS, String PRODIRECCION, String PROCORRERO, String PROTELEFONO, String PROESTADO){
        this.PROID = PROID;
        this.PROPNOMBRES=PROPNOMBRES;
        this.PROAPELLIDOS=PROAPELLIDOS;
        this.PRODIRECCION=PRODIRECCION;
        this.PROCORRERO=PROCORRERO;
        this.PROTELEFONO=PROTELEFONO;
        this.PROESTADO=PROESTADO;
    }

    //Getters y Setters
    public int getPROID() {
        return PROID;
    }

    public void setPROID(int PROID) {
        this.PROID = PROID;
    }

    public String getPROPNOMBRES() {
        return PROPNOMBRES;
    }

    public void setPROPNOMBRES(String PROPNOMBRES) {
        this.PROPNOMBRES = PROPNOMBRES;
    }

    public String getPROAPELLIDOS() {
        return PROAPELLIDOS;
    }

    public void setPROAPELLIDOS(String PROAPELLIDOS) {
        this.PROAPELLIDOS = PROAPELLIDOS;
    }

    public String getPRODIRECCION() {
        return PRODIRECCION;
    }

    public void setPRODIRECCION(String PRODIRECCION) {
        this.PRODIRECCION = PRODIRECCION;
    }

    public String getPROCORRERO() {
        return PROCORRERO;
    }

    public void setPROCORRERO(String PROCORRERO) {
        this.PROCORRERO = PROCORRERO;
    }

    public String getPROTELEFONO() {
        return PROTELEFONO;
    }

    public void setPROTELEFONO(String PROTELEFONO) {
        this.PROTELEFONO = PROTELEFONO;
    }

    public String getPROESTADO() {
        return PROESTADO;
    }

    public void setPROESTADO(String PROESTADO) {
        this.PROESTADO = PROESTADO;
    }
}
