package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CsvService {

  public <T> void writeCsv(List<T> list, String fileNae){
    File file = new File("./", fileNae+".csv");
    String NEWLINE = System.lineSeparator();



    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))){
      bw.write('\uFEEF');

      int index = 0;
      //header
      for(var field : list.get(0).getClass().getDeclaredFields()){
        field.setAccessible(true);
        if(index != 0){
          bw.write(",");
        }
        bw.write(field.getName());
        index++;
      }
      bw.newLine();

      //data
      for(var item : list){
        index = 0;

        //data
        var fields = item.getClass().getDeclaredFields();
          for(var field : fields){
            field.setAccessible(true);
            if(index != 0){
              bw.write(",");
            }
            bw.write(field.get(item).toString());
            index++;
          }
        bw.write(NEWLINE);
      }
    }catch (IOException e){
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

}
