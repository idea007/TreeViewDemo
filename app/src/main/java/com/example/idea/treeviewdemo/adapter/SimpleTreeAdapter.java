package com.example.idea.treeviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.idea.treeviewdemo.R;
import com.example.idea.treeviewdemo.tree.bean.Node;
import com.example.idea.treeviewdemo.tree.bean.TreeListViewAdapter;
import com.example.idea.treeviewdemo.tree.bean.TreeNodeIndicator;

import java.util.List;

public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T>
{

	public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
							 int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException
	{
		super(mTree, context, datas, defaultExpandLevel);
	}

	@Override
	public View getConvertView(Node node , int position, View convertView, ViewGroup parent)
	{
		
		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.item_tree, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.tni_indicator = (TreeNodeIndicator) convertView
					.findViewById(R.id.tni_indicator);
			viewHolder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			convertView.setTag(viewHolder);

		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		//set indicator state
		viewHolder.tni_indicator.reset();
		viewHolder.tni_indicator.setLevel(node);
		viewHolder.tni_indicator.isLast(node.isLast());
		viewHolder.tni_indicator.setState(node);
		viewHolder.tni_indicator.isStart(node.isStart());


		viewHolder.tv_title.setText(node.getLabel());

		return convertView;
	}

	private final class ViewHolder
	{
		TreeNodeIndicator tni_indicator;
		TextView tv_title;
	}

}
