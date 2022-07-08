const HomePage = {template: '<div><navigation-bar></navigation-bar><router-view></router-view></div>'}
const SportFacilities = {template: '<sport-facilities></sport-facilities>'}
const Registration = {template: '<div> <navigation-bar></navigation-bar><register-user></register-user></div>'}
const Login = {template: '<div><navigation-bar></navigation-bar><log-in></log-in></div>'}
const Admin = {template: '<div><admin-navigation></admin-navigation><admin-home></admin-home></div>'}
const Manager = {template: '<div><manager-navigation></manager-navigation><sport-facilities></sport-facilities></div>'}
const Trainer = {template: '<div><trainer-navigation></trainer-navigation><sport-facilities></sport-facilities></div>'}
const Customer = {template: '<div><customer-navigation></customer-navigation><sport-facilities></sport-facilities></div>'}

const AdminManagersView = {template: '<div><admin-navigation></admin-navigation><admin-managers></admin-managers></div>'}
const AdminTrainersView = {template: '<div><admin-navigation></admin-navigation><admin-trainers></admin-trainers></div>'}
const AdminCustomersView = {template: '<div><admin-navigation></admin-navigation><admin-customers></admin-customers></div>'}
const AdminUserRegistration = {template: '<div><admin-navigation></admin-navigation><admin-userRegistration></admin-userRegistration></div>'}
const AdminCreateFacility = {template: '<div><admin-navigation></admin-navigation><admin-createFacility></admin-createFacility></div>'}

const AdminHome = {template: '<div><admin-navigation></admin-navigation><sport-facilities></sport-facilities></div>'}
const ManagerFacility = {template: '<div><manager-navigation></manager-navigation><manager-facility></manager-facility></div>'}
const ManagerCreateTraining = {template: '<div><manager-navigation></manager-navigation><manager-training></manager-training></div>'}
const ManagerTrainingsView = {template: '<div><manager-navigation></manager-navigation><all-trainings></all-trainings></div>'}

const AdminProfile = {template: '<div><admin-navigation></admin-navigation><admin-profile></admin-profile></div>'}
const ManagerProfile = {template: '<div><manager-navigation></manager-navigation><manager-profile></manager-profile></div>'}
const TrainerProfile = {template: '<div><trainer-navigation></trainer-navigation><trainer-profile></trainer-profile></div>'}
const CustomerProfile = {template: '<div><customer-navigation></customer-navigation><customer-profile></customer-profile></div>'}

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
			path: '/admin', component: AdminHome
		},
		{
			path: '/manager', component: Manager
		},
		{
			path: '/trainer', component: Trainer
		},
		{
			path: '/customer', component: Customer
		},
		{
			path: '/admin/managersView', component: AdminManagersView
		},
		{
			path: '/admin/trainersView', component: AdminTrainersView
		},
		{
			path: '/admin/customersView', component: AdminCustomersView
		},
		{
			path: '/admin/userRegistration', component: AdminUserRegistration
		},
		{
			path: '/admin/createFacility', component: AdminCreateFacility
		},
		{
			path: '/admin/usersView', component: Admin
		},
		{
			path: '/manager/facility', component: ManagerFacility
		},
		{
			path: '/manager/createTraining', component: ManagerCreateTraining
		},
		{
			path: '/manager/trainingsView', component: ManagerTrainingsView
		},
		{
			path: '/admin/myProfile', component: AdminProfile
		},
		{
			path: '/manager/myProfile', component: ManagerProfile
		},
		{
			path: '/trainer/myProfile', component: TrainerProfile
		},
		{
			path: '/customer/myProfile', component: CustomerProfile
		}
	]
});


var app = new Vue({
	router,
	el: "#app"
})