package texteditorprogram;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;



/**
 * Text Editor Window.
 * 
 * This class must extend JFrame and implement ActionListener.
 * 
 * See the Assignment 13 document for details.
 * 
 * @author THAO TRINH
 */
public class TextEditorFrame extends JFrame implements ActionListener {
  
    JTextArea textArea; // declare textArea
    
    public TextEditorFrame(String titleIn){
        
        // set up JFrame using its super class's method
        super(titleIn); // constructor calls
        super.setSize(500,500); // set size
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close operation
        super.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        

        JPanel mainPanel = new JPanel(); // create mainPanel to add textArea
       

       
        // textArea is designed with 23 in height and 58 in width
        textArea = new JTextArea(23, 58);

        // set Line Wrapping
        textArea.setLineWrap(true);


        //Adds the Text Area to a Scroll Pane
        JScrollPane scroll = new JScrollPane(textArea);
        
        // add scroll to mainPanel
        mainPanel.add(scroll);
        

        
        JMenuBar menuBar = new JMenuBar(); // create menuBar to add fileMenu and menu items
    
        super.setJMenuBar(menuBar); // set menuBar to JFrame
        
        JMenu fileMenu = new JMenu("File"); // visible File
        fileMenu.setMnemonic(KeyEvent.VK_F);    // set Mnemonic for File
        
    
        // create, set Mnemonic for New item and add it to fileMenu. Plus, set actioncommand and add ActionListener to it
        JMenuItem newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        fileMenu.add(newItem);
        newItem.setActionCommand("new");
        newItem.addActionListener(this);

        // create, set Mnemonic for Open item and add it to fileMenu. Plus, set actioncommand and add ActionListener to it
        JMenuItem openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        fileMenu.add(openItem);
        openItem.setActionCommand("open");
        openItem.addActionListener(this);

        // create, set Mnemonic for Save item and add it to fileMenu. Plus, set actioncommand and add ActionListener to it
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);        
        fileMenu.add(saveItem);
        saveItem.setActionCommand("save");
        saveItem.addActionListener(this);
        
        // create, set Mnemonic for Exit item and add it to fileMenu. Plus, set actioncommand and add ActionListener to it
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        fileMenu.add(exitItem);
        exitItem.setActionCommand("exit");
        exitItem.addActionListener(this);

        //create a ButtonGroup to group New, Open and Save together
        ButtonGroup group = new ButtonGroup();        
        group.add(newItem);
        group.add(openItem);
        group.add(saveItem);    
        
        // add separator between save and exit
        fileMenu.addSeparator();
        // add exit to fileMenu
        fileMenu.add(exitItem);
        
        // add fileMenu to menuBar
        menuBar.add(fileMenu);

    

        // add mainPanel to the JFrame and set visible
        super.add(mainPanel);      
        super.setVisible(true);              
        
    }
    
    
        
    
    
    public void actionPerformed (ActionEvent e)  {

        if(e.getActionCommand().equals("exit"))
        {
            System.exit(0); // end program
        }
        
        else if(e.getActionCommand().equals("new")) // empty the textArea if "new" action command is called
        {
            textArea.setText("");

        }
        
        else if(e.getActionCommand().equals("open")) // when action command "open" is called
            
        {
            
            String content = ""; // declare a string variable named content
            
            JFileChooser chooser = new JFileChooser(); // create a JFileChooser object
 
            int result = chooser.showOpenDialog(null); // open the dialog for the user to select the file to open and assign to the result variable
     
            if (result == JFileChooser.APPROVE_OPTION) {              
        
            File selectedFile = chooser.getSelectedFile(); // assign the selected file to selectedFile File name
                            
            try { // instead of using throw exception, using try - catch method
                                        
                Scanner  fileReader = new Scanner (selectedFile); // fileReader to selectedFile
                                         
                while(fileReader.hasNextLine()) // if the fileReader has next line then it will be assign to content variable
                {
                    content += fileReader.nextLine() + '\n';
                           
                }                            
            
                textArea.setText(content); // set content to textArea

                        
                fileReader.close(); // close fileReader
                         
                } catch (FileNotFoundException ex) {
                           
                    ex.printStackTrace();
                }
   
            }
        }   
        
        
        else if(e.getActionCommand().equals("save")) // when save action command is called
        {
             JFileChooser chooser = new JFileChooser(); // JFileChooser named saver
 
            int result = chooser.showOpenDialog(null); // assign the opening dialog of saver to result variable
     
            if (result == JFileChooser.APPROVE_OPTION) {            // if choosing a file is approved 
        
            File selected = chooser.getSelectedFile(); // assign the file selected to selected variable
                            
            try { // instead of using "throws exception" method, using try - catch method
                                        
                PrintWriter  fileWriter = new PrintWriter (selected); // access to the selected File to write on it
   
                fileWriter.println(textArea.getText());    // print the content in a textArea to the selected saving file
             
                fileWriter.close(); // close fileWriter
                
                    } catch (FileNotFoundException ex) {
                
                        ex.printStackTrace();
                            
                    }
                }                
        
        }


    }
    
}




