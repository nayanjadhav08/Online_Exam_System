package com.vwits.model;

public class Result_Data {
//	 ID                                        NOT NULL NUMBER(38)
//	 USERID                                             NUMBER(5)
//	 OBTAINEDMARKS                                      NUMBER(38)
//	 TOTALMARKS                                         NUMBER(38)
//	 EXAMID
	private int id ;
	private int userId ;
	private int obtainedMarks ;
	private int totalMarks ;
	private int examId ;
	
	
	public  Result_Data() {
		// TODO Auto-generated method stub

	}
	
	public Result_Data(int id, int userId, int obtainedMarks, int totalMarks, int examId) {
		super();
		this.id = id;
		this.userId = userId;
		this.obtainedMarks = obtainedMarks;
		this.totalMarks = totalMarks;
		this.examId = examId;
	}
	
	//without id - autogenerTED
	public Result_Data(int userId, int obtainedMarks, int totalMarks, int examId) {
		super();
		
		this.userId = userId;
		this.obtainedMarks = obtainedMarks;
		this.totalMarks = totalMarks;
		this.examId = examId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result + id;
		result = prime * result + obtainedMarks;
		result = prime * result + totalMarks;
		result = prime * result + userId;
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
		Result_Data other = (Result_Data) obj;
		if (examId != other.examId)
			return false;
		if (id != other.id)
			return false;
		if (obtainedMarks != other.obtainedMarks)
			return false;
		if (totalMarks != other.totalMarks)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nResult_Data [id=" + id + ", userId=" + userId + ", obtainedMarks=" + obtainedMarks + ", totalMarks="
				+ totalMarks + ", examId=" + examId + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	
	
	
}
