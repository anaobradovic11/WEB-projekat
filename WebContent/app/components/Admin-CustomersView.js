Vue.component("admin-customers", {
	data: function(){
		return{
			registeredCustomers: null,
		}
	},
	
	template: `
	
	<html lang="en">
		<head>
		    <meta charset="UTF-8">
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		    <title>ADMIN</title>
		
		    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
		
		    <!-- font awesome cdn link  -->
		
		    <!-- custom css file link  -->
		    <link rel="stylesheet" href="css/dataView.css">
		
		</head>
		<body>
	<section class="dishes" id="dishes">
	
	    <h3 class="sub-heading"> Clean Fit </h3>
	    <h1 class="heading"> Registered Customers </h1>
	    
	    <h2 class ="heading"> Choose type of user to show</h2>
	    <button class="btn" v-on:click="ShowManagers()">Managers</button>
	    <button class="btn" v-on:click="ShowTrainers()">Trainers</button>
	    <button class="btn">Customers</button>
	
	    <div class="box-container">
	
	        <div class="box" v-for="ru in registeredCustomers">
	            <a href="#" class="fas fa-heart"></a>
	            <a href="#" class="fas fa-eye"></a>
	            <h3>{{ru.name}}</h3>
	            <h3>
	            	{{ru.surname}}
	            </h3>
	            <h4>Username : {{ru.username}}</h4>
	            <span>{{ru.userRole}}</span>
	            <br></br>
	            <span>{{ConvertBanned(ru)}}</span>
	            <br></br>
	        </div>
	        
	    </div>
	
	</section>	
		
		</body>
	</html>
	
	`,
	methods : {
		ConvertBanned: function(user) {
			
			if(user.banned===true)
				return "Banovan";
				else
				return "Nije banovan";
		},
		ShowManagers : function(){
			router.push({ path : '/admin/managersView'});
		},
		ShowTrainers : function(){
			router.push({ path : '/admin/trainersView'});
		},
	},
	mounted () {
        axios
          .get('rest/customers/')
          .then(response => (this.registeredCustomers = response.data))
    },
});