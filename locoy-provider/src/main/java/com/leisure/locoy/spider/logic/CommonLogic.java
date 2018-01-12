package com.leisure.locoy.spider.logic;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CommonLogic {
	//首页
	//图书首页
	//图书列表页
	//内容页
	CommonLogic(){}
	
	public static String toViewHTML(Document document) {
		document.getElementsByTag("script").remove();
		Element body = document.body();
		body.getElementsByTag("a").parallelStream().forEach(ele->{
			String attr = ele.attr("href");
			attr = attr.replaceAll("http://www.luoxia.com", "");
			ele.attr("data_href", attr).removeAttr("href");
		});
		String viewHTML = body.html();
		viewHTML = viewHTML.replaceAll("落霞", "千千").replaceAll("http://www.luoxia.com", "");
		return viewHTML;
	}
}
