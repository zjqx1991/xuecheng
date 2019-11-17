package com.revanwang.xc.manage_cms.service.impl;


import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.CmsTemplate;
import com.revanwang.xc.framework.domain.cms.request.QueryTemplateRequest;
import com.revanwang.xc.framework.exception.RevanThrowException;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.framework.model.response.QueryResult;
import com.revanwang.xc.manage_cms.dao.ICmsTemplateRepository;
import com.revanwang.xc.manage_cms.service.ICmsTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CmsTemplateServiceImpl implements ICmsTemplateService {

    @Autowired
    private ICmsTemplateRepository templateRepository;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public QueryResponseResult findCmsTemplateList(int page, int size, QueryTemplateRequest templateRequest) {
        if (templateRequest == null) {
            templateRequest = new QueryTemplateRequest();
        }

        //1.设置页码查询
        if (page < 1) {
            page = 1;
        }
        page = page - 1;
        if (size < 10) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);

        //2.设置条件查询
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("templateName", ExampleMatcher.GenericPropertyMatchers.contains());
//                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("siteId", ExampleMatcher.GenericPropertyMatchers.contains())
        //3.添加查询
        CmsTemplate template = new CmsTemplate();
        if (templateRequest != null) {
            //3.1 站点查询
            String templateParam = templateRequest.getParam();
            if (StringUtils.isNotBlank(templateParam)) {
//                template.setId(templateParam);
//                template.setSiteId(templateParam);
                template.setTemplateName(templateParam);
            }
        }
        //4.条件查询
        Example<CmsTemplate> example = Example.of(template, matcher);
        Page<CmsTemplate> templatePages = this.templateRepository.findAll(example, pageable);
        QueryResult<List<CmsTemplate>> result = new QueryResult<>();
        result.setData(templatePages.getContent());
        result.setTotal(templatePages.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    @Override
    public QueryResponseResult cmsTemplateAdd(CmsTemplate template) {
        if (template.getTemplateFileId() == null || !template.getTemplateFileId().contains(".ftl")) {
            RevanThrowException.throwException(CommonCode.CMS_TEMPLATE_PATH_NOT_FOUND);
        }
        //存储模板
        String templateId = this.gridFsSave(template.getTemplateFileId(), template.getTemplateName());
        if (templateId == null) {
            RevanThrowException.throwException(CommonCode.CMS_TEMPLATE_GRIDFS_SAVE_FAIL);
        }
        template.setTemplateFileId(templateId);
        CmsTemplate cmsTemplate = this.templateRepository.save(template);
        QueryResult<CmsTemplate> result = new QueryResult<>();
        result.setData(cmsTemplate);
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    @Override
    public QueryResponseResult cmsTemplateDelete(String id) {
        if (StringUtils.isBlank(id)) {
            RevanThrowException.throwException(CommonCode.CMS_TEMPLATE_DELETE_PARAM_FAIL);
        }
        Optional<CmsTemplate> optional = this.templateRepository.findById(id);
        if (!optional.isPresent()) {
            RevanThrowException.throwException(CommonCode.CMS_TEMPLATE_DELETE_PARAM_FAIL);
        }
        //删除文件
        this.deleteTemplateWithId(optional.get().getTemplateFileId());
        //删除模板
        this.templateRepository.deleteById(id);
        QueryResult<CmsTemplate> result = new QueryResult<>();
        result.setData(optional.get());

        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    /**
     * 保存模板
     *
     * @param ftlPath 模板路径
     * @return 存储文件id
     */
    private String gridFsSave(String ftlPath, String ftlName) {
        //要存储的文件
        File file = new File(ftlPath);
        //定义输入流
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //向GridFS存储文件
        ObjectId revan_test = gridFsTemplate.store(inputStream, ftlName);
        //得到文件id
        String fildId = revan_test.toString();
        System.out.println("FreemarkerControllerTest.gridFSTest:==" + fildId);
        return fildId;
    }

    /**
     * 删除模板
     */
    public void deleteTemplateWithId(String id) {
        //根据文件id删除fs.files和fs.chunks中的记录
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(id)));
    }

}
