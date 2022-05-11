'''
DFA Simulator: 
    Equipe Shaolin:
        Enrico Giannobile RA: 19.00610-0
        Guilherme de Campos RA: 20.00089-8
        Luis Guilherme de Souza Munhoz RA: 20.01937-8

'''

def simulate_dfa(dfa, input):
    '''
    Função que simula um dfa a partir de um arquivo e de um input de uma cadeia 
    '''
    state = dfa['initial_state']   # estado inicial 
    accept = False
    initial_input = input # armazenando a cadeia para mostrar se ela foi aceita ou rejeitada
    input = list(input)   # transformando a cadeia digitada pelo usuário em uma lista para fácil manipulação
    while(len(input) > 0):

        c = input.pop(0)

        if(c not in dfa['sigma']):
            # Insere c de volta na cadeia, exibe mensagem de erro e sai do loop se c não está no alfabeto do dfa
            input.insert(0, c)
            print(f"o símbolo {c} não pertence ao alfabeto do autômato!")
            break

        if(state not in dfa['states']):
            # Se o estado não estiver na lista de estados do dfa exibe mensagem de erro e sai do loop
            print(f"o estado {state} não pertence conjunto de estados do autômato!")
            break
        try:
            # Tenta exibir os estados transitados durante a simulação
            print(f"({state}, '{c}') ->  {dfa['delta'][(state,c)]}")
            state = dfa['delta'][(state, c)]
        except KeyError:
            # Caso não conseguir exibe mensagem de erro e sai do loop
            print(f"Não foi possível realizar a transição do estado {state} com entrada {c}")
            break
    if (state in dfa['final_states'] and len(input) == 0):
        # Verifica se o estado atual está na lista de estados finais e se a cadeia toda foi percorrida
        accept = True
    if(accept):
        print()
        print(f"A cadeia {initial_input} foi aceita pelo autômato!")
        print()
    else:
        print()
        print(f"A cadeia {initial_input} foi rejeitada pelo autômato!")
        print()

def get_file():
    '''
    O usuário digita o nome do arquivo e o programa 
    tenta abrir o arquivo e,
    caso o arquivo não for encontrado ou ocorrer algum erro pede para verificar se está tudo certo e tentar novamente, 
    
    '''
    while True:
        try:
            filename = input("Digite o nome do arquivo: ")
            with open(filename) as dfa_file:
                dfa_data = dfa_file.read()
        except OSError:
        
            print('Erro ao acessar o arquivo. Verifique se o nome do arquivo está correto e se ele está no mesmo diretório que o main.py e tente novamente.')
        else:
            return dfa_data


def main():
    '''
    Função que chama a função simulate_dfa, exibe uma pequena interface para o programa e 
    exibe mensagem de programa finalizado caso CTRL + C for apertado
    '''
    try:
        print()
        print("=" * 80)
        while(True):
            print()
            # Entrada da cadeia a ser simulada pelo dfa
            user_input = input("Digite a cadeia de entrada do autômato: ")
            print()
            simulate_dfa(dfa, user_input)
            print()
    except KeyboardInterrupt:
        print()
        print("Programa finalizado pelo usuário")
        print()
        print("=" * 80)

dfa_data = get_file()

dfa = eval(dfa_data)


main()
