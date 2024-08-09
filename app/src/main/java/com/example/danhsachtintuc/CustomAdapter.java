package com.example.danhsachtintuc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context myContext;
    private int myLayout;
    private List<tintuc> newsList;

    public CustomAdapter(Context context, int layout, List<tintuc> tintucList) {
        myContext = context;
        myLayout = layout;
        newsList = tintucList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder = new ViewHolder();
            holder.txtTitle = view.findViewById(R.id.title);
            holder.txtContent = view.findViewById(R.id.noidung);
            holder.txtDate = view.findViewById(R.id.date);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        tintuc news = newsList.get(i);
        holder.txtTitle.setText(news.getTitle());
        holder.txtContent.setText(news.getNoidung());
        holder.txtDate.setText(news.getDate());

        return view;
    }

    static class ViewHolder {
        TextView txtTitle;
        TextView txtContent;
        TextView txtDate;
    }
}
