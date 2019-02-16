package com.company.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "library_has_book", schema = "hibernate_library_db", catalog = "")
@IdClass(LibraryHasBookEntityPK.class)
public class LibraryHasBookEntity {

  private int libraryId;
  private int bookId;

  public LibraryHasBookEntity(){}
  public LibraryHasBookEntity(int libraryId, int bookId){
    this.libraryId = libraryId;
    this.bookId = bookId;
  }

  @Id
  @Column(name = "library_id")
  public int getLibraryId() {
    return libraryId;
  }

  public void setLibraryId(int libraryId) {
    this.libraryId = libraryId;
  }

  @Id
  @Column(name = "book_id")
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
    LibraryHasBookEntity that = (LibraryHasBookEntity) o;
    return libraryId == that.libraryId &&
        bookId == that.bookId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(libraryId, bookId);
  }
}
