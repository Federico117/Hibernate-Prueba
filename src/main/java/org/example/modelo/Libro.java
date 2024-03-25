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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

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
                ", empleado="+(empleado != null ? empleado.getCodigo() : "no hay empleado")+
                '}';
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
