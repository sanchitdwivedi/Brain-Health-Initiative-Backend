package com.healthcare.entity;

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
    @JoinColumn(nullable = false, name="abha_id")
    private Patient abhaId;

    @ManyToOne
    @JoinColumn(nullable = false, name="doctor_id")
    private Doctor doctorId;

    @ManyToOne
    @JoinColumn(nullable = false, name="hospital_id")
    private Hospital hospitalId;

    @Column(nullable = false, name="compliant")
    private String compliant;

    @Column(nullable = false, name="Examination")
    private String examination;

    @Column(nullable = false, name="illness_summary")
    private String illnessSummary;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = true, name="diagnosis_type")
    private DiagnosisType diagnosistype;

    @Column(nullable = false, name="icd_description")
    private String icdDescription;

    @Column(nullable = false, name="idc_10code")
    private String idc10code;

    @Column(nullable = false, name="improvement_type")
    private ImprovementType improvementtype;

    @Column(nullable = false, name="medicine_name")
    private String medicineName;

    @Column(nullable = false, name="dosage")
    private String dosage;

    @Column(nullable = false, name="dosing_time")
    private DosingTime dosingtime;

    @Column(nullable = false, name="duration")
    private Date duration;

    @Column(nullable = false, name="date_and_time")
    private Date dateAndTime;

    @Column(nullable = false, name="remarks")
    private String remarks;

    @Column(nullable = false, name="treatment_instructions")
    private String treatmentInstructions;

    @Column(nullable = false, name="follow_up")
    private String followUp;

    @Column(nullable=false, name="refer")
    private Integer refer;

    public ConsultationForm() {
    }

    public ConsultationForm(Integer formId, Patient abhaId, Doctor doctorId, Hospital hospitalId, String compliant, String examination, String illnessSummary, DiagnosisType diagnosistype, String icdDescription, String idc10code, ImprovementType improvementtype, String medicineName, String dosage, DosingTime dosingtime, Date duration, Date dateAndTime, String remarks,
                            String treatmentInstructions, String followUp, Integer refer) {
        this.formId = formId;
        this.abhaId = abhaId;
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

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Patient getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(Patient abhaId) {
        this.abhaId = abhaId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
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

    public String getIdc10code() {
        return idc10code;
    }

    public void setIdc10code(String idc10code) {
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

    public DosingTime getDosingtime() {
        return dosingtime;
    }

    public void setDosingtime(DosingTime dosingtime) {
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
                ", abhaId=" + abhaId +
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
