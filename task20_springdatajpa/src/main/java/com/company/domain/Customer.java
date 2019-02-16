package com.company.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id", nullable = false)
  private Long id;
  @Column(name = "surname", nullable = false, length = 25)
  private String surname;
  @Column(name = "name", nullable = false, length = 25)
  private String name;
  @Column(name = "email", nullable = true, length = 45)
  private String email;
  @Column(name = "street", nullable = true, length = 30)
  private String street;
  @Column(name = "apartment", nullable = true, length = 10)
  private String apartment;
  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "city_id")
  private City city;
  @ManyToMany
  @JoinTable(name = "customer_book",
      joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false))
  private Set<Book> books;

  Customer(){}
  Customer(String surname, String name, String email, String street, String apartment){
    this.surname=surname;
    this.name=name;
    this.email=email;
    this.street=street;
    this.apartment=apartment;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long idCustomer) {
    this.id = idCustomer;
  }

  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }

  public String getApartment() {
    return apartment;
  }
  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  public City getCity() {
    return city;
  }
  public void setCity(City city) {
    this.city = city;
  }

  public Set<Book> getBooks() {
    return books;
  }
  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer that = (Customer) o;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (street != null ? !street.equals(that.street) : that.street != null) return false;
    if (apartment != null ? !apartment.equals(that.apartment) : that.apartment != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
    return result;
  }
}
