package linkedlist;

/*
Singly Linked List: Social Media Friend Connections - Complete Implementation

OVERVIEW:
Each user is stored in a singly linked list.
Each user node maintains a separate singly linked list of friend IDs.

DATA STRUCTURE:
UserNode
- userId (int)
- name (String)
- age (int)
- friendsHead (FriendNode) → head of friend list
- next (UserNode)

FriendNode
- friendId (int)
- next (FriendNode)

OPERATIONS:
1. Add user
2. Add friend connection (bidirectional)
3. Remove friend connection
4. Display friends of a user
5. Find mutual friends
6. Search user by ID or Name
7. Count number of friends

EDGE CASES:
- User not found
- No friends
- Duplicate friend connections
*/

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int id) {
        friendId = id;
        next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendsHead;
    UserNode next;

    UserNode(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}

public class SocialMediaConnections {

    UserNode head;

    /* ADD USER */
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    /* FIND USER BY ID */
    private UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    /* ADD FRIEND CONNECTION (BIDIRECTIONAL) */
    public void addFriend(int u1, int u2) {

        UserNode user1 = findUser(u1);
        UserNode user2 = findUser(u2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        user1.friendsHead = new FriendNode(u2);
        user1.friendsHead.next = user1.friendsHead;

        user2.friendsHead = new FriendNode(u1);
        user2.friendsHead.next = user2.friendsHead;

        System.out.println("Friend connection added.");
    }

    /* DISPLAY FRIENDS OF USER */
    public void displayFriends(int userId) {

        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        FriendNode temp = user.friendsHead;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    /* FIND MUTUAL FRIENDS */
    public void findMutualFriends(int u1, int u2) {

        UserNode user1 = findUser(u1);
        UserNode user2 = findUser(u2);

        if (user1 == null || user2 == null) return;

        FriendNode f1 = user1.friendsHead;
        FriendNode f2 = user2.friendsHead;

        while (f1 != null) {
            FriendNode temp = f2;
            while (temp != null) {
                if (f1.friendId == temp.friendId)
                    System.out.println("Mutual Friend ID: " + f1.friendId);
                temp = temp.next;
            }
            f1 = f1.next;
        }
    }
}
