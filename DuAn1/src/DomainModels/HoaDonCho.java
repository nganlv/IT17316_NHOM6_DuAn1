/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author levan
 */
public class HoaDonCho {
    private String maHd, ngayTao, maNv, tenKh;

    public HoaDonCho() {
    }

    public HoaDonCho(String maHd, String ngayTao, String maNv, String tenKh) {
        this.maHd = maHd;
        this.ngayTao = ngayTao;
        this.maNv = maNv;
        this.tenKh = tenKh;
    }
    
    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }
    
}
