package com.mjc.school.model.implementation;

import com.mjc.school.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
@Entity
public class NewsModel implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String title;
    @Column
    private String content;
    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorModel author;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="news_tags", joinColumns = @JoinColumn(name = "news_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagModel> tag = new ArrayList<>();
}
