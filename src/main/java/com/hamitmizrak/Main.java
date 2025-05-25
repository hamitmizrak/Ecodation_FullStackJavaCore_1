package com.hamitmizrak;

import com.hamitmizrak.controller.LoginRegisterController;
import java.util.logging.Logger;

// Database veya file için Login bilgileri
// username: hamitmizrak@gmail.com
// password: root
public class Main {
    // ✅ Loglama
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // ✅ Psvm
    public static void main(String[] args) {
        logger.info("🚀 Proje başlatılıyor...");
        LoginRegisterController controller = new LoginRegisterController();
        controller.login();
    }

}