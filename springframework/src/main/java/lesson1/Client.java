package lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Patient patient = context.getBean("patient", Patient.class);

        patient.setName("Иванов И.И.");
        patient.setTimeToVisit("1 марта, 17:30");
        patient.visitDoctor();
    }


}
