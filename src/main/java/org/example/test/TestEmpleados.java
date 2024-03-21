package org.example.test;

import org.example.modelo.Comentario;
import org.example.modelo.Publicacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        insertar();
        imprimir();
        borrar(2L);
        imprimir();
        //emf.close();
    }

    private static void borrar(long comentario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comentario c = em.find(Comentario.class, comentario);
        Publicacion pub = c.getPublicacion();
        pub.eliminarComentario(c);
        em.getTransaction().commit();
        em.close();
    }

    static void insertar(){
        Publicacion p = new Publicacion(1L, "Hoy hace sol");
        Comentario c = new Comentario(1L, "Aqui llueve.");
        Comentario c2 = new Comentario(2L, "Eres basura");
        p.insertarComentario(c);
        p.insertarComentario(c2);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    static void imprimir(){
        EntityManager em = emf.createEntityManager();
        List<Publicacion> publicaciones = (List<Publicacion>)em.createQuery("FROM Publicacion").getResultList();
        System.out.println(publicaciones);
        List<Comentario> comentarios = (List<Comentario>)em.createQuery("FROM Comentario").getResultList();
        System.out.println("Hay "+comentarios.size()+" comentarios");
        for(Comentario cm : comentarios){
            System.out.println(cm);
        }
    }
}
