package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student {
    int studentId;
    String name;
    Date dateOfAdmission;

    public Student(String name)
    {
        setName(name);
    }

    public Student(int studentId, String name)
    {
        this(name);
        setStudentId(studentId);
    }

    public Student(int studentId, String name, Date dateOfAdmission)
    {
        this(studentId, name);
        setDateOfAdmission(dateOfAdmission);
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfAdmission() {
        return this.dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public boolean isPlatinumAlumni() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.dateOfAdmission);
        int year = calendar.get(Calendar.YEAR);
        return LocalDate.now().getYear() - year >= 30;
    }
}
