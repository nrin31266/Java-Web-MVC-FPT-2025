package com.rin.app.mapper;

import com.rin.app.dto.request.MuonTraSachRequest;
import com.rin.app.entity.KhachHang;
import com.rin.app.entity.MuonTraSach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppMapper {
    @Mapping(target = "ghiChu", source = "ghiChuKH")
    KhachHang toKhachHang(MuonTraSachRequest requestBody);

    @Mapping(target = "ghiChu", source = "ghiChuMTS")
    MuonTraSach toMuonTraSach(MuonTraSachRequest requestBody);
}
