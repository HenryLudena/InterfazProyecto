package DataAccess.Entities;

public class Mascota {
    private int MASID;
    private int PROID;
    private int TIPID;
    private int PERFIL_ID;
    private String MAS_NOMBRE;                  
    private String MAS_OBSERVACION;               
    private String MAS_SINTOMA_ALERGIAS;          
    private String NOMBRE_NUEVO;
    private String TIPNOMBRE;
    private String PRONOMBRES;
    private String PROAPELLIDOS;
    private String PROTELEFONO;
    private String PRODICRECCION;

    
    
    //Constructor de la tabla con sus respectivos parámetros para getters y setters
    public Mascota (int PROID, int TIPID, int MASID, String MAS_NOMBRE, String TIPNOMBRE, String PRONOMBRES, String PROAPELLIDOS, String PROTELEFONO, String MAS_OBSERVACION, String MAS_SINTOMA_ALERGIAS){
        this.PROID = PROID;
        this.TIPID = TIPID;
        this.MASID = MASID;
        this.MAS_NOMBRE=MAS_NOMBRE;
        this.TIPNOMBRE = TIPNOMBRE;
        this.PRONOMBRES = PRONOMBRES;
        this.PROAPELLIDOS = PROAPELLIDOS;
        this.PROTELEFONO = PROTELEFONO;
        this.MAS_OBSERVACION=MAS_OBSERVACION;
        this.MAS_SINTOMA_ALERGIAS=MAS_SINTOMA_ALERGIAS;
        
    }
    public Mascota (int MASID, String MAS_NOMBRE){
        this.MASID = MASID;
        this.MAS_NOMBRE=MAS_NOMBRE;
    }
    public Mascota (String MAS_NOMBRE, String NOMBRE_NUEVO){
        this.MAS_NOMBRE = MAS_NOMBRE;
        this.NOMBRE_NUEVO = NOMBRE_NUEVO;
    }

    //Constructor Codigo QR
    public Mascota (String MAS_NOMBRE, String PRONOMBRES, String PRODICRECCION, String PROTELEFONO){
        this.MAS_NOMBRE = MAS_NOMBRE;
        this.PRONOMBRES = PRONOMBRES;
        this.PRODICRECCION = PRODICRECCION;
        this.PROTELEFONO = PROTELEFONO;
    }

    //Getters y Setters
    public int getPROID() {
        return PROID;
    }
    public void setPROID(int PROID) {
        this.PROID = PROID;
    }
    public int getTIPID() {
        return TIPID;
    }
    public void setTIPID(int TIPID) {
        this.TIPID = TIPID;
    }
    public int getPERFIL_ID() {
        return PERFIL_ID;
    }
    public void setPERFIL_ID(int PERFIL_ID) {
        this.PERFIL_ID = PERFIL_ID;
    }
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

    public String getNOMBRE_NUEVO() {
        return NOMBRE_NUEVO;
    }
    public void setNOMBRE_NUEVO(String NOMBRE_NUEVO) {
        this.NOMBRE_NUEVO = NOMBRE_NUEVO;
    }
    public String getTIPNOMBRE() {
        return TIPNOMBRE;
    }
    public void setTIPNOMBRE(String TIPNOMBRE) {
        this.TIPNOMBRE = TIPNOMBRE;
    }
    public String getPRONOMBRES() {
        return PRONOMBRES;
    }
    public void setPRONOMBRES(String PRONOMBRES) {
        this.PRONOMBRES = PRONOMBRES;
    }
    public String getPROAPELLIDOS() {
        return PROAPELLIDOS;
    }
    public void setPROAPELLIDOS(String PROAPELLIDOS) {
        this.PROAPELLIDOS = PROAPELLIDOS;
    }
    public String getPROTELEFONO() {
        return PROTELEFONO;
    }
    public void setPROTELEFONO(String PROTELEFONO) {
        this.PROTELEFONO = PROTELEFONO;
    }

    public String getPRODICRECCION() {
        return PRODICRECCION;
    }
    public void setPRODICRECCION(String PRODICRECCION) {
        this.PRODICRECCION = PRODICRECCION;
    }
}
