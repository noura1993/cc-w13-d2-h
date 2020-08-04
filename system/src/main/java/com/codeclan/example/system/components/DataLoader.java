package com.codeclan.example.system.components;

import com.codeclan.example.system.models.File;
import com.codeclan.example.system.models.Folder;
import com.codeclan.example.system.models.User;
import com.codeclan.example.system.repository.FileRepository;
import com.codeclan.example.system.repository.FolderRepository;
import com.codeclan.example.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        User user1 = new User("Bob");
        userRepository.save(user1);

        Folder folder1 = new Folder("CodeClan", user1);
        folderRepository.save(folder1);

        File file1 = new File("system", "java", 100, folder1);
        fileRepository.save(file1);
    }
}
