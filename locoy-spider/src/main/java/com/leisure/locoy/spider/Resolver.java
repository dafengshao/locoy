package com.leisure.locoy.spider;

import org.jsoup.nodes.Document;

public interface Resolver {

	Document invoke(String url);
}
