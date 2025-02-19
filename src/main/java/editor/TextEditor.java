
package editor;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

/**
 *
 * @author furkan-A
 */
public class TextEditor extends javax.swing.JFrame {

    private File dosyaYolu;
    private final UndoManager undoManager = new UndoManager();
    static String[] txtKelimeler;  
    ArrayList<Object> hataliKelimeler;
    ArrayList<Object> dogruKelimeler;
    
    PanelIslemler panelIslem = new PanelIslemler(this);
    
    
    public TextEditor() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        tabPanel = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        dosyaOlustur = new javax.swing.JMenuItem();
        dosyaAc = new javax.swing.JMenuItem();
        dosyaKapat = new javax.swing.JMenuItem();
        dosyayiKaydet = new javax.swing.JMenuItem();
        duzenleMenu = new javax.swing.JMenu();
        geriAl = new javax.swing.JMenuItem();
        bul = new javax.swing.JMenuItem();
        degistir = new javax.swing.JMenuItem();
        hata = new javax.swing.JMenu();
        hataBul = new javax.swing.JMenuItem();
        hataDuzelt = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Dosya");

        dosyaOlustur.setText("Oluştur");
        dosyaOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaOlusturActionPerformed(evt);
            }
        });
        jMenu1.add(dosyaOlustur);

        dosyaAc.setText("Aç");
        dosyaAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaAcActionPerformed(evt);
            }
        });
        jMenu1.add(dosyaAc);

        dosyaKapat.setText("Kapat");
        dosyaKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaKapatActionPerformed(evt);
            }
        });
        jMenu1.add(dosyaKapat);

        dosyayiKaydet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        dosyayiKaydet.setText("Kaydet");
        dosyayiKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyayiKaydetActionPerformed(evt);
            }
        });
        jMenu1.add(dosyayiKaydet);

        jMenuBar1.add(jMenu1);

        duzenleMenu.setText("Düzenle");

        geriAl.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        geriAl.setText("Geri Al");
        geriAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriAlActionPerformed(evt);
            }
        });
        duzenleMenu.add(geriAl);

        bul.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        bul.setText("Bul");
        bul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulActionPerformed(evt);
            }
        });
        duzenleMenu.add(bul);

        degistir.setText("Değiştir");
        degistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistirActionPerformed(evt);
            }
        });
        duzenleMenu.add(degistir);

        jMenuBar1.add(duzenleMenu);

        hata.setText("Hata");

        hataBul.setText("Hataları Bul");
        hataBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hataBulActionPerformed(evt);
            }
        });
        hata.add(hataBul);

        hataDuzelt.setText("Hatayı Düzelt");
        hataDuzelt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hataDuzeltActionPerformed(evt);
            }
        });
        hata.add(hataDuzelt);

        jMenuBar1.add(hata);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyaOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaOlusturActionPerformed
               
        String dosyaIsmi = "";
        int result = -1;
        // olusturulacak dosya dizini secme araci
        JFileChooser fc = new JFileChooser();
	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        result = fc.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION){
                // secilen dizini alma 
            dosyaYolu = fc.getSelectedFile();            
            dosyaIsmi = JOptionPane.showInputDialog(null, "dosya ismi (.txt)");      
            
            JTextPane yeniTextPanel = panelIslem.olustur();   
            yeniTextPanel.getDocument().addUndoableEditListener(undoManager); 
            getTabPanel().add(dosyaIsmi+ ".txt", yeniTextPanel);            
        }  
        else {
            System.out.println("İşlem iptal edildi...");
        }
    }//GEN-LAST:event_dosyaOlusturActionPerformed

    private void dosyaAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaAcActionPerformed
        
        int result = -1;
        JFileChooser fc = new JFileChooser(); 
        // dosya secme aracını çagirma 
        result = fc.showOpenDialog(this);         

        if (result == JFileChooser.APPROVE_OPTION) { 
            // kaydedilecek dizini seçme aracı 
            dosyaYolu = fc.getSelectedFile();
            File file = new File(fc.getSelectedFile().getAbsolutePath()); 
            dosyaYolu = dosyaYolu.getParentFile();
            try {   // dosyayı okumak için buffered ve file reader oluşturuluyor ve ekrana yazılıyor                
                String satir = "";
                String tumMetin = "";                 
                FileReader fileRead = new FileReader(file);              
                BufferedReader bufReader = new BufferedReader(fileRead); 
                
                tumMetin = bufReader.readLine(); 
                
                // dosyanın icindeki tum stringleri alma
                while ((satir = bufReader.readLine()) != null) { 
                    tumMetin = tumMetin + "\n" + satir;                  
                } 
                      
              // ekranda gosterilmek uzere textpane sekmesi olusturulur ve acilir
                JTextPane yeniTextPaneli = panelIslem.ac(); // new JTextPane();
                yeniTextPaneli.getDocument().addUndoableEditListener(undoManager);
                                
                getTabPanel().add(file.getName(), yeniTextPaneli);                
                yeniTextPaneli.setText(tumMetin);
            } 
            catch (IOException e) { 
                System.out.println("--- HATA --- Dosya Okunamıyor " +file.toString()); 
            } 
        }
    }//GEN-LAST:event_dosyaAcActionPerformed

    private void dosyaKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaKapatActionPerformed
        
        int sonuc = JOptionPane.showConfirmDialog(null, "Dosyayı kaydetmek istiyor musunuz?");
        // dosyanin kapatilmasi onayini alir ve gereken islemleri yapar
        switch (sonuc) {
            case JOptionPane.YES_OPTION:
                dosyayiKaydetActionPerformed(evt);
               // getTabPanel().remove(getIndex());
                panelIslem.kapat(getIndex());
                break;
            case JOptionPane.NO_OPTION:          
                panelIslem.kapat(getIndex());
               // tabPanel.remove(getIndex());  
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Cancel edildi: ");
                break;
            default:
                break;            
        }    }//GEN-LAST:event_dosyaKapatActionPerformed

    private void dosyayiKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyayiKaydetActionPerformed
       // ekranda acik olan text pane 'in indexini aliyor
        int index = getIndex();
        
        File file = new File(dosyaYolu + "\\" + getTabPanel().getTitleAt(index));
        FileWriter writer;
        BufferedWriter bufWriter;
        try { 
            // Dosyayı kaydetmek için file ve buffered writer oluşturuluyor.
            writer = new FileWriter(file, false); 
            bufWriter = new BufferedWriter(writer);
                    
            bufWriter.write(((JTextPane)getTabPanel().getComponentAt(index)).getText());
            
            bufWriter.close();
            System.out.println("Dosya Kaydetme Başarılı");
        } 
        catch (IOException e) { 
            System.out.println("--- HATA --- Dosya kaydetmede hata olustu " +file.toString()); 
        } 
       
    }//GEN-LAST:event_dosyayiKaydetActionPerformed

    private void hataBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hataBulActionPerformed

        // ekranda acik olan text pane 'in metnini stringe aktariyor
        String metin = metniAl();
        dogruKelimeler  = new ArrayList<>();
        hataliKelimeler = new ArrayList<>();
        
        List<Object> kelimeListesi = metniOku(metin);       // ekranda olan metni metod yardimi ile kelimelere parcaliyor ve diziye ekliyor
                                                            // hata kontrol etmek icin kelimleri dogru ve hatali olarak ayrı arraylistlere atmak icin liste olusturuyoruz   
                 
        IterableEditor iterEd = new IterableEditor(kelimeListesi);
        Iterator iterator = iterEd.getIterator();
        String kelime;
        boolean bulunduMu = false;
        
        while (iterator.hasNext()) {      // metinde olan kelimeler tek tek gezilip dogru ve hatali olarak listeye aktariliyor.
            kelime = (String)iterator.next();
            bulunduMu = false;
            for (String word : txtKelimeler) {
                if (kelime.equalsIgnoreCase(word)) {                 
                    bulunduMu = true;               
                    break;
                }
            }  
            if (bulunduMu) { dogruKelimeler.add(kelime); }  
            else {  hataliKelimeler.add(kelime); }
        } 
        String wrongWords = "";
        // arraylistlere aktarilan kelimeler  ekranın sag tarafindaki kutucuklara yazdiriyor. 

       // hataliKelimeGoster.setText("**** Hatalı Kelimeler ****\n");
        for (Object hatali : hataliKelimeler) {
            // hataliKelimeGoster.append((String)hatali + "\n");
            wrongWords += (String)hatali + ", "; 
            
        }
        JOptionPane.showMessageDialog(null, wrongWords, "Hatalı Kelimeler", HEIGHT);
        
    }//GEN-LAST:event_hataBulActionPerformed

    private void hataDuzeltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hataDuzeltActionPerformed
        
        hataBulActionPerformed(evt);                                    // hatalari duzeltebilmek icin once kelimelerin hatali olanlarını hataKontrol et yardimi ile bulmaliyiz
        HataDuzelt hata = new HataDuzelt(new SingleTranStrateji());
        
        ArrayList<String> singleKelimeler = hata.StratejiUygula(hataliKelimeler);
        ArrayList<String> eskiKelimeler  = hata.KelimeleriAl();
        
        String metin = metniAl();
        String duzelenKelimeler = "";
        
       // bilgiEkrani.setText("**** Düzeltilen Kelimeler ****\n");        // burada duzeltilenler ekranin saginda bulunan kutucuga yazilmaktadir.
        for (int i = 0; i < singleKelimeler.size(); i++) {
            metin = metin.replace(eskiKelimeler.get(i), singleKelimeler.get(i));
            duzelenKelimeler +=  (String)singleKelimeler.get(i) + ", ";
            
         //   bilgiEkrani.append((String)singleKelimeler.get(i) + "\n");
        }
        JOptionPane.showMessageDialog(null, duzelenKelimeler, "Düzeltilen Kelimeler", HEIGHT);

        ((JTextPane)getTabPanel().getComponentAt(getIndex())).setText(metin);
    }//GEN-LAST:event_hataDuzeltActionPerformed

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        // ekranda acik olan text pane 'in indexini aliyor
        int index = getIndex();
        String metin = metniAl();
        
        String input = JOptionPane.showInputDialog(null, "Değiştirmek istediğiniz kelimeyi giriniz:");
        System.out.println("input: "+ input);
        String yeniKelime = "";
        String kelime;        
        boolean bulunduMu = false;
         
        List<Object> kelimeListesi = metniOku(metin);       
              
        IterableEditor iterEd = new IterableEditor(kelimeListesi);
        Iterator iterator = iterEd.getIterator();
        
        while (iterator.hasNext()) {
            kelime = (String)iterator.next();
            if (kelime.equalsIgnoreCase(input)) {
                if (bulunduMu != true){ // aynı kelimenin metin icerisinde birden fazla olmasi durumunda yeni kelimeyi tekrardan almamak suretiyle if blogu acilmistir.
                    yeniKelime = JOptionPane.showInputDialog(null, "yeni kelimenizi giriniz:");
                }
                bulunduMu = true;
                kelime = yeniKelime;                  
            }
        }
        if (bulunduMu) {  // degistirilecek kelimenin sonrasinda gelen index e bakip ona gore replace yapiliyor.
            metin = metin.replaceAll(input + "([.])", yeniKelime + ".");
            metin = metin.replaceAll(input + "([,])", yeniKelime + ",");
            metin = metin.replaceAll(input + "([ ])", yeniKelime + " ");
            metin = metin.replaceAll(input + "([;])", yeniKelime + ";");
            metin = metin.replaceAll(input + "([:])", yeniKelime + ":");
            metin = metin.replaceAll(input + "([\n])", yeniKelime + "\n");
                  
            ((JTextPane)getTabPanel().getComponentAt(index)).setText("");     
            ((JTextPane)getTabPanel().getComponentAt(index)).setText(metin);
        }
        else {         
            JOptionPane.showMessageDialog(null, "Kelime Bulunamadı!!!");
        }
    }//GEN-LAST:event_degistirActionPerformed

    private void bulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulActionPerformed
        
        int index = getIndex();
        String metin = metniAl();
      // bulunan kelimenin arkaplanini boyamak icin gerekli siniflarin nesneleri
        MutableAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setBackground(attributes, Color.WHITE);

        StyledDocument doc = ((JTextPane)getTabPanel().getComponentAt(index)).getStyledDocument();
        String text;
        try {       /*     ilk once ne olursa olsun metin siyaha boyaniyor 
                     *    cunku eger onceden boyanmis kelime varsa onu eski hale getirmek icin
                     */
            text = doc.getText(0, doc.getLength());
            doc.setCharacterAttributes(0, metin.length(), attributes, true);
        } catch (BadLocationException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

        String input = JOptionPane.showInputDialog(null, "Bulmak istediğiniz kelimeyi giriniz:").trim();
        System.out.println("Aranan Kelime: "+ input);            
                
        List<Object> kelimeListesi = metniOku(metin); 
        
        IterableEditor iterEd = new IterableEditor(kelimeListesi);
        Iterator iterator = iterEd.getIterator();
        
        boolean bulunduMu = false;
        String kelime;
        int x = 0; // kelimenin bulundugu indexi dondurmede yardimci integer deger
        

        while (iterator.hasNext()) {
            kelime = (String)iterator.next();
            if (input.equalsIgnoreCase(kelime)) {
                try {
                    // bulunan kelimenin arkaplanini yesil renge boyar
                    StyleConstants.setBackground(attributes, Color.GREEN);
                    doc = ((JTextPane)getTabPanel().getComponentAt(index)).getStyledDocument();
                    text = doc.getText(0, doc.getLength());

                    doc.setCharacterAttributes(x, input.length(), attributes, true);
                    x += input.trim().length() + 1; // x, boyanacak kelimelerin indexlerini bulmaya yarar

                } catch (BadLocationException ex) {
                    System.out.println("boyamada hata");
                }
                bulunduMu = true;
            }
            else {               
                x += (kelime.length() + 1);
            }
        }
        if (bulunduMu==false){
            JOptionPane.showMessageDialog(null, "Kelime Bulunamadı!!!");
        }
    }//GEN-LAST:event_bulActionPerformed

    private void geriAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriAlActionPerformed

        UndoableEditor ue = new UndoableEditor(this, undoManager);
        ue.geriAl();
        
    }//GEN-LAST:event_geriAlActionPerformed

    private String metniAl(){
        int index = getIndex();
        String metin = ((JTextPane)getTabPanel().getComponentAt(index)).getText();
        return metin;
    }
    
    protected int getIndex() {
        
        return getTabPanel().getSelectedIndex();
    }
    
    public List<Object> metniOku(String metin) { // ekrandan alinan metnin parcaliyor
    
        String[] kelimeler = metin.split("[ ,.;:\n]");   
        List<Object> kelimeler2 = new ArrayList<>(); 
        
        for (String string : kelimeler) {
            String trim = string.trim();
            kelimeler2.add(trim);
        }
                        
        return kelimeler2;
    }
    
    public static String[] txtOku() { // words.txt dosyasini okuyup bir String dizisinde atiyor.
        Scanner fileIn = null;       
        String words = "";
              
        try {
            fileIn = new Scanner(new FileInputStream("words.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found ");
        }      
        
        while (fileIn.hasNext()) {            
            String satir = fileIn.nextLine();
            words = words + " " + satir;            
        }
        
        // words.txt dosyasındaki kelimeleri diziye aktarıyor
        String[] kelime = words.split(" ");
        System.out.println("toplam kelime sayısı: " + kelime.length);
               
        return kelime;

    }
    
    public javax.swing.JTabbedPane getTabPanel() {
        return tabPanel;
    }
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        System.out.println("\n--- 'words.txt' dosyası okunuyor! ---");
        long basla = System.currentTimeMillis();
        txtKelimeler = txtOku();
        long bitis = System.currentTimeMillis();              
        System.out.println("\ndosya okunma süresi: "+ (bitis-basla)/1000 +" sn");
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);

            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bul;
    private javax.swing.JMenuItem degistir;
    private javax.swing.JMenuItem dosyaAc;
    private javax.swing.JMenuItem dosyaKapat;
    private javax.swing.JMenuItem dosyaOlustur;
    private javax.swing.JMenuItem dosyayiKaydet;
    private javax.swing.JMenu duzenleMenu;
    private javax.swing.JMenuItem geriAl;
    private javax.swing.JMenu hata;
    private javax.swing.JMenuItem hataBul;
    private javax.swing.JMenuItem hataDuzelt;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tabPanel
     */
    
}
