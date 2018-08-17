Helsingin yliopiston aineopintojen harjoitustyö, Tietorakenteet ja algoritmit, loppukesä 2018 -kurssilla tehtävä ohjelma.

* Ohjelma etsii painotetussa verkossa (ei negatiivisia arvoja) kahden solmun välisen kevyimmän reitin. 
* Ideana on, että ohjelmaa voi käyttää mm. maastossa helppokulkuisimman reitin etsimiseen, missä kartta voidaan ajatella ruudukkona, jonka yksi ruutu on lähtöpiste, yksi ruutu on loppupiste ja muut ruudut kuvaavat maaston maaston helppokulkuisuutta tai mahdollista estettä ruuduille annetuilla painoilla.
* Ruudukko kuvataan painotettuna verkkona G=(V,E), missä kaaren paino kuvaa kuvaa kulkemisen hankaluutta viereiseen ruutuun, eli kaaren päässä olevaan solmuun.
* Käytännössä verkko koostuu solmu-olioista, jonka yhtenä arvona on (kaaren)paino- / hankalakulkuisuusattribuutti.
* Verkko on 2D m*m taulukko.
* Ohjelman voi suorittaa Dijkstran algoritmilla tai A-star algoritmilla.

### Dijkstran algoritmi
* tietorakenteet minimikeko ja vieruslista
* tavoite aikavaativuus O(|E|+|V|log|V|)
* tavoite tilavaativuus O(|V|)

### A *-algoritmi
* tietorakenteet minimikeko ja vieruslista
* tavoite aikavaativuus O(|E|+|V|log|V|)
* tavoite tilavaativuus O(|V|)

* Ohjelma saa syötteenään listan solmujen painoista, alku- ja loppusolmun järjestysnumeron, verkon mitat m ja n sekä käytettävän algoritmin alkukirjaimen(d/a).
