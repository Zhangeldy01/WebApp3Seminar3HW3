package com.example.WebApp3Seminar3HW3.services;

import com.example.WebApp3Seminar3HW3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    private DataProcessingService dataProcessingService;
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * метод процесс регистрации
     */
    public void processRegistration(String name, int age,String email) {

        // Создание пользователя - user
        User user = userService.createUser(name, age, email);

        // созданный user добавляется в репозиторий (БД)
        dataProcessingService.addUserToList(user);

        //вывод сообщения в консоль
        notificationService.notifyUser(user);
    }

    //Метод processRegistration
}
