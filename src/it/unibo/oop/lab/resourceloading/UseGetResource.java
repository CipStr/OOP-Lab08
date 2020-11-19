package it.unibo.oop.lab.resourceloading;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.color.*;

/**
 * Example class loading an image with {@link Class#getResource(String)}.
 *
 */
public final class UseGetResource {

    private UseGetResource() {
    }

    /**
     * @param args
     *            Ignored
     * @throws IOException if an I/O error occurs
     */
    public static void main(final String... args) throws IOException {
        /*
         * Access resources as streams
         */
        final InputStream in = ClassLoader.getSystemResourceAsStream("settings/settings");
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            line = br.readLine();
        }
        //final JLabel lab2 = new JLabel(line);
        /*
         * Loading of icons and images is made very easy!
         */
        final URL imgURL = ClassLoader.getSystemResource("images/giphy.gif");
        final Icon icon = new ImageIcon(imgURL);
        /*
         * From now on, it's just plain GUI construction
         */
        final JLabel lab1 = new JLabel(icon);
        final JLabel lab3 = new JLabel(icon);
        final JLabel lab5 = new JLabel(icon);
        final JLabel lab6 = new JLabel(icon);
        final JLabel lab7 = new JLabel(icon);
        final JLabel lab8 = new JLabel(icon);
        final JLabel lab9 = new JLabel(icon);
        final JLabel lab10 = new JLabel(icon);
        final JLabel lab11= new JLabel(icon);
        final JLabel lab12= new JLabel(icon);
        final JLabel lab13= new JLabel(icon);
        final JLabel lab14= new JLabel(icon);
        final JLabel lab15= new JLabel(icon);
        final JLabel lab16= new JLabel(icon);
        final JLabel lab17= new JLabel(icon);
        final JLabel lab20= new JLabel(icon);
        final JLabel lab18= new JLabel(icon);
        final JLabel lab19= new JLabel(icon);
        final JLabel lab21= new JLabel(icon);
        final JLabel lab22= new JLabel(icon);
        
        final JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        pan.setBackground(Color.black);
        pan.add(lab1);
        //pan.add(lab2);
        pan.add(lab3);
        pan.add(lab5);
        pan.add(lab6);
        pan.add(lab7);
        pan.add(lab8);
        pan.add(lab9);
        pan.add(lab10);
        pan.add(lab11);
        pan.add(lab12);
        pan.add(lab13);
        pan.add(lab14);
        pan.add(lab15);
        pan.add(lab16);
        pan.add(lab17);
        pan.add(lab18);
        pan.add(lab19);
        pan.add(lab20);
        pan.add(lab12);
        pan.add(lab21);
        pan.add(lab22);
        final JFrame f = new JFrame("Image loader");
        
        f.getContentPane().add(pan);
        f.setResizable(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

}
