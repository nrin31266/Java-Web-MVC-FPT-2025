package com.rin.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "The_Loai_Sach")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TheLoaiSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer maLoaiSach;
    String tenLoaiSach;
}
