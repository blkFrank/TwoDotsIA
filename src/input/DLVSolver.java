package input;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

import object.Cell;
import object.Matrix;

import java.util.Vector;

public class DLVSolver {

    private static String encodingResource="encodings/twoDots";

    private static Handler handler;

    private InputProgram facts;

    private InputProgram encoding;

    private Matrix matrix;

    public DLVSolver(Matrix matrix) {
        handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));
        facts = new ASPInputProgram();
        encoding = new ASPInputProgram();
        initFacts();
        encoding.addFilesPath(encodingResource);
        handler.addProgram(encoding);
        this.matrix = matrix;
    }

    public void initFacts() {
        for (int i = 0; i < matrix.getDim(); i++) {
            for (int j = 0; j < matrix.getDim(); j++) {
                try {
                    facts.addObjectInput(matrix.getElement(i, j));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        handler.addProgram(facts);
    }

    public void refreshProgramFact() {
        handler.removeProgram(facts);
        initFacts();
    }

    public Vector<Cell> initCellSelected() {

        Vector<Cell> cellSelected = new Vector<>();

        Output o = handler.startSync();
        AnswerSets answers = (AnswerSets) o;

        for(AnswerSet a:answers.getAnswersets()){
            try {
                for(Object obj:a.getAtoms()){
                    if(! (obj instanceof Cell))continue;
                    Cell cell= (Cell) obj;
                    cellSelected.add(cell);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cellSelected;
    }
}
