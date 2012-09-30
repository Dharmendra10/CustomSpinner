package com.color.droid.customspinner;

import java.util.ArrayList;

import com.color.droid.customspinner.adapters.SpinnerAdapter;
import com.color.droid.customspinner.adapters.SpinnerAdapter.OnSpinnerItemOperation;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class SpinnerDialog<T> extends Dialog implements android.view.View.OnClickListener, OnItemClickListener{

	Context mContext;
	
	TextView tvTitle;
	ListView mListView;
	ArrayList<T> mList;
	OnSpinnerItemOperation mItemOperation;
	
	public SpinnerDialog(Context context, ArrayList<T> list, OnSpinnerItemOperation operation) {
		super(context, R.style.dialog_style);
//		super(context);
		setContentView(R.layout.spinner_dialog);
		mContext = context;
		mList = list;
		this.mItemOperation = operation;
		bindComponents();
		addListeners();
		init();
	}

	private void bindComponents() {
		// TODO Auto-generated method stub
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		mListView = (ListView) findViewById(android.R.id.list);
		
	}

	public void setDialogTitle(String title) {
		tvTitle.setText(title);
	}
	
	private void addListeners() {
		
	}

	private void init() {
		this.setDialogTitle(mContext.getString(R.string.app_name));
		this.setCancelable(true);
		if(mList == null) {
			mList = new ArrayList<T>();
		}
		SpinnerAdapter<T> mSpinnerAdapter = new SpinnerAdapter<T>(mContext, mList, mItemOperation);
		mListView.setAdapter(mSpinnerAdapter);
	}

	@Override
	public void onClick(View v) {
		mContext = null;
		this.dismiss();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		this.dismiss();
	}
}
