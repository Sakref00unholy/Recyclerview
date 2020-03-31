package com.hfad.studentrecycleview;

    class Students {
        private static final Student[] students = new Student[]{
                new Student(1, "Peter", "PeterJensen20@gmail.com",20),
                new Student(2, "Jonas", "JonasPedersen95@gmail.com", 25),
                new Student(3, "Bo", "BoGunnersen99@jubii.com", 21),
                new Student(4, "Lars", "LarsJensen98@gmail.com",22),
                new Student(5, "Cecilie", "Cecilie95@gmail.com",24),
                new Student(6, "Natalie", "NatalieRasmussen94@gmail.com",26)
        };
        public static Student[] getAllStudents() {
            return students;
        }
        public static Student getStudentById (int id) {
            for (Student s : students){
                if (s.getId() == id) return s;
            }
            return null;
        }

}
