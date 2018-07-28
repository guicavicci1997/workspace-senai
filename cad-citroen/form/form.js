<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Citroen</title>
 <link type="text/css" href="<c:url value='/assets/css/form.css' />" rel="stylesheet" />
</head>



<body>

<form:form id = "form_cad" action="${s:mvcUrl('PFC#gravar').build()}" method="post" commandName = "pessoaFisica">
	<h1>Formulário de cadastro para Teste Drive Citroen</h1>
    <div class ="atb_cadastro">
        <label>Nome</label>
        <form:input path="nome" />
        <form:errors path="nome" />
    </div>
    <div class ="atb_cadastro">
        <label>Sobrenome</label>
        <form:input path="sobrenome"/>
        <form:errors path="sobrenome" />
        <!--<form:errors path="sobrenome" /> -->
    </div>
    <div class ="atb_cadastro">
        <label>Data de Nascimento</label>
        <form:input path="dataNascimento" placeholder="yyyy/MM/dd"/>
    </div>
    <div class ="atb_cadastro">
        <label>Renda Mensal</label>
        <form:input path="rendaMensal" />
    </div>
    <div id = "opcoes_carros" class ="atb_cadastro"> 
    	<label>Opções de Carros</label>
        <select name= "carros">
        	<option>C3</option>
        	<option>Aircross</option>
        	<option>C4Lounge</option>
        	<option>C4Picasso</option>       
        </select>
                
    </div>
    <button type="submit">Cadastrar</button>
</form:form>

</body>
</html>