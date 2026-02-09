# Makefile para el compilador LLPLXC
# Compilador de PLX a LLVM IR

# Regla por defecto: compilar todo
all: compilar

# Compilar el proyecto completo
compilar:
	cup -expect 1 LLPLXC.cup
	jflex LLPLXC.flex
	javac *.java

# Ejecutar un archivo de prueba
# Uso: make run SRC=archivo.plx
run:
	java LLPLXC $(SRC) salida.ll
	@echo "=== Código generado (salida.ll): ==="
	@cat salida.ll

# Ejecutar todas las pruebas
test:
	@for f in ../pruebas/*.plx; do \
		base=$$(basename "$$f" .plx); \
		echo "=== Probando: $$base ==="; \
		java LLPLXC "$$f" "../test_$${base}.ll" 2>&1; \
		if [ $$? -eq 0 ]; then \
			echo "OK"; \
		else \
			echo "ERROR en $$base"; \
		fi \
	done

# Limpiar archivos generados
clean:
	rm -f *.class parser.java sym.java Yylex.java Yylex.java~ ../test_*.ll

# Mostrar ayuda
help:
	@echo "Makefile para LLPLXC - Compilador PLX a LLVM IR"
	@echo ""
	@echo "Comandos disponibles:"
	@echo "  make           - Compilar el proyecto"
	@echo "  make compilar  - Compilar el proyecto"
	@echo "  make run SRC=archivo.plx - Compilar y mostrar código LLVM"
	@echo "  make test      - Ejecutar todas las pruebas"
	@echo "  make clean     - Limpiar archivos generados"
	@echo "  make help      - Mostrar esta ayuda"

.PHONY: all compilar run test clean help
