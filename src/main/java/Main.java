import service.CsvService;
import service.ExcelService;

public class Main {
  static Court court = new Court();
  static ExcelService excelService = new ExcelService();
  static CsvService csvService = new CsvService();

  static CreateRandomData createRandomData = new CreateRandomData();


  public static void main(String[] args) throws Exception {
//    court.auction();
    excelService.writeExcel(createRandomData.getRandomAuctionItemList(),"test");
    csvService.writeCsv(createRandomData.getRandomAuctionItemList(),"test");
  }
}