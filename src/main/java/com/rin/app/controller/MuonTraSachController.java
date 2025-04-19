package com.rin.app.controller;

import com.rin.app.dto.request.MuonTraSachRequest;
import com.rin.app.entity.KhachHang;
import com.rin.app.entity.MuonTraSach;
import com.rin.app.service.MuonTraSachService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("MuonTraSach")
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MuonTraSachController {

    MuonTraSachService muonTraSachService;

    @GetMapping("Them")
    public String getMuonTraSachPage(
            Model model
    ){
        model.addAttribute("requestBody",new MuonTraSachRequest());
        model.addAttribute("loaiKhachHangs", muonTraSachService.getAllLoaiKhachHang());
        model.addAttribute("sachs", muonTraSachService.getAllSach());

        return "MuonTraSach/Them";
    }

    @PostMapping("Them")
    public String addSinhVienTotNghiep(@Valid @ModelAttribute("requestBody") MuonTraSachRequest requestBody,
                                       BindingResult bindingResult, Model model
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("requestBody",requestBody);
            model.addAttribute("loaiKhachHangs", muonTraSachService.getAllLoaiKhachHang());
            model.addAttribute("sachs", muonTraSachService.getAllSach());
            return "MuonTraSach/Them";
        }
        try{
            muonTraSachService.muonSach(requestBody);
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            model.addAttribute("requestBody",requestBody);
            model.addAttribute("loaiKhachHangs", muonTraSachService.getAllLoaiKhachHang());
            model.addAttribute("sachs", muonTraSachService.getAllSach());
            return "MuonTraSach/Them";
        }
        return "redirect:/";

    }

    @GetMapping("/LichSuMuon")
    public String timKiemSinhVien(
            Model model,
            @RequestParam(value = "soDT", required = false) String soDT,
            @RequestParam(value = "tenSach", required = false) String tenSach,
            @RequestParam(value = "ngayMuon", required = false) LocalDate ngayMuon
    ) {
        model.addAttribute("soDT", soDT);
        model.addAttribute("tenSach", tenSach);
        model.addAttribute("ngayMuon", ngayMuon);

        List<MuonTraSach> muonTraSaches = muonTraSachService.lichSuMuon(soDT, tenSach, ngayMuon);
        model.addAttribute("muonTraSachs", muonTraSaches);



        return "MuonTraSach/LichSuMuon";
    }

    @PostMapping("/Xoa/{maKH}/{maSach}")
    public String timKiemSinhVien(
            Model model,
            @PathVariable("maKH") String maKH,
            @PathVariable("maSach") Integer maSach
    ) {
       try{
            muonTraSachService.xoaMuonSach(maKH, maSach);

       }catch (Exception e){
           model.addAttribute("error",e.getMessage());
           return "MuonTraSach/Loi";
       }



       return "redirect:/MuonTraSach/KhachHang?maKH="+maKH;
    }

    @GetMapping("/KhachHang")
    public String getKhachHang(
            Model model,
            @RequestParam(name = "maKH") String maKH
    ){
        KhachHang khachHang= muonTraSachService.getKhachHang(maKH);
        model.addAttribute("khachHang", khachHang);
        return "MuonTraSach/KhachHang";
    }
}
