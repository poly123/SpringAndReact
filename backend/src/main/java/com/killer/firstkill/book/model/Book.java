package com.killer.firstkill.book.model;

import lombok.*;
import java.time.LocalDateTime;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode를 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 받는 생성자 자동 생성
@Builder // Builder 패턴 적용
public class Book {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}