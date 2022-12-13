package com.example.bugbug.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("tags")
public class Tag {
    @Id
    @Column("tag_id")
    private Integer tagId;
    private String name;
    private Integer deleted;
}
