Vue.component("trainer-group", {
	data: function(){
		return{
			trainings: null,
			user : {},
			trainer : {},
			trainingType : "Group trainings",
			trainingByTypeAndTrainer : []
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
	    <h1 class="heading"> {{trainer.name}}'s group trainings </h1>
	
		<button class="btn" v-on:click="ShowPersonal()">Personal trainings</button>
	    <button class="selectedBtnn" v-on:click="ShowGroup()">Group trainings</button>
	    <button class="btn" v-on:click="ShowAll()">All trainings</button>
	
	    <div class="box-container">
	
	        <div class="box" v-for="tr in trainingByTypeAndTrainer" v-if="tr.deleted === false">
	            <a href="#" class="fas fa-heart"></a>
	            <a href="#" class="fas fa-eye"></a>
	            <img :src="tr.imageName" alt="JEBISE"/>
	            <h3>{{tr.name}}</h3>
	            <div>
	            	Type: {{tr.type}}
	            </div>
	            <h4>{{tr.trainerId}}</h4>
	            <span>{{tr.durationInMinutes}} min</span>
	            <br></br>
	            <br></br>
	        </div>
	        
	    </div>
	
	</section>	
		
		</body>
	</html>	
	`,
	methods :  {
		ShowPersonal : function(){
			router.push({ path : '/trainer/personalTrainingsView'});
		},
		ShowGroup : function(){
			router.push({ path : '/trainer/groupTrainigsView'});
		},
		ShowAll : function(){
			router.push({ path : '/trainer/trainingsView'});
		},
	}
	,
	mounted () {
        axios
          .get('rest/login/loggedUser')
          .then(response => {(this.user = response.data)
          		
          	axios
          		.get('rest/trainers/getTrainerById/' + this.user.username, this.user)
          		.then(response => {(this.trainer = response.data)
          		
          			axios
          				.get('rest/trainings/getTrainingsByTrainerId/' + this.trainer.username, this.trainer)
          				.then(response => {(this.trainings = response.data)
          				for(let tr of this.trainings){
							if(tr.type === this.trainingType){
								this.trainingByTypeAndTrainer.push(tr)
							}
						}
          					/*axios
		          				.get('rest/trainings/getTrainingsByTrainingType/' + this.trainingType)
		          				.then(response => {(this.trainingByTypeAndTrainer = response.data)
          				
          				})*/
          		})
           })
        })	
    },
});