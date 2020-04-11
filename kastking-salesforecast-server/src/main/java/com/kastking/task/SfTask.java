package com.kastking.task;

import com.kastking.common.utils.StringUtils;
import com.kastking.salesforcastInfo.service.SalesforcastInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务调度测试
 *
 * @author kastking
 */
@Component("sfTask")
public class SfTask {
    @Autowired
    private SalesforcastInfoService salesforcastInfoService;

    /***
     * 生成销量预计
     * @param period 期数
     */
    public void generateSalesEstimates(Date period) {
        salesforcastInfoService.generateSalesEstimates(period);
    }

    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}" , s, b, l, d, i));
    }

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("执行无参方法");
    }
}
