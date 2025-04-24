package entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CustomAnnotationTester {
    @SuppressWarnings("rawtypes")
    public void test() throws Exception {
        Phone phone = new Nokia();
        Class c = phone.getClass();

        Annotation annotations[] = c.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
            phone.setMobileName("Nokia 9");
            System.out.println("Mobile Name: " + phone.getMobileName());

            Method[] methods = annotation.annotationType().getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.getName());

                Object value = method.invoke(annotation, (Object[]) null);
                System.out.println(value);
            }
        }
    }
}
