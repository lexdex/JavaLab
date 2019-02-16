package comparator;

import java.util.Comparator;



import model.Gem;

        import java.util.Comparator;

public class GemComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem g1, Gem g2) {
        return Integer.compare(g1.getValue(), g2.getValue());
    }
}
