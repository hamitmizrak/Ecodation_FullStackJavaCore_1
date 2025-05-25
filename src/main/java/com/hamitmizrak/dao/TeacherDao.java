package com.hamitmizrak.dao;

import com.hamitmizrak.dto.ETeacherSubject;
import com.hamitmizrak.dto.TeacherDto;
import com.hamitmizrak.exception.TeacherNotFoundException;
import com.hamitmizrak.iofiles.SpecialFileHandler;
import com.hamitmizrak.utils.SpecialColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Logger;

/**
 * 📌 Öğretmen Yönetim DAO (Data Access Object)
 * Öğretmenlerin veritabanı işlemlerini yöneten sınıftır.
 */
public class TeacherDao implements IDaoGenerics<TeacherDto> {

    // Logger
    private static final Logger logger = Logger.getLogger(TeacherDao.class.getName());

    // Field
    private final Scanner scanner = new Scanner(System.in);
    private final List<TeacherDto> teacherDtoList;
    private static final Random random = new Random();
    private int maxId = 0; // En büyük ID'yi tutan değişken

    ////////////////////////////////////////////////////////////////////////////////////
    // Inner Class
    private final InnerFileHandler innerClass;

    // static
    static {
        System.out.println(SpecialColor.RED + " Static: TeacherDao" + SpecialColor.RESET);
    }

    // Parametresiz Constructor
    public TeacherDao() {
        this.teacherDtoList = new ArrayList<>();
        innerClass = new InnerFileHandler();
        System.out.println(SpecialColor.RED + " Parametresiz Constructor: TeacherDao" + SpecialColor.RESET);
    }

    /// /////////////////////////////////////////////////////////////
    // INNER CLASS
    private class InnerFileHandler {
        private final SpecialFileHandler fileHandler;

        // Constructor
        private InnerFileHandler() {
            this.fileHandler = new SpecialFileHandler();
            fileHandler.setFilePath("teachers.txt");
        }

        // FileIO => Eğer teachers.txt oluşturulmamışsa oluştur
        private void createFileIfNotExists() {
            fileHandler.createFileIfNotExists();
        }

        // 📌 Öğretmenleri dosyaya kaydetme
        private void writeFile() {
            StringBuilder data = new StringBuilder();
            for (TeacherDto teacher : teacherDtoList) {
                data.append(teacherToCsv(teacher)).append("\n");
            }
            fileHandler.writeFile(data.toString());
        }

        // 📌 Öğretmenleri dosyadan yükleme
        private void readFile() {
            teacherDtoList.clear();
            fileHandler.readFile();
        }
    }

    /// /////////////////////////////////////////////////////////////
    // 📌 maxId'yi değişkeni bir(1) artırarak güncelleyen metod
    private void updateMaxId() {
        maxId = teacherDtoList.stream().mapToInt(TeacherDto::id).max().orElse(0); // Eğer öğretmen yoksa ID'yi 0 olarak başlat
    }

    /// /////////////////////////////////////////////////////////////
    // 📌 Öğretmen nesnesini => CSV formatına çevirme
    private String teacherToCsv(TeacherDto teacher) {
        return teacher.id() + ","
                + teacher.name() + ","
                + teacher.surname() + ","
                + teacher.birthDate()
                + "," + teacher.subject() + ","
                + teacher.yearsOfExperience() + ","
                + teacher.isTenured() + "," + teacher.salary();
    }

    // 📌 CSV formatındaki satırı TeacherDto nesnesine çevirme
    private TeacherDto csvToTeacher(String csvLine) {
        try {
            if (csvLine.trim().isEmpty()) {
                System.out.println(SpecialColor.YELLOW + "⚠️ Boş satır atlandı!" + SpecialColor.RESET);
                return null;
            }

            // ⚠️  Genelde CSV formatında virgül(,) ile eklemeler yapılır
            String[] parts = csvLine.split(",");

            if (parts.length != 8) {
                System.err.println(SpecialColor.RED + "⚠️ Hatalı CSV formatı! Beklenen 8 sütun, ama " + parts.length + " sütun bulundu." + SpecialColor.RESET);
                System.err.println("⚠️ Hatalı satır: " + csvLine);
                return null;
            }

            // Date pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = null;
            try {
                if (!parts[3].isBlank()) {
                    birthDate = LocalDate.parse(parts[3], formatter);
                }
            } catch (DateTimeParseException e) {
                System.err.println("Geçersiz tarih formatı: " + parts[3] + " (Beklenen format: yyyy-MM-dd)");
                return null;
            }

            return new TeacherDto(Integer.parseInt(parts[0]), parts[1], parts[2], birthDate, ETeacherSubject.valueOf(parts[4]), Integer.parseInt(parts[5]), Boolean.parseBoolean(parts[6]), Double.parseDouble(parts[7]));

        } catch (Exception e) {
            System.out.println(SpecialColor.RED + "⚠️ CSV'den öğretmen yükleme hatası: " + e.getMessage() + SpecialColor.RESET);
            return null;
        }
    }

