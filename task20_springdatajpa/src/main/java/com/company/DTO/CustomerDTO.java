package com.company.DTO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.company.controller.BookController;
import com.company.domain.Customer;
import com.company.exceptions.NoSuchBookException;
import com.company.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class CustomerDTO extends ResourceSupport {
    Customer customer;
    public CustomerDTO(Customer customer, Link selfLink) throws NoSuchCustomerException, NoSuchBookException {
        this.customer=customer;
        add(selfLink);
        add(linkTo(methodOn(BookController.class).getBooksByCustomerID(customer.getId())).withRel("books"));
    }

    public Long getCustomerId() {
        return customer.getId();
    }

    public String getSurname() {
        return customer.getSurname();
    }

    public String getName() {
        return customer.getName();
    }

    public String getEmail() {
        return customer.getEmail();
    }

    public String getCity() {
        if(customer.getCity()==null) return "";
        return customer.getCity().getCity();
    }

    public String getStreet() {
        return customer.getStreet();
    }

    public String getApartment() {
        return customer.getApartment();
    }
}
