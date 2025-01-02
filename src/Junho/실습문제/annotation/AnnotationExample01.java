package Junho.실습문제.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationExample01 {
    @Override
    public String toString() {
        return "Annotation Example";
    }
    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }
    @SuppressWarnings("unchecked")
    public void suppressExample() {
        List rawList = new ArrayList(); // 경고 억제
        rawList.add("text");
    }

    public static void main(String[] args) {
        AnnotationExample01 annotationExample01 = new AnnotationExample01();
    }
}
