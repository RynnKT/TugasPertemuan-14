/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_14;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ridho
 */
@Entity
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByIdBooking", query = "SELECT b FROM Booking b WHERE b.idBooking = :idBooking"),
    @NamedQuery(name = "Booking.findByTanggal", query = "SELECT b FROM Booking b WHERE b.tanggal = :tanggal"),
    @NamedQuery(name = "Booking.findByLapangan", query = "SELECT b FROM Booking b WHERE b.lapangan = :lapangan"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_booking")
    private Integer idBooking;
    @Basic(optional = false)
    @Column(name = "tanggal")
    private String tanggal;
    @Basic(optional = false)
    @Column(name = "lapangan")
    private String lapangan;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan")
    @ManyToOne(optional = false)
    private Pelanggan idPelanggan;

    public Booking() {
    }

    public Booking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Booking(Integer idBooking, String tanggal, String lapangan) {
        this.idBooking = idBooking;
        this.tanggal = tanggal;
        this.lapangan = lapangan;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLapangan() {
        return lapangan;
    }

    public void setLapangan(String lapangan) {
        this.lapangan = lapangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pelanggan getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Pelanggan idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuan_13.Booking[ idBooking=" + idBooking + " ]";
    }
    
}
