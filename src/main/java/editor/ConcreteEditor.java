
package editor;

/**
 *
 * @author furkan-A
 */
public class ConcreteEditor extends TextEditor {
    
    protected PanelIslemler pi;

    public ConcreteEditor(PanelIslemler pi) {
        this.pi = pi;
    }
    
    public void dosyaAcActionPerformed() {
        pi.ac();
    }
    
    public void dosyaKapatActionPerformed() {
        
        pi.kapat(super.getIndex());
    }
    
    public void dosyaOlusturActionPerformed() {
        pi.olustur();
    }
}
