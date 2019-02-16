package com.company.parsers;

import java.io.File;
import java.util.List;

public abstract class JSONParser<T> {
   private List<T> elements;


    public List<T> getElements(){
        return elements;
    }

    public void setElements(List<T> elements){
        this.elements = elements;
    }
   public abstract void parse(File json);
}
