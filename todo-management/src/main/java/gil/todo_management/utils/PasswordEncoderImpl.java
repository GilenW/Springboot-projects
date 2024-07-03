package gil.todo_management.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
//
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "yourPlainTextPassword";
//        String encodedPassword = encoder.encode(rawPassword);
//        System.out.println(encodedPassword);
//        UPDATE sec_user SET password = '$2a$10$m6KZSRyZLI77BDIBrA0o2exK758bBRQHhCKMkCvW0IIQFEXebtplS' WHERE login = 'TestUser';


    }




}
