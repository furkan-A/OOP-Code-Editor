
package editor;

import java.util.ArrayList;

/**
 *
 * @author furkan-A
 */
public class HataDuzelt {
    
    private Strateji strateji;

    public HataDuzelt(Strateji strateji) {
        this.strateji = strateji;
    }
            
    public ArrayList StratejiUygula(ArrayList<Object> hataliKelimeler) {
        return strateji.hataDuzeltmeYontemi(hataliKelimeler);
    }
    public ArrayList KelimeleriAl() {
        return strateji.EskiKelimeleriAl();
    }
}
