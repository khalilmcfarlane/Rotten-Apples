package CS1530.RottenApples.impl;

import java.util.*;

import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.FriendRequestRepository;
import CS1530.RottenApples.repositories.UserRepository;
       
public class FriendImpl {
    private FriendRequestRepository friendRequestRepository;
    private UserRepository userRepository;

    public List<friendRequest> getFriends(User user) {
        List<friendRequest> friendList = friendRequestRepository.findUser(user.getUsername());
        if(friendList.size() > 0) {
            return friendList;
        } else {
            return new ArrayList<friendRequest>();
        }
    }

    public void addToFriends(String currentUser, String friendUserName) {
        User curr = userRepository.findFriend(currentUser);
        User friend = userRepository.findFriend(friendUserName);
        if(!(checkFriendship(currentUser, friendUserName))) {
            friendRequest fr = new friendRequest();
            fr.setRecipient(curr);
            fr.setSender(friend);
            fr.setAccepted(true);
            friendRequestRepository.save(fr);
        }
    }

    public Boolean checkFriendship(String currentUser, String friendUserName) {
        User curr = userRepository.findFriend(currentUser);
        User friend = userRepository.findFriend(friendUserName);
        friendRequest isFriend = friendRequestRepository.findFriend(curr, friend);
        if(isFriend != null) {
            return true;
        }
        return false;
    }
}
