package com.kostrych.model;

import com.kostrych.model.Annotation.Column;
import com.kostrych.model.Annotation.PrimaryKey;
import com.kostrych.model.Annotation.Table;

@Table(name = "Ticket")
public class TicketEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 20)
    private  String name;

    @Column(name = "surname", length = 20)
    private  String surname;

    @Column(name = "place", length = 5)
    private  String place;

    @Column(name = "price")
    private Integer price;

    @Column(name = "theatre_id")
    private Integer theatre_id;

    public TicketEntity(Integer id, String name, String surname, String place, Integer price, Integer theatre_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.place = place;
        this.price = price;
        this.theatre_id = theatre_id;
    }

    public TicketEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(Integer theatre_id) {
        this.theatre_id = theatre_id;
    }
}
