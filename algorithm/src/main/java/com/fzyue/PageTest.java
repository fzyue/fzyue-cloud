package com.fzyue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PageTest {

    private static List<String> labelList = new ArrayList<>();
    private static TreeMap<String, List<String>> idMapList = new TreeMap<>();

    public static void main(String[] args) {
        init();
        int pageNo = 1;
        int pageSize = 10;
        while (true) {

            List<String> list = query(pageNo, pageSize);
            if (null == list || list.isEmpty()) {
                break;
            }
            System.out.println(list);
            pageNo++;
        }

    }

    public static void init() {
        for (int i = 0; i < 0; i++) {
            labelList.add("a" + i);
        }
        String[] arr = new String[]{"b_1", "c_1", "d_17", "e_10", "f_1", "g_2", "h_5", "i_8", "j_10", "k_10"};
        for (int i = 0; i < 10; i++) {
            String[] split = arr[i].split("_");
            List<String> idList = new ArrayList<>();
            for (int j = 0; j < Integer.valueOf(split[1]); j++) {
                idList.add(split[0] + j);
            }
            idMapList.put(split[0], idList);
        }
    }

    public static List<String> query(int pageNo, int pageSize) {
        // labelList能支持的最大页数
        List<String> results = new ArrayList<>();
        int labelMaxPageNo = labelList.size() % pageSize == 0 ? labelList.size() / pageSize : labelList.size() / pageSize + 1;
        if (labelMaxPageNo >= pageNo ) {
            int start = (pageNo - 1) * pageSize;
            int end = labelList.size() > start + pageSize ? start + pageSize : labelList.size();
            results.addAll(labelList.subList(start, end));
            if (results.size() < pageSize) {
                // 借位数据
                queryCstIdList(pageNo, pageSize, labelList.size(), results);
            }
        } else {
            queryCstIdList(pageNo, pageSize, labelList.size(), results);
        }

        return results;
    }

    private static void queryCstIdList(int pageNo, int pageSize, int labelTotalSize, List<String> results) {
        int needSize = pageSize - results.size();
        int skipNum = (pageNo - 1) * pageSize - labelTotalSize > 0 ? (pageNo - 1) * pageSize - labelTotalSize : 0;
        for (Map.Entry<String, List<String>> entry : idMapList.entrySet()) {
            List<String> idList = entry.getValue();

            if (idList.size() <= skipNum) {
                skipNum -= idList.size();
                continue;
            }

            int preQueryStart = skipNum;
            while(true) {
                // 当前数据之前没有全部检索，当次可以检索
                int currLeftCount = idList.size() - preQueryStart;
                int querySize = currLeftCount > needSize ? needSize : currLeftCount;

                System.out.println("从" + entry.getKey()+ "中获取了" + querySize + "位数据");
                int end = (preQueryStart + querySize) <= idList.size() ? (preQueryStart + querySize) : idList.size();
                List<String> qs = idList.subList(preQueryStart, end);
                results.addAll(qs);
                skipNum = 0;
                if (results.size() >= pageSize || preQueryStart + end >= idList.size()) {
                    break;
                }
                preQueryStart += qs.size();

            }

            if (results.size() >= pageSize) {
                break;
            }
            needSize = pageSize - results.size();
        }
    }
}
