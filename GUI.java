import javax.swing.*;
import java.awt.*;
public class GUI {
    public static void GUI() {
        JFrame frame = new JFrame("User information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        // Создание панели меню и добавление компонентов
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Открыть");
        JMenuItem m12 = new JMenuItem("Сохранить как");
        JMenuItem m21 = new JMenuItem("Помощь");
        m1.add(m11);
        m1.add(m12);
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
        panel.add(labelName); 
        panel.add(tfName);
        panel.add(labelSurName);
        panel.add(tfSurName);
        panel.add(labelPatr);
        panel.add(tfPatr);
        panel.add(labelBitrh);
        panel.add(Birth);
        panel.add(labelNumber);
        panel.add(tfNumber);
        panel.add(labelGender);
        panel.add(Gender);
        panel.add(send);
        panel.add(reset);
        
        
        GridLayout layout = new GridLayout(7, 2, 0, 10);
        panel.setLayout(layout);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        
 
        
        frame.setVisible(true);
    
    }

    
}
