package org.zerock.b01.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {

    @Id
//    @Column(length = 300, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String member_id;
    @Column(length = 300, nullable = false)
    private String member_pw;
    @Column(length = 300)
    private String name;
    @Column(length = 300)
    private String phone;
    @Column(length = 300)
    private String Email1;
    @Column(length = 300)
    private String Email2;
    @Column(length = 300)
    private String gender;
    @Column(length = 4)
    private boolean agree;
//    @CreatedDate
//    @Column
//    private LocalDateTime create_date;

}
