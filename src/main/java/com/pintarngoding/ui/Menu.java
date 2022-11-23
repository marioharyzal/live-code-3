package com.pintarngoding.ui;

import com.pintarngoding.constant.LastEducation;
import com.pintarngoding.constant.StudentStatus;
import com.pintarngoding.model.Student;
import com.pintarngoding.model.StudentCredential;
import com.pintarngoding.service.StudentService;
import com.pintarngoding.utils.response.ResponseStatus;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    StudentService studentService;

    Student student;
    StudentCredential studentCredential;

    public Menu(StudentService studentService, Student student, StudentCredential studentCredential) {
        this.studentService = studentService;
        this.student = student;
        this.studentCredential = studentCredential;
    }

    public void landingApp() {


        String banner = "=============== Pintar Ngoding Bootcamp ================\nRole : \n1. Admin\n2. Siswa\n(0 untuk keluar)";

        try {
            while (true) {
                System.out.println(banner);
                System.out.print("Masukkan role di sini : ");
                Integer menu = scanner.nextInt();
                System.out.println(menu);
                switch (menu) {
                    case 1:
                        adminPage();
                        break;
                    case 2:
                        studentPage();
                        break;
                    case 0:
                        return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void studentPage() {
        String banner = "=============== Halaman siswa ================\nBelum punya akun? type 2\n1. Login\n2. Register";
        System.out.println(banner);
        System.out.print("Pilih option : ");
        Integer optionMenuStudent = scanner.nextInt();
        switch (optionMenuStudent) {
            case 1:
                login();
                break;
            case 2:
                registerPage();
        }

    }

    public void adminPage() {
        String banner = "=============== Halaman Admin ================\nMenu Admin : \n1. Manajemen Pelatih(Trainer)\n2. Manajemen Kategori Pelatihan\n3. Manajemen materi pelatihan\n4. Menejeman pelatihan\n5. Manajemen Persetujuan Pengambilan Pelatihan";
        System.out.println(banner);
        System.out.println("Masukkan option : ");
        int option = scanner.nextInt();
        System.out.println("coming soon");
    }

    public void registerPage() {
        System.out.println("=============== Halaman register siswa ================");
        System.out.print("Masukkan email : ");
        String email = scanner.next();
        System.out.print("Nama depan : ");
        String firstName = scanner.next();
        System.out.print("Nama belakang : ");
        String lastName = scanner.next();
        System.out.print("Nama panggilan : ");
        String callName = scanner.next();
        System.out.print("Alamat domisili : ");
        String residenceDomisili = scanner.next();
        System.out.print("No Handphone : ");
        String noHp = scanner.next();
        System.out.print("No KTP : ");
        String noKtp = scanner.next();
        System.out.print("1. SMA\n2. SMK\n3. S1\n4. S2\n5. D3\n6. D4\nPilih pendidikan terakhir anda : ");
        String lastEducation = scanner.next();


        System.out.print("Masukkan password : ");
        String password = scanner.next();

        studentCredential.setEmail(email);
        studentCredential.setPassword(password);

        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setCallName(callName);
        LastEducation lastEducationFinal = null;
        switch (lastEducation) {
            case "1":
                lastEducationFinal = LastEducation.SMA;
                break;
            case "2":
                lastEducationFinal = LastEducation.SMK;
            case "3":
                lastEducationFinal = LastEducation.S1;
            case "4":
                lastEducationFinal = LastEducation.S2;
            case "5":
                lastEducationFinal = LastEducation.D3;
            case "6":
                lastEducationFinal = LastEducation.D4;
            default:
        }
        student.setLastEducation(lastEducationFinal);
        student.setNoHp(noHp);
        student.setNoKtp(noKtp);
        student.setResidenceAddress(residenceDomisili);
        student.setIsActive(StudentStatus.FALSE);
        student.setStudentCredential(studentCredential);

        ResponseStatus msg = studentService.addData(student);
        System.out.println(msg.getMessage());
    }

    public void login() {
        System.out.println("=============== Halaman Login siswa ================");
        System.out.print("Masukkan email : ");
        String email = scanner.next();
        System.out.print("Nama password : ");
        String password = scanner.next();

        studentCredential.setEmail(email);
        studentCredential.setPassword(password);
        ResponseStatus<Student> msg = studentService.getOneData(studentCredential);
        System.out.println(msg.getMessage());
        if (msg.getMessage().equals("SUCCESS")) {
            while (true) {
                System.out.println();
                System.out.println("=============== wellcome " + msg.getData().getFirstName() + " " + msg.getData().getLastName() + " ================");
                System.out.print("1. Pilih Pelatihan\n2. Aktivasi akun\n(0 untuk keluar)");
                System.out.print("\nPilih input : ");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("coming soon");
                        break;
                    case 2:
                        System.out.println("coming soon");
                        break;
                    case 0:
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
