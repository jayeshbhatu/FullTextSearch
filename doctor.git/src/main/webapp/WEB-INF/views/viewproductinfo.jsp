<%@include file="Header.jsp" %>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.autocomplete.js"></script>
<%-- <script
	src="${pageContext.request.contextPath}/resources/css/jquery.autocomplete.css"></script>
 --%>
<body>
	<div class="wrapper">
		<div class="container ">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12">
					<div id="searchBox">

						<div
							style="margin-top: 2%; z-index: 99; background-color: rgba(204, 204, 204, 0.10); padding: 2% 1% 1% 2%; margin-bottom: 1%; width: 100%; float: left;">
							<form action="searchproduct" name="search" method="post">
							
								<div class="col-md-4 col-xs-12"
											style="padding-left: 0; padding-right: 0; z-index: 999;">

											<div id="form-container">
												<div id="searchtext">
													<input type="text" class="inputsearh" value=""
														name="name" placeholder="SearchBy(name,category)">
												
												</div>
											</div>
																						</div>
									<div class="col-md-2" style="padding-left: 0; z-index: 9;">

										<button class="btn btn-flat  btn-lg"
											style="width: 95%; background: #fb9225; color: white;"
											type="submit">
											Search 
										</button>
<div>total serach result :${liofproducts.size()}</div>
									</div>
								
							</form>
						</div>

					</div>

				</div>

			</div>
				<div id='content'>
					<div class="col-md-12 col-xs-12 col-sm-12"
							style="margin-bottom: 1%; box-shadow: 0px 5px 9px #999;">
				
					<c:forEach items="${liofproducts}" var="product" varStatus="status"> 
					<div class="row">
				<div class="col-md-5 col-sm-5 col-xs-9">
				<h5>
				<b>${product.fullName}</b>
				</h5>
					<h5>
					category:${product.category} &nbsp; &nbsp; Locate On Map:<a href="#" onclick="pan('${product.latitude}','${product.longitude}','${status.index}');">Location</a>			
					</h5>
				
									
				</div>
				
				<div class="col-md-5 col-sm-5 col-xs-12">
									
									<p>
												<c:if test="${product.rating != null}">
												${product.rating}
									<c:forEach var="i" begin="1" end="${product.rating}">
									<img
										src="${pageContext.request.contextPath}/resources/images/star32.png" />
								</c:forEach>
								</c:if>
									
									</p>
								</div>
				</div>
					</c:forEach>
				</div>
				</div>
				<c:if test="${empty liofproducts}">
					<p class="no-result">No Result Found</p>
				</c:if>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-1"></div>
		</div>
	</div>
	
	<div class="push"></div>
	<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
	
<div id="map"
													style="height: 400px; width: 100%; border-radius: 5px; margin-top: 0px;">
												</div>	
<script type="text/javascript">
function pan(param1,param2){
     var myLatlng = new google.maps.LatLng(param1,param2);
     var myOptions = {
         zoom: 15,
         center: myLatlng,
         mapTypeId: google.maps.MapTypeId.ROADMAP
         }
      map = new google.maps.Map(document.getElementById("map"), myOptions);
      var marker = new google.maps.Marker({
          position: myLatlng, 
          map: map,
      title:"View Location"
     });
} 
</script>
</body>
</html>
