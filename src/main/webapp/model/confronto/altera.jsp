<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 0 15px">
			<a href="#">Home</a> / <a href="#">Alterar</a> / <strong>Confronto</strong>
		</div>
		<div class="container_24 relative">

			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Alterar Confronto</h3>
					<div class="hr"></div>

					<form id="contact-form" action="altera"
						enctype="multipart/form-data" method="POST">
						<fieldset>
							<input type="hidden" id="confronto" value="${confronto.id}">
							<p>
								<label class="evento">Evento:<br /> <input type="text"
									name="confronto.evento" value="${confronto.evento}" />
								</label>
							</p>
							<p>
								<label class="data">Data:<br /> <input type="text"
									name="confronto.data" value="${confronto.data}" />
								</label>
							</p>
							<p>
								<label> 1Â° Lutador:<br /> <select
									name="confronto.lutadorId1" class="estado select" id="lutador1">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${confronto.lutador1.id}">${lutador2.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<p>
								<label> 2Â° Lutador:<br /> <select
									name="confronto.lutadorId2" class="estado select" id="lutador2">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${confronto.lutador2.id}">${lutador2.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<p>
								<label> Categoria:<br /> <select
									name="confronto.categoriaId" class="estado select"
									id="categoria">
										<option value="sec">Selecionar...</option>
										<c:forEach var="categoria" items="${categoriaList}">
											<option value="${confronto.categoria.id}">${confronto.categoria.descricao}</option>
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

Evento :
<input type="text" id="evento" name="confronto.evento">
<br />
Data
<input type="text" id="data" name="confronto.data">
<br />
1° Lutador :
<input type="text" id="lutadorId1" name="confronto.lutadorId1">
<br />
2° Lutador :
<input type="text" id="lutadorId2" name="confronto.lutadorId2">
<br />
Categoria :
<input type="text" id="categoriaId" name="confronto.categoriaId">
<br />
