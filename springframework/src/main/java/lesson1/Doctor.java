package lesson1;

interface Doctor {
    String name = null;
    String speciality = null;

    void doCare(Patient patient);
    String getName();
    String getSpeciality();
}
