package com.example.idea.treeviewdemo.bean;


import com.example.idea.treeviewdemo.tree.bean.TreeNodeId;
import com.example.idea.treeviewdemo.tree.bean.TreeNodeLabel;
import com.example.idea.treeviewdemo.tree.bean.TreeNodePid;

public class FileBean
{
	@TreeNodeId
	private int _id;
	@TreeNodePid
	private int parentId;
	@TreeNodeLabel
	private String name;
	private long length;
	private String desc;

	public FileBean(int _id, int parentId, String name)
	{
		super();
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
	}

}
