<%@include file ="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/finaltp/jquery-ui.js"></script>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12">
					<div id="searchBox">

						<div
							style="margin-top: 2%; z-index: 99; background-color: rgba(204, 204, 204, 0.10); padding: 2% 1% 1% 2%; margin-bottom: 1%; width: 100%; float: left;">


<form id="searchform" name="searchform" method="post"
									action="searchproduct">

								<!-- 	<fieldset>
										 
										
										<input name="name" id="name" type="text"
												placeholder="SerchByName" />
																				
						<input type="submit" value="Search" >				
										</fieldset> -->
									<div class="col-md-4 col-xs-12"
											style="padding-left: 0; padding-right: 0; z-index: 999;">

											<div id="form-container">
												<div id="searchtext">
													<input type="text" class="inputsearh" 
														name="name" id="name" placeholder="SearchBy(name,category)">
															
												</div>
											</div>
										</div>
									<div class="col-md-2 col-xs-12" style="padding-left: 0; z-index: 9;">

										<button class="btn btn-flat  btn-lg"
											style="width: 55%; background: #fb9225; color: white;"
											type="submit">
											Search 
										</button>

									</div>
									
										
								</form>
</div>
</div>
</div>
</div>
</div>
