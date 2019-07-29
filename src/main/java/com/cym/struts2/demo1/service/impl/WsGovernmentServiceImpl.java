package com.cym.struts2.demo1.service.impl;

import com.cym.struts2.demo1.bean.WsGovernment;
import com.cym.struts2.demo1.bean.WsGovernmentExample;
import com.cym.struts2.demo1.mapper.WsGovernmentMapper;
import com.cym.struts2.demo1.service.WsGovernmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@Component
@WebService
public class WsGovernmentServiceImpl extends SpringBeanAutowiringSupport implements WsGovernmentService {
    @Autowired
    WsGovernmentMapper governmentMapper;


    @WebMethod(exclude = true)
    @Override
    public PageInfo<WsGovernment> getGovernmentInfo(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum <= 0 ? 1 : pageNum, pageSize <= 0 ? 10 : pageSize);
        WsGovernmentExample example = new WsGovernmentExample();
        example.createCriteria().andEnableFlagNotEqualTo("3");
        List<WsGovernment> all = governmentMapper.selectByExample(example);
        PageInfo<WsGovernment> pageInfo = new PageInfo<WsGovernment>(all, 10);

        return pageInfo;
    }

    @Override
    public WsGovernment getGovernmentById(int id) {
        System.out.println(id);
        WsGovernment gov = governmentMapper.selectByPrimaryKey(new BigDecimal(id));
        return gov;
    }

    @Override
    public boolean addGovernment(WsGovernment government) {
        int flag = governmentMapper.insertSelective(government);
        if (flag == 0) {
            return false;
        }
        return true;
    }
}
