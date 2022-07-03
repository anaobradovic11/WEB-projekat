
const HomePage = {template: "<home-page></home-page>"}
const SportFacilities = {template: "<sport-facilities></sport-facilities>"}
const Registration = {template: '<register-user></register-user>'}
const LogIn = {template: '<log-in></log-in>'}
const SportFacilities = {template: "<sport-facilities></sport-facilities>"}


const router = new VueRouter({
	mode: 'hash',
	routes: [
		{

			path: "/", component: HomePage
		},
		{
			path: "/sportFacilities", component: SportFacilities
		},
		{
			path: '/register', component: Registration
		},
		{
			path: '/login', component: LogIn
		}
			path: "/sportFacilities", component: SportFacilities
		},
	]
});

var app = new Vue({
	router,
	el: "#app"
})