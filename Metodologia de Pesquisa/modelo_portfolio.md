# Portfólio - 3° Semestre de Banco de Dados

### Descrição
O projeto foi desenvolvido em parceria com a Dom Rock, empresa especializada em soluções de tecnologia voltadas para big data, inteligência artificial e data lakes em nuvem, com foco em aumentar a produtividade e a agilidade nas operações e decisões estratégicas das organizações.
O desafio proposto à equipe consistiu na criação de um software capaz de receber arquivos CSV e, por meio de uma interface intuitiva, permitir que o usuário realizasse o mapeamento dos dados, gerando automaticamente um arquivo YML compatível com o algoritmo utilizado no pipeline de processamento da empresa.

Essa solução teve como objetivo eliminar a necessidade de conhecimento técnico específico exigido pela criação manual do arquivo YML, tornando o processo mais simples e acessível.

[Repositório](https://github.com/BeatrizPlacido/API_3SEM)

### Tecnologias Utilizadas

#### Front-end
- **HTML:** Estruturação das páginas e organização dos elementos visuais da interface.
- **CSS:** Responsável pela aparência, estilos e layout da aplicação, garantindo usabilidade.
- **JavaScript:** Permite interatividade e dinamismo na interface, tornando a experiência do usuário mais fluida.

#### Back-end
- **Java 8:** Linguagem base utilizada para implementar a lógica do sistema.
- **Java Development Kit (JDK) 21:** Fornece o ambiente de desenvolvimento atualizado, com ferramentas e bibliotecas para compilar e executar o código Java.
- **Spring Boot:** Framework que facilita a criação e configuração da aplicação back-end, agilizando o desenvolvimento.
- **Spring JPA:** Simplifica a persistência e manipulação de dados no banco, garantindo acesso eficiente às informações.
- **Spring Security:** Responsável por autenticação e controle de acesso, garantindo a segurança da aplicação.
- **JWT (JSON Web Tokens):** Mecanismo de autenticação baseado em tokens, utilizado para validar sessões de usuários de forma segura.

#### Contribuições Pessoais
Como a escolha da tecnologia para o desenvolvimento do front-end foi atribuída ao grupo, optamos por utilizar JavaScript puro, visando aprofundar nosso conhecimento e familiaridade com a linguagem. Ao longo do projeto, atuei exclusivamente no front-end, colaborando em diversas tarefas, oferecendo suporte aos colegas e corrigindo pequenos bugs identificados durante as sprints. Minhas principais contribuições concentraram-se em:

  <details>
   <summary>Interface que permite realizar o mapeamento de dados do CSV.</summary>
    O projeto foi dividido em três etapas principais seguindo a segmentação do pipeline de processamento da empresa.

    A primeira, denominada "Landing Zone", permite que o usuário faça o upload de um arquivo no formato CSV, contendo as informações necessárias para a análise. Após o envio, o sistema solicita o preenchimento de detalhes sobre os dados do arquivo, como o tipo de dado de cada coluna, a descrição do conteúdo e o ajuste dos nomes conforme as especificações do algoritmo responsável pela geração do arquivo YML.


    * Tabela gerada de forma dinâmica com base nos dados do CSV:
    ```js
    function generateTable(){

        let table = document.getElementById("body_dados");
        for (let x = 0; x < dados.length; x++) {
            let dadosTable = `
            <tr>
                <td class="checkbox-container"><input type="checkbox" class="checkbox-custom" id="checkbox${x}"></td>
                <td><input type="text" class="inputs" id="input-text${x}" value="${dados[x]}"></td>
                <td>${exampleData[x]}</td>
                <td>
                    <select class="inputs select-custom" id="select${x}">
                        <option value="string">Texto</option>
                        <option value="float">Número decimal</option>
                        <option value="int">Número inteiro</option>
                        <option value="boolean">Verdadeiro/Falso</option>
                        <option value="char">Caracter Único (Ex: M ou F)</option>
                        <option value="date">Data</option>
                    </select>
                </td>
                <td><textarea name="desc" id="desc${x}" class="desc_input"></textarea></td>
            </tr>`;
            table.insertAdjacentHTML("afterbegin", dadosTable);
        }
    }
    ```

    * Request resonsável por enviar os dados da tabela para o backend:
    ```js
    async function sendData(allData) {
        try{
            let response = await api.post("/colunas", allData);

            if(response.status === 201) {
                let message = "Campos registrados com sucesso.";
                let path = '/Front-end/media/images/success-img.gif'
                prompt_function(message, path, 1)
            }
        }catch(error){
            let message = "Alguma coisa deu errado. Tente novamente mais tarde.";
            let path = '/Front-end/media/images/error-img.gif'
            prompt_function(message, path, 0)
        }
    }
    ```
  </details>

  <details>
   <summary>Detalhes</summary>
   
  </details>

  <details>
   <summary>Dashboard interativo de consolidação dos dados</summary>
   
    Utilizamos a lib Chart.js para construir o dashboard para exibição das métricas gerais do sistema (metadados, usuários e empresas) e gráficos dinâmicos alimentados pela API.

    A estrutura do dash foi construída no arquivo /pages/admin/homeAdmin.html e utiliza as funções implementadas no arquivo /scripts/admin/homeAdmin.js para exibir os seguintes gráficos

    * Distribuição dos tipos de dado por arquivo (Float, String, Int etc.)

    * Distribuição de status das colunas (Pendente, Invalidado, Validado)

    * Distribuição de estágios dos arquivos dentro do pipeline definido (LandingZone, Bronze, Silver, Finalizado)


    Abaixo segue o exemplo da implementação realizada no código para realizar a busca de dados na API

   ```js
    async function getTiposDeDados(idMetadata, idEmpresa) {
        try{
            let body = [idEmpresa]

            let response = await api.post(`/dash/quantityTypeData/${idMetadata}`, body);
            let dadosEmpresa = response.data;

            if(response.status === 200) {
                tipos_de_dados(dadosEmpresa)
            }else{
                let message = "Alguma coisa deu errado. Tente novamente mais tarde.";
                let path = '/Front-end/media/images/error-img.gif'
                prompt_function(message, path)
            }
        }
        catch(error){
            let message = "Alguma coisa deu errado. Tente novamente mais tarde.";
            let path = '/Front-end/media/images/error-img.gif'
            prompt_function(message, path)
        }
    }
   ```

    e a função utilizada para construção do gráfico com base nos dados retornados pela função acima

   ```js

    function tipos_de_dados(dadosEmpresa) {
        const idCanva = Chart.getChart("myChart")

        if (idCanva) {
            idCanva.destroy();
        }

        let xValues = ["Float", "String", "Integer", "Boolean", "Char", "Date"];
        let yValues = [dadosEmpresa.Float, dadosEmpresa.String, dadosEmpresa.Int, dadosEmpresa.Boolean, dadosEmpresa.Char, dadosEmpresa.Date];
        let barColors = ["#08115E", "#B6CAF8", "#6188DE", "#94C2FF", "#65A2FF"];

        new Chart("myChart", {
            type: "bar",
            data: {
                labels: xValues,
                datasets: [{
                    backgroundColor: barColors,
                    data: yValues
                }]
            },
            options: {
                plugins: {
                    legend: { display: false }
                },
                title: {
                    display: false,
                    text: "TIPOS DE DADO POR METADATA"
                },
                scales: {
                    x: {
                        grid: {
                            display: false
                        }
                    },
                    y: {
                        grid: {
                            display: false
                        }
                    }
                }
            }
        });
    }
   ```
  </details>

#### Hard Skills
* HTML5, CSS3, JavaScript - Usei no desenvolvimento frontend, criando interfaces responsivas e dinâmicas, com autonomia.
* MySQL - Utilizei para modelagem e gerenciamento de dados relacionais, com capacidade plena de criação de queries e ajustes no banco de dados.
* IntelliJ IDEA - Ferramenta utilizada no desenvolvimento do projeto, com alto nível de proficiência na customização do ambiente e uso de plugins.
* Git/GitHub - Versionamento de código e trabalho em equipe, com eficiência no uso de branches, pull requests e resolução de conflitos.
* Figma - Para prototipagem de interfaces e colaboração no design da solução, utilizando a ferramenta com eficiência.

#### Soft Skills
* Comunicação - Foi essencial para alinhar as expectativas da equipe durante as reuniões de planejamento e revisões de sprint e na resolução de conflitos relacionados a integração com o backend.
* Trabalho em equipe - Pela forma como dividimos o time entre responsáveis pelo frontend e pelo backend além da comunicação tivemos que execitar muito a habilidade de trabalho em equipe para garantir a integração entre as entregas.
* Organização - Mediante prazos de entrega das Sprints e as disciplinas, precisei me organizar para cumprir conforme planejado, principalmente em períodos de provas.
