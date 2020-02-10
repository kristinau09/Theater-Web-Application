/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kristina
 */
@Entity
@Table(name = "THEATERMOVIE", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theatermovie.findAll", query = "SELECT t FROM Theatermovie t"),
    @NamedQuery(name = "Theatermovie.findByTheaterid", query = "SELECT t FROM Theatermovie t WHERE t.theatermoviePK.theaterid = :theaterid"),
    @NamedQuery(name = "Theatermovie.findByMovieid", query = "SELECT t FROM Theatermovie t WHERE t.theatermoviePK.movieid = :movieid")})
public class Theatermovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TheatermoviePK theatermoviePK;

    public Theatermovie() {
    }

    public Theatermovie(TheatermoviePK theatermoviePK) {
        this.theatermoviePK = theatermoviePK;
    }

    public Theatermovie(int theaterid, int movieid) {
        this.theatermoviePK = new TheatermoviePK(theaterid, movieid);
    }

    public TheatermoviePK getTheatermoviePK() {
        return theatermoviePK;
    }

    public void setTheatermoviePK(TheatermoviePK theatermoviePK) {
        this.theatermoviePK = theatermoviePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theatermoviePK != null ? theatermoviePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theatermovie)) {
            return false;
        }
        Theatermovie other = (Theatermovie) object;
        if ((this.theatermoviePK == null && other.theatermoviePK != null) || (this.theatermoviePK != null && !this.theatermoviePK.equals(other.theatermoviePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theatermovie[ theatermoviePK=" + theatermoviePK + " ]";
    }
    
}



