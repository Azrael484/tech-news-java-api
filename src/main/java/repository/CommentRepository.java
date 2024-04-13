package repository;

import com.technews.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository {
    List<Comment> findAllCommentsByPostId(int postId);
}
