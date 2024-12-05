package model.domain;

import java.util.List;

public class StudyGroup {
	private String groupId;
	private String groupName;
	private String groupDescription;
	private String goal;
	private int maxMembers;
	private User leader;
	private List<GroupMember> members;
	private List<Schedule> sehedules;
	private List<Assignment> assignments;
	private List<Announcement> announcements;

	
	public StudyGroup(String groupId, String groupName, String groupDescription, String goal, int maxMembers, User leader,
			List<GroupMember> members, List<Schedule> sehedules, List<Assignment> assignments,
			List<Announcement> announcements) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.goal = goal;
		this.maxMembers = maxMembers;
		this.leader = leader;
		this.members = members;
		this.sehedules = sehedules;
		this.assignments = assignments;
		this.announcements = announcements;
	}


    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
	public StudyGroup() {
        
    }
	public void createGroup() {
		
	}
	
	public void updateGroupInfo() {
		
	}
	
	public void inviteMember(String email) {

	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public int getMaxMembers() {
		return maxMembers;
	}

	public void setMaxMembers(int maxMembers) {
		this.maxMembers = maxMembers;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public List<GroupMember> getMembers() {
		return members;
	}

	public void setMembers(List<GroupMember> members) {
		this.members = members;
	}

	public List<Schedule> getSehedules() {
		return sehedules;
	}

	public void setSehedules(List<Schedule> sehedules) {
		this.sehedules = sehedules;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public String getGroupId() {
		return groupId;
	}
    
}