public class ASIGMAS extends EXPRESION {

    private String nomVar;

    public ASIGMAS(String id, EXPRESION dcha){
        super(null, dcha);
        this.temp = id;
        this.nomVar = id;
        this.tipo = TablaSimbolos.getTipo(id);
    }

    public void gc(){
        EXPRESION exp = (EXPRESION) this.dcha;
        exp.gc();
        
        String lenVar = nomVar + "_length";
        
        if(exp.getTipo() == TIPO.CONJUNTO){
            String tempExp = exp.getTemp();
            String lenExp = tempExp + "_length";
            
            String j = Generador.nuevaTemporal();
            String elem2 = Generador.nuevaTemporal();
            
            String lInicio = Generador.nuevaLabel();
            String lCuerpo = Generador.nuevaLabel();
            String lFin = Generador.nuevaLabel();
            
            Generador.asigna(j, "0");
            Generador.printlabel(lInicio);
            Generador.menor(j, lenExp, lCuerpo, lFin);
            Generador.printlabel(lCuerpo);
            Generador.asigna(elem2, tempExp + "[" + j + "]");
            
            String k = Generador.nuevaTemporal();
            String encontrado = Generador.nuevaTemporal();
            String elemK = Generador.nuevaTemporal();
            String lBusca = Generador.nuevaLabel();
            String lBuscaCuerpo = Generador.nuevaLabel();
            String lBuscaFin = Generador.nuevaLabel();
            String lEncontrado = Generador.nuevaLabel();
            String lNoEncontrado = Generador.nuevaLabel();
            String lSiguiente = Generador.nuevaLabel();
            String lContinuar = Generador.nuevaLabel();
            
            Generador.asigna(encontrado, "0");
            Generador.asigna(k, "0");
            Generador.printlabel(lBusca);
            Generador.menor(k, lenVar, lBuscaCuerpo, lBuscaFin);
            Generador.printlabel(lBuscaCuerpo);
            Generador.asigna(elemK, nomVar + "[" + k + "]");
            Generador.igualdad(elemK, elem2, lEncontrado, lSiguiente);
            Generador.printlabel(lEncontrado);
            Generador.asigna(encontrado, "1");
            Generador.gotolabel(lBuscaFin);
            Generador.printlabel(lSiguiente);
            Generador.asigna(k, k + " + 1");
            Generador.gotolabel(lBusca);
            Generador.printlabel(lBuscaFin);
            
            Generador.igualdad(encontrado, "0", lNoEncontrado, lContinuar);
            Generador.printlabel(lNoEncontrado);
            Generador.asigna(nomVar + "[" + lenVar + "]", elem2);
            Generador.asigna(lenVar, lenVar + " + 1");
            Generador.printlabel(lContinuar);
            
            Generador.asigna(j, j + " + 1");
            Generador.gotolabel(lInicio);
            Generador.printlabel(lFin);
        } else {
            String encontrado = Generador.nuevaTemporal();
            String k = Generador.nuevaTemporal();
            String elemK = Generador.nuevaTemporal();
            String lBusca = Generador.nuevaLabel();
            String lBuscaCuerpo = Generador.nuevaLabel();
            String lBuscaFin = Generador.nuevaLabel();
            String lEncontrado = Generador.nuevaLabel();
            String lNoEncontrado = Generador.nuevaLabel();
            String lSiguiente = Generador.nuevaLabel();
            String lFinal = Generador.nuevaLabel();
            
            Generador.asigna(encontrado, "0");
            Generador.asigna(k, "0");
            Generador.printlabel(lBusca);
            Generador.menor(k, lenVar, lBuscaCuerpo, lBuscaFin);
            Generador.printlabel(lBuscaCuerpo);
            Generador.asigna(elemK, nomVar + "[" + k + "]");
            Generador.igualdad(elemK, exp.getTemp(), lEncontrado, lSiguiente);
            Generador.printlabel(lEncontrado);
            Generador.asigna(encontrado, "1");
            Generador.gotolabel(lBuscaFin);
            Generador.printlabel(lSiguiente);
            Generador.asigna(k, k + " + 1");
            Generador.gotolabel(lBusca);
            Generador.printlabel(lBuscaFin);
            
            Generador.igualdad(encontrado, "0", lNoEncontrado, lFinal);
            Generador.printlabel(lNoEncontrado);
            Generador.asigna(nomVar + "[" + lenVar + "]", exp.getTemp());
            Generador.asigna(lenVar, lenVar + " + 1");
            Generador.printlabel(lFinal);
        }
    }
}
