package org.example.modelo;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @Column(name = "ID_LIBRO")
    private Long isbn;
    @Column(name = "titulo")
    private String titulo;

    public Libro(Long isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "\nLibro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
