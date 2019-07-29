package com.cym.struts2.demo1.action;

import com.cym.struts2.demo1.bean.WsGovernment;
import com.cym.struts2.demo1.service.WsGovernmentService;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Administrator on 2019/7/10.
 */
//@ParentPackage("struts-default")

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Autowired
    WsGovernmentService governmentService;

    private PageInfo<WsGovernment> governmentInfo;

    public PageInfo<WsGovernment> getGovernmentInfo() {
        return governmentInfo;
    }

    public void setGovernmentInfo(PageInfo<WsGovernment> governmentInfo) {
        this.governmentInfo = governmentInfo;
    }

    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    @Action(value = "/login",
            results = {
                    @Result(name = "success",location = "/result.jsp"),
                    @Result(name = "error",location = "/index.jsp")})
    @Override
    public String execute() throws Exception {
        if ("admin".equals(username) && "123456".equals(password)) {
            governmentInfo = governmentService.getGovernmentInfo(pageNum, 10);
            System.out.println(governmentInfo);

            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Action(value = "/getGovPage",results = {@Result(name = SUCCESS,location = "/result.jsp")})
    public String getGovPage() {
        governmentInfo = governmentService.getGovernmentInfo(pageNum, 10);
        return SUCCESS;
    }
}
