<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="health">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="resources/images/title.jpe">
<title>Health Analytics | Admin</title>
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Menu CSS -->
<link href="resources/css/sidebar-nav.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-datepicker.min.css" rel="stylesheet"
	type="text/css" />
<!-- animation CSS -->
<link href="resources/css/animate.css" rel="stylesheet">
<!-- Custom CSS -->

<link href="resources/css/style.css" rel="stylesheet">
<!-- color CSS -->
<link href="resources/css/megna.css" id="theme" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o), m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-19175540-9', 'auto');
        ga('send', 'pageview');
    </script>
</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Left navbar-header -->
		<jsp:include page="left-sidebar.jsp"></jsp:include>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Add Country</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<a
							href="https://themeforest.net/item/elite-admin-responsive-dashboard-web-app-kit-/16750820"
							target="_blank"
							class="btn btn-danger pull-right m-l-20 btn-rounded btn-outline hidden-xs hidden-sm waves-effect waves-light">Buy
							Now</a>
						<ol class="breadcrumb">
							<li><a href="index.html">Hospital</a></li>
							<li class="active">Add Country</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">State Information</h3>
							<table class="table table-hover">
								<thead class="thead-inverse">
									<tr>
										<th>Count</th>
										<th>Country</th>
										<th>State Name</th>
										<th>Edit</th>
										<th>Delete</th>
										<th>isActive</th>

									</tr>
								</thead>
								<tbody class="rowBody">
									<c:set var="count" value="0"></c:set>
									<c:set var="countActive" value="0"></c:set>
									<c:forEach items="${sessionScope.list }" var="i"
										varStatus="myindex">
										<c:if test="${i.isActive == 'yes' }">
											<c:set var="countActive" value="${countActive+1 }"></c:set>
										</c:if>
										<tr class="rowContent">
											<td>${myindex.index +1 }</td>
											<td>${i.country.countryName}</td>
											<td>${i.stateName}</td>
											<td><a href="editState.html?id=${i.stateId}">Edit</a></td>
											<td><a href="deleteState.html?id=${i.stateId}">Delete</a></td>
											<td class="active">${i.isActive}</td>
										</tr>
										<c:set var="count" value="${count+1 }"></c:set>
									</c:forEach>



									<tr class="rowCountTotal">

										<td color="bg-primary"><strong>Total Records</strong></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><strong><c:out value="${count }" /></strong></td>

									</tr>
									<tr class="rowCountActive">

										<td color="bg-primary"><strong>Total Active
												Records</strong></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><strong><c:out value="${countActive }" /></strong></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>


				</div>

			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2016 &copy; </footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="resources/js/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script src="resources/js/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="resources/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="resources/js/waves.js"></script>
	<!-- Date Picker Plugin JavaScript -->
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
    
      	$(".active:contains('No')").css("color","#d9534f");	
      	$(".active:contains('yes')").css("color","#5cb85c");
      	
      	$("#searchBox").animate({width:"450px"},function(){
      		$(this).attr("placeholder","Search Using Country/State Name");
      	}).focus();
/*       	$("#searchBox").keyup(function(){
      		
      		$.ajax({
      			type: "POST",
      			url: "searchStateDataUsingAjax.html",
      			data: 'keywords='+$(this).val(),
      			sucess: function(data){
      				alert("hello");
      				$(".rowBody").replaceWith(data);
      				
      			}
      		});
      	}); */
      	$("#searchForm").attr("action","searchStateDataUsingAjax.html").attr("method","post");;
      	
        // Date Picker
        jQuery('.mydatepicker').datepicker();
        </script>
	<!-- Custom Theme JavaScript -->
	<script src="resources/js/custom.min.js"></script>
	<script src="resources/js/jasny-bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
	<!--Style Switcher -->
	<script src="resources/js/jQuery.style.switcher.js"></script>
</body>

</html>