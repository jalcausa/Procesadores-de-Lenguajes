public class COMENTARIO  extends AST{

    private String comentario;
    
    public COMENTARIO(String st){
        super(null, null);
        this.comentario = st;
    }

    public void gc(){
        Generador.comentario(comentario);
    }
    
}
