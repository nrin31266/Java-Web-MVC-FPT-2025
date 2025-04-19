package com.rin.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "Loai_Khach_Hang")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer maLoaiKH;
    String tenLoaiKH;
}
