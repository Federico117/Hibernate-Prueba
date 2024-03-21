package org.example.test;

import org.example.modelo.Empleado;
import org.example.modelo.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");


    public static void main(String[] args) {
        EntityManager man = emf.createEntityManager();
        Empleado empleado = new Empleado(11L, "Valdez", "Federico", new GregorianCalendar(1994, 07, 21).getTime());
        Libro libro = new Libro(3L, "Diario de Ana Frank");
        Libro libro2 = new Libro(4L, "El caballero de la armadura oxidada");
        man.getTransaction().begin();
        // Persistimos manualmente los libros
        man.persist(libro);
        man.persist(libro2);
        empleado.addLibro(libro);
        empleado.addLibro(libro2);
        man.persist(empleado);
        man.getTransaction().commit();
        imprimirTodo();
        man.close();

        man = emf.createEntityManager();
        man.getTransaction().begin();
        empleado = man.merge(empleado);
        empleado.quitarLibro(1);
        man.getTransaction().commit();
        imprimirTodo();
        man.close();
        System.out.println("Este es el elemento que quedo sin referenciar: "+libro2);
    }

    public static void insertInicial(){
        EntityManager manager = emf.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(1979, 6, 6).getTime());
        Empleado e2 = new Empleado(11L, "Gonzales", "Pedro", new GregorianCalendar(1995, 6, 6).getTime());
        manager.getTransaction().begin();
        manager.persist(e);
        manager.persist(e2);
        manager.getTransaction().commit();
    }

    private static void imprimirTodo(){
        EntityManager manager = emf.createEntityManager();
        List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Hay "+emps.size()+" empleados en el sistema.");
        for(Empleado es : emps){
            System.out.println(es);
        }
        List<Libro> libs = (List<Libro>) manager.createQuery("FROM Libro").getResultList();
        System.out.println("Hay "+libs.size()+" libros en el sistema");
        for(Libro libro : libs){
            System.out.println(libro);
        }
    }
}
