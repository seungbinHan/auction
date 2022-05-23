import dto.AuctionItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateRandomData {

  public static  List<AuctionItem> getRandomAuctionItemList() {
    java.util.Random random = new java.util.Random();
    List<AuctionItem> itemList = new ArrayList<>();

    for (int i = 0; i < 2000; i++) {
      itemList.add(
          AuctionItem.builder()
              .appraisedPrice(random.nextInt())
              .miscarryCount(random.nextInt())
              .minimumPrice(random.nextInt())
              .deposit(random.nextInt())
              .name(getRandomString(15))
              .collateralDate(LocalDate.of(random.nextInt(10)+2013, random.nextInt(12)+1, random.nextInt(28)+1))
              .collateralPrice(random.nextInt())
              .occupyDeposit(random.nextInt())
              .occupyDate(LocalDate.of(random.nextInt(10)+2013, random.nextInt(12)+1, random.nextInt(28)+1))
              .confirmationDate(LocalDate.of(random.nextInt(10)+2013, random.nextInt(12)+1, random.nextInt(28)+1))
              .build()
      );
    }
    return itemList;
  }

  public static String getRandomString(int i)
  {
    String theAlphaNumericS;
    StringBuilder builder;

    theAlphaNumericS = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ가나다라마사아자차카타파하기니디리미비시이지치키티피히"
        + "0123456789";

    //create the StringBuffer
    builder = new StringBuilder(i);

    for (int m = 0; m < i; m++) {
      // generate numeric
      int myindex = (int)(theAlphaNumericS.length() * Math.random());

      // add the characters
      builder.append(theAlphaNumericS.charAt(myindex));
    }
    return builder.toString();
  }


}
