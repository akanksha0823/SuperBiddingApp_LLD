package repository;

import model.Auction;
import model.Buyer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BuyerRepository {
    static  Map<Integer,Buyer> buyers;
    static Map<Integer, Set<Integer>> buyerAuctionMap;

    public BuyerRepository() {
        buyers = new HashMap<>();
        buyerAuctionMap = new HashMap<>();
    }

    public static Map<Integer,Buyer> getBuyerList() {
        return buyers;
    }

    public static Map<Integer, Set<Integer>> getBuyerAuctionMap() {
        return buyerAuctionMap;
    }
}
