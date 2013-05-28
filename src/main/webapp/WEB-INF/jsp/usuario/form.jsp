<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content" ng-app ng-controller="usuarioController">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 0 15px">
			<a href="#">Home</a> / <a href="#">Cadastrar</a> / <strong>Usuário</strong>
		</div>
		<div class="container_24 relative">

			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Cadastro Usuário</h3>
					<div class="hr"></div>

					<form id="contact-form" enctype="multipart/form-data" method="POST">
						<fieldset>
							<p>
								<label class="name"> Nome:<br /> <input type="text"
									id="nome" name="usuario.nome" ng-model="usuario.nome"
									value="${usuario.nome}">
								</label>
							</p>
							<p>
								<label class=""> CPF:<br /> <input type="text"
									name="usuario.cpf" id="cpf" ng-model="usuario.cpf"
									value="${usuario.cpf}">
								</label>
							</p>
							<p>
								<label class="email"> Email:<br /> <input type="text"
									name="usuario.email" id="email" ng-model="usuario.email"
									value="${usuario.email}">
								</label>
							</p>
							<p>
								<label class="login"> Login:<br /> <input type="text"
									id="login" name="usuario.login" ng-model="usuario.login"
									value="${usuario.login}" id="login">
								</label> <label class="senha"> Senha:<br /> <input
									type="password" id="senha" name="usuario.senha"
									ng-model="usuario.senha" value="${usuario.senha}">
								</label>
							</p>
							<p>
								<c:if test="${userSession.usuario.perfil == 1}">
									<label> Perfil:<br /> <select name="usuario.perfil"
										ng-model="usuario.perfil" class="estado select">
											<option value="">Selecione...</option>
											<option value="1">Administrador</option>
											<option value="2">Apostador</option>
									</select>
									</label>
								</c:if>
							</p>
							<p style="color: red; display: none;" id="retorno-form">Por
								Favor, Informe os dados corretamente.</p>
							<div class="clear"></div>
							<br />
							<div class="clear"></div>
							<div class="btns">
								<a class="link-2" id="submit" ng-click="salvaPaciente()">salvar</a>
							</div>
						</fieldset>
					</form>
				</div>
			</article>


			<article class="grid_7 a2">
				<div class="inner">
					<h3 class="hp-1">Notícias</h3>
					<div class="hr"></div>
					<div class="row-1">
						<p class="p1 p2">
							<strong>Bradley Grosh</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3"></a>
						</p>
					</div>
					<div class="row-2">
						<p class="p1 p2">
							<strong>Patrick Pool</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3"></a>
						</p>
					</div>
					<div class="row-2">
						<p class="p1 p2">
							<strong>John Franklin</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3"></a>
						</p>
					</div>
				</div>
			</article>
			<div class="clear"></div>
		</div>
	</div>
</section>
<c:import url="../geral/rodape.jsp"></c:import>
<script src="<c:url value='/js/model/user.js' />" type="text/javascript"></script>
