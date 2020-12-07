package com.vwits.model;

public class Exam {

	private int id ;
	private String examname ;
	private int totalmarks ;
	private int examcode ;
	
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}


	public Exam(int id, String examname, int totalmarks, int examcode) {
		super();
		this.id = id;
		this.examname = examname;
		this.totalmarks = totalmarks;
		this.examcode = examcode;
	}

	

	@Override
	public String toString() {
		return "\nExam [id=" + id + ", examname=" + examname + ", totalmarks=" + totalmarks + ", examcode=" + examcode
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examcode;
		result = prime * result + ((examname == null) ? 0 : examname.hashCode());
		result = prime * result + id;
		result = prime * result + totalmarks;
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
		Exam other = (Exam) obj;
		if (examcode != other.examcode)
			return false;
		if (examname == null) {
			if (other.examname != null)
				return false;
		} else if (!examname.equals(other.examname))
			return false;
		if (id != other.id)
			return false;
		if (totalmarks != other.totalmarks)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getExamname() {
		return examname;
	}


	public void setExamname(String examname) {
		this.examname = examname;
	}


	public int getTotalmarks() {
		return totalmarks;
	}


	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}


	public int getExamcode() {
		return examcode;
	}


	public void setExamcode(int examcode) {
		this.examcode = examcode;
	}
	
	
	
}
