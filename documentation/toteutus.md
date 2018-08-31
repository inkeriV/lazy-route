## Toteutus

### Verkko
* Verkko on m*m ruudukko int[][]
* Verkkoa käsitellään myös listana int[], jossa on solmujen painot solmujen järjestyksen mukaan,
* listana Node[], johon solmu-oliot ovat järjestettynä id-arvonsa mukaan
* sekä vieruslistana Node[][] vieruslista, jossa jokaisen Node[solmun.id].lenght on 4, koska se on vierussollmujen maksimimäärä. Kulma- ja reunasolmuilla jotkin alkiot jäävät nulliksi.

### Solmu
* Verkon solmut ovat olioita, joilla on id-, paino- ja etäisyysarvo
* Id on 1d arrayn indeksi, ja paino on kyseinen arvo listassa indeksin kohdalla
* Etäisyysarvo Dijkstrassa on etäisyys alkusolmusta; alustetaan 'äärettömään'
* A-tähdessä se on solmun etäisyys maalisolmusta; tämä lasketaan 2d verkosta heuristisella funktiolla

### Toiminta
* Ohjelma saa parametriksi listan solmujen painoista, alku- ja loppusolmun järjestysnumerot, verkon mitat (n,m) ja kirjaimen a tai d, mikä kertaa lasketaanko reitti dijkstralla vai a-tähdellä.
* Alustava metodi luo 2d int verkon, Node listan ja Node vieruslistan. Metodi kutsuu heuristista funktiota solmujen luomisessa mikäli halutaan suorittaa a-tähdellä.
* Seuraava metodi luo boolean ja int arrayn, joissa pidetään kirjaa käsitellyistä solmuista ja lyhimmästä reiteistä.
* Solmut laitetaan minimikekoon ja kutsutaan joko dijkstraa tai a-tähteä.


### Dijkstra
* Solmut ovat keossa paino+dist summan mukaan pienimmästä suurimpaan.
* Käsitellyistä solmuista pidetään kirjaa boolean-taulukolla.
* Käsittelyssä olevan solmun vierussolmut käydään vuorotellen läpi, ja lasketaan niille uusi dist arvo.
* Tämä arvo saadaan ohjelman käynnistyksen yhteydessä syötetystä solmuja kuuvaavasta listasta: solmut[vierussolmu.id]=vierussolmu.dist.
* Koska keossa olevien solmujen arvoja ei voi enää muuttaa, luodaan uusi solmu muokattavan solmun id:llä ja uusilla arvoilla ja pistetään kekoon.
* Lyhin reitti saadaan talteen tallettamalla käsitellyn solmun id, int-listassa kohtaan, jossa vierussolmun id=listan indeksi, jos lyhin reitti vierussolmuun kulkee käsittelyssä olevan solmun kautta.
* Tämän jälkeen otetaan jälleen uusi solmu keosta.

### A-star
* A-star toimii samalla tavalla kuin Dijkstra, paitsi että siinä solmut ovat järjestetty kekoon paino(syötetyn listan mukaan)+solmun etäisyys verkossa maalisolmusta.
* Tähän on käytetty yksinkertaista heuristiikka-funktiota.
* Tässä ohjelmassa A-star käyttää Manhattan distance heuristiikkaa, joten etäisyysarvo on laskettu 2d-verkon molempien solmujen koordinaattien avulla solmun |vaakasuuntainen etäisyys|+|pystysuuntainen etäisyys| maalisolmusta.

### Tulos
* Tulosteena String.
* Tällä hetkellä tulos on vielä "1 => 2 => 8 => 9 => 3" -tyyppinen String, jossa reitti on kuvattu solmujen järjestysnumeron (1. solmu = 1) alkusolmusta maalisolmuun.
* Tavoitteena saada tulostetuksi koko verkko, mihin on merkitty kuljettu reitti ja muuta tietoa esim. kuinka painava lyhin reitti on.

### Minimikeko
* Minimikeko on toteutettu solmu-tyypin 1d listana ja numeromuuttujana, jossa pidetään kirjaa siitä, mihin listan indeksiin on viimeksi laitettu solmu. 
* Keon pituus on aluksi 1000 ja muuttuja size -1, kun keko on tyhjä.
* Jos keko tulee täyteen - size = length - luodaan uusi lista, jonka koko on kaksinkertainen aiemmasta, ja kopioidaan alkiot vanhasta listasta uuteen.
* Tämän jälkeen osoitetaan uusi lista keko-olion listaksi.
