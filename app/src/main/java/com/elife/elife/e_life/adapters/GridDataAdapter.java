package com.elife.elife.e_life.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.elife.elife.e_life.R;

import java.util.List;

/**
 * Created by anshad on 25/3/18.
 */

public class GridDataAdapter extends ArrayAdapter {

    List<DataProvider> mlist;

    public GridDataAdapter(Context context, int resource, List<DataProvider> list )
    {
        super(context, resource);
        mlist = list;
    }

    static class LayoutHandler{
        TextView id, categoryname;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mview = convertView;
        LayoutHandler layoutHandler;
        if(mview==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mview = layoutInflater.inflate(R.layout.cat_listing_grid,parent,false);
            layoutHandler = new LayoutHandler();
//            layoutHandler.id = (TextView)mview.findViewById(R.id.tv_name);
            layoutHandler.categoryname = (TextView)mview.findViewById(R.id.tv_cat_name);

            mview.setTag(layoutHandler);
        }else {
            layoutHandler = (LayoutHandler) mview.getTag();
        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
//        layoutHandler.id.setText(dataProvider.getId());
        layoutHandler.categoryname.setText(dataProvider.getCategoryname());
        return mview;
    }
}
