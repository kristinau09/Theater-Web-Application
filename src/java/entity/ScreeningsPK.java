/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kristina
 */
@Embeddable
public class ScreeningsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SCREENINGID")
    private int screeningid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private int movieid;

    public ScreeningsPK() {
    }

    public ScreeningsPK(int screeningid, int movieid) {
        this.screeningid = screeningid;
        this.movieid = movieid;
    }

    public int getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) screeningid;
        hash += (int) movieid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScreeningsPK)) {
            return false;
        }
        ScreeningsPK other = (ScreeningsPK) object;
        if (this.screeningid != other.screeningid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ScreeningsPK[ screeningid=" + screeningid + ", movieid=" + movieid + " ]";
    }
    
}


