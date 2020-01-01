import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignupFrame extends JFrame implements ActionListener {

        private Container container= getContentPane();

        /***** LABELS ****/
        private JLabel userNameLabel= new JLabel("Username:");
        private JLabel firstNameLabel= new JLabel("First Name:");
        private JLabel lastNameLabel= new JLabel("Last Name:");
        private JLabel emailLabel = new JLabel("Email:");
        private JLabel phoneLabel = new JLabel("Phone:");
        private JLabel passwordLabel= new JLabel("Password:");
        private JLabel confirmPasswordLabel= new JLabel("Confirm Password:");

        /***** ERROR LABELS ****/
        private JLabel
                firstNameError= new JLabel(),
                lastNameError= new JLabel(),
                usernameError= new JLabel(),
                passwordError= new JLabel(),
                confirmPasswordError= new JLabel(),
                phone_mail_error= new JLabel()
    ;

        /***** FIELDS ****/
        private  JTextField firstNameField= new JTextField();
        private  JTextField lastNameField= new JTextField();
        private  JTextField userNameField= new JTextField();
        private JTextField phoneField = new JTextField();
        private JPasswordField passwordField= new JPasswordField();
        private JPasswordField confirmPasswordField= new JPasswordField();

        private JTextField emailField = new JTextField();

         /***** BUTTONS ****/
        private JButton loginButton= new JButton("Signup");
        private JButton exitButton = new JButton("Reset");
        private JCheckBox showPasswordCheckBox= new JCheckBox("Show Password");

        SignupFrame(){
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
            int width=300,height=40;
            firstNameLabel.setBounds(50,50,width,height);
            firstNameField.setBounds(50,80,width,height);
            firstNameError.setBounds(50,110,width,height-10);

            lastNameLabel.setBounds(350,50,width,height);
            lastNameField.setBounds(350,80,width,height);
            lastNameError.setBounds(350,110,width,height-10);

            userNameLabel.setBounds(50,150,2*width,height);
            userNameField.setBounds(50,180,2*width,height);
            usernameError.setBounds(50,210,2*width,height-10);

            emailLabel.setBounds(50,250,width,height);
            emailField.setBounds(50,250+height,width*2,height);

            phone_mail_error.setBounds(250,260+height,width,height);

            phoneLabel.setBounds(50,350,width* 2,height);
            phoneField.setBounds(50,350+height+10,width * 2,height);


            passwordLabel.setBounds(50,450,width,height);
            passwordField.setBounds(50,450+height+10,width * 2,height);
            passwordError.setBounds(50,550,width * 2,height-10);

            confirmPasswordLabel.setBounds(50,530+height,width,height);
            confirmPasswordField.setBounds(50,550+height+10,width * 2,height);
            confirmPasswordError.setBounds(50,630,width*2,height-10);



            loginButton.setBounds(150,660,width/2,40);
            //loginButton.setEnabled(false);
            exitButton.setBounds(350,660,width/2,40);

        }

        private void addComponentsToContainer(){
            container.add(userNameLabel);
            container.add(userNameField);
            container.add(usernameError);

            container.add(passwordLabel);
            container.add(passwordField);
            container.add(passwordError);

            container.add(confirmPasswordError);
            container.add(confirmPasswordField);
            container.add(confirmPasswordLabel);

            container.add(firstNameError);
            container.add(firstNameField);
            container.add(firstNameLabel);

            container.add(lastNameError);
            container.add(lastNameField);
            container.add(lastNameLabel);

            container.add(emailField);
            container.add(emailLabel);

            container.add(phoneField);
            container.add(phoneLabel);
            container.add(phone_mail_error);

            container.add(loginButton);
            container.add(exitButton);

        }

        private void addActionEvents(){
            loginButton.addActionListener(this);
            exitButton.addActionListener(this);
            //showPasswordCheckBox.addActionListener(this);
        }

        private void setUIStyle(){

            container.setBackground(new Color(15,55,155));

            Object []labels={firstNameLabel,lastNameLabel,userNameLabel,
                    emailLabel, phoneLabel,passwordLabel,confirmPasswordLabel,
                    confirmPasswordError,passwordError,usernameError,lastNameError,firstNameError
            };
            for (Object o : labels) {
                JLabel label = (JLabel) (o);
                label.setForeground(new Color(255, 255, 255));
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            HashMap<String,String> userInputs;
            HashMap<String, Boolean> is_field_correct;

            if (e.getSource() == loginButton){
                userInputs = getUserInputs();
                is_field_correct = init();


                if(userInputs.get("user_name").isEmpty() && (userInputs.get("first_name").isEmpty() || userInputs.get("last_name").isEmpty())){
                   usernameError.setText(". Username Empty *");
                   is_field_correct.replace("user_name",false);
                }else {
                    usernameError.setText("");
                }

                if(userInputs.get("email").isEmpty() && userInputs.get("phone").isEmpty()){
                    phone_mail_error.setText("Email or Phone must not be Empty");
                    is_field_correct.replace("email",false);
                    is_field_correct.replace("phone",false);
                }

                if (userInputs.get("password").isEmpty()){
                    passwordError.setText(". Password Empty *");
                    is_field_correct.replace("password",false);
                }else {
                    passwordError.setText("");
                }
                if (userInputs.get("password_confirm").isEmpty()){
                    confirmPasswordError.setText(". Confirm Password Empty *");
                    is_field_correct.replace("password_confirm",false);
                }else {
                    confirmPasswordError.setText("");
                }

                if(!userInputs.get("password_confirm").equals(userInputs.get("password"))){
                    confirmPasswordError.setText(". Confirm Password Not Similar *");
                    is_field_correct.replace("password_confirm",false);
                }else {
                    confirmPasswordError.setText("");
                }

                if(
                        is_field_correct.get("user_name") &&
                         is_field_correct.get("email") && is_field_correct.get("phone") &&
                        is_field_correct.get("password") &&
                        is_field_correct.get("password_confirm")){

                    JOptionPane.showMessageDialog(this, "Sign up Success ...");

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
            }
        }

        private HashMap<String,String> getUserInputs(){
            HashMap<String,String> userInputs= new HashMap<>();

            userInputs.put("first_name",firstNameField.getText().trim().toLowerCase());
            userInputs.put("last_name",lastNameField.getText().trim().toLowerCase());
            userInputs.put("user_name",userNameField.getText().trim().toLowerCase());
            userInputs.put("email",emailField.getText().trim().toLowerCase());
            userInputs.put("phone", phoneField.getText().trim().toLowerCase());

            userInputs.put("password",passwordField.getText().trim().toLowerCase());
            userInputs.put("password_confirm", confirmPasswordField.getText().trim().toLowerCase());

            return userInputs;
        }

        private HashMap<String, Boolean> init(){
            HashMap<String, Boolean> is_field_correct = new HashMap<>();
            //is_field_correct.put("first_name",true);
            //is_field_correct.put("last_name",true);
            is_field_correct.put("user_name",true);
            is_field_correct.put("phone",true);
            is_field_correct.put("email",true);
            is_field_correct.put("password",true);
            is_field_correct.put("password_confirm",true);

            return is_field_correct;
        }

        private HashMap<JLabel,String> init_error_labels( ){
            HashMap<JLabel,String> errors= new HashMap<>();
            errors.put(firstNameError,"first_name");
            errors.put(usernameError,"user_name");
            errors.put(passwordError,"password");
            errors.put(confirmPasswordError,"password_confirm");

            return errors;
        }

}
