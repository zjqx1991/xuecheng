package com.revanwang.xc.manage_cms.web.controller;

import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import com.revanwang.xc.manage_cms.service.impl.CmsPageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsPageControllerTest {

    @Autowired
    private CmsPageServiceImpl cmsPageService;
    @Test
    public void findList() {
        System.out.println("CmsPageServiceImplTest.findList:===" + this.cmsPageService);

        //分页参数
        QueryResponseResult result = this.cmsPageService.findList(1, 10, null);
        System.out.println("CmsPageServiceImplTest.findList:===" + result);
    }
}