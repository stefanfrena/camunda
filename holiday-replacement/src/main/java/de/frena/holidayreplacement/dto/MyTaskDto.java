package de.frena.holidayreplacement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyTaskDto {

	@JsonProperty("taskId")
	private String taskId;
	@JsonProperty("taskName")
	private String taskName;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "MyTaskDto [taskId=" + taskId + ", taskName=" + taskName + "]";
	}

}
