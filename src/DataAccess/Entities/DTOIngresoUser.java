package DataAccess.Entities;

public class DTOIngresoUser {
    private Perfil perfilDTO;
    
    //Constructor DTO
    public DTOIngresoUser(Perfil perfilDTO){
        this.perfilDTO = perfilDTO;
    }
    //Getter y setter
    public Perfil getPerfilDTO() {
        return perfilDTO;
    }
    public void setPerfilDTO(Perfil perfilDTO) {
        this.perfilDTO = perfilDTO;
    }
}
