/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorprogram;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author trinh
 */
public class TextEditorProgram {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws Exception {
 
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TextEditorFrame frame = new TextEditorFrame("Text Editor"); // create an instance of TextEditorFrame named frame that having one argument used to display the title of the window
      
       
    
                    
    }
    
}
