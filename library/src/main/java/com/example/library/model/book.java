package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class book {

	
	@Id
	private int id;
	private String title;
	private String author;
	private boolean borrowed;
	@ManyToOne
	private User borrowedby;
	public User getBorrowedby() {
		return borrowedby;
	}
	public void setBorrowedby(User borrowedby) {
		this.borrowedby = borrowedby;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", author=" + author + ", borrowed=" + borrowed + ", borrowedby="
				+ borrowedby + "]";
	}
	
	
	
	
	
}
