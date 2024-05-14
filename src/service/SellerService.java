package service;

import model.Auction;
import model.Buyer;
import model.Seller;
import repository.AuctionRepository;
import repository.BuyerRepository;
import repository.SellerRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SellerService {
     /*
    ADD_SELLER
    CREATE_AUCTION
    CLOSE_AUCTION
     */

    Map<Integer, Seller> sellerList= SellerRepository.getSellerList();
    Map<Integer, Buyer> buyerList= BuyerRepository.getBuyerList();
    Map<Integer, Auction> auctionList= AuctionRepository.getAuctionList();
    Map<Integer, Set<Integer>> sellerAuctionMap= SellerRepository.getSellerAuctionMap();

    public void ADD_SELLER(Seller seller){
        if(sellerList.containsKey(seller.getId()))
            throw new RuntimeException("seller already exists");
        sellerList.put(seller.getId(),seller);
        System.out.println(seller.getName()+" created");
    }
    public void CREATE_AUCTION(int auctionId, String auctionName,int minBid,int maxBid,int sellerId){
        if (!sellerList.containsKey(sellerId)){
            throw new RuntimeException("invalid Seller");
        }
        Seller seller=sellerList.get(sellerId);

        Auction auction=new Auction(auctionId,auctionName,minBid,maxBid,seller.getName(),true);
        auctionList.put(auctionId,auction);
        Set<Integer> auctions=sellerAuctionMap.get(sellerId);
        if(auctions==null)
            auctions=new HashSet<>();
        auctions.add(auction.getId());
    }
    public void CLOSE_AUCTION(int auctionId){
        if(!auctionList.containsKey(auctionId))
            throw new RuntimeException("invalid auction");
        Auction auction=auctionList.get(auctionId);

        String winner=getAuctionWinner(auctionId);

        System.out.println(winner+" IS WINNER");
        auctionList.remove(auction);

    }

    private String getAuctionWinner(int auctionId) {
        if(!auctionList.containsKey(auctionId))
            throw new RuntimeException("invalid auction");
        Auction auction=auctionList.get(auctionId);

        //max-unique
        //bid frequency map
        Map<Integer,Integer> buyerBidderMap=auction.getBuyerBidMap();
        Map<Integer,Integer> bidFrequencyMap=new HashMap<>();

        //building frquncy map
        for(Map.Entry<Integer,Integer> entry: buyerBidderMap.entrySet()){
             bidFrequencyMap.put(entry.getValue(), bidFrequencyMap.getOrDefault(entry.getValue(),0)+1);
        }

        int maxBid=Integer.MIN_VALUE;
        String auctionWinner="NONE";
        int f=0;

        for (Map.Entry<Integer,Integer> entry : bidFrequencyMap.entrySet()){
            if (entry.getValue()==1){
                if(entry.getKey()>maxBid) {
                    maxBid = entry.getKey();
                    f=1;
                }
            }
        }
        //
        int winnerId=0;
        if (f==0)
            throw new RuntimeException("NO Winner");
        else {
            for (Map.Entry<Integer,Integer> entry : buyerBidderMap.entrySet()){
                if (entry.getValue()==maxBid){
                    winnerId= entry.getKey();
                    break;
                }
            }
        }
        //
        return buyerList.get(winnerId).getName();

    }

}
