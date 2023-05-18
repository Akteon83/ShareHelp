package com.Akteon_.sharehelp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.Akteon_.sharehelp.R;

import java.util.List;

public class SwipeAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> list;

    public SwipeAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_discussion_preview, parent, false);
        } else {
            view = convertView;
        }
        return view;
    }
}
