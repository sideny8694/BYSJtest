package com.XBGC.content.api;

import com.XBGC.base.exception.ContentException;
import com.XBGC.content.model.dto.BindTeachplanMediaDto;
import com.XBGC.content.model.dto.SaveTeachplanDto;
import com.XBGC.content.model.dto.TeachplanDto;
import com.XBGC.content.service.TeachplanService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 课程计划编辑接口
 */
@Api(value = "课程计划编辑接口",tags = "课程计划编辑接口")
@RestController
public class TeachplanController {

    @Autowired
    TeachplanService teachplanService;

    @ApiOperation("查询课程计划树形结构")
    //查询课程计划  GET /teachplan/22/tree-nodes
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId) {
        List<TeachplanDto> teachplanTree = teachplanService.findTeachplanTree(courseId);
        return teachplanTree;
    }

    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void saveTeachplan(@RequestBody SaveTeachplanDto teachplan) {
        teachplanService.saveTeachplan(teachplan);
    }

    @ApiOperation("删除课程计划")
    @DeleteMapping("/teachplan/{teachplanId}")
    public ResponseEntity<?> deleteTeachplan(@PathVariable long teachplanId) {
        try {
            teachplanService.deleteTeachplan(teachplanId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("errCode", e.getErrCode());
            errorResponse.put("errMessage", e.getErrMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("课程排序计划")
    @PostMapping("/teachplan/{moveType}/{teachplanId}")
    public ResponseEntity<?> moveTeachplan(@PathVariable String moveType, @PathVariable long teachplanId) {
        try {
            teachplanService.moveTeachplan(moveType, teachplanId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("errCode", e.getErrCode());
            errorResponse.put("errMessage", e.getErrMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "课程计划和媒资信息绑定")
    @PostMapping("/teachplan/association/media")
    public void associationMedia(@RequestBody BindTeachplanMediaDto bindTeachplanMediaDto){
        teachplanService.associationMedia(bindTeachplanMediaDto);
    }


}
