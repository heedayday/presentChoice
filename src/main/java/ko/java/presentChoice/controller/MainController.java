package ko.java.presentChoice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        log.info("index");
        String userId = request.getParameter("userId");
        HttpSession session = request.getSession(); // HTTP 세션을 가져오거나, 없으면 새로 생성하는 명령입니다.
        //System.out.println("info: index");
        return "index";
    }
}
