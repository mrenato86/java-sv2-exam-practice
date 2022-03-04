package potvizsga.message;

import java.util.Optional;

public class MessageService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void registerUser(String username) {
        if (userRepository.findUserByName(username).isPresent()) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
        userRepository.insertUser(username);
    }

    public void sendMessage(User sender, User receiver, String message) {
        Optional<User> senderUser = userRepository.findUserByName(sender.getUsername());
        Optional<User> receiverUser = userRepository.findUserByName(receiver.getUsername());
        if (senderUser.isPresent() && receiverUser.isPresent()) {
            messageRepository.insertMessage(senderUser.get().getId(), receiverUser.get().getId(), message);
        }
    }

}
