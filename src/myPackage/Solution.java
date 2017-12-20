package myPackage;

import java.sql.Date;

public class Solution {
	int id;
	private Date created;
	private Date updated;
	private String description;
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ "]";
	}
	public Solution( Date created, Date updated, String description) {
		this.id = 0;
		this.created = created;
		this.updated = updated;
		this.description = description;
	}
	
	
}
