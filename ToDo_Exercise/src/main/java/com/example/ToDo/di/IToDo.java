package com.example.ToDo.di;

import java.util.Date;

public interface IToDo  {
	long getId();
	String getSummary();
	void setSummary(String summary);
	boolean isDone();
	void setDone(boolean isDone);
	Date getDueDate();
	void setDueDate(Date dueDate);
	IToDo copy();

}
