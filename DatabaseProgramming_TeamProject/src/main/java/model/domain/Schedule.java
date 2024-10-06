package model.domain;

import java.sql.Date;
import java.util.List;

public class Schedule {
	
	private Date date;
	private String description;
	private List<User> participants;
	
	
	public Schedule(Date date, String description, List<User> participants) {
		super();
		this.date = date;
		this.description = description;
		this.participants = participants;
	}
	
	public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }
	
    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<User> getParticipants() {
        return participants;
    }
}