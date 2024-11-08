package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Class_Registration_SystemTest {

    private Class_Registration_System registrationSystem;

    @BeforeEach
    void setUp() {
        registrationSystem = new Class_Registration_System();
    }

    @Test
    void testRegisterStudent() {
        Class_Registration_System.Student student = new Class_Registration_System.Student("John", "Computer Science");
        assertEquals(1, registrationSystem.registerStudent(student));
    }

    @Test
    void testRegisterStudent2() {
        Class_Registration_System.Student student = new Class_Registration_System.Student("John", "Computer Science");
        registrationSystem.registerStudent(student);
        assertEquals(0, registrationSystem.registerStudent(student));
    }

    @Test
    void testRegisterStudent3() {
        Class_Registration_System.Student student1 = new Class_Registration_System.Student("John", "Computer Science");
        Class_Registration_System.Student student2 = new Class_Registration_System.Student("Alice", "Mathematics");
        assertEquals(1, registrationSystem.registerStudent(student1));
        assertEquals(1, registrationSystem.registerStudent(student2));
        assertEquals(0, registrationSystem.registerStudent(student2));
    }

    @Test
    void testRegisterClass() {
        registrationSystem.registerStudent(new Class_Registration_System.Student("John", "Computer Science"));
        List<String> result = registrationSystem.registerClass("John", "CS101");
        List<String> expected = new ArrayList<>();
        expected.add("CS101");
        assertEquals(expected, result);
    }

    @Test
    void testRegisterClass2() {
        registrationSystem.registerStudent(new Class_Registration_System.Student("John", "Computer Science"));
        registrationSystem.registerClass("John", "CS101");
        registrationSystem.registerClass("John", "CS102");
        List<String> result = registrationSystem.registerClass("John", "CS103");
        List<String> expected = new ArrayList<>();
        expected.add("CS101");
        expected.add("CS102");
        expected.add("CS103");
        assertEquals(expected, result);
    }

    @Test
    void testRegisterClass3() {
        registrationSystem.registerStudent(new Class_Registration_System.Student("John", "Computer Science"));
        registrationSystem.registerStudent(new Class_Registration_System.Student("Tom", "Mathematics"));
        registrationSystem.registerClass("John", "CS101");
        registrationSystem.registerClass("Tom", "CS102");
        List<String> result = registrationSystem.registerClass("John", "CS103");
        List<String> expected = new ArrayList<>();
        expected.add("CS101");
        expected.add("CS103");
        assertEquals(expected, result);
    }

    @Test
    void testGetStudentsByMajor() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        registrationSystem.setStudents(students);

        List<String> csStudents = registrationSystem.getStudentsByMajor("Computer Science");
        List<String> expected = new ArrayList<>();
        expected.add("John");
        expected.add("Bob");

        assertEquals(expected, csStudents);
    }

    @Test
    void testGetStudentsByMajor2() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        registrationSystem.setStudents(students);

        List<String> csStudents = registrationSystem.getStudentsByMajor("Computer Science");
        List<String> mathStudents = registrationSystem.getStudentsByMajor("Mathematics");

        List<String> expectedCs = new ArrayList<>();
        expectedCs.add("John");
        expectedCs.add("Bob");
        List<String> expectedMath = new ArrayList<>();

        assertEquals(expectedCs, csStudents);
        assertEquals(expectedMath, mathStudents);
    }

    @Test
    void testGetStudentsByMajor3() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Mathematics"));
        registrationSystem.setStudents(students);

        List<String> csStudents = registrationSystem.getStudentsByMajor("Computer Science");
        List<String> mathStudents = registrationSystem.getStudentsByMajor("Mathematics");

        List<String> expectedCs = new ArrayList<>();
        expectedCs.add("John");
        expectedCs.add("Bob");
        List<String> expectedMath = new ArrayList<>();
        expectedMath.add("Alice");

        assertEquals(expectedCs, csStudents);
        assertEquals(expectedMath, mathStudents);
    }

    @Test
    void testGetStudentsByMajor4() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Mathematics"));
        students.add(new Class_Registration_System.Student("Tom", "Mathematics"));
        students.add(new Class_Registration_System.Student("Jerry", "Mathematics"));
        registrationSystem.setStudents(students);

        List<String> csStudents = registrationSystem.getStudentsByMajor("Computer Science");
        List<String> mathStudents = registrationSystem.getStudentsByMajor("Mathematics");

        List<String> expectedCs = new ArrayList<>();
        expectedCs.add("John");
        expectedCs.add("Bob");
        List<String> expectedMath = new ArrayList<>();
        expectedMath.add("Alice");
        expectedMath.add("Tom");
        expectedMath.add("Jerry");

        assertEquals(expectedCs, csStudents);
        assertEquals(expectedMath, mathStudents);
    }

    @Test
    void testGetAllMajor() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        registrationSystem.setStudents(students);

        List<String> majors = registrationSystem.getAllMajor();
        List<String> expected = new ArrayList<>();
        expected.add("Computer Science");

        assertEquals(expected, majors);
    }

    @Test
    void testGetAllMajor2() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Mathematics"));
        registrationSystem.setStudents(students);

        List<String> majors = registrationSystem.getAllMajor();
        List<String> expected = new ArrayList<>();
        expected.add("Computer Science");
        expected.add("Mathematics");

        assertEquals(expected, majors);
    }

    @Test
    void testGetAllMajor3() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Mathematics"));
        students.add(new Class_Registration_System.Student("Tom", "Mathematics"));
        students.add(new Class_Registration_System.Student("Jerry", "Physics"));
        registrationSystem.setStudents(students);

        List<String> majors = registrationSystem.getAllMajor();
        List<String> expected = new ArrayList<>();
        expected.add("Computer Science");
        expected.add("Mathematics");
        expected.add("Physics");

        assertEquals(expected, majors);
    }

    @Test
    void testGetMostPopularClassInMajor() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Computer Science"));
        registrationSystem.setStudents(students);

        Map<String, List<String>> studentClasses = new HashMap<>();
        studentClasses.put("John", List.of("Algorithms", "Data Structures"));
        studentClasses.put("Bob", List.of("Operating Systems", "Data Structures", "Algorithms"));
        studentClasses.put("Alice", List.of("Data Structures", "Operating Systems", "Calculus"));
        registrationSystem.setStudentClasses(studentClasses);

        String csMostPopularClass = registrationSystem.getMostPopularClassInMajor("Computer Science");
        assertEquals("Data Structures", csMostPopularClass);
    }

    @Test
    void testGetMostPopularClassInMajor2() {
        List<Class_Registration_System.Student> students = new ArrayList<>();
        students.add(new Class_Registration_System.Student("John", "Computer Science"));
        students.add(new Class_Registration_System.Student("Bob", "Computer Science"));
        students.add(new Class_Registration_System.Student("Alice", "Computer Science"));
        students.add(new Class_Registration_System.Student("Tom", "Mathematics"));
        students.add(new Class_Registration_System.Student("Jerry", "Mathematics"));
        registrationSystem.setStudents(students);

        Map<String, List<String>> studentClasses = new HashMap<>();
        studentClasses.put("John", List.of("Algorithms", "Data Structures"));
        studentClasses.put("Bob", List.of("Data Structures", "Algorithms", "Operating Systems"));
        studentClasses.put("Alice", List.of("Data Structures", "Operating Systems", "Calculus"));
        studentClasses.put("Tom", List.of("Calculus", "Linear Algebra"));
        studentClasses.put("Jerry", List.of("Linear Algebra", "Statistics"));
        registrationSystem.setStudentClasses(studentClasses);

        String csMostPopularClass = registrationSystem.getMostPopularClassInMajor("Computer Science");
        String mathMostPopularClass = registrationSystem.getMostPopularClassInMajor("Mathematics");
        assertEquals("Data Structures", csMostPopularClass);
        assertEquals("Linear Algebra", mathMostPopularClass);
    }

    @Test
    void test() {
        registrationSystem.registerStudent(new Class_Registration_System.Student("John", "Computer Science"));
        registrationSystem.registerStudent(new Class_Registration_System.Student("Bob", "Computer Science"));
        registrationSystem.registerStudent(new Class_Registration_System.Student("Alice", "Mathematics"));
        registrationSystem.registerStudent(new Class_Registration_System.Student("Tom", "Mathematics"));
        registrationSystem.registerClass("John", "Algorithms");
        registrationSystem.registerClass("John", "Data Structures");
        registrationSystem.registerClass("Bob", "Operating Systems");
        registrationSystem.registerClass("Bob", "Data Structures");
        assertEquals(List.of("John", "Bob"), registrationSystem.getStudentsByMajor("Computer Science"));
        assertEquals(List.of("Alice", "Tom"), registrationSystem.getStudentsByMajor("Mathematics"));
        assertEquals(List.of("Computer Science", "Mathematics"), registrationSystem.getAllMajor());
        assertEquals("Data Structures", registrationSystem.getMostPopularClassInMajor("Computer Science"));
    }
}