package com.weitu.mpsplatform.commons.page;

import java.util.ArrayList;
import java.util.List;

/**
 *  Description : List数据集分页处理
 * 
 *  @author:  fsh
 *
 */
public class PageHandle {
	/**
	 * 获取分页数
	 * 
	 * @param list
	 * @param pageSize
	 * @return
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static int getPageNum(List list, int pageSize) {
		// 记录总数
		int totalSize = (null == list) ? 0 : list.size();
		// 页数
		int sumpagenumber = totalSize / pageSize;
		// 最后一页记录数
		int lastListsize = totalSize % pageSize;
		// 如果最后一个List的大小不为0，则所需的List个数需要加1
		if (lastListsize != 0) {
			sumpagenumber++;
		}
		return sumpagenumber;
	}
	
	/**
	 * 获取分页数
	 * 
	 * @param totalSize
	 * @param pageSize
	 * @return
	 *
	 */
	public static int getPageNum(int totalSize, int pageSize) {
		// 页数
		int sumpagenumber = totalSize / pageSize;
		// 最后一页记录数
		int lastListsize = totalSize % pageSize;
		// 如果最后一个List的大小不为0，则所需的List个数需要加1
		if (lastListsize != 0) {
			sumpagenumber++;
		}
		return sumpagenumber;
	}

	/**
	 * 获取指定分页的分页数据
	 * 
	 * @param list
	 * @param pageSize
	 * @param pageNum
	 * @return
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static List pageHandle(List list, int pageSize, int pageNum) {
		List pageList = new ArrayList();
		// 记录总数
		int totalSize = (null == list) ? 0 : list.size();

		// 每个子List起始的位置
		int starnum = pageNum * pageSize;
		if (starnum + pageSize < totalSize) {
			pageList = list.subList(starnum, starnum + pageSize);
		} else {
			pageList = list.subList(starnum, totalSize);
		}

		return pageList;
	}
}
