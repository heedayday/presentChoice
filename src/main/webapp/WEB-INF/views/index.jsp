<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>PresentChoice</title>
    <link rel="shortcut icon" href="#"> <%--GET http://localhost:8080/favicon.ico 404 (Not Found) 오류 안나오도록 임시수정--%>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&family=Pacifico&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/resources/lib/animate/animate.min.css" rel="stylesheet">
    <link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/resources/css/style.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>--%>
    <%--vue2 사용하기--%>
    <script src="https://cdn.jsdelivr.net/npm/vue@2"></script>
</head>
<body>
<div id="wrap">
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center" Style="visibility: hidden">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

    <!-- Navbar & Hero Start -->
    <div class="container-xxl position-relative p-0">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4 px-lg-5 py-3 py-lg-0">
            <a href="" class="navbar-brand p-0">
                <%--아이콘 부분 수정하기--%>
                <h1 class="text-primary m-0"><i class="fa fa-gift me-3"></i>PresentChoice</h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0 pe-4">
                    <a href="index.html" class="nav-item nav-link active">홈</a>
                    <a href="about.html" class="nav-item nav-link">소개</a>
                    <a href="service.html" class="nav-item nav-link">고급 선물</a>
                    <a href="menu.html" class="nav-item nav-link">가성비 선물</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">선물 추천 대상</a>
                        <div class="dropdown-menu m-0">
                            <a href="booking.html" class="dropdown-item">가족</a>
                            <a href="team.html" class="dropdown-item">지인</a>
                            <a href="testimonial.html" class="dropdown-item">친구</a>
                        </div>
                    </div>
                    <a href="contact.html" class="nav-item nav-link">추가 설명</a>
                </div>
                <%--<a href="javaScript:;" @click="placehoderInput" class="btn btn-primary py-2 px-4">Search</a>--%>
            </div>
        </nav>
    </div>

    <div class="container-xxl py-5 bg-dark hero-header mb-5">
        <div class="container my-5 py-5">
            <div class="row align-items-center g-5">
                <div class="col-lg-6 text-center text-lg-start">
                    <h1 class="display-3 text-white animated slideInLeft">오늘의 선물 추천</h1>
                    <p class="text-white animated slideInLeft mb-4 pb-2">다양한 선물들 사이에서 지인이나 가족, 친구들에게 주고 싶은 선물을 찾아보세요~!</p>
                    <p><input class="searchInput" v-model="searchInputText"  id="searchInputText" ref="searchInput" type="text" :placeholder="message"/>
                        <%--<a href="javaScript:;" class="btn btn-primary py-sm-3 px-sm-5 me-3 animated slideInLeft" @click="search">Search</a>--%>
                        <select-category ref="selectCategory"></select-category>
                    </p>
                </div>
                <div class="col-lg-6 text-center text-lg-end overflow-hidden">
                    <img class="img-fluid" src="/resources/img/gift-1.png" alt="">
                </div>
            </div>
        </div>
    </div>
<!-- Navbar & Hero End -->
    </div>

</div>

<!-- JavaScript Libraries -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/lib/easing/easing.min.js"></script>
<script src="/resources/lib/wow/wow.min.js"></script>
<script src="/resources/lib/waypoints/waypoints.min.js"></script>
<script src="/resources/lib/counterup/counterup.min.js"></script>
<script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="/resources/lib/tempusdominus/js/moment.min.js"></script>
<script src="/resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="/resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<%@ include file="/WEB-INF/views/indexSearchCategoryButton.jsp" %>

<!-- Template Javascript -->
<script src="/resources/js/main.js"></script>
<script src="/resources/js/index/index.js"></script>


</body>
</html>
