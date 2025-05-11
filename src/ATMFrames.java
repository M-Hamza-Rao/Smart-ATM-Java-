import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Frame1 {
    public Frame1() {
        JLabel l1 = new JLabel("SELECT AN OPTION");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(200,1,200,50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);



        JButton atmButton = new JButton("ATM");
        atmButton.setBounds(190,150,100,50);




        JButton adminButton = new JButton("ADMIN");
        adminButton.setBounds(300,150,100,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(atmButton);
        frame.add(adminButton);
        frame.add(l2);
        frame.setVisible(true);


        atmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(atmButton);
                frame.dispose(); // close the frame
                ATM atm = new ATM();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminButton);
                frame.dispose(); // close the frame
                Admin admin = new Admin();
            }
        });


    }


}



class Frame2{
    public Frame2(boolean x){
        JButton backButton = new JButton("Back");
        backButton.setBounds(1,1,70,25);

        JLabel l1 = new JLabel("ATM");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(270,1,70,50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);

        JLabel lx = new JLabel("Incorrect Account Number or Password");
        lx.setFont(new Font("",Font.ITALIC,11));
        lx.setBounds(180,180,200,30);
        lx.setForeground(Color.RED);


        JTextField accNumtextField = new JTextField("", 20);
        accNumtextField.setBounds(180,100,300,30);

        JLabel l3 = new JLabel("Account Number:");
        l3.setFont(new Font("",Font.BOLD,14));
        l3.setBounds(30,100,150,30);

        JPasswordField passtextField = new JPasswordField(20);
        passtextField.setBounds(180,150,300,30);

        JLabel l4 = new JLabel("Password:");
        l4.setFont(new Font("",Font.BOLD,14));
        l4.setBounds(30,150,150,30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(410,190,70,40);







        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        if(x==false){frame.add(lx);}
        frame.add(accNumtextField);
        frame.add(passtextField);
        frame.add(backButton);
        frame.add(loginButton);
        frame.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                String accountNumber = accNumtextField.getText();
                String password = passtextField.getText();
                System.out.println(accountNumber+" "+password);
                frame.dispose(); // close the frame
                String check = CsvFunctions.readCsv(accountNumber,password);
                try {
                    if (check != "false") {
                        System.out.println("Logging in");
                        String isLocked = CsvFunctions.readCell(Integer.parseInt(check), 5);
                        if(isLocked.equals("false")){
                            Frame3 frame3 = new Frame3(check, false);
                        }
                        else{
                            System.out.println("Account Locked: True");
                            LockedTrue_Frame();
                        }

                    } else {

                        Frame2 frame2 = new Frame2(false);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                run.running();
            }
        });

    }




    public void LockedTrue_Frame() {

        JLabel l0 = new JLabel("ACCOUNT LOCKED!");
        l0.setFont(new Font("",Font.BOLD,20));
        l0.setBounds(190,80,250,50);
        l0.setForeground(Color.RED);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);


        JButton cButton = new JButton("Proceed");
        cButton.setBounds(190,180,200,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l0);
        frame.add(cButton);
        frame.add(l2);
        frame.setVisible(true);




        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cButton);
                frame.dispose(); // close the frame
                run.running();
            }
        });


    }

}







class Frame3 {
    public Frame3(String row_num, boolean x) {

        int i = Integer.parseInt(row_num);
        String data = CsvFunctions.readCsvRow(i);
        User user = new User(data,i);

        JButton logoutButton = new JButton("logout");
        logoutButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("SELECT AN OPTION");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(200,1,200,50);

        JLabel ls = new JLabel("TRANSACTION SUCCESSFUL");
        ls.setFont(new Font("",Font.BOLD,14));
        ls.setBounds(200,30,200,50);
        ls.setForeground(Color.BLUE);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);



        JButton withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(150,120,130,50);

        JButton depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(310,120,130,50);

        JButton settingsButton = new JButton("SETTINGS");
        settingsButton.setBounds(150,180,130,50);

        JButton statementButton = new JButton("STATEMENT");
        statementButton.setBounds(310,180,130,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(logoutButton);
        frame.add(l1);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(settingsButton);
        frame.add(statementButton);
        frame.add(l2);
        if(x==true){frame.add(ls);}
        frame.setVisible(true);


        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(withdrawButton);
                frame.dispose(); // close the frame
                int i = Integer.parseInt(row_num);
                String data = CsvFunctions.readCsvRow(i);
                User user = new User(data,i);
                user.WithdrawFrame(true);

            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(depositButton);
                frame.dispose(); // close the frame
                int i = Integer.parseInt(row_num);
                String data = CsvFunctions.readCsvRow(i);
                User user = new User(data,i);
                user.DepositFrame(true);

            }
        });

        statementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(statementButton);
                frame.dispose(); // close the frame
                int i = Integer.parseInt(row_num);
                String data = CsvFunctions.readCsvRow(i);
                User user = new User(data,i);
                user.statementFrame();

            }
        });

        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(statementButton);
                frame.dispose(); // close the frame
                int i = Integer.parseInt(row_num);
                String data = CsvFunctions.readCsvRow(i);
                User user = new User(data,i);
                user.SettingsFrame();

            }
        });







        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(logoutButton);
                frame.dispose(); // close the frame
                run.running();

            }
        });



    }


}








