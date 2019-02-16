package string.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private List<Object> objects = new ArrayList<>();

    public StringUtils add(Object obj){
        objects.add(obj);
        return this;
    }

    public String concat(){
        return objects.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
