<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 0 15px">
			<a href="#">Home</a> / <a href="#">Alterar</a> / <strong>Categoria</strong>
		</div>
		<div class="container_24 relative">

			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Alterar Categoria</h3>
					<div class="hr"></div>

					<form id="contact-form" action="altera"
						enctype="multipart/form-data" method="POST">
						<fieldset>
							<input type="hidden" id="confronto" value="${categoria.id}">
							<p>
								<label class="descricao">Descricao:<br /> <input
									type="text" name="categoria.descricao"
									value="${categoria.descricao}" />
								</label>
							</p>
							<p>
								<label class="peso_maximo">Peso Maximo:<br /> <input
									type="text" name="categoria.peso_maximo"
									value="${categoria.peso_maximo}" />
								</label>
							</p>
							<p>
								<label class="peso_minimo">Peso Minimo:<br /> <input
									type="text" name="categoria.peso_minimo"
									value="${categoria.peso_minimo}" />
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