public class INTERSECCION extends EXPRESION {

    public INTERSECCION(EXPRESION izq, EXPRESION dcha) {
        super(izq, dcha);
        this.setTipo(TIPO.CONJUNTO);
        this.setSubtipo(izq.getSubtipo());
        this.temp = Generador.nuevaTemporal();
    }

    public void gc() {
        EXPRESION e1 = (EXPRESION) this.izq;
        EXPRESION e2 = (EXPRESION) this.dcha;
        
        e1.gc();
        e2.gc();
        
        String tempRes = this.temp;
        String lenRes = tempRes + "_length";
        
        Generador.asigna(lenRes, "0");
        
        String i = Generador.nuevaTemporal();
        String elem = Generador.nuevaTemporal();
        
        String lInicio = Generador.nuevaLabel();
        String lCuerpo = Generador.nuevaLabel();
        String lFin = Generador.nuevaLabel();
        
        Generador.asigna(i, "0");
        Generador.printlabel(lInicio);
        Generador.menor(i, e1.getTemp() + "_length", lCuerpo, lFin);
        Generador.printlabel(lCuerpo);
        Generador.asigna(elem, e1.getTemp() + "[" + i + "]");
        
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
        Generador.menor(j, e2.getTemp() + "_length", lBuscaCuerpo, lBuscaFin);
        Generador.printlabel(lBuscaCuerpo);
        Generador.asigna(elem2, e2.getTemp() + "[" + j + "]");
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
    }
}
