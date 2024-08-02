# Encurtador de URLs

O desafio foi implementar um serviço que permite encurtar URLs longas para torná-las mais compactas e fáceis de
compartilhar. O desafio foi proposto pelo [backend-br](https://github.com/backend-br/desafios/tree/master/url-shortener).

## Requisitos

- O encurtador de URLs recebe uma URL longa como parâmetro inicial.
- O encurtamento será composto por um mínimo de 05 e um máximo de 10 caracteres.
- Apenas letras e números são permitidos no encurtamento.
- A URL encurtada será salva no banco de dados com um prazo de validade (você pode escolher a duração desejada).
- Ao receber uma chamada para a URL encurtada `https://xxx.com/DXB6V`, você deve fazer o redirecionamento para a
  URL original salva no banco de dados. Caso a URL não seja encontrada no banco, retorne o código de
  status `HTTP 404 (Not Found)`.

## Como rodar o projeto
É necessário configurar três variáveis de ambiente:
- `db_url`: URL de conexão com o banco de dados;
- `db_user`: Usuário do banco de dados;
- `db_password`: Senha do banco de dados.