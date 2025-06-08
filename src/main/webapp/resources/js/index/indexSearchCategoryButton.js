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
            //console.log("클릭 value : "+category.value);
            //console.log("클릭 clicked : "+category.clicked);
            if(category.clicked === 'btn-click'){
                category.clicked ='';
            }else{
                category.clicked ='btn-click';
            }
            //Query 객체를 전달받는 자동실행 함수 예제
            //buttonList($(''));
        },
        clickReset(e){
            //const target = e.target.parentElement;
            //const $categoryList = $('#categoryList');
            const $child = $('.categoryList').find('.btn-click');     //import $ from 'jquery';  // 꼭 추가! 이부분이랑 관련이 있음 주석처리하면 오류남
            $child.removeClass('btn-click');
            console.dir($child);
            /*$child.css('color', 'red');
            * 참고로 해당코드는 style 끝에 추가함 style="font-size: 0.6rem; margin-top: 5px; color: red;" */
        }
    }
});