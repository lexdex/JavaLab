package com.company.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class LibraryEntityPK implements Serializable {

  private int id;
  private int cityId;

  @Column(name = "id")
  @Id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "city_id")
  @Id
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
    LibraryEntityPK that = (LibraryEntityPK) o;
    return id == that.id &&
        cityId == that.cityId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cityId);
  }
}
