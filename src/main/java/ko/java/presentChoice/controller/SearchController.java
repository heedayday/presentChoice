package ko.java.presentChoice.controller;

import ko.java.presentChoice.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/main")
    public ModelAndView MainSearch(HttpServletRequest request, HttpSession session) {
        //Session에 데이터 셋팅
        String setData = StringUtils.defaultIfEmpty(request.getParameter("setData"),"SETDATA");
        session.setAttribute("SetData", setData);

        //화면 페이지 이동 부분
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");       // templates 또는 WEB-INF/views 아래의 JSP, HTML 등
        mav.addObject("result", "검색완료");  // 모델 데이터 추가

        // 검색 관련 데이터 처리 비즈니스
        List<String> result = this.searchService.searchResultList();
        mav.addObject("result", result);
        return mav;
    }

    @PostMapping("/searchResultList.ajax")
    @ResponseBody
    public List<String> getSearchResultList(@RequestBody Map<String,Object> paramMap, Model model) {
        String searchInputText = (String) paramMap.get("searchInputText");
        List<String> selectedCategories = (List<String>) paramMap.get("selectedCategories");
        model.addAttribute("searchInputText", searchInputText);
        model.addAttribute("selectedCategories", selectedCategories);
        System.out.println("검색어: " + searchInputText);
        System.out.println("카테고리: " + selectedCategories);

        return selectedCategories;
    }



}
