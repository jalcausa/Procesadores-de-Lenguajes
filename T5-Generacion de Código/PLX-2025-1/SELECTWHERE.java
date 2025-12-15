public class SELECTWHERE extends AST {

    private CONDICION condicion;

    public SELECTWHERE(CONDICION cond) {
        super(null, null);
        this.condicion = cond;
    }

    public CONDICION getCondicion() {
        return this.condicion;
    }

    public void gc() {
    }
}
