import javax.swing.*;

import Authentication.AuthForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our form and make it visible.
                AuthForm form = new AuthForm();
                form.setVisible(true);
            }
        });
    }
}
