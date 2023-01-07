import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class GUI {
    public static void GUI() {
        JFrame frame = new JFrame("User information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        // Создание панели меню и добавление компонентов
        JMenuBar mb = new JMenuBar();
        JMenu m2 = new JMenu("Help");
        mb.add(m2);
        JMenuItem m21 = new JMenuItem("Помощь");
        m2.add(m21);
 
        // Создание панели внизу и добавление компонентов
        JPanel panel = new JPanel(); // панель не видна при выводе
        JLabel labelName = new JLabel("Имя");
        JTextField tfName = new JTextField(20);

        JLabel labelSurName = new JLabel("Фамилия");
        JTextField tfSurName = new JTextField(20);

        JLabel labelPatr = new JLabel("Отчество");
        JTextField tfPatr = new JTextField(20);

        JLabel labelBitrh = new JLabel("Дата рождения(dd-MM-yyyy)");
        JTextField tfBirth = new JTextField(2);
        

        JLabel labelNumber = new JLabel("Номер телефона");
        JTextField tfNumber = new JTextField(20);

        JLabel labelGender = new JLabel("Пол");
        String [] genders = new String []{"male","female"};
        JComboBox Gender = new JComboBox(genders);

        JButton send = new JButton("Отправить");

        JLabel checkName = new JLabel("  ❌");
        JLabel checkSurName = new JLabel("  ❌");
        JLabel checkPatr = new JLabel("  ❌");
        JLabel checkBirth = new JLabel("  ❌");
        JLabel checkNumber = new JLabel("  ❌");
        JLabel checkGender = new JLabel("  ❌");
        JLabel checkSend = new JLabel("");

        panel.add(labelSurName);
        panel.add(tfSurName);
        panel.add(checkSurName);

        panel.add(labelName); 
        panel.add(tfName);
        panel.add(checkName);

        panel.add(labelPatr);
        panel.add(tfPatr);
        panel.add(checkPatr);

        panel.add(labelBitrh);
        panel.add(tfBirth);
        panel.add(checkBirth);

        panel.add(labelNumber);
        panel.add(tfNumber);
        panel.add(checkNumber);

        panel.add(labelGender);
        panel.add(Gender);
        panel.add(checkGender);

        panel.add(send);
        panel.add(checkSend);

        
       writer writer = new writer();

        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if ((checkName.getText() == "  ✅") && 
                    (checkSurName.getText() == "  ✅") && 
                    (checkPatr.getText() == "  ✅")&& 
                    (checkBirth.getText() == "  ✅")&& 
                    (checkNumber.getText() == "  ✅")&& 
                    (checkGender.getText() == "  ✅"))
                {
                    checkSend.setText("Данные успешно сохранены");
                    try {
                        writer.CreateTXTFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else 
                {
                    checkSend.setText("Проверьте корректность введенных данных");
                }
                }
            
        });

        
        tfName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = tfName.getText();
                boolean check = name.matches("[a-zA-Zа-яА-Я]*$");
                try {
                    if (check == true){
                        String userName = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();
                        writer.write(userName,1);
                        checkName.setText("  ✅");
                    }
                    else{
                        checkName.setText("  ❌ (Имя не может содержать цифры и символы)");
                    }
                }catch(StringIndexOutOfBoundsException e){
                    checkName.setText("  ❌ (Введите свое имя)");
                }
            }
            
        });
        tfSurName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String surName = tfSurName.getText();
                boolean check = surName.matches("[a-zA-Zа-яА-Я]*$");
                try {
                    if (check == true){
                        String userSurName = surName.substring(0,1).toUpperCase()+ surName.substring(1).toLowerCase();
                        writer.write(userSurName,0);
                        checkSurName.setText("  ✅");
                    }
                    else{
                        checkSurName.setText("  ❌ (Фамилия не может содержать цифры и символы)");
                    }
                }catch(StringIndexOutOfBoundsException e){
                    checkSurName.setText("  ❌ (Введите свою фамилию)");
                }
            }
            
        });
        tfPatr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String patr = tfPatr.getText();
                boolean check = patr.matches("[a-zA-Zа-яА-Я]*$");
                try {
                    if (check == true){
                        String userPatr = patr.substring(0,1).toUpperCase()+ patr.substring(1).toLowerCase();
                        writer.write(userPatr,2);
                        checkPatr.setText("  ✅");
                    }
                    else{
                        checkPatr.setText("  ❌ (Отчество не может содержать цифры и символы)");
                    }
                }catch(StringIndexOutOfBoundsException e){
                    checkPatr.setText("  ❌ (Введите свое Отчество)");
                }
            }
            
        });
        tfBirth.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Date date;
                try {
                    date  = new SimpleDateFormat("dd-MM-yyyy").parse(tfBirth.getText());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String format = formatter.format(date);
                    checkBirth.setText("  ✅");
                    System.out.println(format);
                    String[] Birth = format.split("-");
                    String birth = Birth[0]+ "." +Birth[1]+ "." +Birth[2];
                    writer.write(birth, 3);
                } catch (Exception e) {
                    checkBirth.setText("  ❌ (Введите дату формата dd-MM-yyyy)");
                    
            }
        }
        });

        tfNumber.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number = tfNumber.getText();
                try {
                    Long num = Long.parseLong(number);
                    checkNumber.setText("  ✅");
                    writer.write(number,4);
                } catch (Exception e) {
                    checkNumber.setText("  ❌ (Номер может состоять только из цифр");
                    
                }
            }
            
        });
        Gender.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkGender.setText("  ✅");
                String gendr = (String) Gender.getSelectedItem();
                String gendr1;
                if (gendr == "male"){gendr1 = "m";}
                else{gendr1 = "f";}
                writer.write(gendr1, 5);

            }
            
        });

        
        
        
        
        
        
        GridLayout layout = new GridLayout(7, 3, 0, 10);
        panel.setLayout(layout);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        
 
        
        frame.setVisible(true);

    
    }

    public static void name() throws IOException {
        writer writer = new writer();
        writer.CreateTXTFile();
    }
    

          
}
