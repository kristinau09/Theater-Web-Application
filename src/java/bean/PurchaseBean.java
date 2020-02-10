/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEjb;
import entity.Movies;
import entity.Reservation;
import entity.Screenings;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Kristina
 */
@Named(value = "purchaseBean")
@SessionScoped
public class PurchaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private TheaterEjb theaterEjb;
    private Movies movie;
    private Screenings screening;
    //object for resevation entities
    private Reservation reservation = new Reservation();
    //variables to store the data
    private int numOfSeats;
    private String creditCardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String securityCode;
    private String result;


    public PurchaseBean() {
    }
    //adds the purchase 
    public String addPurchase() {
        Date date = new Date();

        reservation.setPurchasetimedate(new SimpleDateFormat("MM/dd/yy HH:mm:ss").format(date));
        theaterEjb.persist(reservation);
        result ="Transaction approved" + " for " + numOfSeats + " seats." + "Your total was $" + numOfSeats * 10 + ". " + " Current time: " + reservation.getPurchasetimedate();
        return "ConfirmationPage.xhtml";

    }

    //Screening for list of movies
    public String showPurchasePage(Screenings screening) {
        this.screening = screening;
        return "PurchasePage.xhtml";
    }


    public TheaterEjb getTheaterEjb() {
        return theaterEjb;
    }

    public void setTheaterEjb(TheaterEjb theaterEjb) {
        this.theaterEjb = theaterEjb;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
  
}







