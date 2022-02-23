package com.healthcare.entity;

import com.healthcare.enumeration.DiagnosisType;
import com.healthcare.enumeration.ICDCode;
import com.healthcare.enumeration.ImprovementType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ConsultationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="form_id")
    private Integer formId;

    @ManyToOne
    @JoinColumn(nullable = false, name="patient_id")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(nullable = false, name="doctor_id")
    private Doctor doctorId;

    @ManyToOne
    @JoinColumn(nullable = false, name="hospital_id")
    private Hospital hospitalId;

    @Column(nullable = false, name="compliant")
    private String compliant;

    @Column(nullable = false, name="examination")
    private String examination;

    @Column(nullable = false, name="illness_summary")
    private String illnessSummary;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = true, name="diagnosis_type")
    private DiagnosisType diagnosistype;

    @Column(nullable = false, name="icd_description")
    private String icdDescription;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="idc_10code")
    private ICDCode idc10code;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="improvement_type")
    private ImprovementType improvementtype;

    @Column(name="medicine_name")
    private String medicineName;

    @Column(nullable = false, name="dosage")
    private String dosage;

    @Column(nullable = false, name="dosing_time")
    private String dosingtime;

    @Column(nullable = false, name="duration")
    private Date duration;

    @Column(nullable = false, name="date_and_time")
    private Date dateAndTime;

    @Column(name="remarks")
    private String remarks;

    @Column(nullable = false, name="treatment_instructions")
    private String treatmentInstructions;

    @Column(name="follow_up")
    private String followUp;

    @Column(name="refer")
    private Integer refer;

    public ConsultationForm() {
    }

    public ConsultationForm(Integer formId, Patient patientId, Doctor doctorId, Hospital hospitalId, String compliant, String examination, String illnessSummary, DiagnosisType diagnosistype, String icdDescription, ICDCode idc10code, ImprovementType improvementtype, String medicineName, String dosage, String dosingtime, Date duration, Date dateAndTime,
                            String remarks, String treatmentInstructions, String followUp, Integer refer) {
        this.formId = formId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
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

    public Patient getPatientId() {
        return patientId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public String getCompliant() {
        return compliant;
    }

    public String getExamination() {
        return examination;
    }

    public String getIllnessSummary() {
        return illnessSummary;
    }

    public DiagnosisType getDiagnosistype() {
        return diagnosistype;
    }

    public String getIcdDescription() {
        return icdDescription;
    }

    public ICDCode getIdc10code() {
        return idc10code;
    }

    public ImprovementType getImprovementtype() {
        return improvementtype;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getDosingtime() {
        return dosingtime;
    }

    public Date getDuration() {
        return duration;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getTreatmentInstructions() {
        return treatmentInstructions;
    }

    public String getFollowUp() {
        return followUp;
    }

    public Integer getRefer() {
        return refer;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public void setIllnessSummary(String illnessSummary) {
        this.illnessSummary = illnessSummary;
    }

    public void setDiagnosistype(DiagnosisType diagnosistype) {
        this.diagnosistype = diagnosistype;
    }

    public void setIcdDescription(String icdDescription) {
        this.icdDescription = icdDescription;
    }

    public void setIdc10code(ICDCode idc10code) {
        this.idc10code = idc10code;
    }

    public void setImprovementtype(ImprovementType improvementtype) {
        this.improvementtype = improvementtype;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setDosingtime(String dosingtime) {
        this.dosingtime = dosingtime;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setTreatmentInstructions(String treatmentInstructions) {
        this.treatmentInstructions = treatmentInstructions;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public void setRefer(Integer refer) {
        this.refer = refer;
    }

    @Override
    public String toString() {
        return "ConsultationForm{" +
                "formId=" + formId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", hospitalId=" + hospitalId +
                ", compliant='" + compliant + '\'' +
                ", examination='" + examination + '\'' +
                ", illnessSummary='" + illnessSummary + '\'' +
                ", diagnosistype=" + diagnosistype +
                ", icdDescription='" + icdDescription + '\'' +
                ", idc10code='" + idc10code + '\'' +
                ", improvementtype=" + improvementtype +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", dosingtime=" + dosingtime +
                ", duration=" + duration +
                ", dateAndTime=" + dateAndTime +
                ", remarks='" + remarks + '\'' +
                ", treatmentInstructions='" + treatmentInstructions + '\'' +
                ", followUp='" + followUp + '\'' +
                ", refer=" + refer +
                '}';
    }
}
