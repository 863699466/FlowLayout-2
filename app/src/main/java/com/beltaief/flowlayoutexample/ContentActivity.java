package com.beltaief.flowlayoutexample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.beltaief.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wassim on 9/22/16.
 */

public class ContentActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.reveLayout)
    FlowLayout flowLayout;

    private ItemsAdapter mAdapter = new ItemsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_example);
        ButterKnife.bind(this);

        flowLayout.setConnectivityAware(true);
        flowLayout.setMode(FlowLayout.MODE.PROGRESS);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(mAdapter);

        getData();
    }

    private void getData() {
        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(String.valueOf(i));
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setData(items);
            }
        }, 2000);
    }

    private void setData(List<String> items) {
        if(items.size() > 0) {
            flowLayout.setMode(FlowLayout.MODE.CONTENT);
        } else {
            flowLayout.setMode(FlowLayout.MODE.EMPTY);
        }
        mAdapter.setData(items);
    }
}

