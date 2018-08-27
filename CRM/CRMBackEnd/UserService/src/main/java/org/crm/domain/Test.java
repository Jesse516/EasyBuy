package org.crm.domain;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public void test1(){
        //将为列表中的字符串添加前缀字符串
        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String>execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + " -----:" + zidingyi;
        }).collect(Collectors.toList());

        execStrs.forEach(System.out::println);
    }


    public static void main(String[] args){
        Test t=new Test();
        t.test1();
    }


}
