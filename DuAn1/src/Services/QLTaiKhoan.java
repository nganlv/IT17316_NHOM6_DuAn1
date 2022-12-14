/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import ViewModels.QuanLyTaiKhoan;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QLTaiKhoan  {
     List<QuanLyTaiKhoan> getView();
     List<TaiKhoan> getAlls();
         TaiKhoan getOne(String maTK);
      Boolean checkMa(String maTk);
         String addCVs(TaiKhoan tk);
         String updateCV(TaiKhoan tk);
    String deleteCV(String  tk);
}
