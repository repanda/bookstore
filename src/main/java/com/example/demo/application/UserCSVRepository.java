package com.example.demo.application;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
class UserCSVRepository implements UserRepository {

    List<User> users;

    @Override
    public void addAll(List<User> users) {
    }

    @Override
    public List<User> getAll() {

        if (users != null) return users;

        List<List<String>> data = CSVMapper.mapCsvFile("user.csv");

        users = data.stream()
                .map(row -> {
                            String s = row.get(3);
                            Date memberTill = s.isBlank() ? null : new Date(s);
                            return new User(row.get(0),
                                    row.get(1),
                                    memberTill);
                        }
                )
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public User findByName(String userName, String borrowerFistName) {
        Optional<User> first = getAll()
                .stream()
                .filter(user -> user.getName().equals(userName) && user.getFirstName().equals(borrowerFistName))
                .findFirst();
        return first
                .orElse(new User("UNKNOWN", "UNKNOWN", null));
    }


}
