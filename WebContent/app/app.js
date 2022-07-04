const HomePage = {template: '<div> <router-view></router-view></div>'}
const SportFacilities = {template: '<sport-facilities></sport-facilities>'}
const Registration = {template: '<div> <register-user></register-user></div>'}
const Login = {template: '<div><log-in></log-in></div>'}

const router = new VueRouter({
	mode: 'hash',
	routes: [
		
		{
			path: '/', component: HomePage,
			children: [
		      {
		        path: '/',
		        component: SportFacilities,
		      }
		    ],
		},
		
		{
			path: '/register', component: Registration
		},
		{
			path: '/login', component: Login
		}
	]
});


var app = new Vue({
	router,
	el: "#app"
})