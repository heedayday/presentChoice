const vueMain = new Vue({
    el: '#wrap',
    data: {
        message: '안녕하세요, Vue!'
    },
    method:{
        moveFocus() {
            alert("도착");
            this.$refs.searchInput.focus();
            document.querySelector("#searchInputText").placeholder = "검색 내용을 입력하세요~!";
        }
    }
});