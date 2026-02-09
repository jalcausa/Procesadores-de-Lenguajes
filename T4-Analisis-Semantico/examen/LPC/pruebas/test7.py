numeros = [2,3,5,7]
lista = [ x+y for x in [x*x for x in numeros ] for y in numeros]
print(lista)
