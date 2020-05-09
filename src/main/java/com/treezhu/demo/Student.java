package com.treezhu.demo;

import javafx.util.Pair;
import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@ToString
public class Student {
    private String vitalsignsSval1;

    private String vitalsignsSval2;

    private String vitalsignsSval3;

    private Float vitalsignsNval1;

    private Float vitalsignsNval2;

    private Float vitalsignsNval3;

    private Float vitalsignsNval4;

    private Float vitalsignsNval5;

    private Float vitalsignsNval6;


}

class AddOrModifyStudent {
    public static void main(String[] args) {
        List<Student> addList = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setVitalsignsSval1("Setting");
        s1.setVitalsignsNval1(1F);
        s1.setVitalsignsNval2(2F);
        s1.setVitalsignsSval2("Lying");
        s1.setVitalsignsNval3(7F);
        s1.setVitalsignsNval4(8F);
//        s1.setVitalsignsSval3("Standing");
//        s1.setVitalsignsNval5(17F);
//        s1.setVitalsignsNval6(18F);
        addList.add(s1);
        List<Student> existList = new ArrayList<Student>();
        Student s2 = new Student();
        s2.setVitalsignsSval1("Standing");
        s2.setVitalsignsNval1(3F);
        s2.setVitalsignsNval2(4F);
//        s2.setVitalsignsSval2("Lying");
//        s2.setVitalsignsNval3(5F);
//        s2.setVitalsignsNval4(6F);
//        s2.setVitalsignsSval3("Setting");
//        s2.setVitalsignsNval5(7F);
//        s2.setVitalsignsNval6(8F);
        existList.add(s2);

        Map<String, Pair<Float, Float>> addMap = buildSvalMap(addList);
        Map<String, Pair<Float, Float>> existMap = buildSvalMap(existList);

        for (Map.Entry<String, Pair<Float, Float>> v : addMap.entrySet()) {
            existMap.put(v.getKey(),v.getValue());
        }
        Object[] keys =  existMap.keySet().toArray();
        Pair<Float, Float> firstPair = existMap.get(keys[0].toString());
        Student student = new Student();
        student.setVitalsignsSval1(keys[0].toString());
        student.setVitalsignsNval1(firstPair.getKey());
        student.setVitalsignsNval2(firstPair.getValue());

        if (keys.length>=2){
            Pair<Float, Float> secondPair = existMap.get(keys[1].toString());
            student.setVitalsignsSval2(keys[1].toString());
            student.setVitalsignsNval3(secondPair.getKey());
            student.setVitalsignsNval4(secondPair.getValue());
        }
        if (keys.length>=3){
            Pair<Float, Float> thirdPair = existMap.get(keys[2].toString());
            student.setVitalsignsSval3(keys[2].toString());
            student.setVitalsignsNval5(thirdPair.getKey());
            student.setVitalsignsNval6(thirdPair.getValue());
        }
        System.out.println(student);

    }

    public static Map<String, Pair<Float, Float>> buildSvalMap(List<Student> students) {
        Map<String, Pair<Float, Float>> existMap = new LinkedHashMap<>(3);
        for (Student s : students) {
            Pair<Float, Float> pair = new Pair<>(s.getVitalsignsNval1(), s.getVitalsignsNval2());
            existMap.put(s.getVitalsignsSval1(), pair);
            if (s.getVitalsignsSval2() != null) {
                Pair<Float, Float> pair2 = new Pair<>(s.getVitalsignsNval3(), s.getVitalsignsNval4());
                existMap.put(s.getVitalsignsSval2(), pair2);
            }
            if (s.getVitalsignsSval3() != null) {
                Pair<Float, Float> pair3 = new Pair<>(s.getVitalsignsNval5(), s.getVitalsignsNval6());
                existMap.put(s.getVitalsignsSval3(), pair3);
            }
        }
        return existMap;
    }
}
