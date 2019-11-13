package com.revanwang.xc.manage_cms.service.impl;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.dao.ICmsPageRepository;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsPageServiceImplTest {

    @Autowired
    private ICmsPageService cmsPageService;

    @Test
    public void findList() {
        //分页参数
        QueryResponseResult result = this.cmsPageService.findList(1, 10, null);
        System.out.println("CmsPageServiceImplTest.findList:===" + result);
    }
}