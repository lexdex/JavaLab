package com.company.parsers.json_simple;

import com.company.model.Gem;
import com.company.model.GemParameters;
import com.company.parsers.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONSimpleGemParser extends JSONParser<Gem> {

    public void parse(File json) {
        List<Gem> gemList = new ArrayList<>();
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object object = parser.parse(new FileReader(json));
            JSONArray jsonArray = (JSONArray) object;
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                gemList.add(createGem(jsonObject));
            }
            setElements(gemList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    private Gem createGem(JSONObject jsonObject) {
        Gem gem = new Gem();
        String name = (String) jsonObject.get("name");
        String origin = (String) jsonObject.get("origin");
        Integer value = ((Long) jsonObject.get("value")).intValue();
        Gem.Preciousness preciousness = Gem.Preciousness.valueOf(((String)jsonObject.get("preciousness")).toUpperCase());
        GemParameters parameters = getParameters(jsonObject);
        gem.setName(name);
        gem.setOrigin(origin);
        gem.setValue(value);
        gem.setPreciousness(preciousness);
        gem.setParameters(parameters);
        return gem;
    }

    private GemParameters getParameters(JSONObject jsonObject) {
        GemParameters parameters = new GemParameters();
        JSONObject params =(JSONObject) jsonObject.get("parameters");
        String color = (String) params.get("color");
        Integer transparency = ((Long) params.get("transparency")).intValue();
        Integer faces = ((Long) params.get("faces")).intValue();
        parameters.setColor(color);
        parameters.setFaces(faces);
        parameters.setTransparency(transparency);
        return parameters;
    }
}
