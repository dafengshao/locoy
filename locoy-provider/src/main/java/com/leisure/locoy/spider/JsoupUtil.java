package com.leisure.locoy.spider;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class JsoupUtil {

	JsoupUtil() {
	}
	public static Document parse(String url) {
		Connection connect = Jsoup.connect(url).timeout(10000);
		connect.header("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		connect.header("Accept-Encoding", "gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.9");
		connect.header("Cache-Control", "max-age=0");
		connect.header("Connection", "keep-alive");
		connect.header("Cookie",
				"__cfduid=de0e85e248cd5b0cd60a3efed060ffdd01514641960; Hm_lvt_a0f09b230d0cebdb23651891978f530a=1514641965,1514641983; Hm_lpvt_a0f09b230d0cebdb23651891978f530a=1514646322");
		connect.header("Host", "www.luoxia.com");
		connect.header("Upgrade-Insecure-Requests", "1");
		connect.header("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
		connect.ignoreContentType(true);
		try {
			return connect.get();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		

	}
	
	public static void main(String[] args) {
		Document parse = parse("http://www.luoxia.com/");
		Elements elementsByTag = parse.getElementsByTag("script");
		elementsByTag.remove();
		System.out.println(parse);
	}
}
