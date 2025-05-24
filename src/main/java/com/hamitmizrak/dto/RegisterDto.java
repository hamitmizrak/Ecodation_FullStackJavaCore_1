package com.hamitmizrak.dto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterDto {

    // ✅ Loglama
    private static final Logger logger = Logger.getLogger(RegisterDto.class.getName());

    // ✅ Field
    private int id;
    private String nickname;
    private String emailAddress;
    private String password;
    private boolean isLocked;
    private String role;

    // ✅ Composition
    private StudentDto studentDto;
    private TeacherDto teacherDto;

    // ✅ CIPHER
    private static final String AES_ALGORITHM = "AES";
    private static final String SECRET_KEY = "MY_16_BYTE_KEY_!";

    // ✅ Parametresiz Constructor
    public RegisterDto() {
        this.id = 0;
        this.nickname = "your_nickname";
        this.emailAddress = "your_email@example.com";
        this.password = "default_password";
        this.role = "UNKNOWN";
        this.isLocked = false;
        this.studentDto = null;
        this.teacherDto = null;
    }

    // ✅ Parametresiz Constructor
    /*public RegisterDto(int id, String nickname, String emailAddress, String password, String role, boolean isLocked,
                       StudentDto studentDto, TeacherDto teacherDto) {
        this.id = id;
        this.nickname = (nickname != null && !nickname.isBlank()) ? nickname.toLowerCase() : "unknown_user";
        this.emailAddress = emailAddress;
        this.password = alreadyEncrypted ? password : encryptPassword(password); // 📌 önemli satır
        //this.password = password;
        this.role = (role != null && !role.isBlank()) ? role.toUpperCase() : "UNKNOWN";
        this.isLocked = isLocked;
        this.studentDto = studentDto;
        this.teacherDto = teacherDto;
    }*/
    // Düzeltme: overload constructor yap ve dosyadan gelen veride şifrelenmemiş gibi davran
    public RegisterDto(int id, String nickname, String emailAddress, String password, String role, boolean isLocked,
                       StudentDto studentDto, TeacherDto teacherDto, boolean alreadyEncrypted) {
        this.id = id;
        this.nickname = nickname;
        this.emailAddress = emailAddress;
        this.password = alreadyEncrypted ? password : encryptPassword(password); // 📌 önemli satır
        this.role = role;
        this.isLocked = isLocked;
        this.studentDto = studentDto;
        this.teacherDto = teacherDto;
    }

    //////////////////////////////////////////////////////////////////////////
    // ✅
    private static SecretKey generateKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
    }

    // ✅
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Şifreleme hatası", e);
        }
    }


    // ✅
    public static String decryptPassword(String encryptedPassword) {
        if (encryptedPassword == null || encryptedPassword.isBlank()) return null;
        try {
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey());
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Şifre çözme başarısız!", e);
            return null;
        }
    }

    // ✅ Şifre Doğrulama
    public boolean validatePassword(String rawPassword) {
        return this.password != null &&
                this.password.equals(encryptPassword(rawPassword));
    }



    // ✅
    public String getDecryptedPassword() {
        return decryptPassword(this.password);
    }

    // ✅ toString
    @Override
    public String toString() {
        return "RegisterDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", role='" + role + '\'' +
                ", isLocked=" + isLocked +
                '}';
    }

    // ✅ GETTER AND SETTER
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);
        //this.password = password;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isLocked() { return isLocked; }
    public void setLocked(boolean locked) { isLocked = locked; }

    public StudentDto getStudentDto() { return studentDto; }
    public void setStudentDto(StudentDto studentDto) { this.studentDto = studentDto; }

    public TeacherDto getTeacherDto() { return teacherDto; }
    public void setTeacherDto(TeacherDto teacherDto) { this.teacherDto = teacherDto; }
}