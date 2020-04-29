# Desafio Digix
Desafio técnico proposto pela empresa Digix.
API REST que realiza a seleção de famílias aptas a ganharem uma casa popular.
 
# Exigências
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

É possível executar o programa Spring Boot através de sua IDE. Executando o método principal na classe com\digix\desafio\StarterApplication.java

# Considerações
Decidi fazer uma API Rest com o framework Spring boot para ter uma melhor abstração da proposta e também possuo mais conhecimento deste framework.
Ao ler o desafio, pensei em como realizar a separação dos dados e optei em utilizar tabelas de banco de dados para organizar os dados do problema proposto.
O sistema está separado em pacotes que são: controller, dto, model, repository, service e utils. Cada pacote tem sua determinada função e é no pacote service que está a lógica do programa. 
Na classe FamiliaService  temos a lógica para montar uma lista de objetos FamiliaDTO que será devolvida no endpoint de famílias aptas. Nela montamos a lista de famílias que estão com o cadastro do tipo “Cadastro válido” , em seguida buscamos as pessoas que compõem e as rendas destas. Aproveitando o loop, já é feito a verificação de quais critérios a família se encaixa e é adicionado os pontos, no final a lista é ordenada pela da maior pontuação para a menor.
Para verificar em quais critérios as famílias se encaixam, temos as classe CriterioService, a qual possui métodos que atendem às regras de cada critério proposto. Para cada critério em que é passado um objeto FamiliaDTO para verificação de encaixe em cada um. Se nenhuma regra do critério é atendida, o objeto retorna sem alteração.
No final do loop é chamado um método para salvar em uma tabela as informações das famílias contempladas, com os dados exigidos no desafio. Com isso podemos chamar o endpoint  buscar famílias contempladas, ele realiza uma paginação para garantir uma boa performance no sistema. Tem como parâmetros a página e o tamanho da página, ele devolve uma página de objeto FamiliaContempladaDTO ordenados por data de contemplação.
Possui um último endpoint que é gerar dados fake, em que é responsável por popular o banco, a fim de realizar testes da funcionalidade.
Fiz classes de teste para verificar possíveis erros nos métodos dos endpoints e principalmente dos critérios.