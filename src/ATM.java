import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class User{
    private String name;
    private String accNum;
    private double balance;
    private String locked;
    private String password;
    private String phone_email;
    private int rowNum;

    public User(String data, int rowNum) {
        String[] parts = data.split("\\+");
        this.accNum = parts[0];
        this.password = parts[1];
        this.name = parts[2];
        this.balance = Double.parseDouble(parts[3]);
        this.phone_email = parts[4];
        this.locked = parts[5];
        this.rowNum=rowNum;
        System.out.println(this.accNum+" "+this.balance+" "+this.name);



    }

    public void WithdrawFrame(boolean x) {
        double currentBalance = this.balance;
        String rowNum = String.valueOf(this.rowNum);
        JLabel l1 = new JLabel("WITHDRAW");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(250, 1, 200, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JTextField amountField = new JTextField("", 20);
        amountField.setBounds(180, 100, 300, 30);

        JLabel l3 = new JLabel("Amount:");
        l3.setFont(new Font("", Font.BOLD, 16));
        l3.setBounds(100, 100, 150, 30);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(410, 190, 100, 40);

        JLabel msg = new JLabel("Transaction Limit: 50000.0");
        msg.setFont(new Font("", Font.BOLD, 14));
        msg.setBounds(100, 140, 400, 20);

        JLabel l4 = new JLabel("Current Balance: " + Double.toString(currentBalance));
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(100, 160, 400, 30);

        JLabel l5 = new JLabel("Service Charges: Rs.22.5");
        l5.setFont(new Font("", Font.ITALIC, 11));
        l5.setBounds(100, 190, 200, 20);
        l5.setForeground(Color.BLUE);

        JLabel lx = new JLabel("*Invalid Amount Entered");
        lx.setFont(new Font("", Font.ITALIC, 11));
        lx.setBounds(100, 205, 200, 30);
        lx.setForeground(Color.RED);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(backButton);
        frame.add(l1);
        frame.add(l2);
        frame.add(msg);
        frame.add(amountField);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        if (x == false) {
            frame.add(lx);
        }
        frame.add(withdrawButton);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                Frame3 frame3=new Frame3(rowNum,false);

            }
        });


        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(withdrawButton);
                frame.dispose(); // close the frame
                String amount = amountField.getText();
                try {
                    boolean y = withdrawAmount(Double.parseDouble(amount));
                    if(y==true){
                        System.out.println("Success ");
                        Frame3 frame3 = new Frame3(rowNum,true);
                    }
                    else{
                        WithdrawFrame(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
    public boolean withdrawAmount(double amount) throws Exception{
        if(this.balance > (amount+22.5) && amount <= 50000){
            this.balance = this.balance - amount - 22.5;
            CsvFunctions.overWriteCell(this.rowNum,3,Double.toString(this.balance));
            return true;
        }
        else{
            return false;
        }
    }






















    public void DepositFrame(boolean x) {
        double currentBalance = this.balance;
        String rowNum = String.valueOf(this.rowNum);
        JLabel l1 = new JLabel("DEPOSIT");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(250, 1, 200, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JTextField amountField = new JTextField("", 20);
        amountField.setBounds(180, 100, 300, 30);

        JLabel l3 = new JLabel("Amount:");
        l3.setFont(new Font("", Font.BOLD, 16));
        l3.setBounds(100, 100, 150, 30);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(410, 190, 100, 40);

        JLabel msg = new JLabel("Transaction Limit: 100000.0");
        msg.setFont(new Font("", Font.BOLD, 14));
        msg.setBounds(100, 140, 400, 20);

        JLabel l4 = new JLabel("Current Balance: " + Double.toString(currentBalance));
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(100, 160, 400, 30);

        JLabel l5 = new JLabel("Service Charges: Rs.20");
        l5.setFont(new Font("", Font.ITALIC, 11));
        l5.setBounds(100, 190, 190, 20);
        l5.setForeground(Color.BLUE);

        JLabel lx = new JLabel("*Invalid Amount Entered");
        lx.setFont(new Font("", Font.ITALIC, 11));
        lx.setBounds(100, 200, 205, 30);
        lx.setForeground(Color.RED);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(backButton);
        frame.add(l1);
        frame.add(l2);
        frame.add(msg);
        frame.add(amountField);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        if (x == false) {
            frame.add(lx);
        }
        frame.add(depositButton);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                Frame3 frame3=new Frame3(rowNum,false);

            }
        });


        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(depositButton);
                frame.dispose(); // close the frame
                String amount = amountField.getText();
                try {
                    boolean y = depositAmount(Double.parseDouble(amount));
                    if(y==true){
                        System.out.println("Success ");
                        Frame3 frame3 = new Frame3(rowNum,true);
                    }
                    else{
                        DepositFrame(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
    public boolean depositAmount(double amount) throws Exception{
        if(amount <= 100000){
            this.balance = this.balance + amount - 20;
            CsvFunctions.overWriteCell(this.rowNum,3,Double.toString(this.balance));
            return true;
        }
        else{
            return false;
        }
    }






    public void statementFrame() {
        double currentBalance = this.balance;
        String rowNum = String.valueOf(this.rowNum);
        JLabel l1 = new JLabel("STATEMENT");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(250, 1, 200, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel l3 = new JLabel("Account Number: "+this.accNum);
        l3.setFont(new Font("", Font.BOLD, 16));
        l3.setBounds(70, 70, 350, 30);
        l3.setForeground(Color.DARK_GRAY);

        JLabel l4 = new JLabel("Name : "+this.name);
        l4.setFont(new Font("", Font.BOLD, 16));
        l4.setBounds(70, 100, 350, 30);
        l4.setForeground(Color.DARK_GRAY);

        JLabel l5 = new JLabel("Email / Phone : "+this.phone_email);
        l5.setFont(new Font("", Font.BOLD, 16));
        l5.setBounds(70, 130, 350, 30);
        l5.setForeground(Color.DARK_GRAY);

        JLabel l6 = new JLabel("Balance : Rs."+this.balance);
        l6.setFont(new Font("", Font.BOLD, 16));
        l6.setBounds(70, 160, 350, 30);
        l6.setForeground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(backButton);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                Frame3 frame3=new Frame3(rowNum,false);

            }
        });




    }





    public void SettingsFrame() {
        String rowNum = String.valueOf(this.rowNum);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("SELECT AN OPTION");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(200,1,200,50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);



        JButton dButton = new JButton("DELETE ACCOUNT");
        dButton.setBounds(190,150,200,50);




        JButton cButton = new JButton("CHANGE PASSWORD");
        cButton.setBounds(190,210,200,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(dButton);
        frame.add(cButton);
        frame.add(l2);
        frame.add(backButton);
        frame.setVisible(true);


        dButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(dButton);
                frame.dispose(); // close the frame

                try {
                    boolean y = deleteAccount();
                    if(y==true){
                        deleteAcc_SuccessFrame();
                    }
                    else{
                        deleteAcc_FailureFrame();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cButton);
                frame.dispose(); // close the frame
                System.out.println("Change password.");
                changePasswordFrame(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                Frame3 frame3=new Frame3(rowNum,false);

            }
        });


    }




    public boolean deleteAccount() throws Exception{
        if(this.balance<=50){
            CsvFunctions.deleteRow(this.rowNum);
            System.out.println("Account deleted: "+true);
            return true;
        }
        else{
            System.out.println("Account deleted: "+false);
            return false;
        }

    }

    public void deleteAcc_SuccessFrame() {
        JLabel l1 = new JLabel("ACCOUNT DELETED!");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(200,120,250,50);

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
        frame.add(l1);
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

    public void deleteAcc_FailureFrame() {
        String rowNum = String.valueOf(this.rowNum);

        JLabel l0 = new JLabel("FAILURE!");
        l0.setFont(new Font("",Font.BOLD,20));
        l0.setBounds(250,80,250,50);
        l0.setForeground(Color.RED);

        JLabel l1 = new JLabel("WITHDRAW ALL AMOUNT FIRST");
        l1.setFont(new Font("",Font.BOLD,16));
        l1.setBounds(180,120,300,50);

        JLabel lx = new JLabel("Balance Should not be more than Rs.50");
        lx.setFont(new Font("",Font.ITALIC,11));
        lx.setBounds(180,150,200,30);
        lx.setForeground(Color.RED);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);


        JButton cButton = new JButton("Proceed");
        cButton.setBounds(190,200,200,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l0);
        frame.add(l1);
        frame.add(cButton);
        frame.add(l2);
        frame.add(lx);
        frame.setVisible(true);




        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cButton);
                frame.dispose(); // close the frame
                Frame3 frame3 = new Frame3(rowNum,false);
            }
        });


    }







    public void changePasswordFrame(boolean x){
        JButton backButton = new JButton("Back");
        backButton.setBounds(1,1,70,25);

        JLabel l1 = new JLabel("Change Password");
        l1.setFont(new Font("",Font.BOLD,20));
        l1.setBounds(170,1,200,50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);

        JLabel lx = new JLabel("Incorrect Current Password");
        lx.setFont(new Font("",Font.ITALIC,11));
        lx.setBounds(180,180,200,30);
        lx.setForeground(Color.RED);


        JTextField oldPassField = new JTextField("", 20);
        oldPassField.setBounds(180,100,300,30);

        JLabel l3 = new JLabel("Current Password:");
        l3.setFont(new Font("",Font.BOLD,14));
        l3.setBounds(30,100,150,30);

        JTextField newPassField = new JTextField("", 20);
        newPassField.setBounds(180,150,300,30);

        JLabel l4 = new JLabel("New Password:");
        l4.setFont(new Font("",Font.BOLD,14));
        l4.setBounds(30,150,150,30);

        JButton loginButton = new JButton("Proceed");
        loginButton.setBounds(380,190,100,40);







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
        frame.add(oldPassField);
        frame.add(newPassField);
        frame.add(backButton);
        frame.add(loginButton);
        frame.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                String newPass = newPassField.getText();
                String oldPass = oldPassField.getText();
                frame.dispose(); // close the frame
                try {
                    boolean y = changePassword(oldPass,newPass);
                    if(y==true){
                        System.out.println("Password changed: Successful");
                        changePass_SuccessFrame();
                    }
                    else{
                        System.out.println("Password changed: Failed");
                        changePasswordFrame(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                SettingsFrame();
            }
        });

    }


    public boolean changePassword(String oldPass, String newPass) throws Exception{
        if(this.password.equals(oldPass)){
            this.password = newPass;
            CsvFunctions.overWriteCell(rowNum,1,newPass);
            return true;
        }
        else{
            return false;
        }
    }





    public void changePass_SuccessFrame() {
        String rowNum = String.valueOf(this.rowNum);

        JLabel l0 = new JLabel("SUCCESSFUL!");
        l0.setFont(new Font("",Font.BOLD,20));
        l0.setBounds(220,80,250,50);
        l0.setForeground(Color.RED);

        JLabel l1 = new JLabel("PASSWORD CHANGED!");
        l1.setFont(new Font("",Font.BOLD,16));
        l1.setBounds(200,120,300,50);

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
        frame.add(l1);
        frame.add(cButton);
        frame.add(l2);
        frame.setVisible(true);




        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cButton);
                frame.dispose(); // close the frame
                Frame3 frame3 = new Frame3(rowNum,false);
            }
        });


    }






























}













public class ATM {




    public ATM(){
        System.out.println("Directing to ATM...");
        Frame2 frame = new Frame2(true);
    }
}
