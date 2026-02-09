/*
 * AST.java
 * Clase base del Árbol de Sintaxis Abstracta (AST)
 * 
 * Representa un nodo genérico que puede contener una lista de sentencias.
 * Cada nodo tiene un hijo izquierdo y un hijo derecho.
 * El recorrido del árbol genera el código LLVM IR correspondiente.
 */

public class AST {
    
    // Hijo izquierdo (normalmente otra lista de sentencias o null)
    protected AST hijoIzquierdo;
    
    // Hijo derecho (normalmente una sentencia)
    protected AST hijoDerecho;

    /*
     * Constructor de la clase AST
     * @param izq Hijo izquierdo del nodo
     * @param der Hijo derecho del nodo
     */
    public AST(AST izq, AST der) {
        this.hijoIzquierdo = izq;
        this.hijoDerecho = der;
    }

    /*
     * Genera código LLVM IR para este nodo y sus hijos
     * Recorre el árbol en preorden (izquierdo, derecho)
     */
    public void generarCodigo() {
        // Generar código del hijo izquierdo (sentencias anteriores)
        if (hijoIzquierdo != null) {
            hijoIzquierdo.generarCodigo();
        }
        // Generar código del hijo derecho (sentencia actual)
        if (hijoDerecho != null) {
            hijoDerecho.generarCodigo();
        }
    }
}
