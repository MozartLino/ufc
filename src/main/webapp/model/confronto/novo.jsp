<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 0 15px">
			<a href="#">Home</a> / <a href="#">Cadastrar</a> / <strong>Confronto</strong>
		</div>
		<div class="container_24 relative">

			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Cadastro de Confronto</h3>
					<div class="hr"></div>

					<form id="contact-form" action="salva"
						enctype="multipart/form-data" method="POST">
						<fieldset>
							<p>
								<label class="name"> Evento:<br /> <input type="text"
									id="evento" name="confronto.evento">
								</label>
							</p>
							<p>
								<label class="data"> Data:<br /> <input type="text"
									name="confronto.data" />
								</label>
							</p>
							<p>
								<label> 1° Lutador:<br /> <select name="confronto.lutadorId1" class="estado select" id="lutador1">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${lutador.id}">${lutador.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<p>
								<label> 2° Lutador:<br /> <select name="confronto.lutadorId2" class="estado select" id="lutador2">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${lutador.id}">${lutador.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
								<label> Categoria:<br /> <select name="confronto.categoriaId" class="estado select" id="categoria">
										<option value="sec">Selecionar...</option>
										<c:forEach var="categoria" items="${categoriaList}">
											<option value="${categoria.id}">${categoria.descricao}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<div class="clear"></div>
							<br />
							<div class="clear"></div>
							<div class="btns">
								<a class="link-2" id="submit">salvar</a>
							</div>
						</fieldset>
					</form>
				</div>
			</article>


			<article class="grid_7 a2">
				<div class="inner">
					<h3 class="hp-1">Not�cias</h3>
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

