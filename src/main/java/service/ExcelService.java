package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {

  public <T> void writeExcel(List<T> list, String fileName) throws Exception{

    int index = 0;
    int index2;

    try(Workbook workbook = new XSSFWorkbook();
        FileOutputStream outputStream = new FileOutputStream("./"+fileName+".xlsx")
    ) {
      Sheet sheet = workbook.createSheet("auctionItem");
      for (var item : list) {
        index2 = 0;
        var fields = item.getClass().getDeclaredFields();
        //data-header
        if(index == 0){
          Row row = sheet.createRow(index);
          for(var field : fields){
            field.setAccessible(true);
            row.createCell(index2).setCellValue(field.getName());
            index2++;
          }
          index++;
          continue;
        }
        //data
        Row row = sheet.createRow(index);
        for(var field : fields){
          field.setAccessible(true);
          row.createCell(index2).setCellValue(field.get(item).toString());
          index2++;
        }
        index++;
      }
      workbook.write(outputStream);
    }catch (IOException e){
      e.printStackTrace();
    }
  }


}
