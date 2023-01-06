import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writer {
    String [] Data = new String[8];//0-фамилия,1-имя,2-отчество,3-дата рождения, 4-номер,5-пол
    public void write(String data,int num) {
    Data[num] = data;
    }

    public void CreateTXTFile() throws IOException {
        String fileName = Data[0]+".txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
            try(FileWriter writer = new FileWriter(file,true ))
        {       
                Boolean checkFile = isFileEmpty(file);
                String [] names = new String[]{"Фамилия","Имя","Отчество","Дата рождения","Номер телефона","Пол"};
                if (checkFile == true)
                {
                    for (int i = 0;i < names.length; i++)
                    {
                        writer.write(names[i]);
                        for (int j = names[i].length();j<=17;j++)
                        {
                            writer.write(" ");
                        }
                    }
                }
                writer.write("\n");
                for (int i = 0;i < Data.length; i++){
                    writer.write(Data[i]);
                    for (int j = Data[i].length();j<=17;j++)
                    {
                        writer.write(" ");
                    }
           }
                writer.flush();
                
        }
            catch(Exception ex){
             
                System.out.println(ex.getMessage());
        } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    } 
    
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }

}
