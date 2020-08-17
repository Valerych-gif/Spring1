package lesson1;

import org.springframework.stereotype.Component;

@Component
public class Therapist implements Doctor{
    private String name = "House M.D.";
    private String speciality = "Терапевт";

    @Override
    public void doCare(Patient patient) {
        System.out.println(speciality + " " + name + " осмотрел пациента " + patient.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSpeciality() {
        return speciality;
    }
}
