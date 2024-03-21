package org.example.modelo;

import javax.persistence.*;

@Entity
@Table
public class Comentario {
    @Id
    @Column
    private Long id;
    @Column
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Long id, String mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", "+publicacion+
                '}';
    }
}
