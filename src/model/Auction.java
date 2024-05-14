package model;

import java.util.HashMap;

public class Auction {
    private final int id;
    private final String name;
    private final int minVal;
    private final int maxVal;
    private final String seller;
    boolean isActive;
    HashMap<Integer, Integer> buyerBidMap;

    public Auction(int id, String name, int minVal, int maxVal, String seller, boolean isActive) {
        this.id = id;
        this.name = name;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.seller = seller;
        this.isActive = isActive;
        buyerBidMap=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinVal() {
        return minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }

    public String getSeller() {
        return seller;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public HashMap<Integer, Integer> getBuyerBidMap() {
        return buyerBidMap;
    }

    public void setBuyerBidMap(HashMap<Integer, Integer> buyerBidMap) {
        this.buyerBidMap = buyerBidMap;
    }
}
