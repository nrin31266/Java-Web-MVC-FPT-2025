package com.rin.app.dto.request;

import com.rin.app.entity.KhachHang;
import com.rin.app.entity.LoaiKhachHang;
import com.rin.app.entity.Sach;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MuonTraSachRequest {
    //KH
    @NotBlank(message = "Ma khach hang la bat buoc")
    String maKH;
    @NotBlank(message = "Ten khach hang la bat buoc")
    String tenKH;
    LocalDate tuoi;
    String gioiTinh;
    String diaChi;
    @NotBlank(message = "Sdt khach hang la bat buoc")
    String soDT;

    String ghiChuKH;
    //ex
    @NotNull(message = "Ma loai khach hang la bat buoc")
    Integer maLoaiKhachHang;

    //MTS


    @NotNull(message = "Ma sach la bat buoc")
    Integer maSach;
    @NotNull(message = "Ban can phai co ngay muon")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngay muon không được nằm trong tương lai")
    LocalDate ngayMuon;

    String ghiChuMTS;

}
