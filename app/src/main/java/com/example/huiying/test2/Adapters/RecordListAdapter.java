package com.example.huiying.test2.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huiying.test2.GetternSetter.records;
import com.example.huiying.test2.R;

import java.util.ArrayList;


public class RecordListAdapter extends ArrayAdapter<records> {

    private static final String TAG = "RecordListAdapter";
    private Context mContext;
    int mResource;

    public RecordListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<records> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Integer icon = getItem(position).getCate_pic();
        String note = getItem(position).getNote();
        String date = getItem(position).getDate();
        String amount = getItem(position).getAmount();

        records spendingRecords = new records(icon, note, date, amount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView ivIcon = (ImageView) convertView.findViewById(R.id.cate_pic);
        TextView tvNote = (TextView) convertView.findViewById(R.id.note);
        TextView tvDate = (TextView) convertView.findViewById(R.id.date);
        TextView tvAmount = (TextView) convertView.findViewById(R.id.amount);

        ivIcon.setImageResource(icon);
        tvNote.setText(note);
        tvDate.setText(date);
        tvAmount.setText(amount);

        return convertView;
    }
}
