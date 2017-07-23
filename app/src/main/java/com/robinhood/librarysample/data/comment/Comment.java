package com.robinhood.librarysample.data.comment;


import com.robinhood.api.github.dto.CommentDTO;
import com.robinhood.librarysample.base.model.Model;
import com.robinhood.librarysample.data.User;

public class Comment extends Model {
    private int id;
    private String createdDate;
    private String updatedDate;
    private String body;
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Comment convertModel(CommentDTO commentDTO) {
        Comment comment = new Comment();
        User user = new User();
        user.setId(commentDTO.getUser().getId());
        user.setAvatarUrl(commentDTO.getUser().getAvatar_url());
        user.setLogin(commentDTO.getUser().getLogin());

        comment.setId(commentDTO.getId());
        comment.setBody(commentDTO.getBody());
        comment.setCreatedDate(commentDTO.getCreated_at());
        comment.setUpdatedDate(commentDTO.getUpdated_at());
        comment.setUser(user);

        return comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
