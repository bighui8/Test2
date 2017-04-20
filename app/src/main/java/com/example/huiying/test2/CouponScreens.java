package com.example.huiying.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.huiying.test2.Adapters.couponListAdapter;
import com.example.huiying.test2.GetternSetter.coupons;

import java.util.ArrayList;
import java.util.List;

public class CouponScreens extends AppCompatActivity {
    private ListView lvCoupons;
    private couponListAdapter adapter;
    private List<coupons> myCouponsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_screens);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvCoupons = (ListView) findViewById(R.id.coupon_list);

        myCouponsList = new ArrayList<>();

        myCouponsList.add(new coupons(1, R.drawable.icon_eat, "Taste", "Sep 1, 2017", "$100 coupon"));
        myCouponsList.add(new coupons(2, R.drawable.icon_shopping, "UNIQLO", "Sep 31, 2017", "10% OFF"));

        adapter = new couponListAdapter(getApplicationContext(), myCouponsList);
        lvCoupons.setAdapter(adapter);

        lvCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentCouponPhoto = new Intent(CouponScreens.this, couponPhotos.class);
                startActivity(intentCouponPhoto);
            }
        });
    }
}

