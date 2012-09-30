package com.color.droid.customspinner.adapters;

import java.util.ArrayList;
import java.util.List;

import com.color.droid.customspinner.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SpinnerAdapter<T> extends BaseAdapter{

	Context mContext;
	List<T> mList;
	LayoutInflater mInflater;
	OnSpinnerItemOperation mItemOperation;
	private int focusPosition = -1;

	public interface OnSpinnerItemOperation {
		public void onItemSelect(int position);
		public void onItemEdit(int position);
		public void onItemDelete(int position);

	}

	public SpinnerAdapter(Context context, ArrayList<T> list, OnSpinnerItemOperation mItemOperation) {
		this.mContext = context;
		this.mList = list;
		this.mItemOperation = mItemOperation;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		T mObject = mList.get(position);
		final ViewHolder mHolder;

		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.spinner_dialog_item, null);

			mHolder = new ViewHolder();
			mHolder.btnDelete = (Button) convertView.findViewById(R.id.btnDelete);
			mHolder.btnEdit = (Button) convertView.findViewById(R.id.btnEdit);
			mHolder.btnSelect = (Button) convertView.findViewById(R.id.btnSelect);
			mHolder.buttonContainer = (LinearLayout) convertView.findViewById(R.id.buttonContainer);
			mHolder.mTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			convertView.setTag(mHolder);
		}else {
			mHolder = (ViewHolder) convertView.getTag();
		}

		mHolder.mTitle.setText(mObject.toString());

		mHolder.btnSelect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mItemOperation.onItemSelect(position);

			}
		});

		mHolder.btnDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mItemOperation.onItemDelete(position);

			}
		});

		mHolder.btnEdit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mItemOperation.onItemEdit(position);

			}
		});

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				focusPosition = position;
				SpinnerAdapter.this.notifyDataSetChanged();
			}
		});

		if(position == focusPosition) {
			mHolder.buttonContainer.setVisibility(View.VISIBLE);
		}else {
			mHolder.buttonContainer.setVisibility(View.GONE);
		}

		return convertView;
	}

	static class ViewHolder {
		TextView mTitle;
		Button btnSelect;
		Button btnEdit;
		Button btnDelete;
		LinearLayout buttonContainer;
	}

}