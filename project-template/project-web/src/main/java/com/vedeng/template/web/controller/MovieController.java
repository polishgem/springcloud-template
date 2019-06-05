package com.vedeng.template.web.controller;


import com.vedeng.template.common.ResultInfo;
import com.vedeng.template.service.feign.user.UserInfoServiceFeignClient;
import com.vedeng.template.service.user.UserService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/movies")
@RestController
public class MovieController {

    /**
     * 日志
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${timeout}")
    private String timeout1;

    @Value("${timeout}")
    private Integer timeout2;

    @Autowired
    private UserInfoServiceFeignClient userInfoServiceFeignClient;

    @Autowired
    private UserService userService;

    @Autowired
    private RedissonClient redisson;


    @GetMapping("/test")
    public ResultInfo findById() {
        return ResultInfo.success(userInfoServiceFeignClient.findById(1L));
    }


    @GetMapping("/getUser")
    public ResultInfo getUser(Long id) {
        return ResultInfo.success(userService.queryUser(id));
    }

    @GetMapping("/cache")
    public ResultInfo testCache() {
        RLock lock = redisson.getLock("anyLock");
        log.info("当前线程：" + Thread.currentThread().getName());
        lock.lock();
        try {
            log.info(Thread.currentThread().getName() + "加锁");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lock.unlock();
        log.info(Thread.currentThread().getName() + "解锁");
        return ResultInfo.success("ssss");
    }

    /**
     * <b>Description:查看页面</b><br>
     *
     * @param name
     * @param request
     * @param response
     * @return <b>Author: Franlin.wu</b>
     * <br><b>Date: 2019年3月14日 下午4:22:36 </b>
     */
    @GetMapping("hi/{name}")
    public ModelAndView testTh(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("index");

        view.addObject("name", name);
        view.setViewName("th");

        return view;
    }

}
