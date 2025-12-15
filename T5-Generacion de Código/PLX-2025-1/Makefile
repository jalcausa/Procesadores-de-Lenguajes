PROG=PLXC

$(PROG).class: $(PROG).java parser.java Yylex.java sym.java
	javac *.java

parser.java sym.java: $(PROG).cup 
	cup $(PROG).cup

Yylex.java: $(PROG).flex sym.java
	jflex $(PROG).flex

clean:
	rm -f *.class Yylex.java sym.java parser.java

test: $(PROG).class
	@for f in plxc-init-2025/*.plx; do \
		echo "Testing $$f..."; \
		java PLXC "$$f" > /tmp/test.ctd 2>&1; \
	done
