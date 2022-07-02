const SportFacilities = {template: "<sport-facilities></sport-facilities>"}

const router = new VueRouter({
	mode: 'hash',
	routes: [
		{
			path: "/sportFacilities", 
			component: SportFacilities
		},
		/*{
			path: ["/", "/login"], 
			component: 
		},*/
		
	]
});

var app = new Vue({
	router,
	el: "#app"
})