/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 *@author Kristina
 */
@Entity
@Table(name = "SCREENINGS", catalog = "", schema = "SCOTT")
@NamedQueries({
    @NamedQuery(name = "Screenings.findAll", query = "SELECT s FROM Screenings s"),
    @NamedQuery(name = "Screenings.findByScreeningid", query = "SELECT s FROM Screenings s WHERE s.screeningsPK.screeningid = :screeningid"),
    @NamedQuery(name = "Screenings.findByTheaterid", query = "SELECT s FROM Screenings s WHERE s.theaterid = :theaterid"),
    @NamedQuery(name = "Screenings.findByMovieid", query = "SELECT s FROM Screenings s WHERE s.screeningsPK.movieid = :movieid"),
    @NamedQuery(name = "Screenings.findByShowtime", query = "SELECT s FROM Screenings s WHERE s.showtime = :showtime"),
    @NamedQuery(name = "Screenings.findByScreen", query = "SELECT s FROM Screenings s WHERE s.screen = :screen"),
    @NamedQuery(name = "Screenings.findByAuditorium", query = "SELECT s FROM Screenings s WHERE s.auditorium = :auditorium")})
public class Screenings implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScreeningsPK screeningsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private int theaterid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SHOWTIME")
    private String showtime;
    @Size(max = 50)
    @Column(name = "SCREEN")
    private String screen;
    @Size(max = 100)
    @Column(name = "AUDITORIUM")
    private String auditorium;

    public Screenings() {
    }

    public Screenings(ScreeningsPK screeningsPK) {
        this.screeningsPK = screeningsPK;
    }

    public Screenings(ScreeningsPK screeningsPK, int theaterid, String showtime) {
        this.screeningsPK = screeningsPK;
        this.theaterid = theaterid;
        this.showtime = showtime;
    }

    public Screenings(int screeningid, int movieid) {
        this.screeningsPK = new ScreeningsPK(screeningid, movieid);
    }

    public ScreeningsPK getScreeningsPK() {
        return screeningsPK;
    }

    public void setScreeningsPK(ScreeningsPK screeningsPK) {
        this.screeningsPK = screeningsPK;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (screeningsPK != null ? screeningsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screenings)) {
            return false;
        }
        Screenings other = (Screenings) object;
        if ((this.screeningsPK == null && other.screeningsPK != null) || (this.screeningsPK != null && !this.screeningsPK.equals(other.screeningsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Screenings[ screeningsPK=" + screeningsPK + " ]";
    }
    
}


