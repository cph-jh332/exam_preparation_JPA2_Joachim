/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author craci
 */
@Entity
public class EBook extends Book implements Serializable {

    @Column(name = "downloadUrl")
    private String downloadUrl;
    
    @Column(name = "sizeMB")
    private double sizeMB;

    /**
     * @return the downloadUrl
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * @param downloadUrl the downloadUrl to set
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * @return the sizeMB
     */
    public double getSizeMB() {
        return sizeMB;
    }

    /**
     * @param sizeMB the sizeMB to set
     */
    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }
    
}
