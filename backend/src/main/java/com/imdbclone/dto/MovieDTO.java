package com.imdbclone.dto;

import java.util.List;

public class MovieDTO {
    
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Integer releaseYear;
    private String director;
    private String genre;
    private Double averageRating;
    private Integer ratingCount;
    private List<CommentDTO> comments;
    
    // Constructors
    public MovieDTO() {}
    
    public MovieDTO(Long id, String title, String description, String imageUrl, 
                   Integer releaseYear, String director, String genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public Integer getReleaseYear() {
        return releaseYear;
    }
    
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public Double getAverageRating() {
        return averageRating;
    }
    
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    
    public Integer getRatingCount() {
        return ratingCount;
    }
    
    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }
    
    public List<CommentDTO> getComments() {
        return comments;
    }
    
    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
} 