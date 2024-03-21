package org.example.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Publicacion {
    @Id
    @Column
    private Long id;
    @Column
    private String titulo;
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public Publicacion() {
    }

    public Publicacion(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void insertarComentario(Comentario comentario){
        this.comentarios.add(comentario);
        comentario.setPublicacion(this);
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public void eliminarComentario(Comentario c) {
        comentarios.remove(c);
        c.setPublicacion(null);
    }
}
