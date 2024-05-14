package repository;

import model.Auction;
import model.Seller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SellerRepository {
    static Map<Integer, Seller> sellerList;
    static Map<Integer, Set<Integer>> sellerAuctionMap;

    public SellerRepository() {
        sellerList = new HashMap<>();;
        sellerAuctionMap =new HashMap<>();
    }

    public static Map<Integer, Seller> getSellerList() {
        return sellerList;
    }
    public static Map<Integer, Set<Integer>> getSellerAuctionMap() {
        return sellerAuctionMap;
    }
}
