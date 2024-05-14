package repository;

import model.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionRepository {
    static Map<Integer, Auction> auctionList;

    public AuctionRepository() {
        auctionList =new HashMap<>();
    }
    public static Map<Integer, Auction> getAuctionList() {
        return auctionList;
    }

}
