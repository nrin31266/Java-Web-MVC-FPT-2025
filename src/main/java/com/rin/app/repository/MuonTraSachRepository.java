package com.rin.app.repository;

import com.rin.app.entity.KhachHang;
import com.rin.app.entity.MuonTraSach;
import com.rin.app.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MuonTraSachRepository extends JpaRepository<MuonTraSach, Integer> , JpaSpecificationExecutor<MuonTraSach> {
    Optional<MuonTraSach> findBySachAndKhachHang(Sach sach, KhachHang khach);
}
