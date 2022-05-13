import common.Utils;
import dto.AuctionItem;
import dto.Bidder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Court {

  AuctionItem auctionItem = AuctionItem.builder()
      .appraisedPrice(200000000)
      .miscarryCount(2)
      .minimumPrice(120000000)
      .deposit(12000000)
      .name("고도빌리지 303호")
      .collateralDate(LocalDate.of(2023,12,12))
      .collateralPrice(80000000)
      .occupyDeposit(60000000)
      .occupyDate(LocalDate.of(2022,3,16))
      .confirmationDate(LocalDate.of(2022,3,16))
      .build();

  Bidder bidder1 = Bidder.builder()
      .name("한경매")
      .deposit(12000000)
      .bidAmount(140000000)
      .build();
  Bidder bidder2 = Bidder.builder()
      .name("김경매")
      .deposit(12000000)
      .bidAmount(150000000)
      .build();
  Bidder bidder3 = Bidder.builder()
      .name("박경매")
      .deposit(12000000)
      .bidAmount(140000000)
      .build();
  Bidder bidder4 = Bidder.builder()
      .name("김초보")
      .deposit(1200000)
      .bidAmount(10000000)
      .build();

  public void auction() {
    System.out.println("집행관 : 지금부터 " + auctionItem.getName() + "건에 대한 경매를 시작하겠습니다.");

    List<Bidder> bidders = new ArrayList<>();
    bidders.add(bidder1);
    bidders.add(bidder2);
    bidders.add(bidder3);
    bidders.add(bidder4);

    System.out.println("지금부터 입찰가를 공개하겠습니다.");
    for (Bidder item : bidders) {
      System.out.println(item.getName() + "님의 입찰가는" + item.getBidAmount() + "입니다");
    }

    Bidder successBidder = Utils.getSuccessBidder(bidders, auctionItem);
    if(successBidder == null){
      System.out.println("이번 건은 낙찰자가 없으므로 유찰되었습니다.");
      return;
    }
    System.out.println(successBidder.getName() + "님이 최고가 매수인으로 낙찰되었습니다.");
    successBidder.setSuccessfulBid(true);

    successBidder.setBenefit(Utils.setBenefit(successBidder, auctionItem));

    if(successBidder.getBenefit() >= 0){
      System.out.println(successBidder.getName() + " : 감정가보다 "+successBidder.getBenefit()+"원 싸게샀다! 대박!!");
    }else{
      System.out.println(successBidder.getName() + ": 감정가보다 "+successBidder.getBenefit() * -1 +"원 비싸게샀다! 이런!!");
    }
  }

}