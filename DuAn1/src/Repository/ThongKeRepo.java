/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ThongKe;
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
public class ThongKeRepo {

    public List<ThongKe> getAll() {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,\n"
                    + "HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia'Thành Tiền'\n"
                    + "FROM     SanPham INNER JOIN\n"
                    + "                  HoaDon ON SanPham.Id = HoaDon.Id INNER JOIN\n"
                    + "                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("SanPham.Ma"));
                kh.setTenSP(rs.getString("SanPham.Ten"));
                kh.setNgay(rs.getString("HoaDon.NgayThanhToan"));
                kh.setSoLuong(rs.getInt("HoaDonChiTiet.SoLuong"));
                kh.setDongia(rs.getDouble("HoaDonChiTiet.DonGia"));
                kh.setThanhTien(rs.getDouble("HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia"));
                listKh.add(kh);

            }
            rs.close();
            ps.close();
            conn.close();
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThongKe> tim(String ma) {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,\n"
                    + "HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia'Thành Tiền'\n"
                    + "FROM     SanPham INNER JOIN\n"
                    + "                  HoaDon ON SanPham.Id = HoaDon.Id INNER JOIN\n"
                    + "                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon"
                    + " where Ma = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("SanPham.Ma"));
                kh.setTenSP(rs.getString("SanPham.Ten"));
                kh.setNgay(rs.getString("HoaDon.NgayThanhToan"));
                kh.setSoLuong(rs.getInt("HoaDonChiTiet.SoLuong"));
                kh.setDongia(rs.getDouble("HoaDonChiTiet.DonGia"));
                kh.setThanhTien(rs.getDouble("HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia"));
                listKh.add(kh);

            }

            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}