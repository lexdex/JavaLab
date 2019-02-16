package com.company.parsers.GSON;

import com.company.model.Gem;
import com.company.model.GemParameters;
import com.company.parsers.JSONParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GSONGemParser extends JSONParser<Gem> {
    private List<Gem> gemList;

    @Override
    public void parse(File json) {
        gemList = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new FileReader(json));
            reader.beginArray();
            while (reader.hasNext()) {
                reader.beginObject();
                Gem gem = new Gem();
                while (reader.hasNext()) {
                    String name = reader.nextName();
                    switch (name) {
                        case Gem.NAME:
                            gem.setName(reader.nextString());
                            break;
                        case Gem.ORIGIN:
                            gem.setOrigin(reader.nextString());
                            break;
                        case Gem.VALUE:
                            gem.setValue(reader.nextInt());
                            break;
                        case Gem.PARAMETERS:
                            gem.setParameters(getGemParameters(reader));
                            break;
                        case Gem.PRECIOUSNESS:
                            gem.setPreciousness(Gem.Preciousness.valueOf(reader.nextString().toUpperCase()));
                            break;
                    }
                }
                reader.endObject();
                gemList.add(gem);
            }
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setElements(gemList);

    }

    private GemParameters getGemParameters(JsonReader reader) throws IOException {
        GemParameters parameters = new GemParameters();
        reader.beginObject();
        while (reader.hasNext()) {
            String nParameter = reader.nextName();
            switch (nParameter) {
                case GemParameters.COLOR:
                    parameters.setColor(reader.nextString());
                    break;
                case GemParameters.TRANSPARENCY:
                    parameters.setTransparency(reader.nextInt());
                    break;
                case GemParameters.FACES:
                    parameters.setFaces(reader.nextInt());
                    break;
            }
        }
        reader.endObject();
        return parameters;
    }
}
