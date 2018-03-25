package com.elife.elife.e_life.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.elife.elife.e_life.R;
import com.elife.elife.e_life.adapters.DataProvider;
import com.elife.elife.e_life.adapters.ListDataAdapter;
import com.elife.elife.e_life.sql.SqliteHelper;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {


    private SqliteHelper sqliteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private List<DataProvider> mPersonList;
    private ListDataAdapter mListDataAdapter;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_categories, container, false);
        View mview = inflater.inflate(R.layout.fragment_categories, container, false);

        ListView listView = (ListView) mview.findViewById(R.id.lv_person);
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

        mListDataAdapter = new ListDataAdapter(getContext(),R.layout.cat_listing_list,mPersonList);
        listView.setAdapter(mListDataAdapter);
        return mview;
    }


}
