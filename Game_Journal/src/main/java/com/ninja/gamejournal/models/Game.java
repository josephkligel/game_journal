package com.ninja.gamejournal.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="games")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3, max=100, message="Game Title must be between 3 and 100 characters!")
	private String gameTitle;
	
	@NotNull
	@Min(value = 1958, message="The first video game ever invented was Tennis for Two in 1958. Please choose a year greater than or equal to 1958!")
	private Integer yearReleased;
	
	@NotEmpty
	@Size(min=3, max=100, message="Publisher must be between 3 and 100 characters!")
	private String publisher;
	
	@NotEmpty
	@Size(min=3, max=500, message="Summary must be between 3 and 500 characters!")
	private String summary;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@OneToMany(mappedBy="game", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<JournalEntry> journalEntries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public Integer getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(Integer yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreated_at() {
		return created_at;
	}

	@PrePersist
	public void onCreate() {
		this.created_at = new Date();
	}

	public List<JournalEntry> getJournalEntries() {
		return journalEntries;
	}

	public void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}
	
	
}
