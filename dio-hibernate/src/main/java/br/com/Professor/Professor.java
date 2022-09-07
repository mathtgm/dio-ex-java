package br.com.Professor;

import javax.persistence.*;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course;
	private String professor_name;
	
	public Professor() {}
	

	public int getcourse() {
		return course;
	}

	public void setcourse(int course) {
		this.course = course;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	@Override
	public String toString() {
		return "Professor [course=" + course + ", professor_name=" + professor_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((professor_name == null) ? 0 : professor_name.hashCode());
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
		Professor other = (Professor) obj;
		if (course != other.course)
			return false;
		if (professor_name == null) {
			if (other.professor_name != null)
				return false;
		} else if (!professor_name.equals(other.professor_name))
			return false;
		return true;
	}
	
	
}
