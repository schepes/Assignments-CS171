/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class Playlist {
    private Episode head;
    private int size;

    public Playlist() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Ensure that "size" is updated properly in other methods, to
    // always reflect the correct number of episodes in the current playlist
    public int getSize() {
        return this.size;
    }

    // Displays the Episodes starting from the head and moving forward
    // Example code and its expected output:
   /*   Playlist pl = new Playlist();
   /*   pl.addLast("PlanetMoney",26.0);
   /*   pl.addLast("TodayExplained",10);
   /*   pl.addLast("RadioLab",25.5);
   /*   pl.displayPlaylistForward();
   /* [BEGIN] (PlanetMoney|26.0MIN) -> (TodayExplained|10.0MIN) -> (RadioLab|25.5MIN) [END]
   */
    public void displayPlaylistForward() {
        String output = "[BEGIN] ";
        Episode current = head;
        if (current != null) {
            while (current.next != head) {
                output += current + " -> ";
                current = current.next;
            }
            output += current + " [END]\n";
        } else {
            output += " [END]\n";
        }
        System.out.println(output);
    }

    // Displays the Episodes starting from the end and moving backwards
    // Example code and its expected output:
   /*   Playlist pl = new Playlist();
   /*   pl.addLast("PlanetMoney",26.0);
   /*   pl.addLast("HowIBuiltThis",10);
   /*   pl.addLast("RadioLab",25.5);
   /*   pl.displayPlaylistForward();
   /* [END] (RadioLab|25.5MIN) -> (HowIBuiltThis|10.0MIN) -> (PlanetMoney|26.0MIN) [BEGIN]
   */
    public void displayPlaylistBackward() {
        String output = "[END] ";
        Episode current = head;
        if (current != null) {
            while (current.prev != head) {
                output += current.prev + " -> ";
                current = current.prev;
            }
            output += current.prev + " [BEGIN]\n";
        } else {
            output += " [BEGIN]\n";
        }
        System.out.println(output);
    }

    // Add a new Episode at the beginning of the Playlist
    public void addFirst(String title, double length) {
        if (this.isEmpty()) {
            head = new Episode(title, length, null, null);
            head.prev = head;
            head.next = head;
            size++;
            return;
        }
        Episode episode = head;
        Episode addedEpisode = new Episode(title, length, null, null);
        addedEpisode.prev = episode.prev;
        addedEpisode.next = episode;
        episode.prev.next = addedEpisode;
        episode.prev = addedEpisode;
        head = addedEpisode;
        size++;
    }

    // Add a new Episode at the end of the Playlist
    public void addLast(String title, double length) {
        if (this.isEmpty()) {
            head = new Episode(title, length, null, null);
            head.next = head;
            head.prev = head;
            size++;
            return;
        }
        Episode episode = head;
        while (episode.next != head) {
            episode = episode.next;
        }
        Episode addedEpisode = new Episode(title, length, head, null);
        episode.next = addedEpisode;
        addedEpisode.prev = episode;
        head.prev = addedEpisode;
        size++;
    }

    // Add a new Episode at the given index, assuming that index
    // zero corresponds to the first node
    public void add(String title, double length, int index) throws RuntimeException {
        if (index > size) {
            throw new RuntimeException("There cant be such index in this playlist");
        }
        if (index == size) {
            this.addLast(title, length);
            return;
        }

        int count = 0;
        Episode episode = head;
        Episode newEpisode = new Episode(title, length, null, null);
        while (count != index) {
            episode = episode.next;
            count++;
        }
        if(episode.equals(head)){
            head = newEpisode;
        }
        newEpisode.next = episode;
        newEpisode.prev = episode.prev;
        episode.prev.next = newEpisode;
        episode.prev = newEpisode;
        size++;


    }

    // Delete the first Episode in the Playlist
    public Episode deleteFirst() throws RuntimeException {
        Episode deletedEpisode = head;
        if (this.isEmpty()) {
            throw new RuntimeException("The list is already empty");
        }
        if (size == 1) {
            head = null;
            size--;
            return deletedEpisode;
        }
        head.prev.next = head.next;
        head.next.prev = head.prev;
        head = head.next;
        size--;
        return deletedEpisode;


    }

    // Delete the last Episode in the Playlist
    // (There is no special "last" variable in this Playlist;
    // think of alternative ways to find that last Episode)
    public Episode deleteLast() {
        if (this.isEmpty()) {
            throw new RuntimeException("The list is already empty");
        }
        Episode deletedEpisode = head.prev;
        if (size == 1) {
            head = null;
            size--;
            return deletedEpisode;
        }
        deletedEpisode.prev.next = deletedEpisode.next;
        deletedEpisode.next.prev = deletedEpisode.prev;
        size--;
        return deletedEpisode;
    }

    // Remove (delete) the Episode that has the given "title"
    // You can assume there will be no duplicate titles in any Playlist
    public Episode deleteEpisode(String title) throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("The list is already empty");
        }
        Episode episode = head;

        if (size == 1 && head.getTitle().equals(title)) {
            this.deleteFirst();
            size--;
            return episode;
        }
        do {
            if (episode.getTitle().equals(title)) {
                episode.next.prev = episode.prev;
                episode.prev.next = episode.next;
                size--;
                if(episode.equals(head)){
                    head = episode.next;
                }
                return episode;
            }
            episode = episode.next;
        } while (episode != head);
        throw new RuntimeException("The episode specified either has a different name or is not at the playlist");
    }

    // Remove (delete) every m-th Episode in the user's circular Playlist,
    // until only one Episode survives. Return the survived Episode.
    public Episode deleteEveryMthEpisode(int m) {
        if (this.isEmpty()) {
            throw new RuntimeException("The list is empty");
        }
        Episode episode = head.prev;
        while (size != 1) {
            for (int i = 0; i < m; i++) {
                episode = episode.next;
            }

            this.deleteEpisode(episode.getTitle());
        }
        return head;
    }

} // End of Playlist class
