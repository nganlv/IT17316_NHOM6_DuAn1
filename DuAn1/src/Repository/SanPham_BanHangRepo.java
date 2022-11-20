/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham_BanHang;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class SanPham_BanHangRepo implements ISanPham_BanHangRepo {

    @Override
    public List<SanPham_BanHang> getAllSp() {
        try {
            List<SanPham_BanHang> listSp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, FORMAT(DonGia,'c','vi-VN') as DonGia,"
                    + " FORMAT(GiamGia,'c','vi-VN') as GiamGia, MauSac, ChatLieu, KichThuoc, Loai, GioiTinh, KieuMay, "
                    + " SoLuongTon from SanPham join ChiTietSP on SanPham.Id=ChiTietSP.IdSP"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_BanHang sp = new SanPham_BanHang();
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setDonGia(rs.getString("DonGia"));
                sp.setGiamGia(rs.getString("GiamGia"));
                sp.setMauSac(rs.getString("MauSac"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setLoai(rs.getString("Loai"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setKieuMay(rs.getString("KieuMay"));
                sp.setSoLuong(rs.getInt("SoLuongTon"));
                listSp.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPham_BanHang> timSpTheoMa(String ma) {
        try {
            List<SanPham_BanHang> listSp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, FORMAT(DonGia,'c','vi-VN') as DonGia,"
                    + " FORMAT(GiamGia,'c','vi-VN') as GiamGia, MauSac, ChatLieu, KichThuoc, Loai, GioiTinh, KieuMay, "
                    + " SoLuongTon from SanPham join ChiTietSP on SanPham.Id=ChiTietSP.IdSP"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id"
                    + " where SanPham.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_BanHang sp = new SanPham_BanHang();
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setDonGia(rs.getString("DonGia"));
                sp.setGiamGia(rs.getString("GiamGia"));
                sp.setMauSac(rs.getString("MauSac"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setLoai(rs.getString("Loai"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setKieuMay(rs.getString("KieuMay"));
                sp.setSoLuong(rs.getInt("SoLuongTon"));
                listSp.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}