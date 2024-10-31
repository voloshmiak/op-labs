class VideoClip extends Song {
    private Integer duration; // in seconds

    public VideoClip(String title, String artist, Integer duration) {
        super(title, artist);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Відеокліп: title='" + getTitle() + '\'' + ", artist='" + getArtist() + '\'' + ", duration=" + duration;
    }
}