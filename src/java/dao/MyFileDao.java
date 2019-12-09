/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import model.MyFile;
import tools.DBUtils;

/**
 *
 * @author omiro
 */
public class MyFileDao {

    public List getAllMyFiles_ID_Filename() {

        List<MyFile> allMyFiles_ID_Filename;
        allMyFiles_ID_Filename = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {

            String query = "SELECT MYFILES_ID, MYFILES_FILENAME FROM MYFILES";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setFilename(rs.getString(2));

                allMyFiles_ID_Filename.add(myFile);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return allMyFiles_ID_Filename;
    }

    public MyFile getById(int id) throws SQLException {

        MyFile myFile = new MyFile();

        String sql = "SELECT * FROM MYFILES WHERE MYFILES_ID=?";

        try (Connection con = DBUtils.getConnection()) {

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                myFile.setId(rs.getInt(1));
                myFile.setFilename(rs.getString(2));
                myFile.setThefileasblob(rs.getBlob(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myFile;
    }

    public void uploadFile(Part p, String filename) {

        try {
            Connection con = DBUtils.getConnection();

            String sql = "INSERT INTO myfiles VALUES (null, ?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filename);

            try {
                ps.setBinaryStream(2, p.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.close();
            }

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteFile(int ID) {
        Connection con = DBUtils.getConnection();

        String sql = "DELETE FROM myfiles WHERE MYFILES_ID = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MyFileDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

}
