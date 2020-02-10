/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEjb;
import entity.Movies;
import entity.Screenings;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kristina
 */
@Named(value = "moviesBean")
@SessionScoped
public class MoviesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    //injects the ejb
    @EJB
    private TheaterEjb theaterEjb;
    //variables to store the information
    private Theater theater;
    private Movies movie; 
    private Screenings screening;
      
    

    /**
     * Creates a new instance of MoviesBean
     */
    public MoviesBean() {
    }
    //getter and setter

    public TheaterEjb getTheaterEjb() {
        return theaterEjb;
    }

    public void setTheaterEjb(TheaterEjb theaterEjb) {
        this.theaterEjb = theaterEjb;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Screenings getScreening() {
        return screening;
    }

    public void setScreening(Screenings screening) {
        this.screening = screening;
    }
    
    
    //show movie by theaterID. TheaterID is a parameter that get passed from html page.
    public String showMovies(Theater t) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int theaterid=t.getTheaterid();
        theater = theaterEjb.findTheaterById(theaterid);
        return "MoviePage.xhtml";
    }
    //get list of movies
    public List<Movies> getMoviesList() {
        
        int theaterid = theater.getTheaterid();
        return theaterEjb.findMoviesByTheater(theaterid);
     
    }
    //method for showing screening
    public String showScreening(Movies movie) {
        this.movie = movie;
        return "ScreeningPage.xhtml";
    }
    //get list of screenings information
    public List<Screenings> getInfoForScreenings() {
        int movieid = movie.getMovieid();
        int theaterid = theater.getTheaterid();
        return theaterEjb.findScreenings(movieid, theaterid);

    }
}







