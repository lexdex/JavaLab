package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class GamePanel {
    private static final String PATH = "res/background.jpg";

    private static JFrame window;
    private static JLabel backgroundLabel;

    public static void create() {
        window = new JFrame("Droid Battle");
        try {
            backgroundLabel = new JLabel(new ImageIcon(ImageIO.read(new File(PATH))));
            window.setContentPane(backgroundLabel);

            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { e.printStackTrace(); }
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 100);

        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.setBorder(BorderFactory.createEmptyBorder(2, 3, 2, 3));
        window.setVisible(true);
    }

}
