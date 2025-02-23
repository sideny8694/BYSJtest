package com.XBGC.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.XBGC.content.model.dto.TeachplanDto;
import com.XBGC.content.model.po.Teachplan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    //课程计划查询
    public List<TeachplanDto> selectTreeNodes(Long courseId);

    // 更新课程计划的排序
    void updateSort(@Param("orderby") Integer orderby, @Param("id") Long id);

    // 查询指定课程下指定父节点的所有子课程计划，用于排序交换位置
    List<Teachplan> selectSiblings(@Param("courseId") Long courseId, @Param("parentId") Long parentId);
}
