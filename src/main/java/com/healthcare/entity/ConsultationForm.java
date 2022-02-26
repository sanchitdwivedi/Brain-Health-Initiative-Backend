package com.healthcare.entity;

import com.healthcare.enumeration.DiagnosisType;
import com.healthcare.enumeration.ICDCode;
import com.healthcare.enumeration.ImprovementType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="idc_10code")
    private ICDCode idc10code;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="improvement_type")
    private ImprovementType improvementtype;

    @Column(name="medicine_name")
    private String medicineName;

    @NotBlank
    @Column(nullable = false, name="dosage")
    private String dosage;

    @NotBlank
    @Column(nullable = false, name="dosing_time")
    private String dosingtime;

    @NotNull
    @Column(nullable = false, name="duration")
    private Date duration;

    @NotNull
    @Column(nullable = false, name="date_and_time")
    private Date dateAndTime;

    @Column(name="remarks")
    private String remarks;

    @NotBlank
    @Column(nullable = false, name="treatment_instructions")
    private String treatmentInstructions;

    @Column(name="follow_up")
    private String followUp;

    @Column(name="refer")
    private Integer refer;

    public ConsultationForm() {
    }

    public ConsultationForm(Integer formId, Patient patient, Doctor doctor, Hospital hospital, String compliant, String examination, String illnessSummary, DiagnosisType diagnosistype, String icdDescription, ICDCode idc10code, ImprovementType improvementtype, String medicineName, String dosage, String dosingtime, Date duration, Date dateAndTime, String remarks, String treatmentInstructions, String followUp, Integer refer) {
        this.formId = formId;
        this.patient = patient;
        this.doctor = doctor;
        this.hospital = hospital;
        this.compliant = compliant;
        this.examination = examination;
        this.illnessSummary = illnessSummary;
        this.diagnosistype = diagnosistype;
        this.icdDescription = icdDescription;
        this.idc10code = idc10code;
        this.improvementtype = improvementtype;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.dosingtime = dosingtime;
        this.duration = duration;
        this.dateAndTime = dateAndTime;
        this.remarks = remarks;
        this.treatmentInstructions = treatmentInstructions;
        this.followUp = followUp;
        this.refer = refer;
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

    public ICDCode getIdc10code() {
        return idc10code;
    }

    public void setIdc10code(ICDCode idc10code) {
        this.idc10code = idc10code;
    }

    public ImprovementType getImprovementtype() {
        return improvementtype;
    }

    public void setImprovementtype(ImprovementType improvementtype) {
        this.improvementtype = improvementtype;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosingtime() {
        return dosingtime;
    }

    public void setDosingtime(String dosingtime) {
        this.dosingtime = dosingtime;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
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

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public Integer getRefer() {
        return refer;
    }

    public void setRefer(Integer refer) {
        this.refer = refer;
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
                ", idc10code=" + idc10code +
                ", improvementtype=" + improvementtype +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", dosingtime='" + dosingtime + '\'' +
                ", duration=" + duration +
                ", dateAndTime=" + dateAndTime +
                ", remarks='" + remarks + '\'' +
                ", treatmentInstructions='" + treatmentInstructions + '\'' +
                ", followUp='" + followUp + '\'' +
                ", refer=" + refer +
                '}';
    }
}
