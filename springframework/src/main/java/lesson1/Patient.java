package lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Patient {

    private String name;
    private MedicalCard medicalCard;
    private Doctor doctor;
    private String timeToVisit;

    @Autowired
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Autowired
    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeToVisit(String timeToVisit) {
        this.timeToVisit = timeToVisit;
    }

    public void visitDoctor(){
        System.out.println("Пациент " + name + " направляется к доктору");
        System.out.println("Информация о докторе: \n\tСпециализация: " + doctor.getSpeciality() + "\n\tИмя: " + doctor.getName());
        System.out.println("Время приема: " + timeToVisit);
        System.out.print("Наличие медицинской книжки: ");
        if (medicalCard!=null)
            System.out.println("есть");
        else
            System.out.println("отсутствует");
        doctor.doCare(this);
    }

    public String getName() {
        return name;
    }
}
