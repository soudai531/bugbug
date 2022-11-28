package com.example.bugbug.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("tags")
public class Tag {
    @Id
    @Column("tag_id")
    private int tagId;
    private String name;
    private int deleted;
}
