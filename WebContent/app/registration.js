var newRegistration = new Vue({
    el:'#registrationForm',
    data:{
        customers: null,
        title: "Registration",
        newManager: {}, 
        maleSelected: null, 
        femaleSelected: null,
        error:''
    },
    mounted() {
        this.newManager = { userId: Math.random().toString(36).substring(2,7), username: null, password: null,
        name: null, surname: null, birthdate: null, gender: null, userRole: null, svisitedFacilities: null,
        customerType: null, colletedPoints:null, due: null }

        axios.get('rest/customers/getAllCustomers')
            .then(response => (this.customers = response.data))
    }, 
    methods: {
        createUser: function (event) {
            this.error = ""
            if (!this.newManager.name || !this.newManager.surname) {
                this.error = "Unesite ime i prezime";
                event.preventDefault();
                return;
            }

            if(this.maleSelected.checked == true){

                this.newManager.gender = Gender.MALE;
            }

            if(this.femaleSelected.checked == true){

                this.newManager.gender = Gender.FEMALE;
            }

            axios.post('rest/customers/createCustomer', this.newManager)
                .then((response) => {
                        alert('Novi proizvod uspešno kreiran')
                        this.customers.push(response.data)
                    })
                    event.preventDefault();
        }

    }

});