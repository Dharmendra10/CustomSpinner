package com.color.droid.customspinner.view;

import java.util.ArrayList;

import com.color.droid.customspinner.SpinnerDialog;
import com.color.droid.customspinner.adapters.SpinnerAdapter.OnSpinnerItemOperation;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;


public class CustomDropDown<T> extends Button {

	Context mContext;
	ArrayList<T> mList;
	OnSpinnerItemOperation mItemOperation;
	private SpinnerDialog<T> mDialog;
	
	public CustomDropDown(Context context) {
		super(context);
		this.mContext = context;
		init();
	}

	
	
	public CustomDropDown(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		init();
	}



	public CustomDropDown(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		init();
	}

	public void setAdpater(ArrayList<T> mList, OnSpinnerItemOperation itemOperation) {
		this.mList = mList;
		this.mItemOperation = itemOperation;
		
		if(this.mList != null && this.mList.size() > 0) {
			setText("Select from list");
//			mItemOperation.onItemSelect(0);
		}else {
			this.mList = new ArrayList<T>();
			setText("Select from list");
		}
		
	}
	
	public void DismissDialog() {
		if(mDialog != null) {
			mDialog.dismiss();
		}
	}
	
	private void init() {
		this.mList = new ArrayList<T>();
	}

	@Override
	public boolean performClick() {
		//Open a dialog with Listview
		mDialog = new SpinnerDialog<T>(mContext, mList, mItemOperation);
		mDialog.show();
		return super.performClick();
	}

}
