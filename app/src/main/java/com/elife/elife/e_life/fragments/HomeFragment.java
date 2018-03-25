package com.elife.elife.e_life.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elife.elife.e_life.R;
import com.elife.elife.e_life.adapters.DataProvider;
import com.elife.elife.e_life.adapters.GridDataAdapter;
import com.elife.elife.e_life.sql.SqliteHelper;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private SqliteHelper sqliteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private List<DataProvider> mPersonList;
    private GridDataAdapter mGridDataAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_categories, container, false);
        View mview = inflater.inflate(R.layout.fragment_home, container, false);

        GridView listView = (GridView) mview.findViewById(R.id.gridview);
        mPersonList = new ArrayList<>();
        sqliteHelper = new SqliteHelper(getContext());
        sqLiteDatabase = sqliteHelper.getReadableDatabase();
        Cursor cursor = sqliteHelper.getUserInformation();
        if (cursor.moveToFirst()){
            do{
                String id, categoryname;
                id = cursor.getString(cursor.getColumnIndex("id"));
                categoryname = cursor.getString(cursor.getColumnIndex("categoryname"));
                DataProvider dataProvider = new DataProvider(id,categoryname);
                mPersonList.add(dataProvider);
            }while (cursor.moveToNext());
        }

        mGridDataAdapter = new GridDataAdapter(getContext(),R.layout.cat_listing_grid,mPersonList);
        listView.setAdapter(mGridDataAdapter);
        return mview;
    }


}
