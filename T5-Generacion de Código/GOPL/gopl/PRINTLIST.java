import java.util.ArrayList;

public class PRINTLIST extends AST{

    private ArrayList<AST> expresiones;

    public PRINTLIST (ArrayList<AST> le){
        super(null, null);
        this.expresiones = le;
    }

    public void gc(){
        for(AST e : expresiones){
            PRINT printAux = new PRINT((EXPRESION)e, null);
            printAux.gc();
        }
    }

    
}
