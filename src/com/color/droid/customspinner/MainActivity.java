package com.color.droid.customspinner;

import java.util.ArrayList;

import com.color.droid.customspinner.adapters.SpinnerAdapter.OnSpinnerItemOperation;
import com.color.droid.customspinner.view.CustomDropDown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnSpinnerItemOperation {

	CustomDropDown<String> mDropDown;
	ArrayList<String> mCountries;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bindComponents();
        init();
        addListeners();
    }

    private void bindComponents() {
    	mDropDown = (CustomDropDown<String>) findViewById(R.id.spnList);
	}
    
    private void init() {
    	mCountries = new ArrayList<String>();
    	getCountries();
    	mDropDown.setAdpater(mCountries, this);
	}
    
    private void getCountries() {
	mCountries.add("United Kingdom");
	mCountries.add("United States");
	mCountries.add("Afghanistan");
	mCountries.add("Albania");
	mCountries.add("Algeria");
	mCountries.add("American Samoa");
	mCountries.add("Andorra");
	mCountries.add("Angola");
	mCountries.add("Anguilla");
	mCountries.add("Antarctica");
	mCountries.add("Argentina");
	mCountries.add("Armenia");
	mCountries.add("Aruba");
	mCountries.add("Australia");
	mCountries.add("Bahamas");
	mCountries.add("Bahrain");
	mCountries.add("Bangladesh");
	mCountries.add("Barbados");
	mCountries.add("Canada");
	mCountries.add("Colombia");
	mCountries.add("India");
	
	}
    
    private void addListeners() {
//    	mDropDown.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.spnList:
			
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemSelect(int position) {
		// TODO Auto-generated method stub
		mDropDown.setText(mCountries.get(position));
		mDropDown.DismissDialog();
	}

	@Override
	public void onItemEdit(int position) {
		// TODO Auto-generated method stub
		Toast.makeText(this, mCountries.get(position) + " is Editing.", Toast.LENGTH_SHORT).show();
		mDropDown.DismissDialog();
	}

	@Override
	public void onItemDelete(int position) {
		// TODO Auto-generated method stub
		Toast.makeText(this, mCountries.get(position) + " is Deleted.", Toast.LENGTH_SHORT).show();
		if(mCountries.size() > position) {
			mCountries.remove(position);
			mDropDown.setAdpater(mCountries, this);	
		}
		mDropDown.DismissDialog();
	}
    
}
