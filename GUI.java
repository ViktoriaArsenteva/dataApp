import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
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

        JLabel labelPatr = new JLabel("Отчество(при наличии)");
        JTextField tfPatr = new JTextField(20);

        JLabel labelBitrh = new JLabel("Дата рождения");
        JMenuBar Birth = new JMenuBar();
        JMenu date = new JMenu("Date"); 
        JMenu month = new JMenu("Month"); 
        JMenu year = new JMenu("Year"); 
        for(int i = 1; i<=31;i++){
            JMenuItem dates = new JMenuItem(Integer.toString(i));
            date.add(dates);
        }
        for(int i = 1; i<=12;i++){
            JMenuItem months = new JMenuItem(Integer.toString(i));
            month.add(months);
        }
        for(int i = 1930; i<=2023;i++){
            JMenuItem years = new JMenuItem(Integer.toString(i));
            year.add(years);
        }
        Birth.add(date);
        Birth.add(month);
        Birth.add(year);

        JLabel labelNumber = new JLabel("Номер телефона");
        JTextField tfNumber = new JTextField(11);

        JLabel labelGender = new JLabel("Пол");
        JMenuBar Gender = new JMenuBar();
        JMenu Genders = new JMenu("Gender");
        JMenuItem male = new JMenuItem("m");
        Genders.add(male);
        JMenuItem female = new JMenuItem("f");
        Genders.add(female);
        Gender.add(Genders);


        JButton send = new JButton("Отправить");
        send.setSize(10,10);
        JButton reset = new JButton("Сброс");

        JLabel checkName = new JLabel("  ❌");
        JLabel checkSurName = new JLabel("  ❌");
        JLabel checkPatr = new JLabel("  ❌");
        JLabel checkBirth = new JLabel("  ❌");
        JLabel checkNumber = new JLabel("  ❌");
        JLabel checkGender = new JLabel("  ❌");

        panel.add(labelName); 
        panel.add(tfName);
        panel.add(checkName);

        panel.add(labelSurName);
        panel.add(tfSurName);
        panel.add(checkSurName);

        panel.add(labelPatr);
        panel.add(tfPatr);
        panel.add(checkPatr);

        panel.add(labelBitrh);
        panel.add(Birth);
        panel.add(checkBirth);

        panel.add(labelNumber);
        panel.add(tfNumber);
        panel.add(checkNumber);

        panel.add(labelGender);
        panel.add(Gender);
        panel.add(checkGender);

        panel.add(send);
        panel.add(reset);
       

        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO реализовать вывод ошибки или сообщения успешного окончания программы
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
                        writer.write(userSurName,2);
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
                        writer.write(userPatr,3);
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
        tfNumber.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number = tfNumber.getText();
                try {
                    int num = Integer.parseInt(number);
                    checkNumber.setText("  ✅");
                    writer.write(number,6);
                } catch (Exception e) {
                    checkNumber.setText("  ❌ (Номер может состоять только из цифр");
                    
                }
            }
            
        });
        
        
        
        
        
        GridLayout layout = new GridLayout(7, 3, 0, 10);
        panel.setLayout(layout);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        
 
        
        frame.setVisible(true);
    
    }
    

          
}
