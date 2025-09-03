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
	
	public Course findCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(courseId)) {
                return courses[i];
            }
        }
        return null;
    }

    public Course[] findCoursesByTitle(String title) {
        Course[] found = new Course[count];
        int foundCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                found[foundCount++] = courses[i];
            }
        }
        return foundCount > 0 ? Arrays.copyOf(found, foundCount) : null;
    }
    
    public Course[] findCoursesByDepartment(String department) {
        Course[] result = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                result[resultCount++] = courses[i];
            }
        }
        return resultCount > 0 ? Arrays.copyOf(result, resultCount) : null;
    }
}
