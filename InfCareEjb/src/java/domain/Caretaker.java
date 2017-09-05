/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

/**
 *
 * @author Ada
 */
@Entity
public class Caretaker implements Serializable {

    @XmlInverseReference(mappedBy = "ct")
    @OneToMany//(mappedBy = "caretaker")
    private List<Visit> visits;

    @XmlInverseReference(mappedBy = "ct")
    @OneToMany
    private List<TimeReference> timeReference;

    public List<TimeReference> getTimeReference() {
        return timeReference;
    }

    public void setTimeReference(List<TimeReference> timeReference) {
        this.timeReference = timeReference;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    private String email;

    private String username;

    private String password;

//    public Caretaker(String firstName, String lastName, String email, String username, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caretaker)) {
            return false;
        }
        Caretaker other = (Caretaker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Caretaker[ id=" + id + " ]";
    }

}
