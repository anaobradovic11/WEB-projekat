Vue.component("sport-facilities", {
	data: function(){
		return{
			sportFacilities: null,
			user : {}
		}
	},
	
	template: `
	
	<html lang="en">
		<head>
		    <meta charset="UTF-8">
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		    <title>Complete Responsive Food Website Design Tutorial</title>
		
		    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
		
		    <!-- font awesome cdn link  -->
		
		    <!-- custom css file link  -->
		    <link rel="stylesheet" href="css/dataView.css">
		
		</head>
		<body>
	<section class="dishes" id="dishes">
	
	    <h3 class="sub-heading"> Clean Fit </h3>
	    <h1 class="heading"> Sport facilitites </h1>
	
	    <div class="box-container">
	
	        <div class="box" v-for="sf in sportFacilities">
	            <a href="#" class="fas fa-heart"></a>
	            <a href="#" class="fas fa-eye"></a>
	            <img :src="sf.imageName" alt="JEBISE"/>
	            <h3>{{sf.name}}</h3>
	            <div>
	            	Type: {{sf.type}}
	            </div>
	            <h4>{{sf.location}}</h4>
	            <span>{{sf.averageGrade}}</span>
	            <br></br>
	            <span>{{ConvertWorking(sf)}}</span>
	            <br></br>
	            <div class="btn" v-on:click="redirectWithParam(sf.sportFacilityId)">Details</div>
	        </div>
	        
	    </div>
	
	</section>	
		
		</body>
	</html>
	
	
	
	`,
	methods : {
		ConvertWorking: function(sportFacility) {
			
			if(sportFacility.isWorking===true)
				return "Radi";
				else
				return "Ne radi";
		},
		redirectWithParam : function(id){
			if(this.user.userRole !== undefined){
				if(this.user.userRole === "ADMIN"){
					router.push({ name : 'AdminDetailsView', params:{id}});
				} else if(this.user.userRole === "MANAGER"){
					router.push({ name : 'TrainerDetailsView', params:{id}});
				} else if(this.user.userRole === "COACH"){
					router.push({ name : 'ManagerDetailsView', params:{id}});
				} else if(this.user.userRole === "CUSTOMER"){
					router.push({ name : 'CustomerDetailsView', params:{id}});
				}  
			}
		}
	},
	mounted () {
        axios
          .get('rest/sportFacilities/')
          .then(response => {(this.sportFacilities = response.data)
          
          	axios
	          .get('rest/login/loggedUser')
	          .then(response => {(this.user = response.data)
          })
       })
    },
});