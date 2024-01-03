package model;

/**
 *
 * @author joaof
 */

public class DispositivoBeans {

    private String id_dispositivo;
    private String nome_dispositivo;

    public DispositivoBeans() {
        super();
    }

    public DispositivoBeans(String id_dispositivo, String nome_dispositivo) {
        this.id_dispositivo = id_dispositivo;
        this.nome_dispositivo = nome_dispositivo;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getNome_dispositivo() {
        return nome_dispositivo;
    }

    public void setNome_dispositivo(String nome_dispositivo) {
        this.nome_dispositivo = nome_dispositivo;
    }
    
}
