package com.lis.projects.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 * TypeOfDiagnostic entity class for describing the provided service
 * @autor LastFoxTrail
 * @version 1.0
 */
@Entity
@Table(name = "types_of_diagnostics")
public class TypeOfDiagnostic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public TypeOfDiagnostic() {
    }

    public TypeOfDiagnostic(String typeName, String description, double price) {
        this.typeName = typeName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TypeOfDiagnostic{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfDiagnostic that = (TypeOfDiagnostic) o;
        return Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
}
