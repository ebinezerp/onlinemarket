
<div class="container-fluid">
	<div class="modal fade" role="dailog" id="signupform">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="signupsymbol">
						<button type="button" class="close" style="" data-dismiss="modal">&times;</button>
						<p>Sign Up</p>

					</div>


				</div>


				<div class="modal-body">
					<form action="registration" class="form">

						<div class="form-group">
							<label for="firstname">First Name</label> <input
								class="form-control" type="text" id="fname" name="fname">
						</div>

						<div class="form-group">
							<label for="lastname">First Name</label> <input
								class="form-control" type="text" id="lname" name="lname">
						</div>

						<div class="form-group">
							<label for="email">Email</label> <input class="form-control"
								type="email" id="email" name="email">
								<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
						</div>
						<div class="form-group">
							<label for="mobile">Mobile</label> <input class="form-control"
								type="text" id="phone" name="phone">
						</div>
						<div class="form-group">
							<label for="password">password</label> <input
								class="form-control" type="password" id="password"
								name="password">
						</div>

						<div class="form-group">
							<label for="conpassword">Conform password</label> <input
								class="form-control" type="password" id="cpassword"
								name="cpassword">
						</div>
						<p>
							<input type="checkbox"><a href="#">Term & Conditions</a>
						</p>
						<center>
							<button type="submit" class="btn btn-primary">Sign Up</button>
							<button type="reset" class="btn btn-primary">Clear</button>
						</center>
					</form>


				</div>
			</div>
			<script>
				$(document).ready(function() {
					$("#signup").click(function() {
						$("#loginmodel").modal("toggle");
						$("#signupform").modal("toggle");
						$("#signupform").modal({
							keyboard : true
						});
					});
				});
			</script>



		</div>






	</div>




</div>

