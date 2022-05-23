package service;

import dto.AuctionItem;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {


  public void writeExcel(List<AuctionItem> list, String fileName) {
    int index = 1;
    //워크북 생성
    try(Workbook workbook = new XSSFWorkbook();
        FileOutputStream outputStream = new FileOutputStream("./"+fileName+".xlsx")
    ) {
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
      workbook.write(outputStream);
    }catch (IOException e){
      e.printStackTrace();
    }
  }


}
