package com.zel.mytest.stream;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        testList6();
    }

    //测试List<String>
    private  static void testList1(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
//        strings.stream().filter(r->r.equals("3")).forEach(r-> System.out.println("filter测试:"+r));
        strings.stream().map(r->r+r).forEach(r-> System.out.println("map测试:"+r));
        strings.stream().filter(r->Integer.valueOf(r)%2==0).forEach(r-> System.out.println("filter测试:"+r));
        List<String> collect = strings.stream().filter(r -> Integer.valueOf(r) % 2 == 0).collect(Collectors.toList());
        System.out.println("元素收集:"+collect);
        /*Optional<String> max = strings.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer integer1 = Integer.valueOf(01);
                Integer integer2 = Integer.valueOf(02);
                return integer1-integer2;
            }
        });*/
        Optional<String> max = strings.stream().max((o1,o2)->{
            Integer integer1 = Integer.valueOf(01);
            Integer integer2 = Integer.valueOf(02);
            return integer1-integer2;
        });
        System.out.println("查找最大值为:"+max.get());
        String reduce = strings.stream().reduce( "0",(x, y) -> Integer.valueOf(x) + Integer.valueOf(y) + "");
        System.out.println("求和:"+reduce);
    }

    //测试List<UserEntity>
    private static void testList2(){
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        for(int i=0;i<5;i++){
            UserEntity userEntity = new UserEntity();
            userEntity.setAge("10");
            userEntity.setName("zel_"+i);
            userEntity.setId(i+"");
            userEntities.add(userEntity);
        }
        UserEntity userEntity = userEntities.stream().filter(r -> r.getId().equals("2")).findFirst().get();
        System.out.println(userEntity);
        boolean b = userEntities.stream().filter(r -> r.getId().equals("2")).allMatch(r -> r.getId().equals("2"));
        System.out.println(b);
        HashMap<String, String> nameIdMap = new HashMap<>();
        userEntities.stream().forEach(r->nameIdMap.put(r.getId(),r.getName()));
        System.out.println(nameIdMap.toString());
    }

    //测试list排序
    private static  void testList3(){
        ArrayList<ImgCheckPojo> imgCheckPojos = new ArrayList<>();
        for(int i=1;i<5;i++){
            ImgCheckPojo imgCheckPojo = new ImgCheckPojo();
            imgCheckPojo.setAcceptNo(""+i);
            imgCheckPojo.setEndDay(Long.valueOf(i+""));
            imgCheckPojos.add(imgCheckPojo);
        }
        List<ImgCheckPojo> collect = imgCheckPojos.stream().sorted(Comparator.comparing(ImgCheckPojo::getEndDay)).collect(Collectors.toList());
        System.out.println("按自然升序:"+collect);
        List<ImgCheckPojo> collect2 = imgCheckPojos.stream().sorted(Comparator.comparing(ImgCheckPojo::getEndDay).reversed()).collect(Collectors.toList());
        System.out.println("按自然降序:"+collect2);
    }

    private static  void testList4(){
        ArrayList<ImgCheckPojo> imgCheckPojos = new ArrayList<>();
        for(int i=1;i<5;i++){
            ImgCheckPojo imgCheckPojo = new ImgCheckPojo();
            imgCheckPojo.setAcceptNo(""+i);
            imgCheckPojo.setEndDay(Long.valueOf(i+""));
            imgCheckPojos.add(imgCheckPojo);
        }
        List<ImgCheckPojo> collect = imgCheckPojos.stream().sorted(Comparator.comparing(ImgCheckPojo::getEndDay)).collect(Collectors.toList());
        System.out.println(collect);
        List<ImgCheckPojo> collect2 = imgCheckPojos.stream().sorted(Comparator.comparing(ImgCheckPojo::getEndDay).reversed()).collect(Collectors.toList());
        System.out.println(collect2);
    }
    private static  void testList5(){
        ArrayList<NoteQueryDO> imgCheckPojos = new ArrayList<>();
            NoteQueryDO noteQueryDO1 = new NoteQueryDO();
            noteQueryDO1.setQuestiontype("A");
            imgCheckPojos.add(noteQueryDO1);
            NoteQueryDO noteQueryDO2 = new NoteQueryDO();
            noteQueryDO2.setQuestiontype("B");
            imgCheckPojos.add(noteQueryDO2);
            NoteQueryDO noteQueryDO3 = new NoteQueryDO();
            noteQueryDO3.setQuestiontype("C");
            imgCheckPojos.add(noteQueryDO3);
            NoteQueryDO noteQueryDO4 = new NoteQueryDO();
            noteQueryDO4.setQuestiontype("H");
            imgCheckPojos.add(noteQueryDO4);
        List<NoteQueryDO> collect = imgCheckPojos.stream().filter(r->"A".equals(r.getQuestiontype()) || "H".equals(r.getQuestiontype())).collect(Collectors.toList());
        System.out.println(collect);
    }
    private static  void testList6(){
        Runnable ra = ()->{
            System.out.println("111");
        };
        Thread thread = new Thread(ra);
        thread.start();
    }
}
