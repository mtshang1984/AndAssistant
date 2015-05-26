package com.example.andassistant;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

@SuppressLint("DefaultLocale")
public class SearchEngine {
	ArrayList<String> url_list;

	public SearchEngine() {
		super();
		url_list = new ArrayList<String>();
	}

	// 根据关键词和所选用的搜索引擎生成网址
	public static String GetString_url(String search_egine_selection,
			String Keyword) {
		String string_url;
		switch (search_egine_selection.toLowerCase()) {
		default:
			string_url = "https://www.google.com.hk/search?q=";
			break;
		// 网络搜索
		case "google":
			string_url = "https://www.google.com.hk/search?q=";
			break;
		case "bing":
			string_url = "http://global.bing.com/search?q=";
			break;
		case "bingcn":
			string_url = "http://cn.bing.com/search?q=";
			break;
		case "baidu":
			string_url = "http://www.baidu.com/s?ie=utf-8&wd=";
			break;
		case "haosou":
			string_url = "http://m.haosou.com/s?ie=utf-8&q=";
			break;

		// 问答搜索
		case "bingqa":
			string_url = "http://cn.bing.com/knows/search?est=3&q=";
			break;
		case "baiduzhidao":
			string_url = "http://zhidao.baidu.com/search?word=";
			break;
		case "baidujingyan":
			string_url = "http://jingyan.baidu.com/search?lm=11&word=";
			break;
		case "zhihu":
			string_url = "http://www.zhihu.com/search?q=";
			break;
		case "tianyawenda":
			string_url = "http://wenda.tianya.cn/m/searchTopic.jsp?q=";
			break;
		case "haosouwenda":
			string_url = "http://m.wenda.haosou.com/search/?q=";
			break;
		case "sogouwenwen":
			string_url = "http://wenwen.m.sogou.com/search.jsp?key=";
			break;
		case "guokewenda":
			string_url = "http://m.guokr.com/search/all/?wd=";
			break;

		// 学术搜索
		case "googlescholar":
			string_url = "https://scholar.google.com.hk/scholar?q=";
			break;
		case "bingacademic":
			string_url = "http://cn.bing.com/academic/search?q=";
			break;
		case "baiduxueshu":
			string_url = "http://xueshu.baidu.com/s?ie=utf-8&wd=";
			break;

		// 健康搜索
		case "39jiankang":
			string_url = "http://so.39.net/ask.aspx?words=";
			break;

		// 旅游搜索
		case "mafengwowenda":
			string_url = "http://m.mafengwo.cn/group/s.php?key=";
			break;

		// 百科搜索
		case "wikipedia":
			string_url = "https://zh.m.wikipedia.org/w/index.php?search=";
			break;
		case "bingwiki":
			string_url = "http://cn.bing.com/knows/search?est=2&q=";
			break;
		case "baidubaike":
			string_url = "http://wapbaike.baidu.com/search?enc=utf8&word=";
			break;
		case "hudongbaike":
			string_url = "http://so.baike.com/m/doc/";
			break;
		case "haosoubaike":
			// string_url = "http://m.baike.haosou.com/search/?q=";
			string_url = "http://baike.haosou.com/search/?q=";
			break;

		// 社交搜索
		case "twitter":
			string_url = "https://mobile.twitter.com/search?q=";
			break;
		case "weibo":
			string_url = "http://s.weibo.com/weibo/";
			break;
		case "googleplus":
			string_url = "https://plus.google.com/u/0/s/";
			break;
		case "kuandaishan":
			string_url = "http://m.kdslife.com/club/search_";
			break;

		// 装修
		case "liba":
			string_url = "http://wap.libaclub.com/mobile.php?act=search&searchAction=submit&keyword=";
			break;
		case "qijia":
			string_url = "http://m.jia.com/bbs/f_57_0?key_words=";
			break;

		// pingjia
		case "dianping":
			string_url = "http://m.dianping.com/search/keyword/1/0_";
			break;

		// 购物搜索
		case "etao":
			string_url = "http://m.etao.com/search/search.php?all_cities=0&fseller=%E4%BA%AC%E4%B8%9C%E5%95%86%E5%9F%8E,%E4%BA%9A%E9%A9%AC%E9%80%8A,%E8%8B%8F%E5%AE%81%E6%98%93%E8%B4%AD,1%E5%8F%B7%E5%BA%97,%E5%9B%BD%E7%BE%8E%E5%9C%A8%E7%BA%BF,%E6%96%B0%E8%9B%8B%E5%95%86%E5%9F%8E,%E6%98%93%E8%BF%85%E7%BD%91,%E5%BD%93%E5%BD%93%E7%BD%91,%E8%B6%A3%E5%A4%A9%E9%BA%A6%E7%BD%91,%E8%B5%B0%E7%A7%80%E7%BD%91,%E5%87%A1%E5%AE%A2%E8%AF%9A%E5%93%81,%E9%9F%A9%E5%9B%BDGmarket%20%E5%AE%98%E7%BD%91,%E8%B6%A3%E7%8E%A9%E7%BD%91,%E9%AB%98%E9%B8%BF%E5%95%86%E5%9F%8E,%E9%A1%BA%E4%B8%B0%E4%BC%98%E9%80%89,%E5%8D%B3%E5%B0%9A%E7%BD%91,%E4%B8%87%E8%A1%A8%E7%BD%91,%E9%94%90%E6%84%8F%E7%BD%91,%E7%BE%8E%E5%9B%BDshopbop,vjia%E5%95%86%E5%9F%8E,YesStyle%E5%AE%98%E7%BD%91,%E5%A5%BD%E4%B9%90%E4%B9%B0,%E4%BC%98%E8%B4%AD%E7%BD%91,%E7%8F%8D%E5%93%81%E7%BD%91,d1%E4%BC%98%E5%B0%9A%E7%BD%91,babymarket%E5%AE%98%E7%BD%91,%E7%BE%8E%E5%9B%BDstp,%E8%81%9A%E5%B0%9A%E7%BD%91&q=";
			break;
		case "smzdm":
			string_url = "http://search.smzdm.com/?s=";
			break;
		case "taobao":
			string_url = "http://s.m.taobao.com/h5?q=";
			break;
		case "jingdong":
			string_url = "http://m.jd.com/ware/search.action?enc=utf-8&keyword=";
			break;
		case "yihaodian":
			string_url = "http://search.m.yhd.com/search/k";
			break;
		case "dangdang":
			string_url = "http://search.m.dangdang.com/search.php?sort_type=sales_desc&keyword=";
			break;
		case "amazon":
			string_url = "http://www.amazon.com/s/keywords=";
			break;
		case "amazoncn":
			string_url = "http://www.amazon.cn/s/sort=popularity-rank&keywords=";
			break;
		case "suningyigou":
			string_url = "http://m.suning.com/v3/search/result.html?keyword=";
			break;
		case "guomeizaixian":
			string_url = "http://m.gome.com.cn/category.html?sort_by=3&key_word=";
			break;
		case "weipinhui":
			string_url = "http://search.vip.com/search?sort=6&searchkw=";
			break;
		case "lefeng":
			string_url = "http://m.lefeng.com/index.php/search/searchResult?sos=sd&wd=";
			break;

		// 下载搜索
		case "cllj":
			string_url = "http://cililian.me/list/";
			break;
		case "pansou":
			string_url = "http://www.pansou.com/s.php?wp=0&q=";
			break;
		case "baiduyun":
			string_url = "http://so.baiduyun.me/search.php?wd=";
			break;
		case "wangpansou":
			string_url = "http://www.wangpansou.cn/s.php?q=";
			break;
		case "panyisou":
			string_url = "http://panyisou.com/?question/search/3/";
			break;
		case "yisou":
			string_url = "http://www.yiso.me/search.php?wd=";
			break;
		case "panduoduo":
			string_url = "http://www.panduoduo.net/s/name/";
			break;
		case "panzz":
			string_url = "http://www.panzz.com/s/?kw=";
			break;
		case "swp360":
			string_url = "http://www.360swp.com/s.php?q=";
			break;
		}
		// 生成URL
		try {
			switch (search_egine_selection.toLowerCase()) {
			default:
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8");
				break;
			case "39jiankang":
				string_url = string_url + URLEncoder.encode(Keyword, "GBK");
				break;
			case "cllj":
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8")
						+ "/1.html";
				break;
			case "yihaodian":
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8")
						+ "/p1-s2-si1-t1";
				break;
			case "googleplus":
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8")
						+ "/posts";
				break;
			case "lefeng":
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8")
						+ "#getSearchList_hash/5/5";
				break;
			case "kuandaishan":
				string_url = string_url + URLEncoder.encode(Keyword, "UTF-8")
						+ ".html";
				break;
			}
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
		return string_url;
	}

	// 打开浏览器浏览单个搜索结果网页
	private String addASearchResults(String search_egine_selection,
			String Keyword) {
		String string_url;
		string_url = GetString_url(search_egine_selection, Keyword);
		url_list.add(string_url);
		return string_url;
	}

	// 打开浏览器浏览搜索结果网页
	public ArrayList<String> GetSearchResults(String search_egine_selection,
			String Keyword) {
		url_list.clear();
		switch (search_egine_selection.toLowerCase()) {
		default:

			addASearchResults(search_egine_selection, Keyword);
			break;
		case "web":

			addASearchResults("Google", Keyword);
			addASearchResults("Bing", Keyword);
			// addASearchResults("BingCN", Keyword);
			addASearchResults("Baidu", Keyword);
			addASearchResults("Haosou", Keyword);
			break;
		case "wenda":

			addASearchResults("BingQA", Keyword);
			addASearchResults("Baiduzhidao", Keyword);
			addASearchResults("baidujingyan", Keyword);
			addASearchResults("Zhihu", Keyword);
			addASearchResults("tianyawenda", Keyword);
			addASearchResults("haosouwenda", Keyword);
			addASearchResults("sogouwenwen", Keyword);
			addASearchResults("guokewenda", Keyword);
			break;

		case "scholar":

			addASearchResults("googlescholar", Keyword);
			addASearchResults("bingacademic", Keyword);
			addASearchResults("baiduxueshu", Keyword);
			break;

		case "baike":

			addASearchResults("wikipedia", Keyword);
			addASearchResults("BingWiki", Keyword);
			addASearchResults("baidubaike", Keyword);
			addASearchResults("hudongbaike", Keyword);
			addASearchResults("haosoubaike", Keyword);
			break;

		case "social":

			addASearchResults("Twitter", Keyword);
			addASearchResults("Weibo", Keyword);
			addASearchResults("GooglePlus", Keyword);
			addASearchResults("KuanDaiShan", Keyword);
			break;

		case "shopping":

			addASearchResults("SMZDM", Keyword);
			addASearchResults("etao", Keyword);
			addASearchResults("Taobao", Keyword);
			addASearchResults("Jingdong", Keyword);
			addASearchResults("Yihaodian", Keyword);
			addASearchResults("dangdang", Keyword);
			addASearchResults("AmazonCN", Keyword);
			addASearchResults("suningyigou", Keyword);
			addASearchResults("guomeizaixian", Keyword);
			addASearchResults("weipinhui", Keyword);
			addASearchResults("lefeng", Keyword);
			addASearchResults("Amazon", Keyword);
			break;
		case "download":

			addASearchResults("panzz", Keyword);
			addASearchResults("wangpansou", Keyword);
			addASearchResults("baiduyun", Keyword);
			addASearchResults("yisou", Keyword);
			addASearchResults("CLLJ", Keyword);
			// addASearchResults("panduoduo", Keyword);
			// addASearchResults("SWP360", Keyword);
			// addASearchResults("panyisou", Keyword);
			// addASearchResults("PanSou", Keyword);
			break;

		case "zhuangxiu":

			addASearchResults("Liba", Keyword);
			addASearchResults("Qijia", Keyword);
			break;

		case "koubei":

			addASearchResults("Dianping", Keyword);
			break;

		case "lvyou":

			addASearchResults("mafengwowenda", Keyword);
			break;

		case "jiankang":

			addASearchResults("39jiankang", Keyword);
			break;

		}
		return url_list;

	}
}
