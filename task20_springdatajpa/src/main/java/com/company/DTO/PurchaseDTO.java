package com.company.DTO;

import com.company.domain.Purchase;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class PurchaseDTO extends ResourceSupport {
  Purchase purchase;
  public PurchaseDTO(Purchase purchase, Link selfLink) {
    this.purchase=purchase;
    add(selfLink);
  }

  public Long getPurchaseId() {
    return purchase.getId();
  }

  public String getCustomer() {
    return purchase.getCustomer();
  }

  public String getBook() {
    return purchase.getBook();
  }

  public String getAction() {
    return purchase.getAction();
  }

  public String getUser() {
    return purchase.getUser();
  }

  public String getTime() {
    return purchase.getTimeStamp().toString();
  }
}
