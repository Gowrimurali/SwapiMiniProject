package com.spartaglobal.gm;

import org.junit.jupiter.api.*;


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
            System.out.println(peopleDTO.getEyeColor());
            Assertions.assertFalse(peopleDTO.isNameNull());
        }

    }
    @Nested
    @DisplayName("Check Integers")
    class Integer{
        @Test
        @DisplayName("Check if Height is GreaterThan zero")
        void checkIfHeightIsGreaterThanZero() {

        }

        @Test
        @DisplayName("Check if Mass is GreaterThan zero")
        void checkIfMassIsGreaterThanZero() {

        }

        @Test
        @DisplayName("Check if Height can be converted to int")
        void checkIfHeightCanBeConvertedToInt() {

        }

        @Test
        @DisplayName("Check if Mass can be converted to int")
        void checkIfMassCanBeConvertedToInt() {

        }
    }
    @Nested
    @DisplayName("Check Format ")
    class Format{
        @Test
        @DisplayName("Check if Create Format is correct")
        void checkIfCreateFormatIsCorrect() {

        }

        @Test
        @DisplayName("Check if Edit Format is correct")
        void checkIfEditFormatIsCorrect() {

        }

        @Test
        @DisplayName("Get Last 3 chars of DOB")
        void getLast3CharsOfDob() {

        }

        @Test
        @DisplayName("Get First 3 chars of DOB")
        void getFirst3CharsOfDob() {

        }

        @Test
        @DisplayName("Check if Date is valid")
        void checkIfDateIsValid() {

        }

        @Test
        @DisplayName("Check if Gender Is Valid")
        void checkIfGenderIsValid() {

        }

        @Test
        @DisplayName("Check if URL is Valid")
        void checkIfUrlIsValid() {

        }

        @Test
        @DisplayName("Check if URLs Are Valid")
        void checkIfUrLsAreValid() {

        }
    }
}
