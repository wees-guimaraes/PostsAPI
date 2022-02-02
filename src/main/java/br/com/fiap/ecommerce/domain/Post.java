package br.com.fiap.ecommerce.domain;

import br.com.fiap.ecommerce.dto.AuthorDTO;
import br.com.fiap.ecommerce.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String title;
    private String body;
    private LocalDate date;

    private AuthorDTO author;

    private List<CommentDTO> commentDTOList = new ArrayList<>();

    public Post() {
    }

    public Post(String id, String title, String body, LocalDate date, AuthorDTO author, List<CommentDTO> commentDTOList) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
        this.commentDTOList = commentDTOList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, date);
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CommentDTO> getCommentDTOList() {
        return commentDTOList;
    }

    public void setCommentDTOList(List<CommentDTO> commentDTOList) {
        this.commentDTOList = commentDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public String toString() {
        return "Post{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", body='" + body + '\'' + ", date=" + date + '}';
    }
}
