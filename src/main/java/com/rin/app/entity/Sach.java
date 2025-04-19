package com.rin.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "Sach")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer maSach;
    String tenSach;
    @ManyToOne
    @JoinColumn(name = "maLoaiSach")
    TheLoaiSach theLoaiSach;
    String tacGia;
    String namXuatBan;
    Long donGia;
}
