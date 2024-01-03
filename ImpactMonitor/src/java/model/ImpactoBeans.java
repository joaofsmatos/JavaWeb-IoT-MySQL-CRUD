package model;

/**
 *
 * @author joaof
 */

public class ImpactoBeans {

    private String n_impacto;
    private String msg_impacto;
    private String hora_impacto;
    private String data_impacto;
    private String id_impacto;

    public ImpactoBeans() {
        super();
    }

    public ImpactoBeans(String n_impacto, String id_impacto, String msg_impacto, String hora_impacto, String data_impacto) {
        this.id_impacto = id_impacto;
        this.n_impacto = n_impacto;
        this.msg_impacto = msg_impacto;
        this.hora_impacto = hora_impacto;
        this.data_impacto = data_impacto;
    }

    public String getN_impacto() {
        return n_impacto;
    }

    public void setN_impacto(String id_impacto) {
        this.n_impacto = id_impacto;
    }
    
    public String getId_impacto() {
        return id_impacto;
    }

    public void setId_impacto(String id_impacto) {
        this.id_impacto = id_impacto;
    }

    public String getMsg_impacto() {
        return msg_impacto;
    }

    public void setMsg_impacto(String msg_impacto) {
        this.msg_impacto = msg_impacto;
    }

    public String getHora_impacto() {
        return hora_impacto;
    }

    public void setHora_impacto(String hora_impacto) {
        this.hora_impacto = hora_impacto;
    }

    public String getData_impacto() {
        return data_impacto;
    }

    public void setData_impacto(String data_impacto) {
        this.data_impacto = data_impacto;
    }
}
