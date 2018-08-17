## Toteutus

### Verkko
* Verkko on m*m ruudukko int[][]
* Verkkoa käsitellään myös listana int[], jossa on solmujen painot solmujen järjestyksen mukaan,
* listana Node[], johon solmu-oliot ovat järjestettynä id-arvonsa mukaan
* sekä vieruslistana ArrayList<Node>[] vieruslista, jossa esim. vieruslista[2] on ArrayList<Node> toisena listassa olevan solmun vierussolmuista (ArrayList omaan vieruslistatietorakenteeseen asti)

### Solmu
* Verkon solmut ovat olioita, joilla on id-, paino- ja etäisyysarvo
* Id on 1d arrayn indeksi, ja paino on kyseinen arvo listassa indeksin kohdalla
* Etäisyysarvo Dijkstrassa on etäisyys alkusolmusta; alustetaan 'äärettömään'
* A-tähdessä se on solmun etäisyys maalisolmusta; tämä lasketaan 2d verkosta heuristisella funktiolla

### Toiminta
* Ohjelma saa parametriksi listan solmujen painoista, alku- ja loppusolmun järjestysnumerot, verkon mitat (n,m) ja kirjaimen a tai d, mikä kertaa lasketaanko reitti dijkstralla vai a-tähdellä.
* Alustava metodi luo 2d int verkon, Node listan ja Node vieruslistan. Metodi kutsuu heuristista funktiota solmujen luomisessa mikäli halutaan suorittaa a-tähdellä.
* Seuraava metodi luo boolean ja int arrayn, joissa pidetään kirjaa käsitellyistä solmuista ja lyhimmästä reiteistä.
* Solmut laitetaan minimikekoon (vielä tässä vaiheessa javan stack) ja kutsutaan joko dijkstraa tai a-tähteä.

(kesken tästä eteenpäin..)
### Dijkstra

### A-star
* heuristiikka-funktio

### Tulos
