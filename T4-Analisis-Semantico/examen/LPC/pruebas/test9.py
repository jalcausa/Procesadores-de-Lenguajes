numeros = [1,2,3,7,11,13]
lista = [ x+1 for x in [x*x for x in numeros ] if x*x>10 ]
lista = [ y*x for x in numeros for y in numeros if y>0 and x<10]
print(lista)
