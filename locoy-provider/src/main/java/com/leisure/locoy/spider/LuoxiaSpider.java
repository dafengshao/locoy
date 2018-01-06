package com.leisure.locoy.spider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.leisure.locoy.provider.domain.MerchantBookDO;

public class LuoxiaSpider {
	LuoxiaSpider(){}
	public static List<MerchantBookDO> getBook() {
		Document indexPage = JsoupUtil.parse("http://www.luoxia.com/");
		Element elementById = indexPage.getElementById("main-nav");
		Elements elementsByTag = elementById.getElementsByTag("li");
		List<String> urlList = new ArrayList<>();
		Set<MerchantBookDO> list = new HashSet<>();
		elementsByTag.forEach(ele->{
			Element child = ele.child(0);
			String attr = child.attr("href");
			//urlList.add(attr);
		});
		Elements elementsByClass = indexPage.getElementsByClass("hot-books").get(0).getElementsByTag("ol");
		String operateCategory = null;
		Iterator<Element> iterator = elementsByClass.iterator();
		while(iterator.hasNext()) {
			Element action = iterator.next();//ol
			Elements elementsByTag2 = action.getElementsByTag("li");
			Iterator<Element> iterator2 = elementsByTag2.iterator();
			while(iterator2.hasNext()) {
				Element next = iterator2.next();
				boolean hasClass = next.hasClass("hot-book-tit");
				if(hasClass) {
					operateCategory = next.text().replaceAll("：", "");
				}else {
					String bookUrl = next.child(0).attr("href");
					String bookName = next.child(0).attr("title");
					String author = next.child(0).child(1).text();
					MerchantBookDO book = new MerchantBookDO();
					book.setSiteUrl(bookUrl);
					book.setBookName(bookName);
					book.setAuthor(author);
					book.setOperateCategory(operateCategory);
					list.add(book);
				}
			}
		}
		for(String url:urlList) {
			Document bookListDoc = JsoupUtil.parse(url);
			if(url.equals("http://www.luoxia.com/top/")||url.equals("http://www.luoxia.com/indb/")) {
				/**Element elementsByClass = bookListDoc.getElementsByClass("book-list-indb").get(0);
				Elements elementsByTag2 = elementsByClass.getElementsByTag("li");
				elementsByTag2.forEach(ele->{
					Element div = ele.child(0);//div
					Element a = div.child(0);//a
					String bookUrl = a.attr("href");
					String bookName = a.attr("title");
					a.child(0)
				});*/
			}else {
				Elements elementsByClassLis = bookListDoc.getElementsByClass("pop-book2");
				elementsByClassLis.forEach(ele->{
					Element child0 = ele.child(0);
					String coverUrl = child0.child(0).attr("src");
					Element child1 = ele.child(1);
					String bookName = child1.text();
					String bookUrl = child1.attr("href");
					Element child2 = ele.child(2);
					String text = child2.attr("title");
					String[] split = text.split("/");
					String category = split[0];
					String author = split[1];
					MerchantBookDO e = new MerchantBookDO();
					e.setAuthor(author);
					e.setBookCategory(category);
					e.setCoverUrl(coverUrl);
					e.setBookName(bookName);
					e.setSiteUrl(bookUrl);
					list.add(e);
				});
			}
			
			
		}
		return new ArrayList<>(list);
	}
}
