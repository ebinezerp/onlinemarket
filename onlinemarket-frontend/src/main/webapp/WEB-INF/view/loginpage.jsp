<div class="content">

	<div class="row">

		<div class="col-sm-4"></div>
		<div class="col-sm-4">

			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
						<h1>Log In</h1>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<form class="form" action="login" method="post">

							${error}

							<div class="form-group">
								<label>Email</label> <input type="text" name="username"
									class="form-control" required>

							</div>
							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									class="form-control" required>
							</div>
							<input type="submit" value="Log In">
						</form>

					</div>
				</div>

			</div>



		</div>
		<div class="col-sm-4"></div>

	</div>

</div>
</div>