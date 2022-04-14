package com.healthcare.entity;

import com.healthcare.enumeration.*;
import com.healthcare.util.HashMapConverter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class ConsultationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name="form_id")
    private Integer formId;

    @ManyToOne
    @JoinColumn(nullable = false, name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false, name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(nullable = false, name="hospital_id")
    private Hospital hospital;

    @NotBlank
    @Column(nullable = false, name="compliant")
    private String compliant;

    @NotBlank
    @Column(nullable = false, name="examination")
    private String examination;

    @NotBlank
    @Column(nullable = false, name="illness_summary")
    private String illnessSummary;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = true, name="diagnosis_type")
    private DiagnosisType diagnosistype;

    @NotBlank
    @Column(nullable = false, name="icd_description")
    private String icdDescription;

    @NotBlank
    @EnumValidator(
            enumClazz = ICDCode.class,
            message = "Invalid ICD Code"
    )
    @Schema(allowableValues = { "G40", "I63", "R51", "F03" })
    @Column(name = "icd10code")
    private String icd10Code;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="improvement_type")
    private ImprovementType improvementtype;

//    @Column(name="medicine_name")
//    private String medicineName;
//
//    @NotBlank
//    @Column(nullable = false, name="dosage")
//    private String dosage;
//
//    @NotBlank
//    @Column(nullable = false, name="dosing_time")
//    private String dosingtime;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @Convert(converter = HashMapConverter.class)
    private List<Map<String, String>> medicineInfo;

    @NotNull
    @Column(nullable = false, name="date_and_time")
    private Date dateAndTime;

    @Column(name="remarks")
    private String remarks;

    @NotBlank
    @Column(nullable = false, name="treatment_instructions")
    private String treatmentInstructions;

    @Future
    @Column(name="follow_up")
    private Date followUp;

    @ManyToOne
    @JoinColumn(name="refer")
    private Doctor refer;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @Convert(converter = HashMapConverter.class)
    private List<Map<String, Object>> questionnaireResponse = new ArrayList<>();

    public ConsultationForm() {
    }

    public ConsultationForm(Integer formId, Patient patient, Doctor doctor, Hospital hospital, String compliant, String examination, String illnessSummary, DiagnosisType diagnosistype, String icdDescription, String icd10Code, ImprovementType improvementtype, List<Map<String, String>> medicineInfo, Date dateAndTime, String remarks, String treatmentInstructions, Date followUp, Doctor refer, List<Map<String, Object>> questionnaireResponse) {
        this.formId = formId;
        this.patient = patient;
        this.doctor = doctor;
        this.hospital = hospital;
        this.compliant = compliant;
        this.examination = examination;
        this.illnessSummary = illnessSummary;
        this.diagnosistype = diagnosistype;
        this.icdDescription = icdDescription;
        this.icd10Code = icd10Code;
        this.improvementtype = improvementtype;
        this.medicineInfo = medicineInfo;
        this.dateAndTime = dateAndTime;
        this.remarks = remarks;
        this.treatmentInstructions = treatmentInstructions;
        this.followUp = followUp;
        this.refer = refer;
        this.questionnaireResponse = questionnaireResponse;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getCompliant() {
        return compliant;
    }

    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getIllnessSummary() {
        return illnessSummary;
    }

    public void setIllnessSummary(String illnessSummary) {
        this.illnessSummary = illnessSummary;
    }

    public DiagnosisType getDiagnosistype() {
        return diagnosistype;
    }

    public void setDiagnosistype(DiagnosisType diagnosistype) {
        this.diagnosistype = diagnosistype;
    }

    public String getIcdDescription() {
        return icdDescription;
    }

    public void setIcdDescription(String icdDescription) {
        this.icdDescription = icdDescription;
    }

    public String getIcd10Code() {
        return icd10Code;
    }

    public void setIcd10Code(String icd10Code) {
        this.icd10Code = icd10Code;
    }

    public ImprovementType getImprovementtype() {
        return improvementtype;
    }

    public void setImprovementtype(ImprovementType improvementtype) {
        this.improvementtype = improvementtype;
    }

    public List<Map<String, String>> getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(List<Map<String, String>> medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTreatmentInstructions() {
        return treatmentInstructions;
    }

    public void setTreatmentInstructions(String treatmentInstructions) {
        this.treatmentInstructions = treatmentInstructions;
    }

    public Date getFollowUp() {
        return followUp;
    }

    public void setFollowUp(Date followUp) {
        this.followUp = followUp;
    }

    public Doctor getRefer() {
        return refer;
    }

    public void setRefer(Doctor refer) {
        this.refer = refer;
    }

    public List<Map<String, Object>> getQuestionnaireResponse() {
        return questionnaireResponse;
    }

    public void setQuestionnaireResponse(List<Map<String, Object>> questionnaireResponse) {
        this.questionnaireResponse = questionnaireResponse;
    }

    @Override
    public String toString() {
        return "ConsultationForm{" +
                "formId=" + formId +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", hospital=" + hospital +
                ", compliant='" + compliant + '\'' +
                ", examination='" + examination + '\'' +
                ", illnessSummary='" + illnessSummary + '\'' +
                ", diagnosistype=" + diagnosistype +
                ", icdDescription='" + icdDescription + '\'' +
                ", icd10Code='" + icd10Code + '\'' +
                ", improvementtype=" + improvementtype +
                ", medicineInfo=" + medicineInfo +
                ", dateAndTime=" + dateAndTime +
                ", remarks='" + remarks + '\'' +
                ", treatmentInstructions='" + treatmentInstructions + '\'' +
                ", followUp=" + followUp +
                ", refer=" + refer +
                ", questionnaireResponse=" + questionnaireResponse +
                '}';
    }
}
