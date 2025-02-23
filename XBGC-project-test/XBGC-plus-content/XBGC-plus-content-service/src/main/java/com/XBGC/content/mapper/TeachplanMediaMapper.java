package com.XBGC.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.XBGC.content.model.po.TeachplanMedia;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface TeachplanMediaMapper extends BaseMapper<TeachplanMedia> {
    /**
     * 根据课程计划 ID 删除关联的媒体信息
     * @param teachplanId 课程计划 ID
     */
    void deleteByTeachplanId(@Param("teachplanId") long teachplanId);

}
