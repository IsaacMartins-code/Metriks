<img src="https://github.com/user-attachments/assets/e5d216a8-f538-4373-a065-4449fb530631" width=380px height=100px>

# 🖥Monitor de processos e gerenciador de Hardware

Monitor de processos em Java, que usa a biblioteca **OSHI** para informações de 
processos / hardware e **JavaFX** para visualização das métricas, com interface intuitiva 
inspirada em gerenciadores nativos de sistemas operacionais.

## 📚Conceitos e tecnologias utilizadas: 

- Java (JDK 21.0.6 LTS)
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
![CpuView](https://github.com/user-attachments/assets/53e05398-7725-491f-b3f9-639326787567)


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
![MemView](https://github.com/user-attachments/assets/40d63de2-72f3-4435-bd40-2ab2e799d4aa)


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
![DiskView](https://github.com/user-attachments/assets/e6559dbb-b5bb-45ee-b27b-be86eb28737e)


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
![NetworkView](https://github.com/user-attachments/assets/d0550681-3652-4477-b63d-d6325079b076)

Na view rede, é possível ver quantos adaptadores de rede estão presentes no seu hardware, com informações de: 

- Nome
- Tipo de interface
- Quantidade de **GB** enviados
- Quantidade de **GB** recebidos

Também é possível selecionar um adaptador dentro da lista e obter mais informações, como: 

- Endereço Ipv4 (sensurado por questões de privacidade)
- Endereço Ipv6 (sensurado por questões de privacidade)
- Endereço MAC (sensurado por questões de privacidade)
- Pacotes enviados
- Pacotes recebidos
- velocidade de envio e recepção de dados, que varia entre **Kbps**, **Mbps** e **Gbps** de acordo com a velocidade
