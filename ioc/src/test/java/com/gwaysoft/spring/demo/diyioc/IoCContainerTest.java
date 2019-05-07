package com.gwaysoft.spring.demo.diyioc;

import com.gwaysoft.spring.demo.diyioc.car.Audi;
import com.gwaysoft.spring.demo.diyioc.car.Buick;
import com.gwaysoft.spring.demo.diyioc.human.LiSi;
import com.gwaysoft.spring.demo.diyioc.human.ZhangSan;
import org.junit.Before;
import org.junit.Test;

public class IoCContainerTest {

    private IoCContainer ioCContainer = new IoCContainer();

    @Before
    public void before() {
        ioCContainer.setBean(Audi.class, "audi");
        ioCContainer.setBean(Buick.class, "buick");
        ioCContainer.setBean(ZhangSan.class, "zhangSan", "audi");
        ioCContainer.setBean(LiSi.class, "liSi", "buick");
    }

    @Test
    public void test() {
        ZhangSan zhangSan = (ZhangSan) ioCContainer.getBean("zhangSan");
        zhangSan.goHome();

        LiSi liSi = (LiSi) ioCContainer.getBean("liSi");
        liSi.goHome();
    }
}
