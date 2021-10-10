package com.akshipulya.xmlParser.model;

public class Bush extends Plant {

    public Bush(double height, String name) {
        super(height, name);
    }

    @Override
    public String toString() {
        return "Bush{" +
                "height=" + getHeight() +
                ", name='" + getName() + '\'' +
                '}' + "\n";
    }
}
