package com.dicoding.picodiploma.daftarfilm2;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photo;
    private String name;
    private String year;
    private String type;
    private String duration;
    private String genres;
    private String language;
    private String synopsis;
    private String rated;

    protected Film(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        year = in.readString();
        type = in.readString();
        duration = in.readString();
        genres = in.readString();
        language = in.readString();
        synopsis = in.readString();
        rated = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public Film() {

    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(name);
        dest.writeString(year);
        dest.writeString(type);
        dest.writeString(duration);
        dest.writeString(genres);
        dest.writeString(language);
        dest.writeString(synopsis);
        dest.writeString(rated);
    }
}
