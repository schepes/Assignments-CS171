public class ITunes {

    public static void main(String[] args) {

        // Sample testing code ...
        Playlist pl = new Playlist();

        pl.addLast("PlanetMoney", 26.0);
        pl.addLast("HowIBuiltThis", 10);
        pl.addLast("EzraKleinShow", 65.0);
        pl.addLast("RadioLab", 25.5);
        pl.addLast("MakeMeSmart", 24.5);
        pl.addLast("Worldly", 55);
        //System.out.println(pl.deleteEpisode("Worldly"));
       // System.out.println(pl.deleteEpisode("PlanetMoney"));
       // pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
//        pl.add("Whasaa", 10, 0);
//        pl.displayPlaylistForward();
//        System.out.println("a");
//        pl.add("Whasa", 10, 1);
//        pl.displayPlaylistForward();
//        pl.add("Whasea", 10, 2);
//        pl.displayPlaylistForward();
//        pl.add("Whasfa", 10, 8);
//        pl.displayPlaylistForward();
//        pl.add("Whadssa", 10, 11);
//        pl.displayPlaylistForward();
        System.out.println(pl.deleteEveryMthEpisode(7));

    }
}
