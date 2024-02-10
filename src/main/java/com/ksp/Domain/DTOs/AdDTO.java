/**
 * The com.ksp.Domain.DTOs package contains Data Transfer Objects (DTOs) related to advertisements.
 */
package com.ksp.Domain.DTOs;

/**
 * The AdDTO class represents a data transfer object for an advertisement.
 * It contains information such as the title, salary, and URL of the advertisement.
 */
public class AdDTO {
    private String Title;
    private String Salary;
    private String URL;

    /**
     * Constructs a new AdDTO object with the specified title, salary, and URL.
     *
     * @param title  the title of the advertisement
     * @param salary the salary offered in the advertisement
     * @param URL    the URL of the advertisement
     */
    public AdDTO(String title, String salary, String URL) {
        Title = title;
        Salary = salary;
        this.URL = URL;
    }

    /**
     * Retrieves the title of the advertisement.
     *
     * @return the title of the advertisement
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Sets the title of the advertisement.
     *
     * @param title the title of the advertisement
     */
    public void setTitle(String title) {
        Title = title;
    }

    /**
     * Retrieves the salary offered in the advertisement.
     *
     * @return the salary offered in the advertisement
     */
    public String getSalary() {
        return Salary;
    }

    /**
     * Sets the salary offered in the advertisement.
     *
     * @param salary the salary offered in the advertisement
     */
    public void setSalary(String salary) {
        Salary = salary;
    }

    /**
     * Retrieves the URL of the advertisement.
     *
     * @return the URL of the advertisement
     */
    public String getURL() {
        return URL;
    }

    /**
     * Sets the URL of the advertisement.
     *
     * @param URL the URL of the advertisement
     */
    public void setURL(String URL) {
        this.URL = URL;
    }
}
