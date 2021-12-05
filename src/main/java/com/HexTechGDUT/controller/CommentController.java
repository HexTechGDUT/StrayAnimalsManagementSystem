package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.po.Comment;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.CommentService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Api("评论")
@CrossOrigin
@RestController
@RequestMapping(value = "/animal/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @AuthToken
    @ApiOperation("发布评论")
    @PostMapping("/publish")
    public Result<Comment> publish(@Validated @RequestBody Comment comment){
        if (commentService.publish(comment) == 1) {
            return ResultUtils.successWithInfo(comment,"发布成功");
        }
        return ResultUtils.failWithInfo(null,"发布失败");
    }

    @AuthToken
    @ApiOperation("删除评论")
    @PostMapping("/delete")
    public Result<String> delete(@Validated @RequestBody int id){
        if (commentService.delete(id) == 1) {
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }

    @PassToken
    @ApiOperation("通过动物id查询评论")
    @PostMapping("/queryCommentByAnimalId")
    public Result<List<Comment>> queryCommentByAnimalId(@Validated @RequestBody int animalId){
        List<Comment> comments = commentService.queryCommentByAnimalId(animalId);
        if (comments.isEmpty()) {
            return ResultUtils.failWithInfo(null,"还没有人发布评论");
        }
        return ResultUtils.success(comments);
    }

    @AuthToken
    @ApiOperation("通过用户id查询评论")
    @PostMapping("/queryCommentByUserId")
    public Result<List<Comment>> queryCommentByUserId(@Validated @RequestBody String userId){
        List<Comment> comments = commentService.queryCommentByUserId(userId);
        if (comments.isEmpty()){
            return ResultUtils.failWithInfo(null,"该用户还没有发布评论");
        }
        return ResultUtils.success(comments);
    }

}
