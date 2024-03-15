package com.project.SmartStay.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recordings {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length = 100000) // Adjust the length according to your database schema
    private String youtubeUrl;

    private String topic;

    private LocalDate date;
    // Relationships
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subject;
	public Recordings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recordings(Long id, String youtubeUrl, String topic, LocalDate date, Subjects subject) {
		super();
		this.id = id;
		this.youtubeUrl = youtubeUrl;
		this.topic = topic;
		this.date = date;
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Subjects getSubject() {
		return subject;
	}
	public void setSubject(Subjects subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Recordings [id=" + id + ", youtubeUrl=" + youtubeUrl + ", topic=" + topic + ", date=" + date
				+ ", subject=" + subject + "]";
	}
    

}
