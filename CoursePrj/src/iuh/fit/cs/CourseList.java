/**
 * 
 */
package iuh.fit.cs;

import java.util.Arrays;

/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @version 1.0
 * @created date3 thg 9, 2025 time22:15:35
 */
public class CourseList {
	private Course[] courses;
	private int count = 0;
	
	/**
	 * @return the courses
	 */
	public Course[] getCourses() {
		return Arrays.copyOf(courses, count);
	}

	public CourseList() {
		this(10);
	}
	
	public CourseList(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException("Capacity > 0");
		}
		courses = new Course[capacity];
	}

	public boolean addCourse(Course course) {
		if(count >= courses.length) {
			System.out.println("List is full");
			return false;
		}
		for (int i = 0; i < count; i++) {
			if(courses[i].getId().equals(course.getId())) {
				System.out.println("Id already exists");
				return false;
			}
		}
		courses[count++] = course;
		return true;
	}
	
	public boolean removeCourse(Course courseId) {
		for (int i = 0; i < count; i++) {
			if(courses[i].getId().equals(courseId)) {
				System.arraycopy(courses, i + 1, courses, i, count - i - 1);
				return true;
			}
		}
		System.out.println("ID not found");
		return false;
	}
	
	
}
