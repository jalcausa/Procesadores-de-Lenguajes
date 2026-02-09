import java.util.ArrayList;

public class CONJUNTO extends EXPRESION {

    protected ArrayList<EXPRESION> elementos;
    
    public CONJUNTO(){
        super(null, null);
        elementos = new ArrayList<>();
        this.setTipo(TIPO.CONJUNTO);
        this.setTemp(Generador.nuevaTemporal());
    }

    public CONJUNTO(int subtipo){
        super(null, null);
        elementos = new ArrayList<>();
        this.setTipo(TIPO.CONJUNTO);
        this.setSubtipo(subtipo);
        this.setTemp(Generador.nuevaTemporal());
    }

    public void anyadir(EXPRESION e){
        if(this.getTam()==0){
            this.tipo.setSubtipo(e.getTipo());
            this.elementos.add(e);
            this.setTam(1);
        } else {
            this.elementos.add(e); 
            this.setTam(elementos.size());               
        }
    }

    public ArrayList<EXPRESION> getElementos(){
        return this.elementos;
    }

    public void gc(){
        Generador.printLength(this.temp, 0);
        for (int i = 0; i < this.elementos.size(); i++){
            EXPRESION e = this.elementos.get(i);
            e.gc();
            String indice = this.temp + "_length";
            String etiq = this.temp+"["+indice+"]";
            Generador.asigna(etiq, e.getTemp());
            Generador.asigna(indice, indice + " + 1");
        }
    }
}
