<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<div class="abcd">
		
		<div class="contact">

			<div class="right-w3">
				<h2 style="color:#5292e7;text-transform: capitalize">Health</h2>
				<h2 style="margin-left: -250px;text-transform: capitalize;">Analytics</h2>
                
			</div>

		<div class="tg-refinesearcharea contact_wrap" style="box-shadow: 0 2px 4px 1px rgba(0,0,0,0.25); background:#fff;width:360px;height: 300px">
			
			<div class="tg-heading-border tg-small">
				<h2 style="text-transform: none; margin-left: -110px;">Create new password</h2>
			</div>
		
			<form class="form-refinesearch tg-haslayout contact_form" action="verifyPassword.html" method="post" >
			
				<fieldset>
				<p style="color:black;">We'll ask for this password whenever you sign in.</p>
				<div class="name">
						<input type="text" name="userPassword" class="username" placeholder=" Enter Password" required="required" style="height: 0px;">
					</div>
					<div class="name">
						<input type="text"  class="username" placeholder=" re-enter Password" required="required" style="height: 0px;">
					</div>
					<input type="submit" class="btn btn-succes" value="Save changes" style="height: 30px;line-height: 1px;width: 100%;margin-left: 0px;margin-top: 30px;color: white;background-color: #5292e7;"/>
				<c:forEach items="${sessionScope.registrationlist}" var = "i">
				<input type="hidden" name="loginid" value="${i.login.loginId}"/>
				</c:forEach>
				</fieldset>
			</form>
		</div>
			
		</div>
		<!---728x90--->
		
		<!---728x90--->
	</div>

	
	</body>
	</html>
	
	 