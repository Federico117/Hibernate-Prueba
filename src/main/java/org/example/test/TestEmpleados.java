package org.example.test;

import org.example.modelo.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {
    private static EntityManager manager;
    private static EntityManagerFactory emf;


    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
        insertInicial();
        manager.getTransaction().begin();
        Empleado e = manager.find(Empleado.class, 10L);
        e.setNombre("Cristina");
        manager.getTransaction().commit();
        imprimirTodo();
    }

    public static void insertInicial(){
        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(1979, 6, 6).getTime());
        Empleado e2 = new Empleado(11L, "Gonzales", "Pedro", new GregorianCalendar(1995, 6, 6).getTime());
        manager.getTransaction().begin();
        manager.persist(e);
        manager.persist(e2);
        manager.getTransaction().commit();
    }

    private static void imprimirTodo(){
        List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Hay "+emps.size()+" empleados en el sistema.");
        for(Empleado es : emps){
            System.out.println(es);
        }
    }
}
