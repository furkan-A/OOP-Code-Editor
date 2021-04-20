
package editor;

import static editor.TextEditor.txtKelimeler;
import java.util.ArrayList;

/**
 *
 * @author furkan-A
 */
public class SingleTranStrateji implements Strateji {

    ArrayList<String> kelimeHarfler = new ArrayList<>();        //  single tra. icin kelimenin harflerini tutuyor
    ArrayList<String> duzeltilenKelimeler = new ArrayList<>();  //  duzeltilen kelime listesi
    ArrayList<String> eskiKelimeler = new ArrayList<>();        //  kelimelerin duzenlenmeden onceki halini tutuyor
    
    @Override
    public ArrayList hataDuzeltmeYontemi(ArrayList<Object> hataliKelimeler) {
               
        for (Object kelime : hataliKelimeler) {                         // hatali kelimeleri kontrol etmek icin tek tek alıyor
            
            char[] textArray = kelime.toString().toCharArray();
            
            for (int j =0;j<textArray.length;j++){
                kelimeHarfler.add(Character.toString(textArray[j]));
            }
            
            for (int i = 0; i < kelimeHarfler.size()-1; i++){
                                
                String temp;
                String ssKelime = "";
                                                                        //  kelimenin single transposition'larini olusturuyor
                temp = kelimeHarfler.get(i);
                kelimeHarfler.set(i, kelimeHarfler.get(i+1));
                kelimeHarfler.set(i+1, temp);
                                                                        //  bulunan single transposition tekrar kelimeye donusturuluyor
                for (String harf : kelimeHarfler) {
                    ssKelime += harf;
                }                
                                                                        //  kelimeyi eski haline donderiyor
                temp = kelimeHarfler.get(i);
                kelimeHarfler.set(i, kelimeHarfler.get(i+1));
                kelimeHarfler.set(i+1, temp);               
                                                                        //  duzeltilen kelimeleri words.txt de olup olmadigini kontrol ediyor.
                for (String s : txtKelimeler) {                         //  txtKelimeler = words.txt'deki kelimeler
                    if (ssKelime.equals(s)) {
                        duzeltilenKelimeler.add(ssKelime);
                        eskiKelimeler.add(kelime.toString());
                    }
                }                
            }            
            System.out.println("");
            kelimeHarfler.clear();
        } 
        return duzeltilenKelimeler;
    }

    @Override
    public ArrayList EskiKelimeleriAl() {
        return eskiKelimeler;
    }
    
}
