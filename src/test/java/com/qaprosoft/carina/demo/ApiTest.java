package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {

//    @Test
//    @MethodOwner(owner = "Khalezova_Marianna")
//    public void testDelete() {
//        DeletePostMethod deletePostMethod = new DeletePostMethod();
//        deletePostMethod.callAPIExpectSuccess();
//        deletePostMethod.validateResponse();
//    }


    @Test
    @MethodOwner(owner = "Khalezova_Marianna")
    public void testPut() {
        PutPostMethod putPostMethod = new PutPostMethod();
        putPostMethod.callAPIExpectSuccess();
    }

//    @Test
//    @MethodOwner(owner = "Khalezova_Marianna")
//    public void testPost() {
//        PostPostMethod postPostMethod = new PostPostMethod();
//        postPostMethod.setProperties("api/posts/post.properties");
//        postPostMethod.callAPIExpectSuccess();
//        postPostMethod.validateResponse();
//
//    }

    @Test
    @MethodOwner(owner = "Khalezova_Marianna")
    public void testGet() {
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethod.validateResponseAgainstSchema("api/posts/get/rs.schema");
    }

}
