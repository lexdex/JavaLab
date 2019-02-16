package com.company.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library", schema = "hibernate_library_db", catalog = "")
@IdClass(LibraryEntityPK.class)
public class LibraryEntity {

  private int id;
  private String name;
  private int books;
  private int magazines;
  private double popularity;
  private int cityId;
  private CityEntity cityByCityId;
  private LibraryHasBookEntity libraryHasBookById;

  public LibraryEntity(){}

  public LibraryEntity(Integer id, String name, Integer books, Integer magazines, Double popularity, Integer city_id) {
    this.id = id;
    this.name = name;
    this.books = books;
    this.magazines = magazines;
    this.popularity = popularity;
    this.cityId = city_id;
  }

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "books")
  public int getBooks() {
    return books;
  }

  public void setBooks(int books) {
    this.books = books;
  }

  @Basic
  @Column(name = "magazines")
  public int getMagazines() {
    return magazines;
  }

  public void setMagazines(int magazines) {
    this.magazines = magazines;
  }

  @Basic
  @Column(name = "popularity")
  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  @Id
  @Column(name = "city_id")
  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryEntity that = (LibraryEntity) o;
    return id == that.id &&
        books == that.books &&
        magazines == that.magazines &&
        Double.compare(that.popularity, popularity) == 0 &&
        cityId == that.cityId &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, books, magazines, popularity, cityId);
  }

  @Override
  public String toString() {
    return String
        .format("%-11s %-15s %-5d %-5d %-15d %d", id, name, books, magazines, popularity);
  }

  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
  public CityEntity getCityByCityId() {
    return cityByCityId;
  }

  public void setCityByCityId(CityEntity cityByCityId) {
    this.cityByCityId = cityByCityId;
  }

  @ManyToOne
  @JoinColumn(name = "id", referencedColumnName = "library_id", nullable = false)
  public LibraryHasBookEntity getLibraryHasBookById() {
    return libraryHasBookById;
  }

  public void setLibraryHasBookById(LibraryHasBookEntity libraryHasBookById) {
    this.libraryHasBookById = libraryHasBookById;
  }
}
