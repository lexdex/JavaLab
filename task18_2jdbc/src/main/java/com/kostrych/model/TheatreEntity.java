package com.kostrych.model;

import com.kostrych.model.Annotation.Column;
import com.kostrych.model.Annotation.PrimaryKey;
import com.kostrych.model.Annotation.Table;

@Table(name = "Theatre")
public class TheatreEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "address", length = 10)
    private  String address;

    public TheatreEntity(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public TheatreEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddres() {
        return address;
    }

    public void setAddres(String address) {
        this.address = address;
    }
}
