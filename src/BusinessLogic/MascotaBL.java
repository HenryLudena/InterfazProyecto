package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.TablaDAOMascota;
import DataAccess.Entities.Mascota;
import Framework.NetworkException;

public class MascotaBL {
    public Integer getMaxIdMascota() {
        try {
            ResultSet rs =   new TablaDAOMascota().getMaxIdMascota();
            return  rs.getInt("maxIdMascota"); 
        } 
        catch (Exception e) {
            return 0;
        }
    } 

    public List<Mascota> getAllMascotas() throws NetworkException{
        try {
            TablaDAOMascota tablaDAOMascota = new TablaDAOMascota();
            List<Mascota> listaMascotas = new ArrayList<Mascota>();

            ResultSet resultSet =  tablaDAOMascota.getAllMascota();
            while(resultSet.next())    {
                Mascota mascota = new Mascota(  resultSet.getInt(   "MASID"),
                                                resultSet.getString("MAS_NOMBRE")); 
                listaMascotas.add(mascota);
            }
            return listaMascotas; 
        } 
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAllMascotas");
        }
    } 

    public Mascota getMascotaById(int MASID) throws NetworkException{
        try {
            TablaDAOMascota tablaDAOMascota = new TablaDAOMascota(); 
            ResultSet resultSet =  tablaDAOMascota.getMascotaById(MASID);
            if(resultSet.next())    
                return new Mascota(resultSet.getInt(   "MASID"),
                                resultSet.getString("MAS_NOMBRE")); 
            return null;
        } 
        //String query = " INSERT INTO MASCOTA (PROID, TIPID, MAS_NOMBRE, MAS_OBSERVACION, MAS_SINTOMA_ALERGIAS, PERFIL_ID) VALUES (?, ?, ?, ?, ?, ?)";
        
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAllMascota");
        }
    } 
    public boolean createMascota(Mascota mascota) throws NetworkException{
        return new TablaDAOMascota().insertMascota(mascota.getPROID(), mascota.getTIPID(), mascota.getMAS_NOMBRE(), mascota.getMAS_OBSERVACION(), mascota.getMAS_SINTOMA_ALERGIAS(), mascota.getPERFIL_ID());
    } 
    public boolean updateMascota(Mascota m) throws NetworkException{
        return new TablaDAOMascota().updateMascota(m.getMAS_NOMBRE(), m.getNOMBRE_NUEVO());
    } 
    public boolean deleteMascota(int MASID) throws NetworkException{
        return new TablaDAOMascota().deleteMascota(MASID);
    } 
}
