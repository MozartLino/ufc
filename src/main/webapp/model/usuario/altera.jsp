<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 0 15px">
			<a href="#">Home</a> / <a href="#">Alterar</a> / <strong>Usuario</strong>
		</div>
		<div class="container_24 relative">

			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Alterar Dados do Usuario</h3>
					<div class="hr"></div>

					<form id="contact-form" action="altera"
						enctype="multipart/form-data" method="POST">
						<fieldset>
							<input type="hidden" name="usuario.id" value="${usuario.id}">
							<p>
								<label class="nome">Nome:<br /> <input type="text"
									name="usuario.nome" value="${usuario.nome}" />
								</label>
							</p>
							<p>
								<label class="">CPF:<br /> <input type="text"
									name="usuario.cpf" value="${usuario.cpf}" />
								</label>
							</p>
							<p>
								<label class="login">Login:<br /> <input type="text"
									name="usuario.login" value="${usuario.login}" />
								</label>
							</p>
							<p>
								<label class="senha">Senha:<br /> <input type="text"
									name="usuario.senha" value="${usuario.senha}" />
								</label>
							</p>
							<p>
								<label class="email">E-mail:<br /> <input type="text"
									name="usuario.email" value="${usuario.email}" />
								</label>
							</p>

							<div class="clear"></div>
							<br />
							<div class="clear"></div>
							<div class="btns">
								<a class="link-2" id="altera">salvar</a>
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
						<img src="images/page2-img1.jpg" class="img-indent-bot" alt="">
						<p class="p1 p2">
							<strong>Bradley Grosh</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3">{...}</a>
						</p>
					</div>
					<div class="row-2">
						<img src="images/page2-img2.jpg" class="img-indent-bot" alt="">
						<p class="p1 p2">
							<strong>Patrick Pool</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3">{...}</a>
						</p>
					</div>
					<div class="row-2">
						<img src="images/page2-img3.jpg" class="img-indent-bot" alt="">
						<p class="p1 p2">
							<strong>John Franklin</strong>
						</p>
						<p class="p1">
							Mauris accumsa nulla vel diam sed in lacus ut enim adipiscing
							aliquet. Nulla venenatis in pede mi <a href="more.html"
								class="link-3">{...}</a>
						</p>
					</div>
				</div>
			</article>
			<div class="clear"></div>
		</div>
	</div>
</section>
<c:import url="../geral/rodape.jsp"></c:import>

