package com.example.apiversioning.mapper;

import org.springframework.stereotype.Component;

import com.example.apiversioning.models.User;
import com.example.apiversioning.userDto.UserDTOv1;
import com.example.apiversioning.userDto.UserDTOv2;

@Component
public class UserMapper {
    public UserDTOv1 toV1(User user) {
        return new UserDTOv1(
                user.id(),
                user.name(),
                user.email(),
                user.website());
    }

    public UserDTOv2 toV2(User user) {
        String[] nameParts = splitName(user.name());
        return new UserDTOv2(
                user.id(),
                nameParts[0], // first name
                nameParts[1], // last name
                user.email(),
                user.website());
    }

    private String[] splitName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return new String[] { "", "" };
        }

        String trimmed = fullName.trim();
        int lastSpaceIndex = trimmed.lastIndexOf(' '); // ✅ use space char

        if (lastSpaceIndex == -1) { // ✅ comparison
            return new String[] { trimmed, "" };
        }

        return new String[] {
                trimmed.substring(0, lastSpaceIndex),
                trimmed.substring(lastSpaceIndex + 1)
        };
    }

}
