
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-fluid">


	<!-- Modal -->
	<div class="modal fade" id="loginmodel" role="dialog">
		<div class="modal-dialog">


			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>
						<span class="glyphicon glyphicon-lock"></span> Login
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
				<form:form class="form" action="admin/login" method="post" commandName="user">
				
				<div class="form-group">
				<label for="username">UserName</label>
				<form:input path="userName" class="form-control"/>
				</div>
				<div class="form-group">
				<label for="password">Password</label>
				<form:input path="password" class="form-control"/>
				</div>
				<center><input type="submit" class="btn btn-primary"></center>
				
				</form:form>
					
					<div>
						<a href="#">Forget Password</a>
					</div>
				</div>
				<div class="modal-footer">
					<center>
						<div class="btn-group btn-group-lg">
							<a href="registration">"<button type="button" class="btn btn-primary" >SignUP</button></a>

						</div>
					</center>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#login").click(function() {
			$("#loginmodel").modal();
		});
	});
</script>