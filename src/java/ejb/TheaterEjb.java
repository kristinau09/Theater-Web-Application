/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movies;
import entity.Screenings;
import entity.Theater;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kristina
 */
@Stateless
public class TheaterEjb {

    //creates the persistence unit 
    @PersistenceContext(unitName = "FInalTheaterProjectPU2")
    private EntityManager em;

    //persists the object 
    public void persist(Object object) {
        em.persist(object);
    }
    //finds theater by id 

    public Theater findTheaterById(int theaterid) {
        return em.createNamedQuery("Theater.findByTheaterid", Theater.class)
                .setParameter("theaterid", theaterid)
                .getSingleResult();
    }

    //finds all the theaters
    public List<Theater> findAllTheater() {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }

    //finds all the theaters by zipcode 
    public List<Theater> findTheaterByZipcode(String zipcode) {
        return em.createNamedQuery("Theater.findByZipcode", Theater.class)
                .setParameter("zipcode", zipcode)
                .getResultList();
    }

    //find movies by the theater
    public List<Movies> findMoviesByTheater(int theaterid) {
        return em.createNamedQuery("Theater.findAllMovies", Movies.class)
                .setParameter("theaterid", theaterid)
                .getResultList();
    }

    //find the screenings 
    public List<Screenings> findScreenings(int movieid, int theaterid) {
        return em.createNamedQuery("Movies.findScreenings", Screenings.class)
                .setParameter("movieid", movieid)
                .setParameter("theaterid", theaterid)
                .getResultList();
    }
    //find 
    public List<Theater> findAllPossibleTheater(Theater theater) {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }

}
