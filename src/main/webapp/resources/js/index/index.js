new Vue({
    el: '#wrap',
    data: {
        message:'',
        items: ['가구','가전','문구','전자기기','인테리어','미술','음악','여행'],
        searchInputText:''
    },
    methods:{
        placehoderInput() {
            this.message ="검색 내용을 입력하세요~!";
            this.$refs.searchInput.focus();
        },
        search() {
            const searchInputText = this.searchInputText;
            const categories = this.$refs.selectCategory.categories;
            console.log(searchInputText);
            categories.forEach((category, index) => {
                console.log(`category ${index}:`, category);
            });
            console.log("===========================================================");
            const selectedCategories = categories.filter(category => category.clicked != '');
            selectedCategories.forEach((category, index) => {
                console.log(`category ${index}:`, category);
            });
        }
    }
});