    /// /////////////////////////////////////////////////////////////
    // C-R-U-D
    // Öğretmen Ekle
    /**
     * 📌 Öğretmen Ekleme (CREATE)
     */
    @Override
    public Optional<TeacherDto> create(TeacherDto teacherDto) {
        // Validation
        if (teacherDto == null || findByName(teacherDto.name()).isPresent()) {
            logger.warning("❌ Geçersiz veya mevcut olan öğretmen eklenemez.");
            return Optional.empty();
        }
        // Eğer validation doğru ise ekleme yapabilirsin.
        teacherDtoList.add(teacherDto);
        // Loglama
        logger.info("✅ Yeni öğretmen eklendi: " + teacherDto.name());
        // Dosya yaz
        innerClass.writeFile();
        return Optional.of(teacherDto);
    }

    // Öğretmen Listesi
    /**
     * 📌 Tüm Öğretmenleri Listeleme (LIST)
     */
    @Override
    public List<TeacherDto> list() {
        if (teacherDtoList.isEmpty()) {
            logger.warning("⚠️ Kayıtlı öğretmen bulunamadı!");
            //throw new RegisterNotFoundException("Öğretmen listesi boş.");
            System.out.println(SpecialColor.RED + "Öğretmen listesi boş" + SpecialColor.RESET);
        }
        return new ArrayList<>(teacherDtoList);
    }

