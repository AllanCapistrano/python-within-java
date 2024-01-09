import argparse
import ast

import numpy as np

def main():
    parser = argparse.ArgumentParser(description='Exemplo de criação de array NumPy a partir de uma lista de valores.')

    # Adicione argumentos aqui
    parser.add_argument('valores', type=str, help='Valores para criar o array NumPy como uma lista')

    args = parser.parse_args()

    # Converte a string para uma lista utilizando ast.literal_eval
    valores_lista = ast.literal_eval(args.valores)

    # Cria um array NumPy a partir dos valores fornecidos
    numpy_array = np.array(valores_lista)

    # print('Array NumPy criado:')
    print(list(numpy_array)) # Para o Process Builder
    # print(numpy_array) # Para o Apache Common Exec

if __name__ == "__main__":
    main()
