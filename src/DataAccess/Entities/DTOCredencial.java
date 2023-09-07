package DataAccess.Entities;

public class DTOCredencial {
    private Mascota mascotaDTO;
    private Propietario propietarioDTO;
    private Tipo tipoDTO;

    public DTOCredencial(Mascota mascotaDTO, Propietario propietarioDTO, Tipo tipoDTO){
        this.mascotaDTO = mascotaDTO;
        this.propietarioDTO= propietarioDTO;
        this.tipoDTO = tipoDTO;
    }

    public Mascota getMascotaDTO() {
        return mascotaDTO;
    }

    public void setMascotaDTO(Mascota mascotaDTO) {
        this.mascotaDTO = mascotaDTO;
    }

    public Propietario getPropietarioDTO() {
        return propietarioDTO;
    }

    public void setPropietarioDTO(Propietario propietarioDTO) {
        this.propietarioDTO = propietarioDTO;
    }

    public Tipo getTipoDTO() {
        return tipoDTO;
    }

    public void setTipoDTO(Tipo tipoDTO) {
        this.tipoDTO = tipoDTO;
    }

}
