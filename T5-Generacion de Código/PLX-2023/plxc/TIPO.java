public class TIPO {
    public static final int NOASIGNADO = 0;
    public static final int ENTERO = 1;
    public static final int REAL = 2;
    public static final int CARACTER = 3;
    public static final int CONJUNTO = 4;

    private int tipo;
    private int subtipo;
    private int tam;

    public TIPO(){
        tipo = 0;
        subtipo = 0;
        tam = 0;
    }

    public TIPO(int t){
        tipo = t;
        subtipo = -1;
        tam = 0;
    }

    public TIPO(int t, int st){
        tipo = t;
        subtipo = st;
        tam = 0;
    }

    public TIPO(int t, int st, int exptam){
        tipo = t;
        subtipo = st;
        tam = exptam;
    }

    public int getTipo(){
        return tipo;
    }

    public int getSubtipo(){
        return subtipo;
    }

    public int getTam(){
        return this.tam;
    }

    public void setTipo(int nt){
        tipo = nt;
    }

    public void setSubtipo(int nst){
        subtipo = nst;
    }

    public void setTam(int t){
        this.tam = t;
    }
}
