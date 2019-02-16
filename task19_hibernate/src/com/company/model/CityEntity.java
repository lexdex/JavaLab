package com.company.model;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city", schema = "hibernate_library_db", catalog = "")
public class CityEntity {

  private int id;
  private String name;
  private Collection<LibraryEntity> librariesById;

  public CityEntity(){}
  public CityEntity(int id, String name){
    this.id = id;
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CityEntity that = (CityEntity) o;
    return id == that.id &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return String.format("%-5s %-15s %s", id, name);
  }

  @OneToMany(mappedBy = "cityByCityId")
  public Collection<LibraryEntity> getLibrariesById() {
    return librariesById;
  }

  public void setLibrariesById(Collection<LibraryEntity> librariesById) {
    this.librariesById = librariesById;
  }
}
