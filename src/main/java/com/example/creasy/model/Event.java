package com.example.creasy.model;

import com.example.creasy.controller.dto.EventDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public
class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime start;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime finish;
	private String address;
	private String url;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Partner partner;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name= "user_id",referencedColumnName = "id")
	private User userById;
	
	public Event(Long id, String title, String description, LocalDateTime start, LocalDateTime finish) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = start;
		this.finish = finish;
	}

	public Event(  String description, LocalDateTime start, LocalDateTime finish,String address,
				Partner partner,User userById) {
		super();
		this.description = description;
		this.start = start;
		this.finish = finish;
		this.address= address;
		this.partner=partner;
		this.userById = userById;
	}
	
	public Event() {
		super();
	}

	public EventDto toEventDto() {
		EventDto eventDto = new EventDto();
		eventDto.setUrl("http://localhost:8080/evenement"+this.id);
		eventDto.setId(this.id);
		eventDto.setStart(this.start);
		eventDto.setFinish(this.finish);
		eventDto.setTitle(this.partner.getFirstname() + " " +this.partner.getLastname());

		return eventDto;
	}

	public User getUserById() {
		return userById;
	}

	public void setUserById(User userById) {
		this.userById = userById;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

}