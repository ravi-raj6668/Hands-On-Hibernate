package com.innodev.hibernate.entity;

import org.hibernate.annotations.Type;

import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	@Type(type="pg-uuid")
	private UUID certificateId;
	private String course;
	private String duration;

	public Certificate() {
		super();
	}

	public Certificate(UUID certificateId, String course, String duration) {
		super();
		this.certificateId = certificateId;
		this.course = course;
		this.duration = duration;
	}

	public UUID getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(UUID certificateId) {
		this.certificateId = certificateId;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", course=" + course + ", duration=" + duration + "]";
	}

}
