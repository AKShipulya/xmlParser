package com.akshipulya.xmlParser.model;

public class Tree extends Plant {

    public Tree(double height, String name) {
        super(height, name);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + getHeight() +
                ", name='" + getName() + '\'' +
                '}' + "\n";
    }
}
