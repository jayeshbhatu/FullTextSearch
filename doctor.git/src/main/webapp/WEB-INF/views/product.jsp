<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="Header.jsp" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script src="http://ubilabs.github.io/geocomplete/jquery.geocomplete.js"
	type="text/javascript"></script>
<script
	src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>



<form:form id="addform" name="addform"
									modelAttribute="product" method="post"
									action="addproduct">

									<fieldset>
									
									<legend>ADD Store Detail</legend>
										<div class="control-group">
											<label for="control-label">Your Name : </label>
										 <form:input path="fullName"
												name="fullName" id="fullName" type="text"
												placeholder="Full Name" class="input-xlarge"/>
										
										</div>
										 	<div class="control-group">
										 	<label for="control-label">Category : </label>
										 <form:input path="category"
												name="category" id="category" type="text"
												placeholder="Category"  class="input-xlarge"/>
										
										</div>
										<div class="control-group">
										<label for="control-label"> Store Rating: </label>
										  <form:input path="rating"
												name="Rating" id="rating" type="text"
												placeholder="Rating" class="input-xlarge" />
										
										</div>
										<div class="control-group">
										<label for="control-label">Your Location : </label>
										<input 
												name="loaction" id="location" type="text"
												placeholder="Enter Location" class="input-xlarge" />
										</div>
										<form:input path="latitude" type="hidden" id="lat" name="lat"/>
										 <form:input path="longitude"
											type="hidden" id="longt" name="longt"/>
										
										
										
						<input type="button" value="submit" onclick="checkdetail()">				
										</fieldset>
										
								</form:form>

<c:set var="Message" value="store detail added successfully"></c:set>
<c:if test ="${Message == message}">
<script>
alert("Store Detail Added SuceessFully");
</script>
</c:if>



<script>
$(function() {
	$("#location").geocomplete(options).bind("geocode:result",
			function(event, result) {
				$('#lat').val(result.geometry.location.lat());
				$('#longt').val(result.geometry.location.lng());
			});
});
var options = {
		componentRestrictions : {
			country : [ "in" ]
		}
	};
</script>
<script type="text/javascript">


// this function is  only alphabatic are allowed for name and category;
function checkAlphabetic(temp)
{
	var re = /^([a-zA-Z _])+$/;
	if(re.test(temp))
	{
		return true;
	}
	else
	{
		return false;	
	}
}



function checkdetail()
{
	 var name=document.getElementById("fullName").value;
	 var pcategory=document.getElementById("category").value;
	 var rating =document.getElementById("rating").value;
	 var location=document.getElementById("location").value;
	 if(checkAlphabetic(name)==false || name.length > 70 || name.length < 2)
	{
	
		 document.getElementById("fullName").value="";
		 
		 document.getElementById("fullName").placeholder="enetr a correct name";
		 document.getElementById("fullName").focus();
		 return false;
	}
	 if(checkAlphabetic(pcategory)==false || pcategory.length > 70 || pcategory.length < 3)
		{
		
			 document.getElementById("category").value="";
			 
			 document.getElementById("category").placeholder="enetr a correct category";
			 document.getElementById("category").focus();
			 return false;
		}
	 if(isNaN(rating) || rating < 1 || rating > 5)
		{
		 document.getElementById("rating").value="";
		 
		 document.getElementById("rating").placeholder="enetr a correct rating";
		 document.getElementById("rating").focus();
		 return false; 
		 }
	 if(location == null || location == "")
		 {
		
		 document.getElementById("location").placeholder="enetr a location";
		 document.getElementById("location").focus();
		 return false;
		 }
	 	document.addform.submit();
}

</script>
