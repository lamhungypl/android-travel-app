package com.example.endtermandroid.object;

import android.net.Uri;

public class CardCityModel {
    private String mainTemp;
    private String mainDescription;
    private Uri srcMainImage;
    private String detailSpeed;

    public CardCityModel(String mainTemp, String mainDescription, Uri srcMainImage, String detailSpeed, String detailFeelLike, String detailHumidity, String detailPressure) {
        this.mainTemp = mainTemp;
        this.mainDescription = mainDescription;
        this.srcMainImage = srcMainImage;
        this.detailSpeed = detailSpeed;
        this.detailFeelLike = detailFeelLike;
        this.detailHumidity = detailHumidity;
        this.detailPressure = detailPressure;
    }

    public String getMainTemp() {
        return mainTemp;
    }

    public void setMainTemp(String mainTemp) {
        this.mainTemp = mainTemp;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public Uri getSrcMainImage() {
        return srcMainImage;
    }

    public void setSrcMainImage(Uri srcMainImage) {
        this.srcMainImage = srcMainImage;
    }

    public String getDetailSpeed() {
        return detailSpeed;
    }

    public void setDetailSpeed(String detailSpeed) {
        this.detailSpeed = detailSpeed;
    }

    public String getDetailFeelLike() {
        return detailFeelLike;
    }

    public void setDetailFeelLike(String detailFeelLike) {
        this.detailFeelLike = detailFeelLike;
    }

    public String getDetailHumidity() {
        return detailHumidity;
    }

    public void setDetailHumidity(String detailHumidity) {
        this.detailHumidity = detailHumidity;
    }

    public String getDetailPressure() {
        return detailPressure;
    }

    public void setDetailPressure(String detailPressure) {
        this.detailPressure = detailPressure;
    }

    private String detailFeelLike;
    private String detailHumidity;
    private String detailPressure;

}
