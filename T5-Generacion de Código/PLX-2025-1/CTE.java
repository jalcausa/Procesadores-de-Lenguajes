public class CTE extends EXPRESION {

    public CTE(String valor, EXPRESION dcha) {
        super(null, null);
        this.temp = valor;
    }

    public boolean esConstante() {
        try {
            Integer.parseInt(this.temp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getValor() {
        return Integer.parseInt(this.temp);
    }
}
