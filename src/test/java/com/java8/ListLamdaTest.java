package com.java8;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/12
 * Time: 9:10  .
 */
public class ListLamdaTest {

    @Test
    public void testForEach(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

       /* list.forEach(a -> {
            System.out.println(a);
        });*/

        Integer result = list.stream().findAny().orElse(null);
        System.out.println(result);

        List<Integer> list1 = list.stream().filter(x -> x%2!=0).collect(Collectors.toList());
        System.out.println(list1);

        Integer max = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == null && o2 == null) return 0;
                if(o1 == null) return -1;
                if(o2 == null) return 1;
                if(o1.intValue() < o2.intValue()){
                    return 1;
                }else if(o1.intValue() > o2.intValue()){
                    return -1;
                }
                return 0;
            }
        }).get();
        System.out.println(max);

        String str1 = String.valueOf("12");
        String str2 = "12";
        System.out.println(str1 == str2);

    }

    @Test
    public void testCompletableFuture(){
        //异步处理
        CompletableFuture.runAsync(() -> {
            System.out.println("hello world");
        });
        System.out.println("end");
    }
}
