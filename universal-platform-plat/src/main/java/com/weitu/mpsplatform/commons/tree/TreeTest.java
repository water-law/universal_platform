package com.weitu.mpsplatform.commons.tree;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: lzl
 * Date: 2019-07-15
 * Time: 15:42
 */
public class TreeTest extends BaseTreeObj{
    public static void main(String[] args) {
        List<TreeTest> objects = new LinkedList<>();


        TreeTest treeTest = new TreeTest();
        treeTest.setParentId("00");
        treeTest.setId("01");
        objects.add(treeTest);


        TreeTest treeTest1 = new TreeTest();
        treeTest1.setParentId("00");
        treeTest1.setId("02");
        objects.add(treeTest1);

        TreeTest treeTest2 = new TreeTest();
        treeTest2.setParentId("02");
        treeTest2.setId("0201");
        objects.add(treeTest2);


        TreeTest treeTest3 = new TreeTest();
        treeTest3.setParentId("00");
        treeTest3.setId("03");
        objects.add(treeTest3);

        TreeTest treeTest4 = new TreeTest();
        treeTest4.setParentId("");
        treeTest4.setId("00");

        List childTreeObjects = TreeService.getChildTreeObjects(objects, "00");
        System.out.println(JSON.toJSON(childTreeObjects));
    }
}
