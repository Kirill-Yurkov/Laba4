package text_objects;


import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
    private final String name;
    private final List<String> medicalRecords;

    public Doctor(String name) {
        super(name);
        this.name = name;
        this.medicalRecords = new ArrayList<>();
    }

    public void examinePatient(Person patient, Disease disease) {
        System.out.println("Doctor " + name + " examines the patient " + patient.getName());
        class Treatment {
            void prescribeTreatment(String patientName) {
                System.out.println("Doctor " + name + " prescribes a course of treatment " + patientName + ": " + disease.toString());
                recordMedicalData(patientName, disease.toString(), disease.getTreatment());
            }

            void recordMedicalData(String patientName, String diagnosis, String treatment) {
                String record = "Patient: " + patientName + ", Diagnosis: " + diagnosis + ", Treatment: " + treatment;
                medicalRecords.add(record);
                MedicalRegister.medicalRecordsOfCenter.add(record + ", Doctor: " + name);
            }
        }
        Treatment treatment = new Treatment();
        treatment.prescribeTreatment(patient.getName());
    }

    public void printMedicalRecords() {
        System.out.println("Doctors records " + name + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
    public static class MedicalRegister{
        private static List<String> medicalRecordsOfCenter = new ArrayList<>();

        public static List<String> getMedicalRecordsOfCenter() {
            return medicalRecordsOfCenter;
        }

        public static void setMedicalRecordsOfCenter(List<String> medicalRecordsOfCenter) {
            MedicalRegister.medicalRecordsOfCenter = medicalRecordsOfCenter;
        }

        public static String stringAllMedicalRecordsOfCenter(){
            StringBuilder s = new StringBuilder();
            for(String current: medicalRecordsOfCenter){
                s.append(current).append("\n");
            }
            return s.toString();
        }
    }
}