import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminFrame2 {
    public AdminFrame2(boolean x) {

        AdminAccount adminAccount = new AdminAccount();

        JButton backButton = new JButton("Back");
        backButton.setBounds(1, 1, 70, 25);

        JLabel l1 = new JLabel("ADMIN");
        l1.setFont(new Font("", Font.BOLD, 20));
        l1.setBounds(270, 1, 70, 50);

        JLabel l2 = new JLabel("8718-4037");
        l2.setFont(new Font("", Font.ITALIC, 10));
        l2.setBounds(530, 340, 70, 30);

        JLabel lx = new JLabel("Incorrect Admin Password");
        lx.setFont(new Font("", Font.ITALIC, 11));
        lx.setBounds(180, 180, 200, 30);
        lx.setForeground(Color.RED);


        JPasswordField passtextField = new JPasswordField(20);
        passtextField.setBounds(180, 150, 300, 30);

        JLabel l4 = new JLabel("Password:");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(30, 150, 150, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(410, 190, 70, 40);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(l1);
        frame.add(l2);
        frame.add(l4);
        if (x == false) {
            frame.add(lx);
        }
        frame.add(passtextField);
        frame.add(backButton);
        frame.add(loginButton);
        frame.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                String password = passtextField.getText();
                frame.dispose(); // close the frame
                boolean check = adminAccount.Validate_adminCredential(password);
                try {
                    if (check) {
                        System.out.println("Admin Logging in");
                        adminAccount.AdminLogin_Frame(false);

                    } else {

                        AdminFrame2 frame2 = new AdminFrame2(false);
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
                run.running();
            }
        });

    }
}
