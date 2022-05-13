package common;

import dto.AuctionItem;
import dto.Bidder;
import java.util.List;

public class Utils {

  public static Bidder getSuccessBidder(List<Bidder> bidderList, AuctionItem auctionItem) {
    Bidder temp = null;

    for (Bidder item: bidderList) {
      if(auctionItem.getDeposit() > item.getDeposit()){
        System.out.println(item.getName()+"님은 보증금을 잘못내셔서 무효처리하겠습니다.");
        continue;
      }
      if(auctionItem.getMinimumPrice() > item.getBidAmount()){
        System.out.println(item.getName()+"님은 입찰가를 잘못적으셨습니다.");
        continue;
      }
      if(temp == null){
        temp = item;
      }
      if(temp == null){
        return null;
      }
      if (temp.getBidAmount() < item.getBidAmount()){
        temp = item;
      }
    }
    return temp;
  }

  public static int setBenefit(Bidder successBidder,AuctionItem auctionItem){
    if(auctionItem.getCollateralDate().isAfter(auctionItem.getOccupyDate())) {
      System.out.println("...임차인 보증금 인수...");
      return auctionItem.getAppraisedPrice() - successBidder.getBidAmount() - auctionItem.getOccupyDeposit();
    }
    return auctionItem.getAppraisedPrice() - successBidder.getBidAmount();
  }
}
