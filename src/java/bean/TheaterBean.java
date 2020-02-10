/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEjb;
import entity.Movies;
import entity.Theater;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author Kristina
 */
@Named(value = "theaterBean")
@SessionScoped
public class TheaterBean implements Serializable {

    @EJB
    private TheaterEjb theaterEjb;

    //variables for entittes
    private Theater theater;
    private Movies movie;
    private String zipcode;

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() {
    }

    //uses the ejb to print out the theater list 
    public String getTheaterListByZipcode() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        this.zipcode = params.get("zipcode");
        return "TheaterPage.xhtml";
    }

    public String showMovie(Theater theater) {
        return "MoviePage.xhtml";
    }

    public List<Theater> getShowTheaters() {
        return theaterEjb.findTheaterByZipcode(zipcode);
    }

}
