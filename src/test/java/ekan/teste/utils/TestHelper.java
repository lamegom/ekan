package ekan.teste.utils;

import static java.lang.String.format;

import java.util.Random;
import java.util.UUID;

import ekan.teste.entity.User;

public class TestHelper {
    public static User buildUser() {
        String uuid = UUID.randomUUID().toString();
        return User.builder()
                .username("username-"+uuid)
                .password(uuid)
                .name("name-"+uuid)
                .email(format("someone-%s@gmail.com", uuid))
                .build();
    }

    public static User buildUserWithId() {
        Random random = new Random();
        String uuid = UUID.randomUUID().toString();
        return User.builder()
                .id(random.nextLong())
                .username("username-"+uuid)
                .password(uuid)
                .name("name-"+uuid)
                .email(format("someone-%s@gmail.com", uuid))
                .build();
    }
}
