package com.company.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class LibraryHasBookEntityPK implements Serializable {

  private int libraryId;
  private int bookId;

  @Column(name = "library_id")
  @Id
  public int getLibraryId() {
    return libraryId;
  }

  public void setLibraryId(int libraryId) {
    this.libraryId = libraryId;
  }

  @Column(name = "book_id")
  @Id
  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryHasBookEntityPK that = (LibraryHasBookEntityPK) o;
    return libraryId == that.libraryId &&
        bookId == that.bookId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(libraryId, bookId);
  }
}
