## Trabalho das disciplinas LBD, FSI e IHC

1. [Introdução](#introducao)
2. [Requisitos para o desenvolvimento](#requisitos)
3. [Telas do site](#telas)
4. [API REST (RESOURCES)](#rest)
5. [Integrantes](#integrantes)

<a name="introducao" />
### Introdução

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sollicitudin ullamcorper lacinia. 
Fusce tellus tortor, venenatis feugiat mattis non, dapibus sed lacus. Sed gravida vehicula tortor. 
Cras mollis pulvinar blandit. Nunc placerat hendrerit nibh vehicula rhoncus. Sed euismod est erat. 
Phasellus luctus rutrum felis, quis accumsan dui tincidunt ac. Aenean hendrerit sem nec ipsum scelerisque eget congue metus posuere. Nullam sodales scelerisque justo, ac interdum erat malesuada sit amet. 
Praesent vitae purus elit. Proin congue, lacus nec lobortis tempor, magna nisl elementum urna, ut aliquet lectus risus vitae turpis. Integer hendrerit venenatis fringilla. Morbi non mattis tellus. Donec elit dui, pulvinar sagittis dapibus eget, tempor vel quam. Nulla pretium vulputate ornare.

Donec ac ligula et felis lacinia venenatis nec in ante. Sed aliquam hendrerit enim, vel bibendum ligula tristique et. Maecenas cursus, eros eget dignissim elementum, odio ipsum lacinia eros, non convallis lectus quam eget tellus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam hendrerit euismod eros, ut imperdiet justo imperdiet at. Pellentesque hendrerit euismod fringilla. Duis vel neque non sem sollicitudin cursus vel vitae nulla. Duis non sem nibh, vitae condimentum eros. Nulla dapibus fringilla ligula, in congue erat porta et. Vivamus malesuada mattis turpis id accumsan. Suspendisse volutpat neque eget dolor pretium vel cursus libero ultrices. Nunc condimentum porta turpis, id rhoncus sapien hendrerit non. Integer molestie volutpat sem a hendrerit. Vestibulum euismod, dolor in lobortis semper, lorem massa interdum dolor, quis ultrices metus dolor in arcu.

<a name="requisitos" />
### Requisitos do desenvolvimento

* Banco de Dados Mysql
* Eclipse IDE
* Plugin Maven para eclipse

<a name="telas" />
### Telas do site

HOME<br />
LOGIN<br />
Cadastro de Usuario<br />


<a name="rest" />
### API REST (Recursos para criação do layout)

###Usuarios

<table width="100%">
	<thead>
		<tr>
			<th width="40%">Recurso</th>
			<th width="60%">Descrição</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="#post-usuarios">POST /usuarios<a/></td>
			<td>
				<i>Cadastra um usuário</i>
			</td>
		</tr>

		<tr>
			<td><a href="#put-usuarios">PUT /usuarios</a></td>
			<td><i>Altera um usuário</i></td>
		</tr>

		<tr>
			<td><a href="#get-usuarios-id">Get /usuarios/:id</a></td>
			<td><i>Perfil do usuário</i></td>
		</tr>

		<tr>
			<td><a href="#get-usuarios">GET /usuarios</a></td>
			<td><i>Ranking de Usuários</i></td>
		</tr>

	</tbody>
</table>

###Lutadores

<table width="100%">
	<thead>
		<tr>
			<th width="40%">Recurso</th>
			<th width="60%">Descrição</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="#post-lutadores">POST /lutadores<a/></td>
			<td>
				<i>Cadastra um lutador</i>
			</td>
		</tr>

		<tr>
			<td><a href="#put-lutadores">PUT /lutadores</a></td>
			<td><i>Altera um lutador</i></td>
		</tr>

		<tr>
			<td><a href="#get-lutadores/{id}">Get /lutadores/:id</a></td>
			<td><i>Perfil do lutador</i></td>
		</tr>

		<tr>
			<td><a href="#get-lutadores">GET /lutadores</a></td>
			<td><i>Lista todos Lutadores</i></td>
		</tr>

	</tbody>
</table>

###Confrontos

<table width="100%">
	<thead>
		<tr>
			<th width="40%">Recurso</th>
			<th width="60%">Descrição</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="#post-confrontos">POST /confrontos<a/></td>
			<td>
				<i>Cadastra um confronto</i>
			</td>
		</tr>

		<tr>
			<td><a href="#put-confrontos">PUT /confrontos</a></td>
			<td><i>Altera um confronto</i></td>
		</tr>

		<tr>
			<td><a href="#get-confrontos">GET /confrontos</a></td>
			<td><i>Lista todos confrontos por evento</i></td>
		</tr>

	</tbody>
</table>


###Evento

<table width="100%">
	<thead>
		<tr>
			<th width="40%">Recurso</th>
			<th width="60%">Descrição</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="#post-eventos">POST /eventos<a/></td>
			<td>
				<i>Cadastra um eventos</i>
			</td>
		</tr>

		<tr>
			<td><a href="#put-confrontos">PUT /eventos</a></td>
			<td><i>Altera um eventos</i></td>
		</tr>
	</tbody>
</table>

<a name="get-usuarios" />
#### GET /usuarios

_Devolve uma lista de usuarios._

	Url do recurso

	http://localhost:8080/ufc/usuarios

	Exemplo de requisição

	GET http://localhost:8080/coletor/templates
	```
	[
		{
			"id": "1",
			"nome": "Ricardo Mozart Lino",
			"cpf": "39764341837",
			"login": "ricardo.mozart",
			"email": "ricardo.mozart@gmail.com"
			"perfil": "1"


		},
		{
			"id": "1",
			"nome": "Ricardo Mozart Lino",
			"cpf": "39764341837",
			"login": "ricardo.mozart",
			"email": "ricardo.mozart@gmail.com"
			"perfil": "1"


		}
	]
	```
	
<a name="get-usuarios-id" />
#### GET /templates/:id

_Devolve um formulário com todos os campos_

	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates/:id

	Exemplo de requisição

	GET http://<SEU-DOMINIO>:8080/coletor/templates/519a7d41c38f6b4eb02df70c
	```
	{
		title: "Formulário",
		fields: [{
			label: "nome",
			type: "text",
			required: true
		}]
	}
	```


<a name="post-templates" />
#### POST /templates

_Adiciona um formulário_

##### Parâmetros:

<table width="100%">
	<thead>
		<tr>
			<th width="40%">Atributos</th>
			<th width="60%">Descrição</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				title<br/>
				<i>requerido</i>
			</td>
			<td>
				<i>String</i><br/>
				<b>Ex value:</b> Formulário teste
			</td>
		</tr>

		<tr>
			<td>
				fields<br/>
				<i>requerido deve conter ao menos um field</i>
			</td>
			<td>
				<i>Array</i><br/>
			</td>
		</tr>

		<tr>
			<td>
				field.label<br/>
				<i>requerido</i>
			</td>
			<td>
				<i>String</i><br/>
				<b>Ex value:</b> Nome
			</td>
		</tr>

		<tr>
			<td>
				field.type<br/>
				<i>requerido</i>
			</td>
			<td>
				<i>String</i><br/>
				valores: color, date, datetime, datetime-local, email, month, number, tel, time, url, week, checkbox, radio
				<b>Ex value:</b> text
			</td>
		</tr>

		<tr>
			<td>
				field.required<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>booleano</i><br/>
				se omitido por padrão é false.<br/>
				<b>Ex value:</b> true
			</td>
		</tr>

		<tr>
			<td>
				field.readOnly<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>booleano</i><br/>
				se omitido por padrão é false, caso seja true anula o required.<br/>
				<b>Ex value:</b> true
			</td>
		</tr>

		<tr>
			<td>
				field.value<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>string</i><br/>
				<b>Ex value:</b> Caio rolando da rocha
			</td>
		</tr>

		<tr>
			<td>
				field.maxLength<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>number</i><br/>
				<b>Ex value:</b> 200
			</td>
		</tr>

		<tr>
			<td>
				field.placeholder<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>string</i><br/>
				<b>Ex value:</b> Digite o nome:
			</td>
		</tr>

		<tr>
			<td>
				field.radio<br/>
				<i>opicional</i>
			</td>
			<td>
				<i>array</i><br/>
				requerido somente se o type for radio<br/>
				<b>Ex value:</b> <pre>[
    {
        "label": "M",
        "value": "masculino"
    },
    {
        "label": "F",
        "value": "feminino"
    }
]</pre>
			</td>
		</tr>
	</tbody>
</table>
	
	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates

	Exemplo de requisição

	POST http://<SEU-DOMINIO>:8080/coletor/templates

	Post Data
	```
	{
		title: "Nome do formulário",
		fields: [{
			label: "Sexo",
			type: "radio",
			required: true,
			readOnly: false,
			value: "masculino",
			radios: [
				{
					"label": "M", 
				"value": "masculino"
				}, {
					"label": "F", 
					"value": "feminino"
				}
			]
		}]
	}	
	```
	
	```
	{
		_id: "519a7d41c38f6b4eb02df70c"
		title: "Nome do formulário",
		fields: [{
			label: "Sexo",
			type: "radio",
			required: true,
			readOnly: false,
			value: "masculino",
			radios: [
				{
					"label": "M", 
				"value": "masculino"
				}, {
					"label": "F", 
					"value": "feminino"
				}
			]
		}]
	}
	```

<a name="put-templates-id" />
#### PUT /templates/:id

	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates/:id

	Atualizar um template de formulário

	Exemplo de requisição

	PUT http://<SEU-DOMINIO>:8080/coletor/templates/519a7d41c38f6b4eb02df70c

	Put Data
	```
	{
		_id: "519a7d41c38f6b4eb02df70c",
		title: "Nome do formulário alterado",
		fields: [{
			label: "Sexo",
			type: "radio",
			required: true,
			readOnly: false,
			value: "masculino",
			radios: [
				{
					"label": "M", 
				"value": "masculino"
				}, {
					"label": "F", 
					"value": "feminino"
				}
			]
		},{
			label: "Nome",
			type: "text",
			required: true
		}]
	}
	```
	
	```
	{
		_id: "519a7d41c38f6b4eb02df70c",
		title: "Nome do formulário alterado",
		fields: [{
			label: "Sexo",
			type: "radio",
			required: true,
			readOnly: false,
			value: "masculino",
			radios: [
				{
					"label": "M", 
				"value": "masculino"
				}, {
					"label": "F", 
					"value": "feminino"
				}
			]
		},{
			label: "Nome",
			type: "text",
			required: true
		}]
	}
	```

<a name="delete-templates-id" />
#### DELETE /templates/:id

	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates/:id

	Remove um template de formulário

	Exemplo de requisição

	DELETE http://<SEU-DOMINIO>:8080/coletor/templates/519a7d41c38f6b4eb02df70c

<a name="get-templates-id-data" />
#### GET /templates/:id/data

	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates/:id

	Exemplo de requisição

	PUT http://<SEU-DOMINIO>:8080/coletor/templates/519a7d41c38f6b4eb02df70c

	```
	{
		fields: [{label: "id"}, {label: "nome"}, {label: "telefone"}, {label: "email"}, {label: "apelido"}],
		data: [{
			id: "519bd0fde4b0a99234c5c6f2",
			nome: "nome1",
			telefone: "99999-999",
			email: "dlbca@gmail.com",
			apelido: "apelido1"
		},
		{
			id: "519bd0fde4b0a99234c5c53f",
			nome: "nome2",
			apelido: "apelido2",
			idade: 23
		}]
	}
	```

<a name="post-templates-id-data" />
#### POST /templates/:id/data

	Url do recurso

	http://<SEU-DOMINIO>:8080/coletor/templates/:id/data

	Exemplo de requisição

	POST http://<SEU-DOMINIO>:8080/coletor/templates/519a7d41c38f6b4eb02df70c/data

	Post Data
	```
	{
		nome: "",
		telefone: "",
		email: "",
		apelido: ""
	}
	```
<a name="integrantes" />
### Integrantes

Ricardo Mozart Lino n 6872088
Victor Rodrigues

<table width="100%">
	<thead>
		<tr>
			<th width="70%">Nome</th>
			<th width="30%">Número USP</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Diego Shibata Ramos Da Silva</td>
			<td>9999999</td>
		</tr>
		
		<tr>
			<td>Leonardo Cadastro</td>
			<td>9999999</i></td>
		</tr>


		<tr>
			<td>Ricardo Mozart Lino</td>
			<td>6872088</i></td>
		</tr>


		<tr>
			<td>Victor Rodrigues</td>
			<td>9999999</i></td>
		</tr>

	</tbody>
</table>
