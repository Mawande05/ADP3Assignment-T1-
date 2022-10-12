package za.ac.cput.factory;

/* LecturerFactoryTest.java
Test class for the Lecturer Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Lecturer;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {
    private final Lecturer lecturer=LecturerFactory.createLecturer("Cameron","Noemdo", "cn@school.com","cn@cput.ac.za","0000000");

    Lecturer lecturer1;

    @Test
    void successCreateLecturer() {
        assertAll(
                ()->assertNotNull(lecturer),
                ()->assertEquals("Cameron",lecturer.getFirstName())
        );
        System.out.println(lecturer);
    }

    @Test
    void failCreateLecturer() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->lecturer1=LecturerFactory.createLecturer("","", "Noemdo","cn@cput.ac.za","0000000"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("First name is not present"));
    }

    @Test
    void testValidEmail() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->lecturer1=LecturerFactory.createLecturer("Cameron","Henry", "Noemdo","cnschool.com","0000000"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));
    }
}
