package com.rin.app.service;

import com.rin.app.dto.request.MuonTraSachRequest;
import com.rin.app.entity.*;
import com.rin.app.mapper.AppMapper;
import com.rin.app.repository.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MuonTraSachService {
    KhachHangRepository khachHangRepository;
    LoaiKhachHangRepository loaiKhachHangRepository;
    MuonTraSachRepository muonTraSachRepository;
    SachRepository sachRepository;
    TheLoaiSachRepository theLoaiSachRepository;

    AppMapper appMapper;

//    @Transactional
    public KhachHang muonSach(MuonTraSachRequest requestBody) {
       try{
           LoaiKhachHang loaiKhachHang = loaiKhachHangRepository.findById(requestBody.getMaLoaiKhachHang()).orElseThrow(
                   ()->new RuntimeException("Khong tim thay loai khach hang")
           );
           Sach sach = sachRepository.findById(requestBody.getMaSach()).orElseThrow(
                   ()->new RuntimeException("Khong tim thay sach")
           );

            KhachHang khachHang;

           Optional<KhachHang> existedKhachHang = khachHangRepository.findById(requestBody.getMaKH());
           khachHang = existedKhachHang.orElseGet(() -> appMapper.toKhachHang(requestBody));


           MuonTraSach newMuonTraSach = appMapper.toMuonTraSach(requestBody);
           newMuonTraSach.setKhachHang(khachHang);
           newMuonTraSach.setSach(sach);

           khachHang.setLoaiKhachHang(loaiKhachHang);
           khachHang.getMuonTraSachs().add(newMuonTraSach);



           return khachHangRepository.save(khachHang);
       }catch (RuntimeException e){
           throw e;
       }
    }

    public List<LoaiKhachHang> getAllLoaiKhachHang() {
        return loaiKhachHangRepository.findAll();
    }

    public List<Sach> getAllSach() {
        return sachRepository.findAll();
    }

    public List<MuonTraSach> lichSuMuon( String soDT,String tenSach, LocalDate ngayMuon) {



        Specification<MuonTraSach> specification =(root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(soDT != null && !soDT.isEmpty()) {
                Join<MuonTraSach, KhachHang> joinKhachHang = root.join("khachHang");
                predicates.add(criteriaBuilder.like(joinKhachHang.get("soDT"), "%"+soDT+"%"));
            }
            if(tenSach != null && !tenSach.isEmpty()) {
                Join<MuonTraSach, Sach> joinKhachHang = root.join("sach");
                predicates.add(criteriaBuilder.like(joinKhachHang.get("tenSach"), "%"+tenSach+"%"));
            }
            if (ngayMuon != null) {
                predicates.add(criteriaBuilder.equal(root.get("ngayMuon"), ngayMuon));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return  muonTraSachRepository.findAll(specification);
    }

    public void xoaMuonSach(String maKH, Integer maSach) {
        KhachHang khachHang = khachHangRepository.findById(maKH).orElseThrow(
                ()->new RuntimeException("Khong tim thay khach hang")
        );
        Sach sach = sachRepository.findById(maSach).orElseThrow(
                ()->new RuntimeException("Khong tim thay sach")
        );

        MuonTraSach muonTraSach = muonTraSachRepository.findBySachAndKhachHang(sach, khachHang).orElseThrow(
                ()->new RuntimeException("Khong tim thay sach")
        );

        if(muonTraSach.getNgayTra() == null){
            throw new RuntimeException("Chua tra sach");
        }

        muonTraSachRepository.delete(muonTraSach);

    }

    public KhachHang getKhachHang(String maKH){
        return khachHangRepository.findById(maKH).orElseThrow(
                ()->new RuntimeException("Khong tim thay khach hang")
        );
    }
}
