package com.company.comparator;

import com.company.model.Gem;

import java.util.Comparator;

public class GemComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem o1, Gem o2) {
        return o1.compareTo(o2);
    }
}
