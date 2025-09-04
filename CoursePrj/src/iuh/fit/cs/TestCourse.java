package iuh.fit.cs;

import java.util.Scanner;

/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @version 1.0
 * @created date3 thg 9, 2025 time22:16:29
 */
public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(20);

        while (true) {
            System.out.println("\n===== COURSE MANAGEMENT MENU =====");
            System.out.println("1. Add new course");
            System.out.println("2. Remove course by ID");
            System.out.println("3. Find course by ID");
            System.out.println("4. Find courses by title");
            System.out.println("5. Find courses by department");
            System.out.println("6. Sort courses by title");
            System.out.println("7. Find courses with max credit");
            System.out.println("8. Print all courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter course ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter course title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter course credit: ");
                        int credit = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter department: ");
                        String department = scanner.nextLine();

                        Course course = new Course(credit, department, id, title);
                        if (courseList.addCourse(course)) {
                            System.out.println("Course added successfully.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter course ID to remove: ");
                    String removeId = scanner.nextLine();
                    if (courseList.removeCourse(removeId)) {
                        System.out.println("Course removed.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter course ID to find: ");
                    String findId = scanner.nextLine();
                    Course foundCourse = courseList.findCourseById(findId);
                    if (foundCourse != null) {
                        System.out.println("Course found:");
                        System.out.println(foundCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title keyword: ");
                    String titleKeyword = scanner.nextLine();
                    Course[] titleResults = courseList.findCoursesByTitle(titleKeyword);
                    if (titleResults != null) {
                        System.out.println("Courses found:");
                        for (Course c : titleResults) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses match the title.");
                    }
                    break;

                case 5:
                    System.out.print("Enter department name: ");
                    String dept = scanner.nextLine();
                    Course[] deptResults = courseList.findCoursesByDepartment(dept);
                    if (deptResults != null) {
                        System.out.println("Courses found:");
                        for (Course c : deptResults) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found for this department.");
                    }
                    break;

                case 6:
                    Course[] sortedCourses = courseList.sortByTitle();
                    System.out.println("Courses sorted by title:");
                    for (Course c : sortedCourses) {
                        System.out.println(c);
                    }
                    break;

                case 7:
                    Course[] maxCreditCourses = courseList.findCoursesWithMaxCredit();
                    if (maxCreditCourses != null) {
                        System.out.println("Courses with max credit:");
                        for (Course c : maxCreditCourses) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses available.");
                    }
                    break;

                case 8:
                    courseList.printAll();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
