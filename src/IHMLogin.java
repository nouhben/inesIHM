import javax.swing.*;

public class IHMLogin {
    public static void main(String[] args) throws Exception{
        LoginFrame frame = new LoginFrame();
        SignupFrame signupFrame= new SignupFrame();

        frame.setTitle("Login");
        signupFrame.setTitle("Sign Up");

        frame.setBounds(100,100,780,680);
        signupFrame.setBounds(300,10,680,900);
       // frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signupFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signupFrame.setResizable(false);
        frame.setResizable(false);
        signupFrame.setVisible(true);
    }
}
