<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../geral/menu.jsp"></c:import>

<section id="content">
	<div class="main">
		<div class="breadcrumb" style="margin: 0 0 10px 0">
			<a href="#">Home</a> / <a href="#">Apostas</a> / <strong>Façam
				suas Apostas</strong>
		</div>
		<div class="container_betlist relative">
			<article class="grid_bets a2">
				<div class="inner">
					<h3 class="hp-1">Façam suas Apostas</h3>
					<div class="hr"></div>
					<form id="contact-form">
						<fieldset id="page4">
							<c:forEach var="confronto" items="${confrontoList}">
								<div class="padding-2">
									<div class="col-1">
										<a href=""><img
											src="/makeyourbad_2.0/images/page2-img2.jpg" alt=""
											style="opacity: 1;"><span></span></a> <strong
											class="project-name">${confronto.lutador1.nome}</strong>
									</div>
									<div class="col-info">
										<p class="info-details">
											Nome: ${confronto.lutador1.envergadura}<br /> Altura:
											${confronto.lutador1.altura} <br /> Peso:
											${confronto.lutador1.peso} <br /> Especialidade:
											${confronto.lutador1.sumario} <br /> From:
											${confronto.lutador1.lugar} <br /> Cinturao:
											${confronto.lutador1.cinturao} <br /> Data de Nascimento:
											${confronto.lutador1.dataNascimento} <br />
										</p>
										<p class="vs-thumb">
											<img src="/makeyourbad_2.0/images/vs-image.png" alt=""
												style="width: 40px; margin-top: 40px;">
										</p>
										<p class="info-details">
											Nome: ${confronto.lutador2.envergadura}<br /> Altura:
											${confronto.lutador2.altura} <br /> Peso:
											${confronto.lutador2.peso} <br /> Especialidade:
											${confronto.lutador2.sumario} <br /> From:
											${confronto.lutador2.lugar} <br /> Cinturao:
											${confronto.lutador2.cinturao} <br /> Data de Nascimento:
											${confronto.lutador2.dataNascimento} <br />
										</p>

									</div>
									<div class="col-2">
										<a href=""><img
											src="/makeyourbad_2.0/images/page2-img1.jpg" alt=""><span></span></a>
										<strong class="project-name">${confronto.lutador2.nome}</strong>
									</div>
									<div class="clear"></div>
								</div>
							</c:forEach>
						</fieldset>
					</form>
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
									<li><a href="#" class="activeSlide">1</a> <a href="#">2</a>
										<a href="#">3</a></li>
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
