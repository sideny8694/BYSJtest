package com.XBGC.content.model.dto;


import com.XBGC.content.model.po.Teachplan;
import com.XBGC.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description 课程计划树型结构dto
 */
@Data
@ToString
public class TeachplanDto extends Teachplan {

    //课程计划关联的媒资信息  与媒资管理的信息
    TeachplanMedia teachplanMedia;

    //子结点  小章节列表
    List<TeachplanDto> teachPlanTreeNodes;

}
