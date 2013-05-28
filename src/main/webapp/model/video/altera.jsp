<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 10px 0">
			<a href="#">Home</a> / <a href="#">Cadastrar</a> / <strong>Usu√°rio</strong>
		</div>
		<div class="container_24 relative">
			<article class="grid_14 a2">
				<div class="inner">
					<h3 class="hp-1">Altera Video</h3>
					<div class="hr"></div>
					<form id="contact-form" action="altera" method="POST">
						<!--<div class="success" style="display: none; "> Contact form submitted! <strong>We will be in touch soon.</strong>
                      </div>-->
						<fieldset>
							<input type="hidden" id="video" value="${video.id}">
							<p>
								<label> 1∞ Lutador:<br /> <select
									name="video.lutadorId1" class="estado select" id="lutador1">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${lutador.id}">${lutador.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<p>
								<label> 2∞ Lutador:<br /> <select
									name="video.lutadorId2" class="estado select" id="lutador2">
										<option value="sec">Selecionar...</option>
										<c:forEach var="lutador" items="${lutadorList}">
											<option value="${lutador.id}">${lutador.nome}</option>
										</c:forEach>
								</select>
								</label>
							</p>
							<p>
								<label class="name">Url do video:<br /> <input
									type="text" name="video.url" value="${video.url}" />
								</label>
							</p>
							<div class="clear"></div>
							<div class="btns">
								<a class="link-2" data-type="submit" id="submit">salvar</a>
								<!--<a class="link-2" data-type="reset">Clear</a>-->
							</div>
						</fieldset>
					</form>
				</div>
			</article>
			<article class="grid_7 a2">
				<div class="inner">
					<h3 class="hp-1">Not√≠cias</h3>
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
<!--=====ASIDE=====-->
<aside>
	<div class="main">
		<div class="container_24">
			<div class="wrapper padding-1 vr-border-1">
				<div class="vr-border-2">
					<article class="prefix_1 grid_9 suffix_1">
						<h3>Latest News</h3>
						<div id="faded">
							<ul class="slider"
								style="position: relative; overflow: hidden; height: 162px;">
								<li
									style="position: absolute; top: 0px; left: 0px; display: list-item; z-index: 4; opacity: 1;">
									<p>
										<strong>20-10-2011</strong> Utoluptates estudesu usandaeItaque
										earumu mos rerum hic tenetura sapientemi delectu ut
										reiciedesto ndisum voluptatibus ass maiores alias dolore ipsum
										mode festum. Asperiores repellat aurerum odesum neces.
									</p>
									<div class="buttons">
										<a href="more.html" class="button-2">Read More</a>
									</div>
								</li>
								<li
									style="position: absolute; top: 0px; left: 0px; display: none; z-index: 2;">
									<p>
										<strong>15-10-2011</strong> Ipsum dolore est rerum hic
										tenetura sapientemi delectu ut reiciedesto ndisum voluptatibus
										ass maiores alias dolore ipsum mode festum. Asperiores
										repellat aurerum odesum neces.
									</p>
									<div class="buttons">
										<a href="more.html" class="button-2">Read More</a>
									</div>
								</li>
								<li
									style="position: absolute; top: 0px; left: 0px; display: none; z-index: 1;">
									<p>
										<strong>08-10-2011</strong> Uenim ad minim veniam, quis
										nostrud earumu mos rerum hic tenetura sapientemi delectu ut
										reiciedesto ndisum voluptatibus ass maiores alias dolore ipsum
										mode festum. Asperiores repellat aurerum odesum neces.
									</p> <a href="more.html" class="button-2">Read More</a>
								</li>
							</ul>
							<div class="navigation">
								<ul class="pagination">
									<a href="#" class="activeSlide">1</a>
									<a href="#">2</a>
									<a href="#">3</a>
								</ul>
							</div>
						</div>
					</article>
					<article class="prefix_1 grid_4 suffix_2">
						<h3>Company</h3>
						<ul class="list-2">
							<li><a href="more.html">About us</a></li>
							<li><a href="more.html">Work team</a></li>
							<li><a href="more.html">What we do</a></li>
							<li><a href="more.html">Clients</a></li>
							<li class="last"><a href="more.html">Testimonials</a></li>
						</ul>
					</article>
					<article class="prefix_1 grid_5">
						<h3>Address</h3>
						<dl class="adress">
							<dt>9870 St Vincent Place, Glasgow, DC 45 Fr 45.</dt>
							<dd>
								<span>+1 800 559 6580</span>Freephone:
							</dd>
							<dd>
								<span>+1 800 603 6035</span>Telephone:
							</dd>
							<dd>
								<span>+1 800 889 9898</span>FAX:
							</dd>
						</dl>
					</article>
				</div>
			</div>
		</div>
	</div>
</aside>

<c:import url="../geral/rodape.jsp"></c:import>

