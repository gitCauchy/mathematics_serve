package org.math.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.math.response.PostVo;
import org.math.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: Post 控制层
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/post")
public class PostController {

    PostService postService;

    /**
     * 热度前 20 榜单
     *
     * @return PostVo 列表
     */
    @GetMapping("/getTop20HotPost")
    public ResponseEntity<List<PostVo>> getTop20HotPost() {
        log.info("12345");
        List<PostVo> postVoList = postService.getTop20HotPost();
        return new ResponseEntity<>(postVoList, HttpStatus.OK);
    }

    @GetMapping("/addLike")
    public void addLike(@RequestParam(value = "postId") Long postId){
        postService.addLike(postId);
    }
}
