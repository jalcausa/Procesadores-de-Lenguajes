public class ASIGPOR extends EXPRESION {

    private String nomVar;

    public ASIGPOR(String id, EXPRESION dcha){
        super(null, dcha);
        this.temp = id;
        this.nomVar = id;
        this.tipo = TablaSimbolos.getTipo(id);
    }

    public void gc(){
        EXPRESION exp = (EXPRESION) this.dcha;
        exp.gc();
        
        String lenVar = nomVar + "_length";
        String tempRes = Generador.nuevaTemporal();
        String lenRes = tempRes + "_length";
        
        Generador.asigna(lenRes, "0");
        
        String i = Generador.nuevaTemporal();
        String elem = Generador.nuevaTemporal();
        
        String lInicio = Generador.nuevaLabel();
        String lCuerpo = Generador.nuevaLabel();
        String lFin = Generador.nuevaLabel();
        
        Generador.asigna(i, "0");
        Generador.printlabel(lInicio);
        Generador.menor(i, lenVar, lCuerpo, lFin);
        Generador.printlabel(lCuerpo);
        Generador.asigna(elem, nomVar + "[" + i + "]");
        
        String j = Generador.nuevaTemporal();
        String encontrado = Generador.nuevaTemporal();
        String elem2 = Generador.nuevaTemporal();
        String lBusca = Generador.nuevaLabel();
        String lBuscaCuerpo = Generador.nuevaLabel();
        String lBuscaFin = Generador.nuevaLabel();
        String lEncontrado = Generador.nuevaLabel();
        String lSiguiente = Generador.nuevaLabel();
        String lContinuar = Generador.nuevaLabel();
        
        Generador.asigna(encontrado, "0");
        Generador.asigna(j, "0");
        Generador.printlabel(lBusca);
        Generador.menor(j, exp.getTemp() + "_length", lBuscaCuerpo, lBuscaFin);
        Generador.printlabel(lBuscaCuerpo);
        Generador.asigna(elem2, exp.getTemp() + "[" + j + "]");
        Generador.igualdad(elem, elem2, lEncontrado, lSiguiente);
        Generador.printlabel(lEncontrado);
        Generador.asigna(encontrado, "1");
        Generador.gotolabel(lBuscaFin);
        Generador.printlabel(lSiguiente);
        Generador.asigna(j, j + " + 1");
        Generador.gotolabel(lBusca);
        Generador.printlabel(lBuscaFin);
        
        Generador.igualdad(encontrado, "1", lEncontrado + "_add", lContinuar);
        Generador.printlabel(lEncontrado + "_add");
        Generador.asigna(tempRes + "[" + lenRes + "]", elem);
        Generador.asigna(lenRes, lenRes + " + 1");
        Generador.printlabel(lContinuar);
        
        Generador.asigna(i, i + " + 1");
        Generador.gotolabel(lInicio);
        Generador.printlabel(lFin);
        
        Generador.asigna(lenVar, "0");
        String k = Generador.nuevaTemporal();
        String elemK = Generador.nuevaTemporal();
        String lCopia = Generador.nuevaLabel();
        String lCopiaCuerpo = Generador.nuevaLabel();
        String lCopiaFin = Generador.nuevaLabel();
        
        Generador.asigna(k, "0");
        Generador.printlabel(lCopia);
        Generador.menor(k, lenRes, lCopiaCuerpo, lCopiaFin);
        Generador.printlabel(lCopiaCuerpo);
        Generador.asigna(elemK, tempRes + "[" + k + "]");
        Generador.asigna(nomVar + "[" + lenVar + "]", elemK);
        Generador.asigna(lenVar, lenVar + " + 1");
        Generador.asigna(k, k + " + 1");
        Generador.gotolabel(lCopia);
        Generador.printlabel(lCopiaFin);
    }
}
