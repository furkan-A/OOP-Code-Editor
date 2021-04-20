
package editor;

import javax.swing.undo.UndoManager;
/**
 *
 * @author furkan-A
 */
public class UndoableEditor implements UndoableCommand {

    protected TextEditor editor;
    protected UndoManager undoMan;

    public UndoableEditor(TextEditor editor, UndoManager um) {
        this.editor = editor;
        this.undoMan = um;
    }
    
    @Override
    public void geriAl() {
        if (undoMan.canUndo()){
            undoMan.undo();
        }
    }

    @Override
    public void execute() {

    }    
    
}
