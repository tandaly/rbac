package com.frame.common.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.frame.common.page.Pagination;
import com.frame.util.HtmlUtil;

/**
 * 基本控制器
 * 
 * @author Tandaly
 * @date 2013-3-5 下午2:49:20
 */
public abstract class BaseController {

	/**
	 * 输出分页数据
	 * @param response
	 * @param pagination
	 * @param result
	 */
	protected void writerPagination(HttpServletResponse response,
			Pagination pagination, Map<String, Object> result) {
		// 分页返回参数
		result.put("pageCount", pagination.getPageCount());
		result.put("result", pagination.getList());
		result.put("countRecord", pagination.getTotalCount());

		HtmlUtil.writerJson(response, result);
	}
}