    /**
     * 📌 Öğretmen Adına Göre Bulma (FIND BY NAME)
     */
    @Override
    public Optional<TeacherDto> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Geçersiz isim girdiniz.");
        }
        return teacherDtoList.stream().filter(t -> t.name().equalsIgnoreCase(name)).findFirst();
    }

    /**
     * 📌 Öğretmen ID'ye Göre Bulma (FIND BY ID)
     */
    @Override
    public Optional<TeacherDto> findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("❌ Geçersiz ID girdiniz.");
        }
        return teacherDtoList.stream().filter(t -> t.id().equals(id)).findFirst().or(() -> {
            logger.warning("⚠️ Öğretmen bulunamadı, ID: " + id);
            return Optional.empty();
        });
    }

    /**
     * 📌 Öğretmen Güncelleme (UPDATE)
     */
    @Override
    public Optional<TeacherDto> update(int id, TeacherDto teacherDto) {
        if (id <= 0 || teacherDto == null) {
            throw new IllegalArgumentException("❌ Güncelleme için geçerli bir öğretmen bilgisi giriniz.");
        }
        for (int i = 0; i < teacherDtoList.size(); i++) {
            if (teacherDtoList.get(i).id().equals(id)) {
                teacherDtoList.set(i, teacherDto);
                logger.info("✅ Öğretmen güncellendi: " + teacherDto.name());
                return Optional.of(teacherDto);
            }
        }
        //throw new RegisterNotFoundException("⚠️ Güncellenecek öğretmen bulunamadı, ID: " + id);
        System.out.println(SpecialColor.RED + "⚠️ Güncellenecek öğretmen bulunamadı, ID: " + id + SpecialColor.RESET);
        return null;
    }

    /**
     * 📌 Öğretmen Silme (DELETE)
     */
    @Override
    public Optional<TeacherDto> delete(int id) {
        Optional<TeacherDto> teacherToDelete = findById(id);
        if (teacherToDelete.isPresent()) {
            teacherDtoList.remove(teacherToDelete.get());

            // ✅ Dosyayı baştan yaz
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(innerClass.fileHandler.getFilePath(), false))) {
                for (TeacherDto teacher : teacherDtoList) {
                    writer.write(teacherToCsv(teacher)); // CSV formatta yaz
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println(SpecialColor.RED + "❌ Dosya silme/güncelleme hatası: " + e.getMessage() + SpecialColor.RESET);
            }

            logger.info("✅ Öğretmen silindi, ID: " + id);
            System.out.println(SpecialColor.BLUE + "Öğretmen başarıyla silindi." + SpecialColor.RESET);
            return teacherToDelete;
        } else {
            logger.warning("⚠️ Silinecek öğretmen bulunamadı, ID: " + id);
            return Optional.empty();
        }
    }


    /// /////////////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////////////////
    // Enum Öğretmen Türü Method
    public ETeacherSubject teacherTypeMethod() {
        System.out.println("\n" + SpecialColor.GREEN + "Öğretmen bölüm türünü seçiniz.\n1-)Tarih\n2-)Bioloji\n3-)Kimya\n4-)Bilgisayar Bilimleri\n5-)Diğer" + SpecialColor.RESET);
        int typeChooise = scanner.nextInt();
        ETeacherSubject swichcaseTeacher = switch (typeChooise) {
            case 1 -> ETeacherSubject.HISTORY;
            case 2 -> ETeacherSubject.BIOLOGY;
            case 3 -> ETeacherSubject.CHEMISTRY;
            case 4 -> ETeacherSubject.COMPUTER_SCIENCE;
            case 5 -> ETeacherSubject.MATHEMATICS;
            default -> ETeacherSubject.OTHER;
        };
        return swichcaseTeacher;
    }

    /// ///////////////////////////////////////////////////////////////////////
    /**
     * 📌 Kullanıcı işlemlerini yönlendirme metodu (CHOOSE)
     * Yani kullanıcıdan alınan değerlere göre verileri manipülasyon yapma
     */
    // Console Seçim (Öğretmen)
    @Override
    public void choose() {
        logger.info("ℹ️ Öğretmen işlemleri ekranına yönlendirildi.");
        while (true) {
            try {
                System.out.println("\n===== ÖĞRETMEN YÖNETİM SİSTEMİ =====");
                System.out.println("1. Öğretmen Ekle");
                System.out.println("2. Öğretmen Listele");
                System.out.println("3. Öğretmen Ara");
                System.out.println("4. Öğretmen Güncelle");
                System.out.println("5. Öğretmen Sil");
                System.out.println("6. Rastgele Öğretmen Seç");
                System.out.println("7. Öğretmenleri Yaşa Göre Sırala");
                System.out.println("8. Çıkış");
                System.out.print("\nSeçiminizi yapınız: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Boşluğu temizleme

                switch (choice) {
                    case 1 -> addTeacher(); // Lambda Expression
                    case 2 -> listTeachers();
                    case 3 -> searchTeacher();
                    case 4 -> updateTeacher();
                    case 5 -> deleteTeacher();
                    case 6 -> chooseRandomTeacher();
                    case 7 -> sortTeachersByAge();
                    case 8 -> {
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    }
                    default -> System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                }
            } catch (Exception e) {
                System.out.println("⛔ Beklenmeyen bir hata oluştu: " + e.getMessage());
                scanner.nextLine(); // Scanner'ı temizle
            }
        }
    }

    private void addTeacher() {
        // ID artık manuel girilmiyor, otomatik artıyor
        int id = ++maxId;

        System.out.print("Öğretmen Adı: ");
        String name = scanner.nextLine();

        System.out.print("Öğretmen Soyadı: ");
        String surname = scanner.nextLine();

        System.out.print("Öğretmen Doğum Tarihi (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.print("Öğretmen Uzmanlık Alanı: ");
        ETeacherSubject subject = teacherTypeMethod();

        System.out.print("Öğretmen Deneyim Yılı: ");
        int yearsOfExperience = scanner.nextInt();

        System.out.print("Öğretmen Kadrolu mu? (true/false): ");
        boolean isTenured = scanner.nextBoolean();

        System.out.print("Öğretmen Maaş: ");
        double salary = scanner.nextDouble();

        TeacherDto teacher = new TeacherDto(id, name, surname, birthDate, subject, yearsOfExperience, isTenured, salary);
        teacherDtoList.add(teacher);
        innerClass.writeFile();

        System.out.println("Öğretmen başarıyla eklendi. Atanan ID: " + id);
    }

    private void listTeachers() {
        // 📌 Eğer liste boşsa dosyadan tekrar yükle
        if (teacherDtoList.isEmpty()) {
            System.out.println(SpecialColor.YELLOW + "⚠️ Öğretmen listesi boş, dosyadan yükleniyor..." + SpecialColor.RESET);

            List<String> fileLines = innerClass.fileHandler.readFile();
            for (String line : fileLines) {
                TeacherDto teacher = csvToTeacher(line);
                if (teacher != null) {
                    teacherDtoList.add(teacher);
                } else {
                    System.out.println(SpecialColor.RED + "⚠️ Hatalı satır atlandı: " + line + SpecialColor.RESET);
                }
            }

            // 📌 Eğer hala liste boşsa uyarı ver
            if (teacherDtoList.isEmpty()) {
                System.out.println(SpecialColor.RED + "⚠️ Dosyada öğretmen verisi bulunamadı!" + SpecialColor.RESET);
            } else {
                System.out.println(SpecialColor.GREEN + "✅ " + teacherDtoList.size() + " öğretmen başarıyla yüklendi!" + SpecialColor.RESET);
            }
        }

        // 📌 Öğretmenleri listele
        if (!teacherDtoList.isEmpty()) {
            System.out.println("\n=== 📜 Öğretmen Listesi ===");
            for (TeacherDto teacher : teacherDtoList) {
                System.out.println(teacher.fullName() + " - " + teacher.subject());
            }
        }
    }


    private void searchTeacher() {
        // Öncelikle Listele
        listTeachers();
        System.out.print("\n" + SpecialColor.YELLOW + "Aranacak öğretmenin adı: " + SpecialColor.RESET);
        String name = scanner.nextLine();

        findByName(name).ifPresentOrElse(
                teacher -> System.out.println("Bulunan Öğretmen: "
                        + teacher.fullName() + " - "
                        + teacher.subject()),
                () -> System.out.println(SpecialColor.RED + "Öğretmen bulunamadı." + SpecialColor.RESET));
    }

    // updateTeacher
    private void updateTeacher() {
        listTeachers();
        System.out.print("\n" + SpecialColor.YELLOW + "Güncellenecek Öğretmen ID: " + SpecialColor.RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // boşluk temizle

        Optional<TeacherDto> teacherOpt = findById(id);
        if (teacherOpt.isEmpty()) {
            System.out.println(SpecialColor.RED + "⚠️ Güncellenecek öğretmen bulunamadı!" + SpecialColor.RESET);
            return;
        }

        TeacherDto oldTeacher = teacherOpt.get();

        System.out.print("Yeni Öğretmen Adı (" + oldTeacher.name() + "): ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = oldTeacher.name();

        System.out.print("Yeni Öğretmen Soyadı (" + oldTeacher.surname() + "): ");
        String surname = scanner.nextLine().trim();
        if (surname.isEmpty()) surname = oldTeacher.surname();

        System.out.print("Yeni Öğretmen Doğum Tarihi (" + oldTeacher.birthDate() + ") ");
        String birthStr = scanner.nextLine().trim();
        LocalDate birthDate = birthStr.isEmpty() ? oldTeacher.birthDate() : LocalDate.parse(birthStr);

        System.out.print("Yeni Öğretmen Uzmanlık Alanı: ");
        ETeacherSubject subject = teacherTypeMethod();

        System.out.print("Yeni Öğretmen Deneyim Yılı (" + oldTeacher.experienceLevel() + "): ");
        Integer yearsOfExperience = scanner.nextInt();

        System.out.print("Yeni Öğretmen Kadrolu mu? (true/false): ");
        boolean isTenured = scanner.nextBoolean();

        System.out.print("Yeni Öğretmen Maaş (" + oldTeacher.salary() + "): ");
        Integer salary = scanner.nextInt();

        // Yeni nesne oluştur
        TeacherDto updatedTeacher = new TeacherDto(id, name, surname, birthDate, subject, yearsOfExperience, isTenured, salary);
        try {
            update(id, updatedTeacher);

            // Dosyayı baştan yaz
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(innerClass.fileHandler.getFilePath(), false))) {
                for (TeacherDto teacher : teacherDtoList) {
                    writer.write(teacherToCsv(teacher));
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println(SpecialColor.RED + "❌ Dosya yazma hatası: " + e.getMessage() + SpecialColor.RESET);
            }

            System.out.println(SpecialColor.GREEN + "🟢 Öğretmen başarıyla güncellendi." + SpecialColor.RESET);
        } catch (TeacherNotFoundException e) {
            System.out.println(SpecialColor.RED + e.getMessage() + SpecialColor.RESET);
        }
    }


    private void deleteTeacher() {
        // Öncelikle Listele
        listTeachers();
        System.out.print("\n" + SpecialColor.YELLOW + "Silinecek öğretmenin ID'si: " + SpecialColor.RESET);
        int id = scanner.nextInt();
        try {
            delete(id);
            System.out.println("Öğretmen başarıyla silindi.");
        } catch (TeacherNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void chooseRandomTeacher() {
        if (teacherDtoList.isEmpty()) {
            System.out.println("Kayıtlı öğretmen yok.");
            return;
        }
        TeacherDto teacher = teacherDtoList.get(random.nextInt(teacherDtoList.size()));
        System.out.println("Seçilen Rastgele Öğretmen: " + teacher.fullName());
    }

    private void sortTeachersByAge() {
        teacherDtoList.sort(Comparator.comparing(TeacherDto::birthDate));
        System.out.println("Öğretmenler yaşa göre sıralandı.");
        listTeachers();
    }


    public static void main(String[] args) {
        //TeacherDao teacherDao = new TeacherDao();
        //teacherDao.choose();
    }
}
