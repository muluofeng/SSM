package com.xxx.ssm.common.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/10/17.
 */
@Controller
public class BookmarkAction {

    private static Logger logger= LogManager.getLogger(BookmarkAction.class);
    @RequestMapping("/admin/bookmark.html")
    public String index(){
        logger.info("lkjds");
        return "admin/bookmark/index";

    }
}
