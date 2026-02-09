public class UNION extends EXPRESION {

    public UNION(EXPRESION izq, EXPRESION dcha) {
        super(izq, dcha);
        this.setTipo(TIPO.CONJUNTO);
        if(izq.getTipo() == TIPO.CONJUNTO){
            this.setSubtipo(izq.getSubtipo());
        } else {
            this.setSubtipo(izq.getTipo());
        }
        this.temp = Generador.nuevaTemporal();
    }

    public void gc() {
        EXPRESION e1 = (EXPRESION) this.izq;
        EXPRESION e2 = (EXPRESION) this.dcha;
        
        e1.gc();
        
        String tempRes = this.temp;
        String lenRes = tempRes + "_length";
        
        Generador.asigna(lenRes, "0");
        
        String i = Generador.nuevaTemporal();
        String elem = Generador.nuevaTemporal();
        
        String lInicio1 = Generador.nuevaLabel();
        String lCuerpo1 = Generador.nuevaLabel();
        String lFin1 = Generador.nuevaLabel();
        
        Generador.asigna(i, "0");
        Generador.printlabel(lInicio1);
        Generador.menor(i, e1.getTemp() + "_length", lCuerpo1, lFin1);
        Generador.printlabel(lCuerpo1);
        Generador.asigna(elem, e1.getTemp() + "[" + i + "]");
        Generador.asigna(tempRes + "[" + lenRes + "]", elem);
        Generador.asigna(lenRes, lenRes + " + 1");
        Generador.asigna(i, i + " + 1");
        Generador.gotolabel(lInicio1);
        Generador.printlabel(lFin1);
        
        e2.gc();
        
        if(e2.getTipo() == TIPO.CONJUNTO) {
            String j = Generador.nuevaTemporal();
            String elem2 = Generador.nuevaTemporal();
            
            String lInicio2 = Generador.nuevaLabel();
            String lCuerpo2 = Generador.nuevaLabel();
            String lFin2 = Generador.nuevaLabel();
            
            Generador.asigna(j, "0");
            Generador.printlabel(lInicio2);
            Generador.menor(j, e2.getTemp() + "_length", lCuerpo2, lFin2);
            Generador.printlabel(lCuerpo2);
            Generador.asigna(elem2, e2.getTemp() + "[" + j + "]");
            
            String k = Generador.nuevaTemporal();
            String encontrado = Generador.nuevaTemporal();
            String elemK = Generador.nuevaTemporal();
            String lBusca = Generador.nuevaLabel();
            String lBuscaCuerpo = Generador.nuevaLabel();
            String lBuscaFin = Generador.nuevaLabel();
            String lEncontrado = Generador.nuevaLabel();
            String lNoEncontrado = Generador.nuevaLabel();
            String lSiguiente = Generador.nuevaLabel();
            
            Generador.asigna(encontrado, "0");
            Generador.asigna(k, "0");
            Generador.printlabel(lBusca);
            Generador.menor(k, lenRes, lBuscaCuerpo, lBuscaFin);
            Generador.printlabel(lBuscaCuerpo);
            Generador.asigna(elemK, tempRes + "[" + k + "]");
            Generador.igualdad(elemK, elem2, lEncontrado, lSiguiente);
            Generador.printlabel(lEncontrado);
            Generador.asigna(encontrado, "1");
            Generador.gotolabel(lBuscaFin);
            Generador.printlabel(lSiguiente);
            Generador.asigna(k, k + " + 1");
            Generador.gotolabel(lBusca);
            Generador.printlabel(lBuscaFin);
            
            Generador.igualdad(encontrado, "0", lNoEncontrado, lCuerpo2 + "_next");
            Generador.printlabel(lNoEncontrado);
            Generador.asigna(tempRes + "[" + lenRes + "]", elem2);
            Generador.asigna(lenRes, lenRes + " + 1");
            Generador.printlabel(lCuerpo2 + "_next");
            Generador.asigna(j, j + " + 1");
            Generador.gotolabel(lInicio2);
            Generador.printlabel(lFin2);
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
            Generador.menor(k, lenRes, lBuscaCuerpo, lBuscaFin);
            Generador.printlabel(lBuscaCuerpo);
            Generador.asigna(elemK, tempRes + "[" + k + "]");
            Generador.igualdad(elemK, e2.getTemp(), lEncontrado, lSiguiente);
            Generador.printlabel(lEncontrado);
            Generador.asigna(encontrado, "1");
            Generador.gotolabel(lBuscaFin);
            Generador.printlabel(lSiguiente);
            Generador.asigna(k, k + " + 1");
            Generador.gotolabel(lBusca);
            Generador.printlabel(lBuscaFin);
            
            Generador.igualdad(encontrado, "0", lNoEncontrado, lFinal);
            Generador.printlabel(lNoEncontrado);
            Generador.asigna(tempRes + "[" + lenRes + "]", e2.getTemp());
            Generador.asigna(lenRes, lenRes + " + 1");
            Generador.printlabel(lFinal);
        }
    }
}
