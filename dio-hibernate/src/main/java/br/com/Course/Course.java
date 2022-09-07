package br.com.Course;

import java.util.HashSet;
import java.util.Set;
import br.com.Professor.Professor;
import br.com.Student.Student;
import javax.persistence.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	private String course_name;
	
	@OneToOne
	private Professor course;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Student> students = new HashSet<Student>();
	
	public Course() {}

	public Course(int course_id, String course_name, Professor course, Set<Student> students) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course = course;
		this.students = students;
	}

	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Professor getcourse() {
		return course;
	}

	public void setcourse(Professor course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course_id;
		result = prime * result + ((course_name == null) ? 0 : course_name.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		Course other = (Course) obj;
		if (course_id != other.course_id)
			return false;
		if (course_name == null) {
			if (other.course_name != null)
				return false;
		} else if (!course_name.equals(other.course_name))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course=" + course
				+ ", students=" + students + "]";
	}	
	
}
