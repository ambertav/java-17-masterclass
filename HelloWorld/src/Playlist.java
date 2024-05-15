import java.util.ArrayList;
import java.util.LinkedList;

// exercise 45
/**
 * Represents a playlist.
 */
public class Playlist {
    public static void main(String[] args) {

    }

    /**
     * Represents an album.
     */
    public class Album {
        private String name;
        private String artist;
        private ArrayList<Song> songs;

        /**
         * Constructs an album with a name and an artist.
         * 
         * @param name   The name of the album.
         * @param artist The artist of the album.
         */
        public Album(String name, String artist) {
            this.name = name;
            this.artist = artist;
            this.songs = new ArrayList<Song>();
        }

        /**
         * Adds a song to the album.
         * 
         * @param title    The title of the song.
         * @param duration The duration of the song.
         * @return True if the song was added successfully, false otherwise.
         */
        public boolean addSong(String title, double duration) {
            if (findSong(title) == null) {
                this.songs.add(new Song(title, duration));
                return true;
            } else
                return false;

        }

        /**
         * Finds a song in the album.
         * 
         * @param title The title of the song to find.
         * @return The song if found, null otherwise.
         */
        private Song findSong(String title) {
            for (Song s : this.songs) {
                if (s.getTitle().equalsIgnoreCase(title))
                    return s;
            }

            return null;
        }

        /**
         * Adds a song from the album to a playlist by track number.
         * 
         * @param trackNumber The track number of the song.
         * @param playlist    The playlist to add the song to.
         * @return True if the song was added successfully, false otherwise.
         */

        public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
            int index = trackNumber - 1;
            if (index >= 0 && index <= this.songs.size()) {
                playlist.add(songs.get(index));
                return true;
            } else
                return false;
        }

        /**
         * Adds a song from the album to a playlist by title.
         * 
         * @param title    The title of the song to add.
         * @param playlist The playlist to add the song to.
         * @return True if the song was added successfully, false otherwise.
         */
        public boolean addToPlayList(String title, LinkedList<Song> playlist) {
            Song song = findSong(title);
            if (song == null)
                return false;
            else {
                playlist.add(song);
                return true;
            }
        }
    }

    /**
     * Represents a song.
     */
    public static class Song {
        private String title;
        private double duration;

        /**
         * Constructs a song with a title and duration.
         * 
         * @param title    The title of the song.
         * @param duration The duration of the song.
         */

        public Song(String title, double duration) {
            this.title = title;
            this.duration = duration;
        }

        /**
         * Gets the title of the song.
         * 
         * @return The title of the song.
         */
        public String getTitle() {
            return this.title;
        }

        /**
         * Converts the song to a string representation.
         * 
         * @return A string representation of the song.
         */
        @Override
        public String toString() {
            return String.format("%s: %.2f", this.title, this.duration);
        }
    }
}
