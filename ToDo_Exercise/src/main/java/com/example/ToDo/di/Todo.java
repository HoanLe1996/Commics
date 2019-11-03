package com.example.ToDo.di;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // QUét và tạo bean thông qua contructor
public class Todo implements IToDo {
	
	public final long id;
	private String summary;
	private Boolean done;
	private Date dueDate;

	public Todo() { // Khởi tạo đối tượng với id - 1
		this(2333); 
	}

	public Todo(long i) {
		this(i, "");
	}
	
	public Todo(long i, String summary) { // Khởi tạo đối tượng với id = -1 và summary = " " ;
		this.id = i;
		this.summary = summary;
	}
	
	@Autowired
	public Todo(long id, String summary, Boolean done, Date dueDate) {
		super();
		this.id = id;
		this.summary = summary;
		this.done = done;
		this.dueDate = dueDate;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return summary;
	}

	@Override
	public void setSummary(String summary) {
		// TODO Auto-generated method stub
		this.summary = summary;

	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return done;
	}
	
	@Autowired
	@Override
	public void setDone(boolean isDone) {
		// TODO Auto-generated method stub
		this.done = isDone;

	}

	@Override
	public Date getDueDate() {
		// TODO Auto-generated method stub
		return dueDate;
	}

	@Autowired
	@Override
	public void setDueDate(Date dueDate) {
		// TODO Auto-generated method stub
		this.dueDate = dueDate;
	}

	@Override
	public IToDo copy() {
		// TODO Auto-generated method stub
		Todo todo = new Todo(id, summary);
		todo.setDone(this.isDone());
		todo.setDueDate(this.getDueDate());
		return todo;
	}
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Todo other = (Todo) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }

	    @Override
		public String toString() {
			return "Todo [id=" + id + ", summary=" + summary + ", done=" + done + ", dueDate=" + dueDate + "]";
		}
	    

}
