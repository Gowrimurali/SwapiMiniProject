package com.spartaglobal.gm;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest{
    private static PeopleDTO peopleDTO;

    @BeforeEach
    void setup() {
        peopleDTO = Injector.injectDTO(ConnectionManager.getConnection(1));
    }


    @Nested
    @DisplayName("Check String")
    class String {
        @Test
        @DisplayName("Check String isNotNull & IsNotEqualToZero")
        void testName() {
            Assertions.assertFalse(peopleDTO.isNameNull());
        }

    }
    @Nested
    @DisplayName("Check Integers")
    class Integer{
        @Test
        @DisplayName("Check if Height is GreaterThan zero")
        void checkIfHeightIsGreaterThanZero() {
            Assertions.assertTrue(peopleDTO.isHeightGreaterThan0());
        }

        @Test
        @DisplayName("Check if Mass is GreaterThan zero")
        void checkIfMassIsGreaterThanZero() {
            Assertions.assertTrue(peopleDTO.isMassGreaterThan0());
        }

        @Test
        @DisplayName("Check if Height can be converted to int")
        void checkIfHeightCanBeConvertedToInt() {
            Assertions.assertTrue(peopleDTO.isHeightInt());
        }

        @Test
        @DisplayName("Check if Mass can be converted to int")
        void checkIfMassCanBeConvertedToInt() {
            Assertions.assertTrue(peopleDTO.isMassInt());
        }
    }
    @Nested
    @DisplayName("Check Format ")
    class Format{
        @Test
        @DisplayName("Check if Create Format is correct")
        void checkIfCreateFormatIsCorrect() {
            Assertions.assertTrue(peopleDTO.checkCreateFormat());
        }

        @Test
        @DisplayName("Check if Edit Format is correct")
        void checkIfEditFormatIsCorrect() {
            Assertions.assertTrue(peopleDTO.checkEditedFormat());
        }

        @Test
        @DisplayName("Get Last 3 chars of DOB and compare with regex")
        void getLast3CharsOfDob() {
            Assertions.assertTrue(peopleDTO.getLastThreeCharactersOfDOB().matches("[A-B]{1}BY"));
        }

        @Test
        @DisplayName("Get First 3 chars of DOB and check if greater than zero")
        void getFirst3CharsOfDob() {
            Assertions.assertTrue(peopleDTO.getFirstNumbersOfDOB()>0);
        }

        @Test
        @DisplayName("Check if Date is valid")
        void checkIfDateIsValid() {
            Assertions.assertTrue(peopleDTO.checkIfDateIsValid());
        }

        @Test
        @DisplayName("Check if Gender Is Valid")
        void checkIfGenderIsValid() {
            Assertions.assertTrue(peopleDTO.checkIfGenderIsValid());
        }

        @Test
        @DisplayName("Test status code works ")
        void testStatusCodeWorks() {
            Assertions.assertEquals(200, peopleDTO.checkStatusCodeOfURL(ConnectionManager.getConnection(1)));
        }

        @Test
        @DisplayName("Check if URL is Valid")
        void checkIfUrlIsValid() {
            Assertions.assertTrue(peopleDTO.checkIfURLIsValid(peopleDTO.getHomeworld()));
        }

        @Test
        @DisplayName("Check if URLs Are Valid")
        void checkIfUrLsAreValid() {
            Assertions.assertTrue(peopleDTO.checkIfURLsAreValidInArray(peopleDTO.getFilms()));

        @DisplayName("Check if a field is array")
        void checkIfAFieldIsArray() {
            Assertions.assertTrue(peopleDTO.checkIfArray(peopleDTO.getFilms()));
        }

        @Test
        @DisplayName("Check if the urls in array is valid")
        void checkIfTheUrlsInArrayIsValid() {
            Assertions.assertTrue(peopleDTO.checkIfURLsAreValidInArray(peopleDTO.getVehicles()));

        }
    }
}
