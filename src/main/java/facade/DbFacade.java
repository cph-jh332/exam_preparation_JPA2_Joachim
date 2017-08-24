/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.EBook;
import entity.PaperBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author craci
 */
public class DbFacade {

    EntityManagerFactory emf;

    public DbFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addEBook(EBook book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public void addPaperBook(PaperBook book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public List<EBook> getAllEBooks() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e FROM EBook e").getResultList();
    }

    public List<PaperBook> getAllPaperBooks() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM PaperBook p").getResultList();
    }

    public EBook changeEBookTitle(Long isbn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EBook eb = em.find(EBook.class, isbn);
        eb.setTitle("Book1");
        em.getTransaction().commit();
        em.close();
        return eb;
    }

    public PaperBook changePaperBookTitle(Long isbn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PaperBook pb = em.find(PaperBook.class, isbn);
        pb.setTitle("Book2");
        em.getTransaction().commit();
        em.close();
        return pb;
    }

    public boolean removeEBook(Long isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            EBook eb = em.find(EBook.class, isbn);
            em.remove(eb);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }finally{
            em.close();
        }
    }
    
    public boolean removePaperBook(Long isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PaperBook pb = em.find(PaperBook.class, isbn);
            em.remove(pb);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }finally{
            em.close();
        }
    }
}
