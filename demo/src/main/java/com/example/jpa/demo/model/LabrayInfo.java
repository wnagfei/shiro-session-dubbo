package com.example.jpa.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "labray_info")
public class LabrayInfo {
    @Id
    @GeneratedValue
    private Integer id;

    private String labrayName;

    private String labrayAdress;

    private String labrayStatus;

    private String labrayRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabrayName() {
        return labrayName;
    }

    public void setLabrayName(String labrayName) {
        this.labrayName = labrayName == null ? null : labrayName.trim();
    }

    public String getLabrayAdress() {
        return labrayAdress;
    }

    public void setLabrayAdress(String labrayAdress) {
        this.labrayAdress = labrayAdress == null ? null : labrayAdress.trim();
    }

    public String getLabrayStatus() {
        return labrayStatus;
    }

    public void setLabrayStatus(String labrayStatus) {
        this.labrayStatus = labrayStatus == null ? null : labrayStatus.trim();
    }

    public String getLabrayRemark() {
        return labrayRemark;
    }

    public void setLabrayRemark(String labrayRemark) {
        this.labrayRemark = labrayRemark == null ? null : labrayRemark.trim();
    }
}