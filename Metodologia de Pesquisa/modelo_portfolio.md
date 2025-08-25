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

- **Personalização de esquema - Front-end**
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

- **Interface de listagem de metadatas - Front-end**
  <details>
   <summary>Detalhes</summary>
   
  </details>

- **Dashboard - Front-end**
  <details>
   <summary>Dashboard interativo de consolidação dos dados</summary>
   
  </details>

#### Hard Skills
Apresente as hard skills que você utilizou/desenvolveu durante o projeto e o nível de proficiência alcançado. Exemplo: CSS - Sei fazer com autonomia
- Detalhar como foi o aprendizado (trazendo evidências)

#### Soft Skills
Apresente as soft skills que você utilizou/desenvolveu durante o projeto e em quais situações elas foram fundamentais. Exemplo: Comunicação - Precisei exercitar minhas habilidades de comunicação para viabilizar as reuniões semanais levando em conta as disponibilidades dos membros, que não cursavam as mesmas disciplinas.
- Detalhar como foi o aprendizado (trazendo evidências)
