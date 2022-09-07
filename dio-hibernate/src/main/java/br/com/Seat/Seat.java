package br.com.Seat;

import br.com.Student.Student;
import javax.persistence.*;


@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seat_number;
	private String seat_position;
	
	@OneToOne
	private Student seat;
	
	public Seat() {}

	public Seat(int seat_number, String seat_position, Student seat_student) {
		this.seat_number = seat_number;
		this.seat_position = seat_position;
		this.seat = seat_student;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getSeat_position() {
		return seat_position;
	}

	public void setSeat_position(String seat_position) {
		this.seat_position = seat_position;
	}

	public Student getSeat() {
		return seat;
	}

	public void setSeat(Student seat_student) {
		this.seat = seat_student;
	}

	@Override
	public String toString() {
		return "Seat [seat_number=" + seat_number + ", seat_position=" + seat_position + ", seat_student="
				+ seat.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seat_number;
		result = prime * result + ((seat_position == null) ? 0 : seat_position.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
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
		Seat other = (Seat) obj;
		if (seat_number != other.seat_number)
			return false;
		if (seat_position == null) {
			if (other.seat_position != null)
				return false;
		} else if (!seat_position.equals(other.seat_position))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}	
	
}
