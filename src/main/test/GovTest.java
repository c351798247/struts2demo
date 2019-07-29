import com.cym.struts2.demo1.bean.WsGovernment;
import com.cym.struts2.demo1.bean.WsGovernmentExample;
import com.cym.struts2.demo1.mapper.WsGovernmentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GovTest {
    @Autowired
    WsGovernmentMapper governmentMapper;
    @Test
    public void test1() {
        PageHelper.startPage(6, 20);
        WsGovernmentExample example = new WsGovernmentExample();
        List<WsGovernment> all = governmentMapper.selectByExample(new WsGovernmentExample());
        PageInfo<WsGovernment> pageInfo = new PageInfo<WsGovernment>(all,5);
        System.out.println(pageInfo);

    }
    @Test
    public void  test2() {
        WsGovernmentExample example = new WsGovernmentExample();
        example.createCriteria().andEnableFlagNotEqualTo("1");
        System.out.println(governmentMapper.countByExample(example));
    }


}
