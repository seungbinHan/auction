package service;

import dto.AuctionItem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CsvService {

  public void writeCsv(List<AuctionItem> list, String fileNae){
    File file = new File("./", fileNae+".csv");
    String NEWLINE = System.lineSeparator();

    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))){
      bw.write('\uFEEF');
      bw.write("appraisedPrice,miscarryCount,minimumPrice,deposit,name,collateralDate,collateralPrice,occupyDeposit,occupyDate,confirmationDate");
      bw.write(NEWLINE);
      for(AuctionItem item : list){
        bw.write(String.valueOf(item.getAppraisedPrice())+","+String.valueOf(item.getMiscarryCount())+","+String.valueOf(item.getMinimumPrice())+","+String.valueOf(item.getDeposit())+","+String.valueOf(item.getName())+","+String.valueOf(item.getCollateralDate())+","+String.valueOf(item.getCollateralPrice())+","+String.valueOf(item.getOccupyDeposit())+","+String.valueOf(item.getOccupyDate())+","+String.valueOf(item.getConfirmationDate()));
        bw.write(NEWLINE);
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

}
