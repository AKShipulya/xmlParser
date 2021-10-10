package com.akshipulya.xmlParser.parser;

import java.util.List;

public interface Parser<T> {

    List<T> parse(String pathToFile);

}
