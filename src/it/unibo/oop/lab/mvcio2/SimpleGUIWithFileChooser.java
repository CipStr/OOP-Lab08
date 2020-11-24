package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import it.unibo.oop.lab.mvc.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        frame.setTitle("My first java graphical interface");
        JPanel canvas = new JPanel(new BorderLayout());
        JTextArea save = new JTextArea();
        JTextArea browseText = new JTextArea();
        JButton saveButton = new JButton("Save");
        canvas.add(saveButton, BorderLayout.SOUTH);
        JPanel panel2 = new JPanel(new BorderLayout());
        canvas.add(panel2, BorderLayout.NORTH);
        panel2.add(browseText, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.CENTER);
        JButton browse = new JButton("Browse");
        panel2.add(browse, BorderLayout.LINE_END);
        browseText.setEditable(false);
        browse.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            Controller c = new Controller();
            int returnVal = chooser.showOpenDialog(panel2);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                browseText.setText("You chose to open this file: " + chooser.getSelectedFile().getName());
                c.setFile(chooser.getSelectedFile());
            }
            if (returnVal!=JFileChooser.APPROVE_OPTION && returnVal!=JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(panel2, "Errore");
            }
            
        });
        saveButton.addActionListener(e -> {
            try {
                new Controller().addInputToFile(save.getText());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setVisible(true);
        frame.setLocationByPlatform(true);
    }
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser();
     }
}
