package com.example.karuta;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KarutaController {

    @GetMapping("/karuta")
    public String karuta(Model model) {
    	int allCount=50;
    	List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        // 打乱顺序
        Collections.shuffle(numbers);
        // 取前50个
        List<Integer> random50 = numbers.subList(0, allCount);
        
        //相手布局
        int upNumbers[]=Random(allCount/2);
        int list1_1Count=upNumbers[0];
        int list1_2Count=upNumbers[1];
        int list2_1Count=upNumbers[2];
        int list2_2Count=upNumbers[3];
        int list3_1Count=upNumbers[4];
        int list3_2Count=upNumbers[5];
        System.out.println(list1_1Count);
        System.out.println(list1_2Count);
    	List<String> list1_1 = new ArrayList<>();
		for(int i=0;i<list1_1Count;i++) {
			list1_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list1_2 = new ArrayList<>();
    	for(int i=0;i<list1_2Count;i++) {
   			list1_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}
    	
    	List<String> list2_1 = new ArrayList<>();
		for(int i=0;i<list2_1Count;i++) {
			list2_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list2_2 = new ArrayList<>();
    	for(int i=0;i<list2_2Count;i++) {
			list2_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list3_1 = new ArrayList<>();
		for(int i=0;i<list3_1Count;i++) {
			list3_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list3_2 = new ArrayList<>();
    	for(int i=0;i<list3_2Count;i++) {
			list3_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}
    	////
        int downNumbers[]=Random(allCount/2);
        int list4_1Count=downNumbers[0];
        int list4_2Count=downNumbers[1];
        int list5_1Count=downNumbers[2];
        int list5_2Count=downNumbers[3];
        int list6_1Count=downNumbers[4];
        int list6_2Count=downNumbers[5];
    	List<String> list4_1 = new ArrayList<>();
		for(int i=0;i<list4_1Count;i++) {
			list4_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list4_2 = new ArrayList<>();
    	for(int i=0;i<list4_2Count;i++) {
			list4_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}
    	
    	List<String> list5_1 = new ArrayList<>();
		for(int i=0;i<list5_1Count;i++) {
			list5_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list5_2 = new ArrayList<>();
    	for(int i=0;i<list5_2Count;i++) {
			list5_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}
    	
    	List<String> list6_1 = new ArrayList<>();
		for(int i=0;i<list6_1Count;i++) {
			list6_1.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

    	List<String> list6_2 = new ArrayList<>();
    	for(int i=0;i<list6_2Count;i++) {
			list6_2.add(len3(random50.get(0).toString()));
			random50.remove(0);
		}

        model.addAttribute("list1_1", list1_1);
        model.addAttribute("list1_2", list1_2);
        model.addAttribute("list2_1", list2_1); 
        model.addAttribute("list2_2", list2_2); 
        model.addAttribute("list3_1", list3_1); 
        model.addAttribute("list3_2", list3_2); 
        model.addAttribute("list4_1", list4_1); 
        model.addAttribute("list4_2", list4_2);  
        model.addAttribute("list5_1", list5_1); 
        model.addAttribute("list5_2", list5_2); 
        model.addAttribute("list6_1", list6_1);
        model.addAttribute("list6_2", list6_2); 
        return "karuta";
    }
    
    public static int[] Random(int total) {
        int parts = 6;
        int max = 6;

        int[] result = new int[parts];
        Random rand = new Random();

        // 1. 先保证每个至少为 1
        Arrays.fill(result, 1);
        int remaining = total - parts; // 25 - 6 = 19

        // 2. 随机分配剩余值，且不超过 max
        while (remaining > 0) {
            int index = rand.nextInt(parts);
            if (result[index] < max) {
                result[index]++;
                remaining--;
            }
        }

        return result;
    }
    
    public static String len3(String args) {
    	String reStr="";
    	if(args.length()==3)reStr=args;
    	if(args.length()==2)reStr="0"+args;
    	if(args.length()==1)reStr="00"+args;
    	return reStr;
    }
}