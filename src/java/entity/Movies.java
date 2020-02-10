/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kristina
 */
@Entity
@Table(name = "MOVIES", catalog = "", schema = "SCOTT")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMovieid", query = "SELECT m FROM Movies m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Movies.findByGenre", query = "SELECT m FROM Movies m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movies.findByDescription", query = "SELECT m FROM Movies m WHERE m.description = :description"),
    @NamedQuery(name = "Movies.findByReleaseDate", query = "SELECT m FROM Movies m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movies.findByRating", query = "SELECT m FROM Movies m WHERE m.rating = :rating"),
    @NamedQuery(name = "Movies.findByRuntime", query = "SELECT m FROM Movies m WHERE m.runtime = :runtime"),
    @NamedQuery(name = "Movies.findByCasts", query = "SELECT m FROM Movies m WHERE m.casts = :casts"),
    @NamedQuery(name = "Movies.findByPoster", query = "SELECT m FROM Movies m WHERE m.poster = :poster"),
    @NamedQuery(name = "Movies.findScreenings", query = "SELECT s FROM Screenings s WHERE s.screeningsPK.movieid = :movieid and s.theaterid = :theaterid")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private Integer movieid;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 60)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 700)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "RELEASE_DATE")
    private String releaseDate;
    @Size(max = 40)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 50)
    @Column(name = "RUNTIME")
    private String runtime;
    @Size(max = 800)
    @Column(name = "CASTS")
    private String casts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "POSTER")
    private String poster;

    public Movies() {
    }

    public Movies(Integer movieid) {
        this.movieid = movieid;
    }

    public Movies(Integer movieid, String poster) {
        this.movieid = movieid;
        this.poster = poster;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ movieid=" + movieid + " ]";
    }
    
}




