import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginFrame extends JFrame implements ActionListener {

    private Container container= getContentPane();
    private JLabel userNameLabel= new JLabel("USERNAME:");
    private JLabel passwordLabel= new JLabel("PASSWORD:");

    private JLabel  nameError= new JLabel(),
                    passwordError= new JLabel();

    private  JTextField userNameField= new JTextField();
    private JPasswordField passwordField= new JPasswordField();

    private JButton loginButton= new JButton("Login");
    private JButton exitButton = new JButton("Reset");
    private JCheckBox showPasswordCheckBox= new JCheckBox("Show Password");

    LoginFrame(){
        setLayoutOfContainer();
        setLocationAndSizeOfComponents();
        addComponentsToContainer();
        addActionEvents();
        setUIStyle();
    }

    private void setLayoutOfContainer(){
        container.setLayout(null);
    }
    private void setLocationAndSizeOfComponents(){
        userNameLabel.setBounds(100,150,100,30);
        userNameField.setBounds(210,150,150,30);
        nameError.setBounds(210,190,150,20);

        passwordLabel.setBounds(100,250,100,30);
        passwordField.setBounds(210,250,150,30);
        showPasswordCheckBox.setBounds(380,250,200,20);
        passwordError.setBounds(210,310,150,30);


        loginButton.setBounds(150,400,100,30);
        exitButton.setBounds(250,400,100,30);

    }

    private void addComponentsToContainer(){
        container.add(userNameLabel);
        container.add(userNameField);
        container.add(nameError);

        container.add(passwordLabel);
        container.add(passwordField);
        container.add(passwordError);

        container.add(showPasswordCheckBox);
        container.add(loginButton);
        container.add(exitButton);
    }
    private void addActionEvents(){
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        showPasswordCheckBox.addActionListener(this);
    }
    private void setUIStyle(){
        container.setBackground(new Color(10,50,160));
        userNameLabel.setForeground(new Color(255,255,255));
        passwordLabel.setForeground(new Color(255,255,255));
        showPasswordCheckBox.setForeground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username="",password="";
        Boolean name_is_correct=true,password_is_correct=true;
        if (e.getSource() == loginButton){

            username = userNameField.getText().trim().toLowerCase();
            password = passwordField.getText().trim().toLowerCase();

            if(username.isEmpty()){
                nameError.setText(". Username Empty!");
                name_is_correct=false;
            }else {
                if (!username.equals("ines")){
                    nameError.setText(". Username Incorrect!");
                    name_is_correct=false;
                }
            }
            if (password.isEmpty()){
                passwordError.setText(". Password Empty!");
                password_is_correct=false;
            }else {
                if (!password.equals("12345")){
                    password_is_correct=false;
                    passwordError.setText(". Password Incorrect!");
                }
            }

                //EVERYTHING's Fine username correct and password correct
            if (name_is_correct && password_is_correct ){
                JOptionPane.showMessageDialog(this, "Login Success");
            }

        }
        if (e.getSource() == showPasswordCheckBox){
            if (showPasswordCheckBox.isSelected()){
                passwordField.setEchoChar((char) 0);
            }else {
                passwordField.setEchoChar('*');
            }
        }
        if (e.getSource() == exitButton){
            //do nothing
            password ="";
            password_is_correct=true;
            passwordError.setText("");
            passwordField.setText("");

            username="";
            userNameField.setText("");
            nameError.setText("");
            name_is_correct=true;
        }
    }
}
