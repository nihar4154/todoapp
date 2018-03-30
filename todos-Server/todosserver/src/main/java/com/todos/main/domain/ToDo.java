package com.todos.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ToDo {

	@Id
    private long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isDone;

    public ToDo() {
    	
    }
	public ToDo(long id, String content, boolean isDone) {
		super();
		this.id = id;
		this.content = content;
		this.isDone = isDone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", content=" + content + ", isDone=" + isDone + "]";
	}
    
    
}
