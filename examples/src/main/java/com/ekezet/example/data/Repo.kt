package com.ekezet.example.data

/**
 * @author kiri
 */
object Repo {
    private val artists = mapOf(
        1 to Artist(1, "Royalston", "AU"),
        2 to Artist(2, "Sizzla Kalonji", "JM"),
        3 to Artist(3, "Richie Hawtin", "GB")
    )

    private val albums = mapOf(
        // Sizzla
        1 to Album(1, 2, "Hotter Than Fire", 1998),
        2 to Album(2, 2, "Black History", 2001),
        3 to Album(3, 2, "Ghetto Revolution", 2002),
        4 to Album(4, 2, "Bobo Ashanti", 2000),
        // Royalston
        5 to Album(5, 1, "OCD", 2014),
        6 to Album(6, 1, "Popular Mechanics", 2017)
    )

    private val tracks = mapOf(
        // Sizzla - Bobo Ashanti
        1 to Track(1, 4, 1, "The World", "4:36"),
        2 to Track(2, 4, 2, "Courage", "3:50"),
        3 to Track(3, 4, 3, "Whether Or Not", "3:45"),
        4 to Track(4, 4, 4, "Grow U Locks", "3:24"),
        5 to Track(5, 4, 5, "This Day", "4:09"),
        6 to Track(6, 4, 6, "Attack", "3:33"),
        7 to Track(7, 4, 7, "Glorify", "3:54"),
        8 to Track(8, 4, 8, "Wicked Naw Go Prosper", "4:03"),
        9 to Track(9, 4, 9, "Good Looking", "3:28"),
        10 to Track(10, 4, 10, "Do Good", "3:49"),
        11 to Track(11, 4, 11, "Strength & Hope", "3:30"),
        12 to Track(12, 4, 12, "Children Beware", "3:35"),
        13 to Track(13, 4, 13, "Must Rise", "3:34"),
        // Sizzla - Ghetto Revolution
        14 to Track(14, 3, 1, "Ghetto Revolution", "3:36"),
        15 to Track(15, 3, 2, "Jah Will Be There", "4:44"),
        16 to Track(16, 3, 3, "That's Why", "4:04"),
        17 to Track(17, 3, 4, "The Truth Is Revealing", "3:56"),
        18 to Track(18, 3, 5, "Don't Say", "3:32"),
        19 to Track(19, 3, 6, "Just Fine", "3:48"),
        20 to Track(20, 3, 7, "Don't Waste Time", "3:43"),
        21 to Track(21, 3, 8, "I Want You", "4:33"),
        22 to Track(22, 3, 9, "Love The Little Children", "3:40"),
        23 to Track(23, 3, 10, "Have You", "3:31"),
        24 to Track(24, 3, 11, "Live It Up", "4:11"),
        25 to Track(25, 3, 12, "Won't Stop", "3:23"),
        26 to Track(26, 3, 13, "So Serious", "3:34"),
        // Sizzla - Black History
        27 to Track(27, 2, 1, "Bandulu", "3:50"),
        28 to Track(28, 2, 2, "Instance", "3:45"),
        29 to Track(29, 2, 3, "Ring Leader", "3:55"),
        30 to Track(30, 2, 4, "Black History", "3:42"),
        31 to Track(31, 2, 5, "No Pain", "3:56"),
        32 to Track(32, 2, 6, "Rastafari Children", "3:43"),
        33 to Track(33, 2, 7, "Problem Inna The System", "4:14"),
        34 to Track(34, 2, 8, "Bun Dem Up", "3:50"),
        35 to Track(35, 2, 9, "Run Dem To Wrong", "3:46"),
        36 to Track(36, 2, 10, "Things Will Be Better", "3:56"),
        37 to Track(37, 2, 11, "Upfullness", "4:13"),
        38 to Track(38, 2, 12, "Galong", "3:46"),
        39 to Track(39, 2, 13, "Don't Be Disappointed", "3:55"),
        40 to Track(40, 2, 14, "Happy To Love", "3:58"),
        // Sizzla - Hotter Than Fire
        41 to Track(41, 1, 1, "Love & Harmony", "3:56"),
        42 to Track(42, 1, 2, "Cost Nothing", "3:13"),
        43 to Track(43, 1, 3, "Ghetto Youth", "3:21"),
        44 to Track(44, 1, 4, "Joy", "3:49"),
        45 to Track(45, 1, 5, "Made It So", "3:44"),
        46 to Track(46, 1, 6, "Jump For Joy", "4:36"),
        47 to Track(47, 1, 7, "Have Your Own", "3:44"),
        48 to Track(48, 1, 8, "I Do Care", "5:01"),
        49 to Track(49, 1, 9, "It's Gettin Red", "4:47"),
        50 to Track(50, 1, 10, "Pure & Clean", "4:14"),
        51 to Track(51, 1, 11, "Rasta Battlefield", "4:19"),
        52 to Track(52, 1, 12, "Yesterday", "4:07"),
        53 to Track(53, 1, 13, "Babylon Applauding", "4:05"),
        54 to Track(54, 1, 14, "Can't Cool", "3:52"),
        // Royalston - OCD
        55 to Track(55, 5, 1, "Jungle Gone Down", "4:02"),
        56 to Track(56, 5, 2, "Arps Of Fury", "5:25"),
        57 to Track(57, 5, 3, "Steeplechase", "4:32"),
        58 to Track(58, 5, 4, "Stalking Stones", "4:09"),
        59 to Track(59, 5, 5, "Keys", "5:04"),
        60 to Track(60, 5, 6, "OCD", "3:27"),
        61 to Track(61, 5, 7, "Kronos", "5:49"),
        62 to Track(62, 5, 8, "People Who Look Like You", "4:24"),
        63 to Track(63, 5, 9, "Modular Jam", "4:29"),
        64 to Track(64, 5, 10, "Lunar", "4:27"),
        65 to Track(65, 5, 11, "Get Up And Growl", "4:09"),
        66 to Track(66, 5, 12, "Shark", "4:08"),
        67 to Track(67, 5, 13, "Slimebanks", "4:58"),
        68 to Track(68, 5, 14, "Black Cloud", "5:06"),
        69 to Track(69, 5, 15, "When Unwanted Thoughts Take Over", "4:39"),
        70 to Track(70, 5, 16, "Memory Jar", "3:51"),
        71 to Track(71, 5, 17, "Days Go On", "3:21"),
        72 to Track(72, 5, 18, "Geisha Rhythm", "3:49"),
        // Royalston - Popular Mechanics
        73 to Track(73, 6, 1, "The Late Heavy Bombarment", "4:21"),
        74 to Track(74, 6, 2, "Diorama", "5:02"),
        75 to Track(75, 6, 3, "We Were Told", "3:49"),
        76 to Track(76, 6, 4, "Spladerunner", "4:08"),
        77 to Track(77, 6, 5, "15GAMMA", "4:47"),
        78 to Track(78, 6, 6, "Who Did She Become", "4:57"),
        79 to Track(79, 6, 7, "Mollymook", "4:14"),
        80 to Track(80, 6, 8, "Cruising", "4:26"),
        81 to Track(81, 6, 9, "Fork Tongue", "3:58"),
        82 to Track(82, 6, 10, "Oscilla", "5:03"),
        83 to Track(83, 6, 11, "Strobes", "3:30"),
        84 to Track(84, 6, 12, "I'll Keep It Warm", "3:26"),
        85 to Track(85, 6, 13, "The Sound We Made", "4:26"),
        86 to Track(86, 6, 14, "Popular Mechanics", "5:49")
    )

    fun getArtist(id: Int) = artists[id]

    fun getAlbums(artistId: Int) =
        albums.entries.filter { it.value.artistId == artistId }.map { it.value }

    fun getTracks(albumId: Int) =
        tracks.entries.filter { it.value.albumId == albumId }.map { it.value }
}
