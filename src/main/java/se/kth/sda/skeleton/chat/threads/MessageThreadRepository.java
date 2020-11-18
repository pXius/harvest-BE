package se.kth.sda.skeleton.chat.threads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageThreadRepository extends JpaRepository<MessageThread, Long> {
    MessageThread findByP1EmailAndP2Email(String p1Email, String p2Email);
}
