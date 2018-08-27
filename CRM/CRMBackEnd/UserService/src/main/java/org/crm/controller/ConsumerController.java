package org.crm.controller;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.Consumer;
import org.crm.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ConsumerController {

    @Autowired
    private ConsumerService conService;
    //分页查询所有客户
    @GetMapping(value = "/userFindByPage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Consumer> fingAll(){
        return conService.findByPage();
    }

    //按编号查询
    @GetMapping(value = "/custFindByNo/{cust_no}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Consumer fingByNo(@PathVariable("cust_no") String cust_no){
        return conService.findByNo(cust_no);
    }

    //按编号修改
    @PostMapping(value = "/updateConsumerByNo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Integer updateConsumerByNo(@RequestBody Consumer consumer){
        int result=conService.updateConsumer(consumer);
        return result;
    }

    //按编号删除，假删除，把状态码status改为3
    @PutMapping(value = "/deleteConsumerByNo/{cust_no}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Integer deleteConsumerByNo(@PathVariable("cust_no") String cust_no){
        int result=conService.deleteConsumerByNo(cust_no);
        return result;
    }

    @GetMapping(value = "/calculate/{madition}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Consumer> calculate(@PathVariable("madition") String madition){
        if(madition.equals("按等级")){
            return conService.calculateByLabel();
        }
        if(madition.equals("按信用度")){
            return conService.calculateBycredit();

        }
        if(madition.equals("按满意度")){
            return conService.calculateBysatisfy();
        }
        return null;
    }



}
