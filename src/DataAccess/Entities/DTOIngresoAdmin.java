package DataAccess.Entities;

public class DTOIngresoAdmin {
    private PerfilAdministrador perfilAdministradorDTO;
    //Constructor DTO
    public DTOIngresoAdmin(PerfilAdministrador perfilAdministradorDTO){
        this.perfilAdministradorDTO = perfilAdministradorDTO;
    }
    //Getter y setter
    public PerfilAdministrador getPerfilAdministradorDTO() {
        return perfilAdministradorDTO;
    }

    public void setPerfilAdministradorDTO(PerfilAdministrador perfilAdministradorDTO) {
        this.perfilAdministradorDTO = perfilAdministradorDTO;
    }
}
