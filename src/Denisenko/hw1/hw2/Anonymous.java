package Denisenko.hw1.hw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anonymous implements ActionListener {



        private JFrame jFrame;
        private JPanel contentPanel;
        private JLabel content;

        public JFrame getjFrame() {
            return jFrame;
        }

        public Anonymous() {
            jFrame=new JFrame();
            jFrame.setSize(1000,800);

            JPanel menuPanel=new JPanel();
            menuPanel.setLayout(new GridLayout(3,1));
            menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            menuPanel.setSize(1000,300);
            JButton createPerson=new JButton("Create Person");
            createPerson.addActionListener(this);
            JButton findPerson=new JButton("Find Person");
            findPerson.addActionListener(this);
            JButton changePerson=new JButton("Change Person");
            changePerson.addActionListener(this);
            menuPanel.add(createPerson);
            menuPanel.add(findPerson);
            menuPanel.add(changePerson);

            contentPanel=new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JPanel hello=new JPanel();
            JLabel content=new JLabel("Hello");

            hello.add(content);
            contentPanel.add(hello,BorderLayout.NORTH);

            jFrame.add(menuPanel,BorderLayout.WEST);
            jFrame.add(contentPanel,BorderLayout.CENTER);

            jFrame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Create Person")){
                JPanel jPanel=new JPanel();
                jPanel.setLayout(new GridLayout(3,2));
                JLabel name = new JLabel("1.Ведите имя");
                JTextField nameTextField=new JTextField(50);
                JLabel passport=new JLabel("2.Пасспорт");
                JTextField passportTextField=new JTextField(50);
                JLabel birthday=new JLabel("3.Дата рождения");
                JTextField birthdayTextField=new JTextField(50);

                jPanel.add(name);
                jPanel.add(nameTextField);

                jPanel.add(passport);
                jPanel.add(passportTextField);
                jPanel.add(birthday);
                jPanel.add(birthdayTextField);

                JButton OK=new JButton("OK");


                contentPanel.add(jPanel,BorderLayout.CENTER);
                contentPanel.add(OK,BorderLayout.SOUTH);
                jFrame.revalidate();
                jFrame.repaint();
            }
            else if (e.getActionCommand().equals("Find Person")){

            }
            else if(e.getActionCommand().equals("Change Person")){

            }

        }
    }


