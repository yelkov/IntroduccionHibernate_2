package edu.badpals.intro_hibernate;

import edu.badpals.intro_hibernate.entities.Card;
import edu.badpals.intro_hibernate.entities.Course;
import edu.badpals.intro_hibernate.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Student alice = new Student();
        alice.setName("Alice");
        alice.setDni("11111111A");
        alice.setPhone("666666666");

        Student bob = new Student();
        bob.setName("Bob");
        bob.setDni("22222222B");
        bob.setPhone("677777777");

        Student carol = new Student();
        carol.setName("Carol");
        carol.setDni("33333333C");
        carol.setPhone("688888888");

        Course accesoDatos = new Course();
        accesoDatos.setDescription("Acceso a datos");
        Course moviles = new Course();
        moviles.setDescription("PMDM");

        Card cardAlice = new Card();
        cardAlice.setCode("1AA");


        try {
            em.getTransaction().begin();

            em.persist(alice);
            em.persist(bob);
            em.persist(carol);

            em.persist(accesoDatos);
            em.persist(moviles);

            em.persist(cardAlice);

            alice.addCourse(accesoDatos);
            alice.addCourse(moviles);
            alice.setCard(cardAlice);
            bob.addCourse(accesoDatos);
            carol.addCourse(moviles);


            em.flush();

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        Student foundAlice = em.find(Student.class, 1);
        Student foundBob = em.find(Student.class, 2);
        Student foundCarol = em.find(Student.class, 3);

        List<Course> courses = foundAlice.getCourses();
        System.out.println("\nCursos de Alice:");
        courses.stream().forEach(course -> System.out.println(course));
        List<Course> courses2 = foundBob.getCourses();
        System.out.println("\nCursos de Bob:");
        courses2.stream().forEach(course -> System.out.println(course));
        List<Course> courses3 = foundCarol.getCourses();
        System.out.println("\nCursos de Carol:");
        courses3.stream().forEach(course -> System.out.println(course));

        em.getTransaction().begin();
        em.remove(foundAlice);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
