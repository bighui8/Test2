package com.example.huiying.test2.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huiying.test2.GetternSetter.coupons;
import com.example.huiying.test2.R;

import java.util.List;

/**
 * Created by huiying on 4/11/2017.
 */

public class couponListAdapter extends BaseAdapter {

    private Context myContext;
    private List<coupons> myCouponList;

    public couponListAdapter(Context myContext, List<coupons> myCouponList) {
        this.myContext = myContext;
        this.myCouponList = myCouponList;

    }


    @Override
    public int getCount() {
        return myCouponList.size();
    }

    @Override
    public Object getItem(int position) {
        return myCouponList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(myContext, R.layout.couponlist_content, null);
        ImageView ivPhoto = (ImageView)v.findViewById(R.id.cate_pic);
        TextView tvName = (TextView)v.findViewById(R.id.store_name);
        TextView tvExpDate = (TextView)v.findViewById(R.id.expiry_date);
        TextView tvNote = (TextView)v.findViewById(R.id.note);

        ivPhoto.setImageResource(myCouponList.get(position).getPhotoID());
        tvName.setText(myCouponList.get(position).getStoreName());
        tvExpDate.setText(myCouponList.get(position).getExpiryDate());
        tvNote.setText(myCouponList.get(position).getNote());

        v.setTag(myCouponList.get(position).getId());

        return v;
    }
}
