# Projeto Políticas de Escalonamento

# - CONTEÚDOS ABORDADOS: 

•	Escalonamento de Processos

o	FIFO (First In First Out)

o	Prioridade estática (quantum = 2)

o	RMS (Rate Monotonic Scheduling)


# - Descrição do Projeto

O projeto consistirá na Implementação de 3 (três) políticas de escalonamento com realização de cálculos de métricas para avaliação dos mesmos previamente definidas:

•	1 Política de escalonamento para sistemas em lote (não preemptiva)

•	1 Política de escalonamento para sistemas interativos (preemptiva)

•	1 Política de escalonamento para sistemas de tempo real


# - Entradas

O programa desenvolvido deverá ler de um arquivo de entrada, com formato definido abaixo, uma lista de processos com seus respectivos (a)tempo de chegada, (b)tempo de computação, (c)tempos de I/O, (d)prioridade, (e)período e (f)deadline, sendo (d) considerado apenas para a execução de políticas de sistemas interativos; e (e) e (f) para as políticas de sistemas de tempo real.
A entrada é composta por uma série de pares de números inteiros separados por um espaço em branco indicando cada um dos parâmetros listados acima, na ordem, de cada processo. A entrada termina com o fim do arquivo.

Exemplo de entrada:

0 20 [3:5;7:9;12:15;18:19] 1 0 0

0 10 [2:3;5:7;8:9] 3 20 20

4 6 [3:4] 1 20 10

4 8 [] 4 15 15

4 8 [] 4 15 15

# - Saídas

A saída do projeto é um arquivo composto por uma tabela para cada política de escalonamento utilizada composta da seguinte forma:

Throughput = 

Política X - Estatísticas de Execução

id do processo processo	tempo de resposta	quantidade de tempo em i/o	quantidade de tempo no estado pronto

1			

2			

3			

