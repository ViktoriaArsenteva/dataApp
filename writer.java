public class writer {
    public static void write(String data,int num) {
        String [] Data = new String[8];//0-имя,1-фамилия,2-отчество,3-день рождения, 4- месяц, 5-год, 6-номер,7-пол
        Data[num] = data;
    }
}
