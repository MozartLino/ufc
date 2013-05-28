<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Contacts</title>
<meta charset="utf-8">

<link rel="stylesheet" href="<c:url value='/css/style.css' />" />
<link type="image/x-icon" rel="icon" href="<c:url value='/images/favicon.ico' />" >
<link type="image/x-icon" rel="shortcut icon" href="<c:url value='/images/favicon.ico' />" >

<script type="text/javascript" src="<c:url value='/js/jquery-1.7.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/superfish.js' />"></script>

</head>
<body id="page5">
	<!--=====HEADER=====-->
	<header>
		<div class="main">
			<div class="inner">
				</div>
				<h1>
					<a href="index.html">Concept interior</a>
				</h1>
				<nav>
					<ul class="sf-menu sf-js-enabled">
						<li><a href="index.html">Home</a></li>
						<li><a href="index-1.html">Company</a></li>
						<li class=""><a href="index-2.html" class="sf-with-ul">Services<b
								class="sf-sub-indicator"></b></a>
							<ul style="display: none;">
								<li><a href="more.html">services List</a></li>
								<li><a href="more.html" class="sf-with-ul">Special
										Offer<b class="sf-sub-indicator"></b>
								</a>
									<ul style="display: none;">
										<li><a href="more.html">Unique Design</a></li>
										<li><a href="more.html">creating style</a></li>
									</ul></li>
								<li><a href="more.html">Support</a></li>
							</ul></li>
						<li><a href="index-3.html">Gallery</a></li>
						<li class="last"><a href="index-4.html" class="active">Contacts</a></li>
					</ul>
				</nav>
				<div class="clear"></div>
			</div>
		</div>
	</header>
	<!--=====CONTENT=====-->
	<section id="content">
		<div class="main">
			<div class="breadcrumb" style="margin: 0 0 10px 0">
				<a href="#">Home</a> / <a href="#">Cadastrar</a> / <strong>Usuário</strong>
			</div>
			<div class="container_24 relative">
				<article class="grid_14 a2">
					<div class="inner">
						<h3 class="hp-1">Cadastro Usuário</h3>
						<div class="hr"></div>
						<form id="contact-form">
							<!--<div class="success" style="display: none; "> Contact form submitted! <strong>We will be in touch soon.</strong>
                      </div>-->
							<fieldset>
								<p>
									<label class="name">Nome:<br /> <input type="text"
										value="" /> <!--<span class="errors">
                                    <span class="error" style="display: none; ">*This is not a valid name.</span>
                                    <span class="empty" style="display: none; ">*This field is required.</span>
                                </span>-->
									</label>
								</p>
								<p>
									<label class="email"> Email:<br /> <input type="text"
										value="" /> <!--<span class="errors"><span class="error" style="display: none; ">*This is not a valid email address.</span> <span class="empty" style="display: none; ">*This field is required.</span></span>-->
									</label>
								</p>
								<p>
									<label class="phone"> Telefone:<br /> <input
										type="text" value="" class="phone" /> <!--<span class="errors"><span class="error" style="display: none; ">*This is not a valid phone number.</span> <span class="empty" style="display: none; ">*This field is required.</span></span>-->
									</label> <label class="cpf"> CPF:<br /> <input type="text"
										value="" class="cpf" /> <!--<span class="errors"><span class="error" style="display: none; ">*This is not a valid phone number.</span> <span class="empty" style="display: none; ">*This field is required.</span></span>-->
									</label>
								</p>
								<p>
									<label class="Endereco"> Endereço:<br /> <input
										type="text" value="" class="endereco" /> <!--<span class="errors"><span class="error" style="display: none; ">*This is not a valid phone number.</span> <span class="empty" style="display: none; ">*This field is required.</span></span>-->
									</label>
								</p>
								<p>
									<label class="Estado"> Estado:<br /> <select
										class="estado">
											<option value="SP">São Paulo</option>
											<option value="RJ">Rio de Janeiro</option>
											<option value="SA">Santos</option>
											<option value="BAMBI">ME XUPA KADU</option>
									</select>
									</label>
								</p>
								<!--<label class="message">
                            <textarea>Message:</textarea>
                            <span class="error" style="display: none; ">*The message is too short.</span> <span class="empty" style="display: none; ">*This field is required.</span> 
                          </label>-->
								<div class="clear"></div>
								<div class="btns">
									<a class="link-2" data-type="submit">salvar</a>
									<!--<a class="link-2" data-type="reset">Clear</a>-->
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


	<footer>
		<div class="inner">
			<ul class="bottom-menu">
				<li><a href="index.html">Home</a></li>
				<li><a href="index-1.html">Company</a></li>
				<li><a href="index-2.html">Services</a></li>
				<li><a href="index-3.html">Gallery</a></li>
				<li class="last"><a href="index-4.html" class="active">Contacts</a></li>
			</ul>
			<div class="fleft padding-3">
				<strong>CONCEPT © 2012</strong> <a href="index-5.html">Privacy
					Policy</a>
			</div>
		</div>

	</footer>
</body>
</html>