package com.cym.struts2.demo1.service;

import com.cym.struts2.demo1.bean.WsGovernment;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2019/7/11.
 */
public interface WsGovernmentService {
    /**
     * 分页查询所有政府机关信息
     * @param pageNum 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    PageInfo<WsGovernment> getGovernmentInfo(int pageNum,int pageSize);

    WsGovernment getGovernmentById(int id);
}
