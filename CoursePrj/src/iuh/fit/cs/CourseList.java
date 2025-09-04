
package iuh.fit.cs;

import java.util.Arrays;
import java.util.Comparator;

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
	
	public boolean removeCourse(String removeId) {
		for (int i = 0; i < count; i++) {
			if(courses[i].getId().equals(removeId)) {
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
    
    public Course[] sortByTitle() {
        Course[] sorted = Arrays.copyOf(courses, count);
        Arrays.sort(sorted, Comparator.comparing(Course::getTitle));
        return sorted;
    }

    public Course[] findCoursesWithMaxCredit() {
        if (count == 0) return null;
        
        int maxCredit = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }

        Course[] result = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                result[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(result, resultCount);
    }
    
    public void printAll() {
        if (count == 0) {
            System.out.println("No courses in the list.");
            return;
        }
        System.out.printf("%-10s | %-25s | %-7s | %-20s\n", "ID", "Title", "Credit", "Department");
        System.out.println(new String(new char[68]).replace("\0", "-"));
        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }
    }
}
