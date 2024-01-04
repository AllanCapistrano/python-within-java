from argparse import ArgumentParser

def main():
    parser = ArgumentParser(description='Exemplo de passagem de valores para um script Python.')
    
    # Adicione argumentos aqui
    parser.add_argument('valor1', type=int, help='Primeiro valor')
    parser.add_argument('valor2', type=int, help='Segundo valor')

    args = parser.parse_args()

    # Acesse os valores passados como argumentos
    resultado = args.valor1 + args.valor2
    print(f'O resultado da soma é: {resultado}')

if __name__ == "__main__":
    main()