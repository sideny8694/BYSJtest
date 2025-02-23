package com.XBGC.search.service;

import com.XBGC.search.po.CourseIndex;

/**
 * @author Mr.w
 * @version 1.0
 * @description 课程索引service
 * @date 2025/2/24 22:40
 */
public interface IndexService {

    /**
     * @param indexName 索引名称
     * @param id 主键
     * @param object 索引对象
     * @return Boolean true表示成功,false失败
     * @description 添加索引
     * @author Mr.w
     * @date 2025/2/24 22:57
     */
    public Boolean addCourseIndex(String indexName,String id,Object object);


    /**
     * @description 更新索引
     * @param indexName 索引名称
     * @param id 主键
     * @param object 索引对象
     * @return Boolean true表示成功,false失败
     * @author Mr.w
     * @date 2025/2/25 7:49
    */
    public Boolean updateCourseIndex(String indexName,String id,Object object);

    /**
     * @description 删除索引
     * @param indexName 索引名称
     * @param id  主键
     * @return java.lang.Boolean
     * @author Mr.w
     * @date 2025/2/25 9:27
    */
    public Boolean deleteCourseIndex(String indexName,String id);

}
