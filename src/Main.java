record Student(int id, String name, int age, double gpa, String gradeLevel) {
}

void main() {
    List<Student> students = Arrays.asList(
            new Student(1, "Alice", 20, 3.8, "Sophomore"),
            new Student(2, "Bob", 22, 3.2, "Senior"),
            new Student(3, "Charlie", 19, 3.5, "Freshman"),
            new Student(4, "Diana", 21, 3.9, "Junior"),
            new Student(5, "Ethan", 20, 2.8, "Sophomore"),
            new Student(6, "Fiona", 22, 3.7, "Senior"),
            new Student(7, "George", 19, 3.1, "Freshman"),
            new Student(8, "Hannah", 21, 3.6, "Junior")
    );

    students.stream().map(Student::name).toList().forEach(IO::println);
    
    students.stream().collect(Collectors.groupingBy(Student::age))
            .forEach((key, value) -> IO.println(key + " : " + value));
}