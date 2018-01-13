package com.leisure.locoy.spider.web;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leisure.locoy.spider.JsoupUtil;
import com.leisure.locoy.spider.logic.CommonLogic;

@Controller
public class HomePageController {
	
	
	@RequestMapping(value="/",produces="text/html;charset=UTF-8")  
	@ResponseBody()
    public String index() {  
		Document parse = JsoupUtil.parse("http://www.luoxia.com/");
		return CommonLogic.toViewHTML(parse);
        
    }

	private String buildHTML(Document parse) {
		parse.getElementById("logo").attr("id","logoico");
		parse.title("小说网 - 严歌苓 芳华小说在线阅读");
		String html = parse.toString();
		html = html.replaceAll("href=\"/favicon.ico\"", "href=\"theme/favicon.ico\"");
		return html.replaceAll("落霞","美阅")
				.replaceAll("href=\"http://www.luoxia.com/", "href=\"/");
	}
	
	@RequestMapping(value="/**",produces="text/html;charset=UTF-8")  
	@ResponseBody()
    public String other( HttpServletRequest request) {  
		System.out.println(request.getRequestURI());
		Document parse = JsoupUtil.parse("http://www.luoxia.com"+request.getServletPath());
		return buildHTML(parse);
    }
}
