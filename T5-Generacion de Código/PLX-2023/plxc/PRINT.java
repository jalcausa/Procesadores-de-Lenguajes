public class PRINT extends AST{

    public PRINT(AST izq, AST dcha){
        super(izq, null);
    }

    public void gc(){
        if(this.izq != null){
            this.izq.gc();
        }

        int tipo = ((EXPRESION)this.izq).getTipo();
        int subtipo = ((EXPRESION)this.izq).getSubtipo();
        String id = ((EXPRESION)this.izq).getTemp();

        switch (tipo) {
            case TIPO.CARACTER:
                Generador.writec(id);
                Generador.writec("10");
                break;

            case TIPO.CONJUNTO:
                String i = Generador.nuevaTemporal();
                String elem = Generador.nuevaTemporal();
                String lenId = id + "_length";
                
                String lInicio = Generador.nuevaLabel();
                String lCuerpo = Generador.nuevaLabel();
                String lFin = Generador.nuevaLabel();
                String lNoEspacio = Generador.nuevaLabel();
                String lConEspacio = Generador.nuevaLabel();
                
                Generador.asigna(i, "0");
                Generador.printlabel(lInicio);
                Generador.menor(i, lenId, lCuerpo, lFin);
                Generador.printlabel(lCuerpo);
                
                Generador.igualdad(i, "0", lNoEspacio, lConEspacio);
                Generador.printlabel(lConEspacio);
                Generador.writec("32");
                Generador.printlabel(lNoEspacio);
                
                Generador.asigna(elem, id + "[" + i + "]");
                
                if(subtipo == TIPO.CARACTER){
                    Generador.writec(elem);
                } else {
                    Generador.write(elem);
                }
                
                Generador.asigna(i, i + " + 1");
                Generador.gotolabel(lInicio);
                Generador.printlabel(lFin);
                Generador.writec("10");
                break;
                
            default:
                Generador.print(id);
                break;
        }
    }
}
