package DataAccess.Entities;

public class Perfil {
    private int PERFIL_ID;
    private String CONTRASENA_PERFIL_NOMBRE;
    private String CEDULA_PERFIL_NOMBRE;
    private String USUARIO_PERFIL_NOMBRE;
    private String PERFIL_ESTADO;

    

    //Constructor de la tabla con sus respectivos parámetros para getters y setters
    public Perfil (int PERFIL_ID, String CONTRASENA_PERFIL_NOMBRE, String CEDULA_PERFIL_NOMBRE, String USUARIO_PERFIL_NOMBRE, String PERFIL_ESTADO){
        this.PERFIL_ID = PERFIL_ID;
        this.CONTRASENA_PERFIL_NOMBRE= CONTRASENA_PERFIL_NOMBRE;
        this.CEDULA_PERFIL_NOMBRE = CEDULA_PERFIL_NOMBRE;
        this.USUARIO_PERFIL_NOMBRE = USUARIO_PERFIL_NOMBRE;
        this.PERFIL_ESTADO = PERFIL_ESTADO;
    }

    //Getters y Setters
    public int getPERFIL_ID() {
        return PERFIL_ID;
    }

    public void setPERFIL_ID(int PERFIL_ID) {
        this.PERFIL_ID = PERFIL_ID;
    }

    public String getCONTRASENA_PERFIL_NOMBRE() {
        return CONTRASENA_PERFIL_NOMBRE;
    }

    public void setCONTRASENA_PERFIL_NOMBRE(String CONTRASENA_PERFIL_NOMBRE) {
        this.CONTRASENA_PERFIL_NOMBRE = CONTRASENA_PERFIL_NOMBRE;
    }

    public String getCEDULA_PERFIL_NOMBRE() {
        return CEDULA_PERFIL_NOMBRE;
    }

    public void setCEDULA_PERFIL_NOMBRE(String CEDULA_PERFIL_NOMBRE) {
        this.CEDULA_PERFIL_NOMBRE = CEDULA_PERFIL_NOMBRE;
    }

    public String getUSUARIO_PERFIL_NOMBRE() {
        return USUARIO_PERFIL_NOMBRE;
    }

    public void setUSUARIO_PERFIL_NOMBRE(String USUARIO_PERFIL_NOMBRE) {
        this.USUARIO_PERFIL_NOMBRE = USUARIO_PERFIL_NOMBRE;
    }

    public String getPERFIL_ESTADO() {
        return PERFIL_ESTADO;
    }

    public void setPERFIL_ESTADO(String PERFIL_ESTADO) {
        this.PERFIL_ESTADO = PERFIL_ESTADO;
    }
}
