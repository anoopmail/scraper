package com.anoopmail.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
	private String url ;
	private Document doc ;
	
	public Scraper(String url){
		this.url = url ;
	}
	
	public List<String> pick(String cssQuery) throws IOException{
		List<String> resultHolder = new ArrayList<String>();
		
		if (this.doc == null){
			this.doc = Jsoup.connect(url).get();
		}
		Elements picked = this.doc.select(cssQuery);
		for (Element e : picked){
			resultHolder.add(e.text());
		}
		return resultHolder;
	}
}
