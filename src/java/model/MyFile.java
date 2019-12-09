/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author omiro
 */
public class MyFile {

    private int id;
    private String filename;
    private Blob thefileasblob;

    public MyFile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Blob getThefileasblob() {
        return thefileasblob;
    }

    public void setThefileasblob(Blob thefileasblob) {
        this.thefileasblob = thefileasblob;
    }

}
