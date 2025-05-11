import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminAccount{
    private final String password = "Admin-8718-4037";



    public void AdminLogin_Frame(boolean x){
        JButton logoutButton = new JButton("logout");
        logoutButton.setBounds(1, 1, 70, 25);

        JLabel l0 = new JLabel("ADMIN");
        l0.setFont(new Font("",Font.BOLD,22));
        l0.setBounds(250,1,200,50);

        JLabel l1 = new JLabel("SELECT AN OPTION");
        l1.setFont(new Font("",Font.BOLD,16));
        l1.setBounds(210,410,200,50);
        l1.setForeground(Color.DARK_GRAY);

        JLabel lx = new JLabel("ACTION SUCCESSFUL");
        lx.setFont(new Font("",Font.BOLD,16));
        lx.setBounds(210,300,200,50);
        lx.setForeground(Color.BLUE);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("",Font.ITALIC,10));
        l2.setBounds(530,340,70,30);



        JButton newAccButton = new JButton("Add New Account");
        newAccButton.setBounds(70,100,200,50);

        JButton viewAccButton = new JButton("View an Account");
        viewAccButton.setBounds(300,100,200,50);

        JButton lockButton = new JButton("Lock/Unlock an Account");
        lockButton.setBounds(70,160,200,50);

        JButton adminDetailsButton = new JButton("Show Admin details");
        adminDetailsButton.setBounds(300,160,200,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l0);
        frame.add(l1);
        frame.add(viewAccButton);
        frame.add(newAccButton);
        frame.add(adminDetailsButton);
        frame.add(lockButton);
        frame.add(l2);
        if(x){frame.add(lx);}
        frame.add(logoutButton);
        frame.setVisible(true);

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(logoutButton);
                frame.dispose(); // close the frame
                run.running();

            }
        });


        newAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(newAccButton);
                frame.dispose(); // close the frame
                addNewAccFrame();


            }
        });

        viewAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewAccButton);
                frame.dispose(); // close the frame
                viewAccFrame(true);

            }
        });

        lockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lockButton);
                frame.dispose(); // close the frame
                LockAccountFrame(true);

            }
        });

        adminDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminDetailsButton);
                frame.dispose(); // close the frame
                ViewAdminFrame();

            }
        });



    }



    public void addNewAccFrame(){
        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("ADMIN");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(270, 1, 70, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JTextField nameField = new JTextField("", 20);
        nameField.setBounds(180, 70, 300, 30);

        JLabel l4 = new JLabel("Name:");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(30, 70, 150, 30);

        JTextField idField = new JTextField("", 20);
        idField.setBounds(180, 120, 300, 30);

        JLabel l6 = new JLabel("ID:");
        l6.setFont(new Font("", Font.BOLD, 14));
        l6.setBounds(30, 120, 110, 30);

        JTextField emailField = new JTextField("", 20);
        emailField.setBounds(180, 170, 300, 30);

        JLabel l5 = new JLabel("Email/Phone: ");
        l5.setFont(new Font("", Font.BOLD, 14));
        l5.setBounds(30, 170, 150, 30);

        JButton newAccButton = new JButton("Add");
        newAccButton.setBounds(410, 220, 70, 40);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(l2);
        frame.add(l4);
        frame.add(emailField);
        frame.add(l5);
        frame.add(l6);
        frame.add(nameField);
        frame.add(idField);
        frame.add(backButton);
        frame.add(newAccButton);
        frame.setVisible(true);


        newAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(newAccButton);
                frame.dispose(); // close the frame
                String name = nameField.getText();
                String email = emailField.getText();
                String id = idField.getText();
                boolean isThere = CsvFunctions.searchCsv("AI-k22-"+id,0);
                try{
                    if(name != "" && email != "" && id != "" && !isThere) {
                            System.out.println("Added"+name+email+id);
                            CsvFunctions.addNewAccount(name,email,id);
                            AdminLogin_Frame(true);
                    }
                    else {
                        System.out.println("New Account creation: False");
                        newAcc_FailureFrame();
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
                AdminLogin_Frame(false);

            }
        });

    }

    public void newAcc_FailureFrame() {

        JLabel l0 = new JLabel("FAILURE!");
        l0.setFont(new Font("",Font.BOLD,20));
        l0.setBounds(250,80,250,50);
        l0.setForeground(Color.RED);

        JLabel l1 = new JLabel("ID ALREADY EXISTS/FIELDS ARE EMPTY");
        l1.setFont(new Font("",Font.BOLD,16));
        l1.setBounds(140,120,400,50);

        JLabel lx = new JLabel("ID cannot be repeated/ Field(s) cannot be empty");
        lx.setFont(new Font("",Font.ITALIC,11));
        lx.setBounds(140,150,400,30);
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
                AdminLogin_Frame(false);
            }
        });


    }


    public void viewAccFrame(boolean x){

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("SEARCH");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(240, 1, 90, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel lx = new JLabel("No User Found");
        lx.setFont(new Font("", Font.ITALIC, 11));
        lx.setBounds(180, 180, 200, 30);
        lx.setForeground(Color.RED);


        JTextField idtextField = new JTextField("", 20);
        idtextField.setBounds(180, 150, 300, 30);

        JLabel l4 = new JLabel("Account Number:");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(30, 150, 150, 30);

        JButton viewButton = new JButton("View");
        viewButton.setBounds(410, 190, 70, 40);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(l2);
        frame.add(l4);
        if (!x) {
            frame.add(lx);
        }
        frame.add(idtextField);
        frame.add(backButton);
        frame.add(viewButton);
        frame.setVisible(true);


        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewButton);
                String id = idtextField.getText();
                frame.dispose(); // close the frame
                try {
                    String check = CsvFunctions.getRowNum(id);

                    if (!check.equals("false")) {
                        String data = CsvFunctions.readCsvRow(Integer.parseInt(check));
                        System.out.println(data);
                        ViewAcc_statementFrame(data);

                    } else {
                        System.out.println("User found: False");
                        viewAccFrame(false);
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
                AdminLogin_Frame(false);
            }
        });

    }

    public void ViewAcc_statementFrame(String data) {
        String accNum, name, phone_email, balance, isLocked;
        String[] parts = data.split("\\+");
        accNum = parts[0];
        name = parts[2];
        balance = parts[3];
        phone_email = parts[4];
        isLocked = parts[5];
        JLabel l1 = new JLabel("STATEMENT");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(250, 1, 200, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel l3 = new JLabel("Account Number: "+accNum);
        l3.setFont(new Font("", Font.BOLD, 16));
        l3.setBounds(70, 70, 350, 30);
        l3.setForeground(Color.DARK_GRAY);

        JLabel l4 = new JLabel("Name : "+name);
        l4.setFont(new Font("", Font.BOLD, 16));
        l4.setBounds(70, 100, 350, 30);
        l4.setForeground(Color.DARK_GRAY);

        JLabel l5 = new JLabel("Email / Phone : "+phone_email);
        l5.setFont(new Font("", Font.BOLD, 16));
        l5.setBounds(70, 130, 350, 30);
        l5.setForeground(Color.DARK_GRAY);

        JLabel l6 = new JLabel("Balance : Rs."+balance);
        l6.setFont(new Font("", Font.BOLD, 16));
        l6.setBounds(70, 160, 350, 30);
        l6.setForeground(Color.DARK_GRAY);

        JLabel l7 = new JLabel("Locked : "+isLocked);
        l7.setFont(new Font("", Font.BOLD, 16));
        l7.setBounds(70, 190, 350, 30);
        l7.setForeground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JButton cButton = new JButton("Proceed");
        cButton.setBounds(300,220,100,40);

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
        frame.add(l7);
        frame.add(cButton);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                viewAccFrame(true);

            }
        });

        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cButton);
                frame.dispose(); // close the frame
                AdminLogin_Frame(false);
            }
        });




    }











    public boolean Validate_adminCredential(String pass){
        if(this.password.equals(pass)){
            System.out.println("Credentials true");
            return true;
        }
        else {
            System.out.println("Credentials false");
            return false;
        }
    }



    public void LockAccountFrame(boolean x){
        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("LOCK/UNLOCK");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(180, 1, 150, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel lx = new JLabel("No User Found");
        lx.setFont(new Font("", Font.ITALIC, 11));
        lx.setBounds(180, 180, 200, 30);
        lx.setForeground(Color.RED);


        JTextField idtextField = new JTextField("", 20);
        idtextField.setBounds(180, 150, 300, 30);

        JLabel l4 = new JLabel("Account Number:");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(30, 150, 150, 30);

        JButton lockButton = new JButton("Lock");
        lockButton.setBounds(410, 190, 70, 40);

        JButton unlockButton = new JButton("UnLock");
        unlockButton.setBounds(310, 190, 90, 40);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(l2);
        frame.add(l4);
        if (!x) {
            frame.add(lx);
        }
        frame.add(idtextField);
        frame.add(backButton);
        frame.add(lockButton);
        frame.add(unlockButton);
        frame.setVisible(true);


        lockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lockButton);
                String id = idtextField.getText();
                frame.dispose(); // close the frame
                try {
                    String check = CsvFunctions.getRowNum(id);

                    if (!check.equals("false")) {
                        CsvFunctions.overWriteCell(Integer.parseInt(check),5,"true");
                        System.out.println("Lock : true");
                        AdminLogin_Frame(true);

                    } else {
                        System.out.println("User found: False");
                        LockAccountFrame(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        unlockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(unlockButton);
                String id = idtextField.getText();
                frame.dispose(); // close the frame
                try {
                    String check = CsvFunctions.getRowNum(id);

                    if (!check.equals("false")) {
                        CsvFunctions.overWriteCell(Integer.parseInt(check),5,"false");
                        System.out.println("UnLock : true");
                        AdminLogin_Frame(true);

                    } else {
                        System.out.println("User found: False");
                        LockAccountFrame(false);
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
                AdminLogin_Frame(false);
            }
        });
    }


    public void ViewAdminFrame() {

        ImageIcon admin1 = new ImageIcon("src/me.jpg");
        ImageIcon admin2 = new ImageIcon("src/wisha.jpg");
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel l1 = new JLabel("ADMINS");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(250, 1, 200, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel img1 = new JLabel("");
        img1.setIcon(admin1);
        img1.setBounds(450, 40, 120, 120);
        img1.setBorder(border);

        JLabel la = new JLabel("ADMIN 1");
        la.setFont(new Font("", Font.BOLD, 16));
        la.setBounds(10, 40, 350, 30);
        la.setForeground(Color.DARK_GRAY);

        JLabel l3 = new JLabel("Name: Rao M.Hamza");
        l3.setFont(new Font("", Font.BOLD, 14));
        l3.setBounds(10, 70, 350, 30);
        l3.setForeground(Color.DARK_GRAY);

        JLabel l4 = new JLabel("Std ID: k22-8718");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(10, 100, 350, 30);
        l4.setForeground(Color.DARK_GRAY);

        JLabel l5 = new JLabel("Email : rmuhammadhamza86@gmail.com");
        l5.setFont(new Font("", Font.BOLD, 14));
        l5.setBounds(10, 130, 350, 30);
        l5.setForeground(Color.DARK_GRAY);

        JLabel lg = new JLabel("-----------------------------------------------------------------------------------------------------------------");
        lg.setFont(new Font("", Font.BOLD, 16));
        lg.setBounds(10, 150, 600, 30);
        lg.setForeground(Color.DARK_GRAY);

        JLabel img2 = new JLabel("");
        img2.setIcon(admin2);
        img2.setBounds(450, 180, 120, 120);
        img2.setBorder(border);

        JLabel lb = new JLabel("ADMIN 2");
        lb.setFont(new Font("", Font.BOLD, 16));
        lb.setBounds(10, 170, 350, 30);
        lb.setForeground(Color.DARK_GRAY);

        JLabel l6 = new JLabel("Name: Wisha");
        l6.setFont(new Font("", Font.BOLD, 14));
        l6.setBounds(10, 200, 350, 30);
        l6.setForeground(Color.DARK_GRAY);

        JLabel l7 = new JLabel("Std ID: k22-4031");
        l7.setFont(new Font("", Font.BOLD, 14));
        l7.setBounds(10, 230, 350, 30);
        l7.setForeground(Color.DARK_GRAY);

        JLabel l8 = new JLabel("Email : k224031@nu.edu.pk");
        l8.setFont(new Font("", Font.BOLD, 14));
        l8.setBounds(10, 260, 350, 30);
        l8.setForeground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(backButton);
        frame.add(la);
        frame.add(img1);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(lg);
        frame.add(img2);
        frame.add(lb);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose(); // close the frame
                AdminLogin_Frame(false);

            }
        });





    }









}














public class Admin {
    public Admin(){
        AdminFrame2 frame = new AdminFrame2(true);
        System.out.println("Directing to Admin...");
    }
}
