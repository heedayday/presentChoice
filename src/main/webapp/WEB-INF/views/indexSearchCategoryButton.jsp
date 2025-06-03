<meta charset="UTF-8">
<script type="text/x-template" id="select-category">
<p>
<table>
    <tr>
        <td>
            <a class="btn btn-lg-square btn-secondary" style="font-size: 0.6rem; margin-top: 5px;"  @click="clickReset($event)">
                Reset
            </a>
        </td>
        <td class="categoryList" v-for="(category, index) in categories" :key="index">
            <a href="javaScript:;" :class="'btn btn-lg-square btn-primary '+ category.clicked" @click="clickCategory(category)" style="font-size: 0.6rem; margin-top: 5px;">
                {{ category.name }}
            </a>
        </td>
    </tr>
</table>
</p>
</script>
<script src="/resources/js/common/buttonList.js"></script>
<script src="/resources/js/index/indexSearchCategoryButton.js"></script>