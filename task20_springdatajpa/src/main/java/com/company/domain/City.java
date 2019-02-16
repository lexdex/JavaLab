package com.company.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id", nullable = false)
  private Long id;
  @Column(name = "city", nullable = false, length = 25)
  private String city;
  @OneToMany(mappedBy = "city")
  private List<Customer> customers;

  City(){}
  City(String city){
    this.city=city;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long idCity) {
    this.id = idCity;
  }

  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  public List<Customer> getCustomers() {
    return customers;
  }
  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    City that = (City) o;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (city != null ? !city.equals(that.city) : that.city != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }
}
