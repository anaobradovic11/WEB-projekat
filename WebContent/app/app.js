const HomePage = {template: '<div> <router-view></router-view></div>'}
const SportFacilities = {template: '<sport-facilities></sport-facilities>'}
const Registration = {template: '<div> <register-user></register-user></div>'}
const Login = {template: '<div><log-in></log-in></div>'}
const Admin = {template: '<div><admin-navigation></admin-navigation><sport-facilities></sport-facilities></div>'}
const Manager = {template: '<div><manager-navigation></manager-navigation><sport-facilities></sport-facilities></div>'}
const Trainer = {template: '<div><trainer-navigation></trainer-navigation><sport-facilities></sport-facilities></div>'}
const Customer = {template: '<div><customer-navigation></customer-navigation><sport-facilities></sport-facilities></div>'}

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
		},
		{
			path: '/admin', component: Admin
		},
		{
			path: '/manager', component: Manager
		},
		{
			path: '/trainer', component: Trainer
		},
		{
			path: '/customer', component: Customer
		}
	]
});


var app = new Vue({
	router,
	el: "#app"
})