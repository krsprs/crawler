package com.ksp.Domain.DTOs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the AdDTO class.
 */
class AdDTOTest {

    /**
     * Test for the getTitle method.
     * It checks if the method correctly retrieves the title.
     */
    @Test
    void getTitle() {
        String title = "Title";
        AdDTO adDTO = new AdDTO(title, "Salary", "URL");
        String result = adDTO.getTitle();
        assertEquals(title, result);
    }

    /**
     * Test for the setTitle method.
     * It checks if the method correctly sets the title.
     */
    @Test
    void setTitle() {
        String title = "Title";
        AdDTO adDTO = new AdDTO("", "Salary", "URL");
        adDTO.setTitle(title);
        assertEquals(title, adDTO.getTitle());
    }

    /**
     * Test for the getSalary method.
     * It checks if the method correctly retrieves the salary.
     */
    @Test
    void getSalary() {
        String salary = "Salary";
        AdDTO adDTO = new AdDTO("Title", salary, "URL");
        String result = adDTO.getSalary();
        assertEquals(salary, result);
    }

    /**
     * Test for the setSalary method.
     * It checks if the method correctly sets the salary.
     */
    @Test
    void setSalary() {
        String salary = "Salary";
        AdDTO adDTO = new AdDTO("Title", "", "URL");
        adDTO.setSalary(salary);
        assertEquals(salary, adDTO.getSalary());
    }

    /**
     * Test for the getURL method.
     * It checks if the method correctly retrieves the URL.
     */
    @Test
    void getURL() {
        String URL = "URL";
        AdDTO adDTO = new AdDTO("Title", "Salary", URL);
        String result = adDTO.getURL();
        assertEquals(URL, result);
    }

    /**
     * Test for the setURL method.
     * It checks if the method correctly sets the URL.
     */
    @Test
    void setURL() {
        String URL = "URL";
        AdDTO adDTO = new AdDTO("Title", "Salary", "");
        adDTO.setURL(URL);
        assertEquals(URL, adDTO.getURL());
    }
}
