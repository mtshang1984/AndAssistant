package com.example.andassistant;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnQueryTextListener {

	private Spinner spinner_search_type;
	// private TextView text_view;
	private SearchView search_view;
	private ListView list_view;
	private String search_keyword;
	private String search_type;
	private SearchEngine search_engine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner_search_type = (Spinner) this
				.findViewById(R.id.spinnerSearchType);
		ArrayAdapter adapter_search_type = ArrayAdapter
				.createFromResource(this, R.array.search_type,
						android.R.layout.simple_spinner_item);
		adapter_search_type
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_search_type.setAdapter(adapter_search_type);
		spinner_search_type.setOnItemSelectedListener(this);

		list_view = (ListView) this.findViewById(R.id.listView);
		list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			   @Override
			   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			      //Object listItem = list_view.getItemAtPosition(position);
				   Uri uri = Uri.parse(list_view.getItemAtPosition(position).toString());  
				   startActivity(new Intent(Intent.ACTION_VIEW,uri));
			   } 
			});

		search_engine = new SearchEngine();
		search_keyword="";
		// text_view = (TextView) this.findViewById(R.id.textViewShow);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		MenuItem searchItem = menu.findItem(R.id.action_search);
		search_view = (SearchView) searchItem.getActionView();
		search_view.setOnQueryTextListener(this);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 处理动作按钮的点击事件
		switch (item.getItemId()) {
		case R.id.action_search:
			openSearch();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openSearch() {
		// TODO Auto-generated method stub
		// TextView text_view = (TextView) this.findViewById(R.id.textViewShow);
		// text_view.setText("开始搜索");

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		search_type = spinner_search_type.getItemAtPosition(position)
				.toString();
		onQueryTextChange(search_keyword);
		// Toast.makeText(this, "你选中的是" + itemString, 1).show();
		// text_view.setText(search_type);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		// Toast.makeText(this, "您输入的是：" + query, Toast.LENGTH_SHORT).show();
		search_keyword = query;
		showSearchResults(search_keyword);
		return true;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		// Toast.makeText(this, "您输入的是：" + newText, Toast.LENGTH_SHORT).show();
		search_keyword = newText;
		showSearchResults(search_keyword);
		return true;
	}

	public boolean showSearchResults(String search_keyword) {

		ArrayList<String> url_list = new ArrayList<String>();
		url_list.clear();
		switch (search_type) {
		default:
		case "网页":
			url_list = search_engine.GetSearchResults("web", search_keyword);
			break;
		case "问答":
			url_list = search_engine.GetSearchResults("wenda", search_keyword);
			break;
		case "学术":
			url_list = search_engine
					.GetSearchResults("scholar", search_keyword);
			break;
		case "百科":
			url_list = search_engine.GetSearchResults("baike", search_keyword);
			break;
		case "社交":
			url_list = search_engine.GetSearchResults("social", search_keyword);
			break;
		case "购物":
			url_list = search_engine.GetSearchResults("shopping",
					search_keyword);
			break;
		case "下载":
			url_list = search_engine.GetSearchResults("download",
					search_keyword);
			break;
		case "装修":
			url_list = search_engine.GetSearchResults("zhuangxiu",
					search_keyword);
			break;
		case "口碑":
			url_list = search_engine.GetSearchResults("koubei", search_keyword);
			break;
		case "旅游":
			url_list = search_engine.GetSearchResults("lvyou", search_keyword);
			break;
		case "健康":
			url_list = search_engine.GetSearchResults("jiankang",
					search_keyword);
			break;

		}
		// strs.add(newText);
		// strs.set(1, search_keyword);
		list_view.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, url_list));
		return true;
	}

}
