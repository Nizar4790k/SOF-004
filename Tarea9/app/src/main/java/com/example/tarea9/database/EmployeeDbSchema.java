package com.example.tarea9.database;

import java.lang.ref.SoftReference;

public class EmployeeDbSchema {

    public static class WorkerTable{

        public static final String NAME="workers";

                public static class Cols{

                    public static final String NAME="name";
                    public static final String POSITION="position";
                    public static final String LOCAL="local";
                    public static final String UUID = "uuid";
                    public static final String SALARY="salary";
                    public static final String HAS_TITLE="hasTitle";



                }

    }

    public static class ManagerTable{

        public static final String NAME="managers";

        public static class Cols{

            public static final String NAME="name";
            public static final String LOCAL="local";
            public static final String UUID = "uuid";
            public static final String SALARY="salary";
            public static final String DEPARTMENT="deparment";



        }

    }





}
