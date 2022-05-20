import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import dto.AuctionItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateRandomData {

  java.util.Random random = new java.util.Random();

  public void writeExcel(List<AuctionItem> list) throws IOException {
    int index = 1;
    //워크북 생성
    Workbook workbook = new XSSFWorkbook();
    //시트생성
    Sheet sheet = workbook.createSheet("auctionItem");
    //로우 생성
    Row header = sheet.createRow(0);
    //로우에 cell set
    Cell headerCell = header.createCell(0);
    headerCell.setCellValue("appraisedPrice");
    headerCell = header.createCell(1);
    headerCell.setCellValue("miscarryCount");
    headerCell = header.createCell(2);
    headerCell.setCellValue("minimumPrice");
    headerCell = header.createCell(3);
    headerCell.setCellValue("deposit");
    headerCell = header.createCell(4);
    headerCell.setCellValue("name");
    headerCell = header.createCell(5);
    headerCell.setCellValue("collateralDate");
    headerCell = header.createCell(6);
    headerCell.setCellValue("collateralPrice");
    headerCell = header.createCell(7);
    headerCell.setCellValue("occupyDeposit");
    headerCell = header.createCell(8);
    headerCell.setCellValue("occupyDate");
    headerCell = header.createCell(9);
    headerCell.setCellValue("confirmationDate");

    for (AuctionItem item : list) {
      Row row = sheet.createRow(index);
      Cell cell = row.createCell(0);
      cell.setCellValue(item.getAppraisedPrice());
      cell = row.createCell(1);
      cell.setCellValue(item.getMiscarryCount());
      cell = row.createCell(2);
      cell.setCellValue(item.getMinimumPrice());
      cell = row.createCell(3);
      cell.setCellValue(item.getDeposit());
      cell = row.createCell(4);
      cell.setCellValue(item.getName());
      cell = row.createCell(5);
      cell.setCellValue(item.getCollateralDate().toString());
      cell = row.createCell(6);
      cell.setCellValue(item.getCollateralPrice());
      cell = row.createCell(7);
      cell.setCellValue(item.getOccupyDeposit());
      cell = row.createCell(8);
      cell.setCellValue(item.getOccupyDate().toString());
      cell = row.createCell(9);
      cell.setCellValue(item.getConfirmationDate().toString());
      index++;
    }

    FileOutputStream outputStream = new FileOutputStream("./temp2.xlsx");
    workbook.write(outputStream);
    workbook.close();
  }

  public List<AuctionItem> getRandomAuctionItemList() {
    List<AuctionItem> itemList = new ArrayList<>();
    byte[] array = new byte[7]; // length is bounded by 7
    for (int i = 0; i < 2000; i++) {
      random.nextBytes(array);
      itemList.add(
          AuctionItem.builder()
              .appraisedPrice(random.nextInt())
              .miscarryCount(random.nextInt())
              .minimumPrice(random.nextInt())
              .deposit(random.nextInt())
              .name(new String(array, Charset.forName("UTF-8")))
              .collateralDate(LocalDate.of(1234, 12, 12))
              .collateralPrice(random.nextInt())
              .occupyDeposit(random.nextInt())
              .occupyDate(LocalDate.of(1234, 12, 12))
              .confirmationDate(LocalDate.of(1234, 12, 12))
              .build()
      );
    }
    return itemList;
  }

  public void writeCsv(List<AuctionItem> list){

    File file = new File("./", "test2.csv");
    try (
        FileOutputStream fos = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
    ) {
      StatefulBeanToCsv<AuctionItem> csvWriter = new StatefulBeanToCsvBuilder<AuctionItem>(writer)
          .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
          .withQuotechar(CSVWriter.DEFAULT_QUOTE_CHARACTER)
          .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
          .withLineEnd(CSVWriter.DEFAULT_LINE_END)
          .withOrderedResults(false)
          .build();
      csvWriter.write(list);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
