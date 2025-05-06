new Vue({
    el: '#wrap',
    data: {
        message: ''
    },
    methods:{
        placehoderInput() {
            this.message ="검색 내용을 입력하세요~!";
            this.$refs.searchInput.focus();
        }
    }
});