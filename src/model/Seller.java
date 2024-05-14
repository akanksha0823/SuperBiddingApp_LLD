package model;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private final int id;
    private final String name;

    public Seller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
