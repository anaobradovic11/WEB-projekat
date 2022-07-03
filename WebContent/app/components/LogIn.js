Vue.component('log-in', {
	template: `
	<div>
		<h1> Log In </h1>
		
		<form id="forma">
			<table>
				<tr><td>Username</td><td><input type="text" name="username"></td></tr>
				<tr><td>Password</td><td><input type="password" name="password"></td></tr>
				<tr><td><input type="submit" value="Login"></td></tr>
				<tr>
					<td><a href="#/register">Not Registered?</a></td>
				</tr>
				<tr>
					<td><a href="#/sportFacilities">Prikaz tabela</a></td>
				</tr>
			</table>
		</form>
	</div>
	`,
});