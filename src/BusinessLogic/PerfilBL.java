package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.TablaDAOAdmin;
import DataAccess.DAO.TablaDAOPerfil;
import DataAccess.Entities.Mascota;
import DataAccess.Entities.Perfil;
import DataAccess.Entities.PerfilAdministrador;
import Framework.NetworkException;

//Perfil es Usuario en la Lógica 
public class PerfilBL {
    public Integer getMaxIdPerfil() {
        try {
            ResultSet rs =   new TablaDAOPerfil().getMaxIdUser();
            return  rs.getInt("maxIdUser"); 
        } 
        catch (Exception e) {
            return 0;
        }
    } 

    public List<Perfil> getAllPerfil() throws NetworkException{
        try {
            TablaDAOPerfil tablaDAOPerfil = new TablaDAOPerfil();
            List<Perfil> listaPerfil = new ArrayList<Perfil>();

            ResultSet resultSet =  tablaDAOPerfil.getAllUser();
            while(resultSet.next())    {
                Perfil perfil = new Perfil( resultSet.getInt(   "PERFIL_ID"),
                                            resultSet.getString("USUARIO_PERFIL_NOMBRE")); 
                listaPerfil.add(perfil);
            }
            return listaPerfil; 
        } 
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAllUser");
        }
    } 

    public Perfil getPerfilById(int PERFIL_ID) throws NetworkException{
        try {
            TablaDAOPerfil tablaDAOPerfil = new TablaDAOPerfil(); 
            ResultSet resultSet =  tablaDAOPerfil.getUserById(PERFIL_ID);
            if(resultSet.next())    
                return new Perfil(resultSet.getInt(   "PERFIL_ID"),
                                  resultSet.getString("USUARIO_PERFIL_NOMBRE")); 
            return null;
        } 
        //String query = " INSERT INTO MASCOTA (PROID, TIPID, MAS_NOMBRE, MAS_OBSERVACION, MAS_SINTOMA_ALERGIAS, PERFIL_ID) VALUES (?, ?, ?, ?, ?, ?)";
        
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetPerfilbyId");
        }
    } 

    public boolean createPerfil(Perfil perfil) throws NetworkException{
        return new TablaDAOPerfil().insertUser(perfil.getCEDULA_PERFIL_NOMBRE(), perfil.getCONTRASENA_PERFIL_NOMBRE(), perfil.getUSUARIO_PERFIL_NOMBRE());
    } 
    public boolean updateAdmin(Perfil perfil) throws NetworkException{
        return new TablaDAOPerfil().updateUser(perfil.getUSUARIO_PERFIL_NOMBRE(), perfil.getNOMBRE_NUEVO());
    } 
    public boolean deleteUser(int PERFIL_ID) throws NetworkException{
        return new TablaDAOPerfil().deleteUser(PERFIL_ID);
    } 
}
