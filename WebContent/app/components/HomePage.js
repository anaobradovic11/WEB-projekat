Vue.component("home-page", {
	template: `
	<div>
		<h1> HOME PAGE </h1>
		<button @click="$router.push('register')">Registration</button>
		<button @click="$router.push('login')">LOG IN</button>
	</div>
	`,
});