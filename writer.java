import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writer {
    String [] Data = new String[8];//0-фамилия,1-имя,2-отчество,3-дата рождения, 4-номер,5-пол
    public void write(String data,int num) {
    Data[num] = data;
    }

    public void CreateFile() throws IOException {
        String fileName = Data[0]+".txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
            try(FileWriter writer = new FileWriter(file, true))
        {
           for (int i = 0;i < Data.length; i++){
            writer.write(Data[i]);
            writer.write("  ");
           }
             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        } catch (Exception ex) {

            try(FileWriter writer = new FileWriter(file, true))
        {   
            writer.write("\n");
           for (int i = 0;i < Data.length; i++){
            writer.write(Data[i]);
            writer.write("  ");
           }
             
            writer.flush();
        }
        catch(IOException e){
             
            System.out.println(e.getMessage());
        } 
        }
    } 
    public void WriteData() {
        
    }
    

}
