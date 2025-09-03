/**
 * 
 */
package iuh.fit.cs;

/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @version 1.0
 * @created date3 thg 9, 2025 time22:11:31
 */
public class Course {
	private int credit;
	private String department;
	private String id;
	private String title;
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public final void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	 public final void setId(String id) {
	        if (id == null || id.isEmpty() || id.length() < 3) {
	            throw new IllegalArgumentException("ID must have at least 3 characters");
	        }
	        if (!id.matches("[a-zA-Z0-9]+")) {
	            throw new IllegalArgumentException("ID must contain only letters or digits");
	        }
	        this.id = id;
	    }
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }
	/**
	 * 
	 */
	public Course() {
		this(404,"EMPTY","EMPTY","EMPTY");
	}
	/**
	 * @param credit
	 * @param department
	 * @param id
	 * @param title
	 */
	public Course(int credit, String department, String id, String title) {
		setCredit(credit);
		setDepartment(department);
		setId(id);
		setTitle(title);
	}

	@Override
	public String toString() {
		
		return String.format("%s | %s | %s | %s", credit,department,id,title);
	}
}
