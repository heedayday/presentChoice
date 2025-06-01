(function ($) {
    $.fn.buttonList = function () {
        //$ jQuery 객체를 전달받는 자동실행 함수
        $(this).each(function (){
            const arg = arguments[0];
            const argList = arguments;
            console.log("/arg/")
            console.dir(arg)
            console.log("/argList/")
            console.dir(argList)
        });
    }
})(jQuery);