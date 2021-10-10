package com.akshipulya.xmlParser.xmlHandler.parser;

import java.util.List;

public interface Parser<T> {

    List<T> parse(String pathToFile);

}
