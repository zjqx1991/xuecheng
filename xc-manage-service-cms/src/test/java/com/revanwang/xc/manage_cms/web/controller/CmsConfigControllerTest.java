package com.revanwang.xc.manage_cms.web.controller;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsConfigControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFSBucket gridFSBucket;

    @Test
    public void findCmsConfigByIdTest() {

        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://127.0.0.1:31001/cms/config/get/5a791725dd573c3574ee333f", Map.class);

        System.out.println(forEntity);
    }


    /**
     * 存储文件
     * @throws Exception
     */
    @Test
    public void gridFSTest() throws Exception {
        //要存储的文件
        File file = new File("/Users/zijingqiuxue/Desktop/FTL/index_banner.ftl");
        //定义输入流
        FileInputStream inputStream = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId revan_test = gridFsTemplate.store(inputStream, "Grid存储测试");
        //得到文件id
        String fildId = revan_test.toString();
        System.out.println("FreemarkerControllerTest.gridFSTest:==" + fildId);
    }


    /**
     * 获取文件
     * @throws IOException
     */
    @Test
    public void gridFSBucketTest() throws IOException {
        //根据id查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is("5dd0d2eb3e2c9de4fd12c6d3")));
        //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFsResource,用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        //获取流中的数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
        System.out.println(s);
    }

}