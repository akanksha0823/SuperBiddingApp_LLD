import model.Buyer;
import model.Seller;
import repository.AuctionRepository;
import repository.BuyerRepository;
import repository.SellerRepository;
import service.BuyerService;
import service.SellerService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Buyer buyer1=new Buyer(1,"buyer1");
        Buyer buyer2=new Buyer(2,"buyer2");
        Buyer buyer3=new Buyer(3,"buyer3");

        Seller seller1=new Seller(1,"seller1");
        AuctionRepository auctionRepository=new AuctionRepository();
        BuyerRepository buyerRepository=new BuyerRepository();
        SellerRepository sellerRepository=new SellerRepository();

        BuyerService buyerService=new BuyerService();
        SellerService sellerService=new SellerService();
        buyerService.ADD_BUYER(buyer1);
        buyerService.ADD_BUYER(buyer2);
        buyerService.ADD_BUYER(buyer3);

        sellerService.ADD_SELLER(seller1);
        sellerService.CREATE_AUCTION(1,"A1",10,50,1);
        buyerService.CREATE_BID(1,1,17);
        buyerService.CREATE_BID(2,1,15);
        buyerService.UPDATE_BID(2,1,19);
        buyerService.CREATE_BID(3,1,19);
        sellerService.CLOSE_AUCTION(1);


         //case 2
        Seller seller2=new Seller(2,"seller2");
        sellerService.ADD_SELLER(seller2);
        sellerService.CREATE_AUCTION(2,"auction2",5,20,2);
        //buyerService.CREATE_BID(3,2,25);
        buyerService.CREATE_BID(2,2,5);
        buyerService.WITHDRAW_BID(2,2);
        sellerService.CLOSE_AUCTION(2);
        }
    }
