package com.ironhack.bootcamp.s08;

public class ObjectEqualityMain {

    public static void main(String[] args) {
        Name text = new Name("Toni");
//        Name text2 = new Name("Toni");
        String text2 = "Toni";

        if (text.equals(text2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }
}

class Name {
    String text;

    public Name(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Name name = (Name) obj;
        if (!this.text.equals(name.text)) {
            return false;
        }

        return true;
    }
}