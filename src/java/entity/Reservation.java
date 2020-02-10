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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Kristina
 */
@Entity
@Table(name = "RESERVATION", catalog = "", schema = "SCOTT")
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByReservationid", query = "SELECT r FROM Reservation r WHERE r.reservationid = :reservationid"),
    @NamedQuery(name = "Reservation.findByCustomerfirstname", query = "SELECT r FROM Reservation r WHERE r.customerfirstname = :customerfirstname"),
    @NamedQuery(name = "Reservation.findByCustomerlastname", query = "SELECT r FROM Reservation r WHERE r.customerlastname = :customerlastname"),
    @NamedQuery(name = "Reservation.findByCustomeremail", query = "SELECT r FROM Reservation r WHERE r.customeremail = :customeremail"),
    @NamedQuery(name = "Reservation.findByPurchasetimedate", query = "SELECT r FROM Reservation r WHERE r.purchasetimedate = :purchasetimedate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESERVATIONID")
    private Integer reservationid;
    @Size(max = 50)
    @Column(name = "CUSTOMERFIRSTNAME")
    private String customerfirstname;
    @Size(max = 50)
    @Column(name = "CUSTOMERLASTNAME")
    private String customerlastname;
    @Size(max = 75)
    @Column(name = "CUSTOMEREMAIL")
    private String customeremail;
    @Size(max = 70)
    @Column(name = "PURCHASETIMEDATE")
    private String purchasetimedate;

    public Reservation() {
    }

    public Reservation(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public String getCustomerfirstname() {
        return customerfirstname;
    }

    public void setCustomerfirstname(String customerfirstname) {
        this.customerfirstname = customerfirstname;
    }

    public String getCustomerlastname() {
        return customerlastname;
    }

    public void setCustomerlastname(String customerlastname) {
        this.customerlastname = customerlastname;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getPurchasetimedate() {
        return purchasetimedate;
    }

    public void setPurchasetimedate(String purchasetimedate) {
        this.purchasetimedate = purchasetimedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}


