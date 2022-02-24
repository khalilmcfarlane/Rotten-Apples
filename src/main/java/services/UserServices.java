package services;

import java.util.*;
import models.User;

public interface UserServices {
    User createUser(User user);

    User updateProduct(User user);

    List<User> getAllProduct();

    User getProductById(UUID userId);

    void deleteProduct(UUID id);
}
