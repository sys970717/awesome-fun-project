package io.tdd.sys.yeongSu.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private static Logger logger = LoggerFactory.getLogger(NewsController.class);

    @GetMapping(value="/{type}")
    public ModelAndView getPage(@PathVariable String type, ModelAndView modelAndView) {
        logger.info("type = {}", type);
        modelAndView.setViewName("/news/" + type+  ".html");
        return modelAndView;
    }


}
