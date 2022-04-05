package CS1530.RottenApples.impl;

import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.FriendRequestRepository;
import CS1530.RottenApples.repositories.UserRepository;
       
public class FriendImpl {
    private FriendRequestRepository friendRequestRepository;
    private UserRepository userRepository;

    public void addToFriends(String currentUser, String friendUserName) {
        User curr = userRepository.findFriend(currentUser);
        User friend = userRepository.findFriend(friendUserName);
        friendRequestRepository.save(new friendRequest(curr, friend));
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
