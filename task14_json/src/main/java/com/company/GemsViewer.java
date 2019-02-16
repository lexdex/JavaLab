package com.company;

import com.company.comparator.GemComparator;
import com.company.menu.Command;
import com.company.model.Gem;
import com.company.parsers.JSONParser;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class GemsViewer implements Command {
    private JSONParser parser;
    private File json;
    private Comparator<Gem> comparator;


    public GemsViewer(JSONParser parser, GemComparator gemComparator, File json) {
        this.parser = parser;
        this.json = json;
        this.comparator = gemComparator;
    }

    public void execute() {
        parser.parse(json);
        view(parser.getElements());
    }
    private void view(List<Gem> elements){
        elements.sort(comparator);
        for(Object gem : elements) {
            System.out.println(gem);
        }
    }
}
