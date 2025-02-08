# YoutubeVideoRemix

YouTube Video Player (30-Second Player for Multiple Videos):

This Java project plays multiple YouTube videos using embedded video links. Each video plays for exactly 30 seconds and automatically transitions to the next video once the current one is finished. This is ideal for quickly previewing a sequence of videos.


Features:

Play multiple YouTube videos using embedded video links.
Automatically plays each video for 30 seconds.
Moves seamlessly to the next video once the current one finishes.
Simple, easy-to-use Java-based application.

Requirements:

Java 8 or later.
Active internet connection to access YouTube videos.
JavaFX or a similar GUI library (if you're building with a graphical user interface).

Installation:

1. Clone the repository to your local machine:
bash
Copy
git clone https://github.com/yourusername/YouTube-Video-Player.git
2. Navigate to the project folder:
bash
Copy
cd YouTube-Video-Player
3. Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse).
4. Build and run the project:
Use your IDE's build tools (Maven/Gradle or direct Java compilation) to run the project.


How It Works:

This application uses embedded YouTube video URLs to stream and display videos. It plays each video for 30 seconds before automatically moving to the next video in the provided list.


Key Functions:

Input List of Video URLs: You provide a list of YouTube embedded video URLs.
Video Play Limit: Each video plays for exactly 30 seconds, regardless of its length.
Automatic Transition: After 30 seconds, the video automatically stops, and the next video in the list starts playing.
Error Handling:The application handles invalid or incorrect video URLs gracefully (e.g., 404 errors, no internet connection).
Example Usage:
Input a list of YouTube video embedded URLs.
The program will start playing the first video, stop it after 30 seconds, and automatically play the next video.
The process repeats until all videos in the list have been played.
Example Video URLs:
https://www.youtube.com/embed/dQw4w9WgXcQ
https://www.youtube.com/embed/3JZ_D3ELwOQ

Code Example:

java
Copy
// Create an instance of the YouTube player with a list of embedded video links
List<String> videoUrls = Arrays.asList(
    "https://www.youtube.com/embed/dQw4w9WgXcQ",  // First video
    "https://www.youtube.com/embed/3JZ_D3ELwOQ",  // Second video
    "https://www.youtube.com/embed/kJQP7kiw5Fk"   // Third video
);

// Create and start the video player
YouTubePlayer player = new YouTubePlayer(videoUrls);

// Play videos for 30 seconds each, automatically transitioning to the next video
player.playVideosFor30Seconds();
Video Playback Flow:
Play Video 1 for 30 seconds.
Pause/Stop Video 1 and move to Video 2.
Repeat the same for all videos in the list.
