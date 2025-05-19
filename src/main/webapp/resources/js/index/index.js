new Vue({
    el: '#wrap',
    data: {
        message:'',
        items: ['가구','가전','문구','전자기기','인테리어','미술','음악','여행'],
        searchInputText:''
    },
    created: function (){
      //초기화 함수
        (function (){
            console.log('index.jsp에 도착했습니다')
        })();
    },
    methods:{
        placehoderInput() {
            this.message ="검색 내용을 입력하세요~!";
            this.$refs.searchInput.focus();
        },
        search() {
            const searchInputText = this.searchInputText;
            const categories = this.$refs.selectCategory.categories;
            const selectedCategories = categories.filter(category => category.clicked != '');

            const prams = {
                searchInputText,
                selectedCategories
            }

            //Ajax 써서 통신으로 검색 결과 리스트를 받아옴
            /*네, 정확히 보셨습니다! $.ajax()는 jQuery의 기능이고, $ 기호는 jQuery 객체를 의미합니다. https://api.jquery.com/jQuery.ajax/*/

            const searchResult =  new Promise((resolve, reject) => {
                $.ajax({
                    url: '/search/searchResultList.ajax', // 1. 요청 보낼 URL
                    type: 'POST', // 2. HTTP 메서드: POST 방식
                    data: JSON.stringify(prams), // 3. 전송할 데이터: JSON 문자열로 변환
                    contentType: 'application/json',  // 4. 요청 본문(Content-Type) 설정
                    dataType: 'json', // 5. 응답 데이터 타입 기대: JSON
                    success: function (data) {
                        //console.log("결과값: " + data);// 6. 요청 성공 시 실행
                        try{
                            if(data.length === 0){
                                throw new Error('데이터 값이 없습니다');
                            }
                        }catch (e){
                            alert("error: "+e.message);
                        }
                        resolve(data);
                        console.log("check")
                    },
                    error: function (data, status, err) {
                        /*error: function(jqXHR[	요청에 대한 전체 응답 객체 (status, responseText 등 포함)], textStatus["error", "timeout", "abort", "parsererror" 중 하나], errorThrown[서버에서 응답한 에러 메시지 또는 예외]) {*/
                        /*매개변수를 하나만 적어도 되고 이때 하나만 적으면 data 두개 적으면  data, status 세개 적으면 data, status, err 이런식으로 자리에 맞는 값만을 사용할 수 있음*/
                        console.log("에러값: " + err); // 7. 요청 실패 시 실행
                        reject(data);
                    },
                    complete: function () {
                        //console.log("완료이후");  // 8. 성공/실패와 관계없이 항상 실행
                }
            });
            });

            searchResult
            . then(data => {
                data.forEach((text,count,array) => {
                    console.log(count+"result: "+text.value);
                    console.log(count+"result: "+text.name);
                    console.log(count+"result: "+text.clicked);
                    //템플릿 리터럴 문법 백틱(``) 으로 감싼 문자열 ${변수} 형식으로 변수를 문자열 안에 삽입
                    console.log(`${count}result: ${array[count].value}`);
                    console.log(`${count}result: ${array[count].name}`);
                    console.log(`${count}result: ${array[count].clicked}`);
                });
            })
            .catch(data => {
                alert("실패: " + data.status);        //HTTP 상태 코드 (예: `200`, `404`, `500`)
                //alert("실패: " + data.statusText);    //상태 코드 설명 문자열 (예: `"OK"`, `"Not Found"`)
                //alert("실패: " + data.responseText);  //서버가 응답한 **원본 텍스트** (예: JSON 문자열)
                alert("실패: " + data.response);      //서버가 응답한 **원본 텍스트** (예: JSON 문자열)
                //alert("실패: " + data.readyState);    //요청의 상태 (예: `4` = 요청 완료)
                //alert("실패: " + data.getAllResponseHeaders());//모든 응답 헤더를 문자열로 반환
                //alert("실패: " + data.getResponseHeader());   //특정 응답 헤더의 값을 가져옴
                //alert("실패: " + data.setRequestHeader());    //요청 헤더 설정 (보낼 때만 유효)
            });

        }
    }
});