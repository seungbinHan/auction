import java.io.IOException;

public class Main {
  static Court court = new Court();
  static CreateRandomData createRandomData = new CreateRandomData();
  public static void main(String[] args) throws IOException {
//    court.auction();
    createRandomData.writeExcel(createRandomData.getRandomAuctionItemList());
    createRandomData.writeCsv(createRandomData.getRandomAuctionItemList());
  }
}