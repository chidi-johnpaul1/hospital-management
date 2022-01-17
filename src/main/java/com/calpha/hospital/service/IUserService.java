package com.calpha.hospital.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import com.calpha.hospital.dto.UserDto;
import com.calpha.hospital.model.PasswordResetToken;
import com.calpha.hospital.model.Users;
import com.calpha.hospital.model.VerificationToken;


public interface IUserService {

    Users registerNewUser(UserDto accountDto);

    Users getUser(String verificationToken);

    void saveRegisteredUser(Users user);

    void deleteUser(Users user);

    void createVerificationTokenForUser(Users user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(Users user, String token);

    Users findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    Optional<Users> getUserByPasswordResetToken(String token);

    Optional<Users> getUserByID(long id);

    void changeUserPassword(Users user, String password);

    boolean checkIfValidOldPassword(Users user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(Users user) throws UnsupportedEncodingException;

    Users updateUser2FA(boolean use2FA);

    List<String> getUsersFromSessionRegistry();
    
    /**
     * To be implemented later
     * */

   // NewLocationToken isNewLoginLocation(String username, String ip);

    //String isValidNewLocationToken(String token);

    void addUserLocation(Users user, String ip);
}
