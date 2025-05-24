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
![CpuViewAtualizada](https://github.com/user-attachments/assets/abddc355-a585-486f-918d-1f5563228bc5)

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
![MemView](https://github.com/user-attachments/assets/b93409d5-51a1-4f91-b744-aa55aa15539d)

Aqui, é possível ver informações de:

- Quantidade total de memória
- Total de memória disponível para uso 
- Quantidade de memória sendo utilizada (valor em **GB**, porcentagem e gráfico)
- Total de memória reservada para Hardware
- Frequência das memórias em **MHz**
- Total de slots da placa-mãe usados
- Tipo da memória

E também informações específicas de processos ativos:

- Nome
- ID do Processo
- Porcentagem usada da memória
- Threads usadas
- Usuário executando o processo


## 📁 Disco: 
![DiskView1](https://github.com/user-attachments/assets/e129287b-735e-4633-8504-31580add52ad)
![DiskView2](https://github.com/user-attachments/assets/be366df8-6e2b-4331-96ae-abbcc1b8aedb)

Na View de Disco, o usuário encontra informações de armazenamento do seu hardware, contando com uma lista de dispositivos de armazenamento e suas respectivas informações de: 

- Nome 
- Porcentagem de tempo de atividade
- Capacidade de armazenamento
- Quantidade de dados escritos e lidos (em **GB**)

O usuário também pode selecionar um dispositivo dentro da lista, e acessar algumas informações adicionais: 

- Quantidade utilizada do armazenamento (Em **GB** e barra de progresso representando o uso)
- Velocidade de escrita e leitura do dispositivo, que varia entre **KB/s**, **MB/s** e **GB/s** de acordo com a velocidade
- Capacidade real do dispositivo
- Capacidade do dispositivo formatado

## 📡 Rede:
