package com.company.DTO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.company.controller.CustomerController;
import com.company.domain.Book;
import com.company.exceptions.NoSuchBookException;
import com.company.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class BookDTO extends ResourceSupport {
    Book book;
    public BookDTO(Book book, Link selfLink) throws NoSuchBookException, NoSuchCustomerException {
        this.book=book;
        add(selfLink);
        add(linkTo(methodOn(CustomerController.class).getCustomersByBookID(book.getId())).withRel("customers"));
    }

    public Long getBookId() {
        return book.getId();
    }

    public String getBookName() {
        return book.getBookName();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getPublisher() {
        return book.getPublisher();
    }

    public Integer getImprintYear() {
        return book.getImprintYear();
    }

    public Integer getAmount() {
        return book.getAmount();
    }
}
