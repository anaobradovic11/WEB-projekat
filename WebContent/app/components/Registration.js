Vue.component("register-user", {
	data: function(){
		return{
			customers: null,
			newCustomer : {}
		}
	},

	template: `
	
	<div class="container">
      <form @submit="createCustomer(newCustomer)" autocomplete="on">
      <h1>Register</h1>
        <!--First name-->
    		<div class="box">
          <label for="firstName" class="fl fontLabel"> First Name: </label>
    			<div class="new iconBox">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
    			<div class="fr">
    					<input type="text" name="firstName" placeholder="First Name" v-model="newCustomer.name"
              class="textBox" autofocus="on" required>
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--First name-->


        <!--Second name-->
    		<div class="box">
          <label for="secondName" class="fl fontLabel"> Last Name: </label>
    			<div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="text" required name="lastName" v-model="newCustomer.surname"
              placeholder="Last Name" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--Second name-->


    		<!---Phone No.------>
    		<div class="box">
          <label for="phone" class="fl fontLabel"> Username: </label>
    			<div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="text" required name="username" maxlength="10" placeholder="Username" class="textBox"
    					v-model="newCustomer.username">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Phone No.---->

    		<!---Password------>
    		<div class="box">
          <label for="password" class="fl fontLabel"> Password </label>
    			<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="Password" required name="password" placeholder="Password" class="textBox"
    					v-model="newCustomer.password">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Password---->
    		
    		<!---BIRTHDATE---->
    		<div class="box">
          <label for="email" class="fl fontLabel"> Date of birth: </label>
    			<div class="fl iconBox"><i class="fa fa-envelope" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="date" class="textBox" v-model="newCustomer.birthdate">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--BIRTHDATE----->

    		<!---Gender----->
    		<div class="box radio">
          <label for="gender" class="fl fontLabel"> Gender: </label>
    				<input type="radio" name="Gender" v-model="newCustomer.gender" value="Male" required> Male &nbsp; &nbsp; &nbsp; &nbsp;
    				<input type="radio" name="Gender" v-model="newCustomer.gender" value="Female" required> Female
    		</div>
    		<!---Gender--->

    		<!---Submit Button------>
    		<div class="box" style="background: #6a9294">
    				<input type="Submit" name="Submit" class="submit" value="SUBMIT">
    		</div>
    		<!---Submit Button----->
    		
    		<div>
    			<tr v-for="c in customers">
					<td>{{c.name}}</td>
					<td>{{c.surname }}</td>
				</tr>
    		</div>
    		
      </form>
  </div>`,
  methods : {
		createCustomer: function(customer) {
			var c = {name:customer.name, surname:customer.surname, username:customer.username, password:customer.password,
					birthdate:customer.birthdate, gender:null, userRole:"CUSTOMER", deleted:false, visitedFacilities:null,
					customerType:null, collectedPoints:0.0}
			axios
	          .post('rest/customers/', c)
	          .then(response => alert("Uspesno registrovan CUSTOMER MRTVI"))
	          .catch(error =>  {
						alert(error.message + " GRESKA");
					})	
		}
	},
	mounted () {
        axios
          .get('rest/customers/')
          .then(response => (this.customers = response.data))	
    }
});