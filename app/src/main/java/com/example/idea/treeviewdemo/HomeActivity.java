package com.example.idea.treeviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.idea.treeviewdemo.adapter.SimpleTreeAdapter;
import com.example.idea.treeviewdemo.bean.Bean;
import com.example.idea.treeviewdemo.bean.FileBean;
import com.example.idea.treeviewdemo.tree.bean.Node;
import com.example.idea.treeviewdemo.tree.bean.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private ListView lv_tree;
    private List<FileBean> mDatas2 = new ArrayList<FileBean>();
    private TreeListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

        initDatas();
        initView();
    }

    private void initDatas() {

        mDatas2.add(new FileBean(1, 0, "第一章"));
        mDatas2.add(new FileBean(2, 1, "第一节"));
        mDatas2.add(new FileBean(3, 1, "第二节"));
        mDatas2.add(new FileBean(4, 1, "第三节"));
        mDatas2.add(new FileBean(5, 2, "第一课"));
        mDatas2.add(new FileBean(6, 2, "第二课"));

        mDatas2.add(new FileBean(7, 4, "第一课"));
        mDatas2.add(new FileBean(8, 4, "第二课"));

    }

    private void initView() {
        lv_tree= (ListView) findViewById(R.id.lv_tree);

        try
        {
            mAdapter = new SimpleTreeAdapter<FileBean>(lv_tree, this, mDatas2, 0);
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener()
            {
                @Override
                public void onClick(Node node, int position)
                {
                    if (node.isLeaf())
                    {
                        Toast.makeText(getApplicationContext(), node.getLabel(),
                                Toast.LENGTH_SHORT).show();
                    }
                }

            });

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        lv_tree.setAdapter(mAdapter);

    }
}
