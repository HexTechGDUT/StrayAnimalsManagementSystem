package com.HexTechGDUT.controller;

import com.HexTechGDUT.po.Comment;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.CommentService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @PostMapping("/publish")
    public Result<Comment> publish(@Validated @RequestBody Comment comment){
        if (commentService.publish(comment)) {
            return ResultUtils.successWithInfo(comment,"发布成功");
        }
        return ResultUtils.failWithInfo(null,"发布失败");
    }

    @AuthToken
    @PostMapping("/delete")
    public Result<String> delete(@Validated @RequestBody Comment comment){
        if (commentService.delete(comment)) {
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }

    @PassToken
    @PostMapping("/queryCommentByAnimalId")
    public Result<List<Comment>> queryCommentByAnimalId(@Validated @RequestBody String animalId){
        List<Comment> comments = commentService.queryCommentByAnimalId(animalId);
        if (comments.isEmpty()) {
            return ResultUtils.failWithInfo(null,"还没有人发布评论");
        }
        return ResultUtils.success(comments);
    }

    @AuthToken
    @PostMapping("/queryCommentByUid")
    public Result<List<Comment>> queryCommentByUid(@Validated @RequestBody String userId){
        List<Comment> comments = commentService.queryCommentByUid(userId);
        if (comments.isEmpty()){
            return ResultUtils.failWithInfo(null,"该用户还没有发布评论");
        }
        return ResultUtils.success(comments);
    }

}
