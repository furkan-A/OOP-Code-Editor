
package editor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author furkan-A
 */
public class IterableEditor implements Liste {
    
    protected List<Object> liste = new LinkedList<>();

    public IterableEditor(List<Object> listee) {
        int count = 0;
        for (Object eleman : listee) {
            liste.add(count, eleman);
            count++;
        }
    }
    
    @Override
    public Iterator getIterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator {
        
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < liste.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Object value = liste.get(index);
            index++;
            return value;      
        }
    }
    
}
