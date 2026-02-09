public class DECLARSET extends EXPRESION {

    private String nomVar;
    private ASIG asig;

    public DECLARSET(AST anterior, TIPO t, String id, ASIG a){
        super(anterior, null);
        this.nomVar = id;
        this.tipo = t;
        this.temp = id;
        this.asig = a;
    }

    public TIPO getTipoDecl(){
        return this.tipo;
    }

    public void gc(){
        if(this.izq != null){
            this.izq.gc();
        }
        Generador.printLength(nomVar, 0);
        if(this.asig != null){
            this.asig.gc();
        }
    }
}
