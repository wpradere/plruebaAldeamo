package com.aldeamo.prueba.model;


import javax.persistence.*;

@Entity
@Table(name = "bartender")
public class BarTentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_array", unique = true)
    private String imput;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImput() {
        return imput;
    }

    public void setImput(String imput) {
        this.imput = imput;
    }
}
