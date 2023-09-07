package DataAccess.Entities;

public class Tipo {
    private int TIPID;
    private String TIPNOMBRE;
    private String TIPESTADO;

    //Constructor de la tabla con sus respectivos parámetros para getters y setters
    public Tipo (int TIPID, String TIPNOMBRE, String TIPESTADO){
        this.TIPID = TIPID;
        this.TIPNOMBRE=TIPNOMBRE;
        this.TIPESTADO=TIPESTADO;
    }
    
    //Getters y Setters
    public int getTIPID() {
        return TIPID;
    }

    public void setTIPID(int TIPID) {
        this.TIPID = TIPID;
    }

    public String getTIPNOMBRE() {
        return TIPNOMBRE;
    }

    public void setTIPNOMBRE(String TIPNOMBRE) {
        this.TIPNOMBRE = TIPNOMBRE;
    }

    public String getTIPESTADO() {
        return TIPESTADO;
    }

    public void setTIPESTADO(String TIPESTADO) {
        this.TIPESTADO = TIPESTADO;
    }

}
