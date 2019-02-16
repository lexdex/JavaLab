package com.company.parsers.jackson;

import com.company.model.Gem;
import com.company.model.GemParameters;
import com.company.parsers.JSONParser;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JACKSONGemParser extends JSONParser<Gem> {
    private List<Gem> gemList;

    @Override
    public void parse(File json) {
        try {
            getGemsWithJsonParser(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setElements(gemList);
    }

    private void getGemsWithJsonParser(File json) throws IOException {
        gemList = new ArrayList<>();
        JsonParser parser = new JsonFactory().createParser(json);
        Gem gem = new Gem();
        JsonToken token;
        while (!parser.isClosed()) {
            token = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(token)) {
                String field = parser.getCurrentName();
                parser.nextToken();
                switch (field) {
                    case Gem.NAME:
                        gem.setName(parser.getValueAsString());
                        break;
                    case Gem.ORIGIN:
                        gem.setOrigin(parser.getValueAsString());
                        break;
                    case Gem.VALUE:
                        gem.setValue(parser.getIntValue());
                        break;
                    case Gem.PRECIOUSNESS:
//                        gem.setPreciousness(Preciousness.PRECIOUS);
                        break;
                    case Gem.PARAMETERS:
                        gem.setParameters(getParameters(parser));
                        break;
                }
            } else if (JsonToken.END_OBJECT.equals(token)) {
                gemList.add(gem);
            }
        }

    }

    private GemParameters getParameters(JsonParser parser) throws IOException {
        JsonToken token = parser.nextToken();
        GemParameters parameters = new GemParameters();
        while (!JsonToken.END_OBJECT.equals(token)) {
            if (JsonToken.FIELD_NAME.equals(token)) {
                String name = parser.getCurrentName();
                parser.nextToken();
                switch (name) {
                    case GemParameters.COLOR:
                        parameters.setColor(parser.getValueAsString());
                        break;
                    case GemParameters.TRANSPARENCY:
                        parameters.setTransparency(parser.getIntValue());
                        break;
                    case GemParameters.FACES:
                        parameters.setFaces(parser.getIntValue());
                        break;
                }

            }
            token = parser.nextToken();
        }
        return parameters;
    }
}
