package service;

import model.Auction;
import model.Buyer;
import repository.AuctionRepository;
import repository.BuyerRepository;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuyerService {
       /*
    ADD_BUYER
    CREATE_BID
    WITHDRAW_BID
    UPDATE_BID
     */
    Map<Integer, Buyer> buyerList= BuyerRepository.getBuyerList();
    Map<Integer, Auction> auctionList= AuctionRepository.getAuctionList();
    Map<Integer, Set<Integer>> buyerAuctionMap= BuyerRepository.getBuyerAuctionMap();
    public void ADD_BUYER(Buyer buyer){
        if(buyerList.containsKey(buyer.getId()))
            throw new RuntimeException("buyer already exists");
        buyerList.put(buyer.getId(),buyer);
        System.out.println(buyer.getName()+" created");
    }

    public void CREATE_BID(int buyerId,int auctionId,int bidAmount){
        Auction auction=auctionList.get(auctionId);
        if(!auction.isActive())
            throw  new RuntimeException("NO Auction Found");
        if (bidAmount<auction.getMinVal() || bidAmount>auction.getMaxVal())
            throw new RuntimeException("Bid AMount Not in Range");
        if(buyerAuctionMap.containsKey(buyerId) && buyerAuctionMap.get(buyerId).contains(auctionId))
            throw new RuntimeException("Bid already created... can only update now");
        auction.getBuyerBidMap().put(buyerId,bidAmount);
        Set<Integer> auctions=buyerAuctionMap.get(buyerId);
        if(auctions==null)
            auctions=new HashSet<>();
        auctions.add(auction.getId());
        buyerAuctionMap.put(buyerId,auctions);

    }

    public void WITHDRAW_BID(int buyerId,int auctionId){
        Auction auction=auctionList.get(auctionId);
        if(!auction.isActive())
            throw  new RuntimeException(" Auction IS Closed");
        auction.getBuyerBidMap().remove(buyerId);
        Set<Integer> auctions=buyerAuctionMap.get(buyerId);
        auctions.remove(auction.getId());
    }

    public void UPDATE_BID(int buyerId,int auctionId,int bidAmount){
        Auction auction=auctionList.get(auctionId);
        if(!auction.isActive())
            throw  new RuntimeException(" Auction IS Closed");
        if (bidAmount<auction.getMinVal() || bidAmount>auction.getMaxVal())
            throw new RuntimeException("Bid AMount Not in Range...cannot update");
        auction.getBuyerBidMap().put(buyerId,bidAmount);

    }
}
