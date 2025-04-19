package com.rin.app.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Khach_Hang")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = {"muonTraSachs"})
public class KhachHang {
    @Id
    String maKH;
    @ManyToOne
    @JoinColumn(name = "maLoaiKH")
    LoaiKhachHang loaiKhachHang;
    String tenKH;
    LocalDate tuoi;
    String gioiTinh;
    String diaChi;

    String soDT;

    String ghiChu;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MuonTraSach> muonTraSachs = new ArrayList<>();

}
