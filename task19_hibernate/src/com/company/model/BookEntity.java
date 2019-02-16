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
@Table(name = "book", schema = "hibernate_library_db", catalog = "")
@IdClass(BookEntityPK.class)
public class BookEntity {

  private int id;
  private String nameAuthor;
  private String published;
  private int imdbId;
  private LibraryHasBookEntity libraryHasBookById;

  public BookEntity() {
  }

  public BookEntity(int id, String nameAuthor, String published, int imdbId) {
    this.id = id;
    this.nameAuthor = nameAuthor;
    this.published = published;
    this.imdbId = imdbId;
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
  @Column(name = "name_author")
  public String getNameAuthor() {
    return nameAuthor;
  }

  public void setNameAuthor(String nameAuthor) {
    this.nameAuthor = nameAuthor;
  }

  @Basic
  @Column(name = "published")
  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  @Id
  @Column(name = "imdb_id")
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
    BookEntity that = (BookEntity) o;
    return id == that.id &&
        imdbId == that.imdbId &&
        Objects.equals(nameAuthor, that.nameAuthor) &&
        Objects.equals(published, that.published);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nameAuthor, published, imdbId);
  }

  @Override
  public String toString() {
    return String.format("%-7d %-15s %-15s %s", id, nameAuthor, published, imdbId);
  }

  @ManyToOne
  @JoinColumn(name = "id", referencedColumnName = "book_id", nullable = false)
  public LibraryHasBookEntity getLibraryHasBookById() {
    return libraryHasBookById;
  }

  public void setLibraryHasBookById(LibraryHasBookEntity libraryHasBookById) {
    this.libraryHasBookById = libraryHasBookById;
  }
}
