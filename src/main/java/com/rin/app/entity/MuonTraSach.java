package com.rin.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "Muon_Tra_Sach")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class MuonTraSach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "maKH")
    KhachHang khachHang;


    @ManyToOne
    @JoinColumn(name = "maSach")
    Sach sach;

    LocalDate ngayMuon;
    LocalDate hanTraSach;
    Boolean statusTraSach;
    LocalDate ngayTra;
    Long tienPhat;
    String ghiChu;
}
