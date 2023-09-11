package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.TablaDAOAdmin;
import DataAccess.DAO.TablaDAOMascota;
import DataAccess.Entities.Mascota;
import DataAccess.Entities.PerfilAdministrador;
import Framework.NetworkException;

public class AdminBL {
    public Integer getMaxIdMascota() {
        try {
            ResultSet rs =   new TablaDAOAdmin().getMaxIdAdmin();
            return  rs.getInt("maxIdAdmin"); 
        } 
        catch (Exception e) {
            return 0;
        }
    } 

    public List<PerfilAdministrador> getAllAdmin() throws NetworkException{
        try {
            TablaDAOAdmin tablaDAOAdmin = new TablaDAOAdmin();
            List<PerfilAdministrador> listaAdmin = new ArrayList<PerfilAdministrador>();

            ResultSet resultSet =  tablaDAOAdmin.getAllAdmin();
            while(resultSet.next())    {
                PerfilAdministrador perfilAdministrador = new PerfilAdministrador(  resultSet.getInt(   "PERFIL_ADMINISTRADOR_ID"),
                                                                                    resultSet.getString("USUARIO_ADMINISTRADOR_NOMBRE")); 
                listaAdmin.add(perfilAdministrador);
            }
            return listaAdmin; 
        } 
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAllAdmin");
        }
    } 

    public PerfilAdministrador getAdminById(int PERFIL_ADMINISTRADOR_ID) throws NetworkException{
        try {
            TablaDAOAdmin tablaDAOAdmin = new TablaDAOAdmin(); 
            ResultSet resultSet =  tablaDAOAdmin.getAdminById(PERFIL_ADMINISTRADOR_ID);
            if(resultSet.next())    
                return new PerfilAdministrador(resultSet.getInt(   "PERFIL_ADMINISTRADOR_ID"),
                                               resultSet.getString("USUARIO_ADMINISTRADOR_NOMBRE")); 
            return null;
        } 
        //String query = " INSERT INTO MASCOTA (PROID, TIPID, MAS_NOMBRE, MAS_OBSERVACION, MAS_SINTOMA_ALERGIAS, PERFIL_ID) VALUES (?, ?, ?, ?, ?, ?)";
        
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAdminbyId");
        }
    } 
    public boolean createAdmin(PerfilAdministrador perfilAdministrador) throws NetworkException{
        return new TablaDAOAdmin().insertAdmin(perfilAdministrador.getCEDULA_ADMINISTRADOR_NOMBRE(), perfilAdministrador.getCONTRASENA_ADMINISTRADOR_NOMBRE(), perfilAdministrador.getUSUARIO_ADMINISTRADOR_NOMBRE());
    } 
    public boolean updateAdmin(PerfilAdministrador pa) throws NetworkException{
        return new TablaDAOAdmin().updateAdmin(pa.getUSUARIO_ADMINISTRADOR_NOMBRE(), pa.getNOMBRE_NUEVO());
    } 
    public boolean deleteAdmin(int PERFIL_ADMINISTRADOR_ID) throws NetworkException{
        return new TablaDAOAdmin().deleteAdmin(PERFIL_ADMINISTRADOR_ID);
    } 
}
