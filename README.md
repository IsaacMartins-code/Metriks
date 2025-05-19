<img src="https://github.com/user-attachments/assets/e5d216a8-f538-4373-a065-4449fb530631" width=380px height=100px>

# 🖥Monitor de processos e gerenciador de Hardware

Monitor de processos em Java, que usa a biblioteca **OSHI** para informações de 
processos / hardware e **JavaFX** para visualização das métricas, com interface intuitiva 
inspirada em gerenciadores nativos de sistemas operacionais.

## 📚Conceitos e tecnologias utilizadas: 

- Java 
- Orientação a Objetos
- JavaFX
- OSHI
- Maven

## 👁‍🗨Nele, é possível ver métricas de:

- Processador
- Memória RAM
- Disco
- Rede

A seguir, screenshots de cada view e o que é possível ver.

## 🧮 Processador: 
<img src="https://github.com/user-attachments/assets/d7d6103b-1dae-464f-8223-8ce8c9560086" alt = "CpuView">

Nesta view, o usuário pode ver informações sobre o processador, como: 

- Nome
- Porcentagem usada pelo sistema (valores e gráfico)
- Porcentagem usada pelos usuários (valores e gráfico)
- Quantidade de Processos rodando
- Quantidade total de Threads consumidas por todos os Processos
- Clock Base
- Quantidade de núcleos
- Quantidade de Processadores Lógicos

E também uma lista de processos ativos no sistema, com especificações de: 

- Nome
- ID do Processo
- Porcentagem usada do processador
- Threads usadas
- Tempo de execução no processador
- Usuário executando o processo

## 💾 Memória RAM:
<img src="https://github.com/user-attachments/assets/84c4a22c-77d7-4704-9db0-36c23e9300b6" alt = "MemView">

Aqui, é possível ver informações de:

- Quantidade total de memória
- Total de memória disponível para uso 
- Quantidade de memória sendo utilizada (valor em GB, porcentagem e gráfico)
- Total de memória reservada para Hardware
- Frequência das memórias em MHz
- Total de slots da placa-mãe usados
- Tipo da memória

E também informações específicas de processos ativos:

- Nome
- ID do Processo
- Porcentagem usada da memória
- Threads usadas
- Usuário executando o processo


## 📁 Disco: 
## 📡 Rede:
