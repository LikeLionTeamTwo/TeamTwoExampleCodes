package Junho.실습문제.annotation.notNullAnnotation;

import java.lang.reflect.Field;

public class NotNullValidator {
    public static void validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            // 필드가 @NotNull 애노테이션을 가지고 있는지 확인
            if (clazz.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true); // private 필드 접근 허용
                Object value = field.get(obj);
                if (value == null) {
                    throw new IllegalArgumentException(field.getName() + " must not be null");
                }
            }
        }
    }
//    public static void printValue(Object obj){
//        NotNull annotation = obj.getClass().getAnnotation(NotNull.class);
//        System.out.println(annotation.value());
//    }

}
