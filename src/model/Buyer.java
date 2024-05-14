package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {
    private final int id;
    private final String name;

    public Buyer(int id, String name) {
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
