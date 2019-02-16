package com.company.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class BookEntityPK implements Serializable {

  private int id;
  private int imdbId;

  @Column(name = "id")
  @Id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "imdb_id")
  @Id
  public int getImdbId() {
    return imdbId;
  }

  public void setImdbId(int imdbId) {
    this.imdbId = imdbId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookEntityPK that = (BookEntityPK) o;
    return id == that.id &&
        imdbId == that.imdbId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, imdbId);
  }
}
