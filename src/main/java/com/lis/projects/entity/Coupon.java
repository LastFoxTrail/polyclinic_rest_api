package com.lis.projects.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Coupon entity class for working with user coupons
 * @autor LastFoxTrail
 * @version 1.0
 */
@Entity
@Table(name = "coupons")
public class Coupon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_receipt")
    private Date dateOfReceipt;

    @Column(name = "time_of_receipt")
    private Time timeOfReceipt;

    @Column(name = "parlor")
    private int parlor;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private double price;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "diagnostic_id")
    private TypeOfDiagnostic typeOfDiagnostic;

    public Coupon() {
    }

    public Coupon(Date dateOfReceipt,
                  String timeOfReceipt,
                  int parlor,
                  String address,
                  double price,
                  Patient patient) {

        this.dateOfReceipt = dateOfReceipt;
        this.timeOfReceipt = Time.valueOf(timeOfReceipt);
        this.parlor = parlor;
        this.address = address;
        this.price = price;
        this.patient = patient;
    }

    public Coupon(Date dateOfReceipt,
                  String timeOfReceipt,
                  int parlor,
                  String address,
                  double price,
                  Patient patient,
                  Doctor doctor,
                  Department department,
                  TypeOfDiagnostic typeOfDiagnostic) {

        this.dateOfReceipt = dateOfReceipt;
        this.timeOfReceipt = Time.valueOf(timeOfReceipt);
        this.parlor = parlor;
        this.address = address;
        this.price = price;
        this.patient = patient;
        this.doctor = doctor;
        this.department = department;
        this.typeOfDiagnostic = typeOfDiagnostic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Time getTimeOfReceipt() {
        return timeOfReceipt;
    }

    public void setTimeOfReceipt(String timeOfReceipt) {
        this.timeOfReceipt = Time.valueOf(timeOfReceipt);
    }

    public int getParlor() {
        return parlor;
    }

    public void setParlor(int parlor) {
        this.parlor = parlor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public TypeOfDiagnostic getTypeOfDiagnostic() {
        return typeOfDiagnostic;
    }

    public void setTypeOfDiagnostic(TypeOfDiagnostic typeOfDiagnostic) {
        this.typeOfDiagnostic = typeOfDiagnostic;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", dateOfReceipt=" + dateOfReceipt +
                ", timeOfReceipt=" + timeOfReceipt +
                ", parlor=" + parlor +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", patient=" + patient.getFirstName() +
                ", doctor=" + doctor.getFirstName() +
                ", department=" + department.getName() +
                ", typeOfDiagnostic=" + typeOfDiagnostic.getTypeName() +
                '}';
    }
}
