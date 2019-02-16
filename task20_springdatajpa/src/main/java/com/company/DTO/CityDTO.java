package com.company.DTO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.company.controller.CustomerController;
import com.company.domain.City;
import com.company.exceptions.NoSuchBookException;
import com.company.exceptions.NoSuchCityException;
import com.company.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class CityDTO extends ResourceSupport {
    City city;
    public CityDTO(
        City city, Link selfLink) throws NoSuchCustomerException, NoSuchBookException, NoSuchCityException {
        this.city=city;
        add(selfLink);
        add(linkTo(methodOn(CustomerController.class).getCustomersByCityID(city.getId())).withRel("customers"));
    }

    public Long getCityId() { return city.getId(); }

    public String getCity() {
        return city.getCity();
    }
}
