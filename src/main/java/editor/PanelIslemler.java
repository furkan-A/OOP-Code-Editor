
package editor;

import javax.swing.JTextPane;

/**
 *
 * @author furkan-A
 */
public class PanelIslemler implements Panel {

    protected TextEditor editor;
    
    public PanelIslemler(TextEditor editor) {
        this.editor = editor;
    }
    
    @Override
    public JTextPane ac() {       
        
        return textpaneOlustur();
    }

    @Override
    public void kapat(int index) {
        
        editor.getTabPanel().remove(index);      
    }    

    @Override
    public JTextPane olustur() {
        
        return textpaneOlustur();
    }
    
    private JTextPane textpaneOlustur() {
        
        JTextPane textPanel = new JTextPane(); 
        return textPanel;
    }
}
