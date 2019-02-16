package com.company.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "purchase")
public class Purchase {
  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "purchase_id", nullable = false)
  private Long id;
  @Column(name = "customer", nullable = false, length = 50)
  private String customer;
  @Column(name = "book", nullable = false, length = 90)
  private String book;
  @Column(name = "Action", nullable = false, length = 10)
  private String action;
  @Column(name = "time_stamp", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date timeStamp;
  @Column(name = "user", nullable = true, length = 50)
  private String user;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomer() {
    return customer;
  }
  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getBook() {
    return book;
  }
  public void setBook(String book) {
    this.book = book;
  }

  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }
  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Purchase that = (Purchase) o;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
    if (book != null ? !book.equals(that.book) : that.book != null) return false;
    if (action != null ? !action.equals(that.action) : that.action != null) return false;
    if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
    if (user != null ? !user.equals(that.user) : that.user != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (customer != null ? customer.hashCode() : 0);
    result = 31 * result + (book != null ? book.hashCode() : 0);
    result = 31 * result + (action != null ? action.hashCode() : 0);
    result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
    result = 31 * result + (user != null ? user.hashCode() : 0);
    return result;
  }
}
