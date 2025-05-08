package ko.java.presentChoice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index() {
        log.info("index");
        //System.out.println("info: index");
        return "index";
    }
}
