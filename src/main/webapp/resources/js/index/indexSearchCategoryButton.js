Vue.component('select-category',{
    template: '#select-category',
    data: function (){
        return {
            categories: [
                {name:'가구', value:'furniture', clicked:''},
                {name:'가전', value:'homeAppliances', clicked:''},
                {name:'문구', value:'phrase', clicked:''},
                {name:'전자기기', value:'electronicDevices', clicked:''},
                {name:'인테리어', value:'interior', clicked:''},
                {name:'미술용품', value:'artSupplies', clicked:''},
                {name:'음악용품', value:'musicSupplies', clicked:''},
                {name:'여행용품', value:'travelSupplies', clicked:''}
            ],
        }
    },
    methods: {
        clickCategory(category) {
            console.log("클릭 value : "+category.value);
            console.log("클릭 clicked : "+category.clicked);
            if(category.clicked === 'btn-click'){
                category.clicked ='';
            }else{
                category.clicked ='btn-click';
            }
        }
    }
});